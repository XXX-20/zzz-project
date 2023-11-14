# Define here the models for your scraped items
#
# See documentation in:
# https://docs.scrapy.org/en/latest/topics/items.html

import scrapy


class MysYsScrapyItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    name = scrapy.Field()
    hp_1 = scrapy.Field()
    attack_1 = scrapy.Field()
    defend_1 = scrapy.Field()
    pass
