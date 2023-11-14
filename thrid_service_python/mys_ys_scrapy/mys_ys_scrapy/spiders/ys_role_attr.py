import re
import time

import scrapy
from pydispatch import dispatcher
from scrapy import signals
from selenium import webdriver

from ..items import MysYsScrapyItem
from ..utils import character_attr_pymysql


class MysYsScrapySpider(scrapy.Spider):
    name = 'MysYsScrapy'
    allowed_domains = ["mihoyo.com"]
    start_urls = [
        'https://bbs.mihoyo.com/ys/obc/content/90/detail?bbs_presentation_style=no_header']  # 角色索引界面（默认展示全部）

    # 浏览器驱动器对象初始化
    def __init__(self, *args, **kwargs):
        option = webdriver.ChromeOptions()  # 实例化一个浏览器对象
        option.add_argument('--headless')  # 添加参数，option可以是headless，--headless，-headless
        self.driver = webdriver.Chrome(chrome_options=option)  # 创建一个无头浏览器
        time.sleep(3)
        super(MysYsScrapySpider, self).__init__(*args, **kwargs)
        dispatcher.connect(self.close_driver, signals.spider_closed)

    def start_requests(self):
        for url in self.start_urls:
            yield scrapy.Request(
                # 这里可以设置多个页面，一般用于分页的
                url=url,
            )

    def close_driver(self):
        print("爬虫正在退出，执行关闭浏览器哦")
        time.sleep(2)
        self.driver.quit()
    '''
    爬虫程序问题：
    1.问题情境：新版本角色更新，角色索引页面更新（添加了一栏新的角色），但角色详情页还没有更新（缺失a标签）
            正则a标签得到的数据和角色详情页的数据就会错位，不对应。
    解决方法：1.修改代码逻辑
            2.晚点爬，等网站数据更新好了再爬
    2.问题情境：各个属性的xpath不固定。属性table会更新。
    情景：4.1版本那维莱特详情页，属性值的html多了一个p或者span标签；table多了一个tbody。
    解决方法：暂时先单独爬
    '''

    # 角色索引页面解析，得到每个角色的详情页链接
    def parse(self, response):
        # print(response.text)
        item = MysYsScrapyItem()

        # 获取tbody标签及其内容（PS：这里extract返回单个结果：一个列表，长度为1）
        role_tbody = response.xpath(
            '//*[@id="__layout"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div/div/div/div/div[3]/div/table/tbody'
        ).extract()[0]
        # print(role_tbody)

        # 获取所有的tr data-filter-tag属性（包含国家、武器类型、元素类型、星级信息）
        role_data_list = re.findall('<tr data-filter-tag="(.*?)"', role_tbody)
        # print(role_data_list)
        
        # 获取tbody内所有的tr的a标签的href属性（正则获取）
        role_href_list = re.findall('a href="(.*?)" ', role_tbody)
        # print(role_href_list)
        # print(len(role_href_list))
        for index in range(0, 1):  # 单个测试使用
        # for index in range(len(role_href_list) - 2, len(role_href_list) - 1):  # 为什么要减2呢，因为最后两个是旅行者的详情页，和其他角色不大一样，需要单独处理

            '''1.获取  国家、武器类型、元素类型、星级'''
            role_data_list_index = role_data_list[index] + ' '  # 加一个空格，便于正则处理
            region = '、'.join(re.findall('区域-(.*?) ', role_data_list_index))
            weapon_type = '、'.join(re.findall('使用武器-(.*?) ', role_data_list_index))
            element_type = '、'.join(re.findall('元素-(.*?) ', role_data_list_index))
            star_level = '、'.join(re.findall('星级-(.*?) ', role_data_list_index))

            data_to_insert_dict = {'region': region, 'weapon_type': weapon_type,
                                   'element_type': element_type, 'star_level': star_level}
            # print(data_to_insert_dict)

            '''2.请求角色详情页地址，进一步解析需要的信息'''
            # 通过拼接米游社域名https://bbs.mihoyo.com，得到实际的角色详情页地址
            role_detail_url = "https://bbs.mihoyo.com" + role_href_list[index]

            ''' 这一行创建了一个新的Scrapy请求，以访问上一步中构建的链接。
            yield 用于生成请求，scrapy.Request 用于创建请求对象。
            这个请求将链接传递给 new_parse 回调函数进行进一步的处理。
            此外，meta 参数用于传递额外的数据，这里将 item 对象传递给了 new_parse 回调函数，以便在后续处理中使用。
            cb_kwargs参数允许您传递一个字典，其中包含回调函数所需的多个参数。
            '''
            yield scrapy.Request(role_detail_url,
                                 callback=self.parse_role_html,
                                 cb_kwargs={'data_to_insert_dict': data_to_insert_dict})

    # 角色详情页面解析，获取角色信息（self参数不能少）
    def parse_role_html(self, response, data_to_insert_dict):

        # 1.hp、atk、def、名称、称号、突破属性
        # 获取90级hp
        hp_90 = response.xpath(
            '/html/body/div[1]/div/div/div[2]/div[2]/div/div[1]/div[3]/div[3]/div[1]/div/div[2]/div/div/div/div/div[8]/table/tbody[2]/tr[2]/td[2]/div'
            '/text()'
        ).get().replace(' ', '').replace(',', '')
        # print(hp_90)

        atk_all_90 = response.xpath(
            '/html/body/div[1]/div/div/div[2]/div[2]/div/div[1]/div[3]/div[3]/div[1]/div/div[2]/div/div/div/div/div[8]/table/tbody[2]/tr[3]/td[2]/div'
            '/text()'
        ).get().replace(' ', '')
        # print(atk_all_90)
        atk_90 = re.search(r'无武器(\d+)', str(atk_all_90)).group(1)
        # print(atk_90)

        def_90 = response.xpath(
            '/html/body/div[1]/div/div/div[2]/div[2]/div/div[1]/div[3]/div[3]/div[1]/div/div[2]/div/div/div/div/div[8]/table/tbody[2]/tr[2]/td[4]/div'
            '/text()'
        ).get().replace(' ', '')
        # print(def_90)

        name = response.xpath(
            '/html/body/div[1]/div/div/div[2]/div[2]/div/div[1]/div[3]/div[3]/div[1]/div/div[1]/div/div/div[2]/div/div/div[1]/div[2]/p'
            '/text()'
        ).get().replace(' ', '')
        # print(name)

        special_dish = response.xpath(
            '/html/body/div[1]/div/div/div[2]/div[2]/div/div[1]/div[3]/div[3]/div[1]/div/div[1]/div/div/div[2]/div/div/div[2]/div[3]/div[2]/div/div[2]'
            '/text()'
        ).get().strip()
        # print(special_dish)

        break_attr_type = response.xpath(
            '/html/body/div[1]/div/div/div[2]/div[2]/div/div[1]/div[3]/div[3]/div[1]/div/div[2]/div/div/div/div/div[8]/table/tbody[2]/tr[3]/td[3]'
            '/text()'
        ).get().strip()
        break_attr_value_90 = response.xpath(
            '/html/body/div[1]/div/div/div[2]/div[2]/div/div[1]/div[3]/div[3]/div[1]/div/div[2]/div/div/div/div/div[8]/table/tbody[2]/tr[3]/td[4]/div'
            '/text()'
        ).get().strip()
        break_attr = break_attr_type + ':' + break_attr_value_90
        # print(break_attr)

        data_to_insert_dict['health_points'] = float(hp_90)
        data_to_insert_dict['attack'] = float(atk_90)
        data_to_insert_dict['defence'] = float(def_90)
        data_to_insert_dict['name'] = name
        data_to_insert_dict['special_dish'] = special_dish
        data_to_insert_dict['break_attr'] = break_attr
        print(data_to_insert_dict)

        # 保存数据到数据库表character_attr
        character_attr_pymysql.character_attr_insert_or_update(data_to_insert_dict)
