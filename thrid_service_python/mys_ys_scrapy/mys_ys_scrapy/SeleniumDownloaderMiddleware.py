from scrapy.http import HtmlResponse
import time

class SeleniumDownloaderMiddleware:

    def process_request(self, request, spider):
        if spider.name == 'MysYsScrapy':
            spider.driver.get(request.url)
            time.sleep(2)
            print(f"当前访问{request.url}")
            spider.driver.refresh()
            time.sleep(3)
            return HtmlResponse(url=spider.driver.current_url, body=spider.driver.page_source, encoding='utf-8')