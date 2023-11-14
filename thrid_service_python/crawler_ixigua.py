import requests
import re
import json
import base64

headers = {
    # cookie很有用，没有cookie访问的页面内容有问题
    'cookie': 'support_webp=true; '
              'support_avif=true; '
              'csrf_session_id=76ceeb6d60b0fcd804de9be6e9693c54; '
              's_v_web_id=verify_lefmeh66_SLWSXhCD_aZkd_4NEx_BgaI_hGUNbdQrHIpi; '
              'MONITOR_WEB_ID=56b4a269-39b6-4147-ab7c-9195b568c5e8; '
              '_tea_utm_cache_2018=undefined; '
              'passport_csrf_token=1a7dd3b7b20888e47197ea1d942e17d5; '
              'passport_csrf_token_default=1a7dd3b7b20888e47197ea1d942e17d5; '
              'passport_auth_status=121a29188cf1b9ecf308efbe3d0920c5%2C; '
              'passport_auth_status_ss=121a29188cf1b9ecf308efbe3d0920c5%2C; '
              'sid_guard=d75c6025dd5f4e3d658be37aad5f91b5%7C1677067151%7C3024000%7CWed%2C+29-Mar-2023+11%3A59%3A11'
              '+GMT; uid_tt=2f228913ef6379e66da0c3399feaa580; '
              'uid_tt_ss=2f228913ef6379e66da0c3399feaa580; '
              'sid_tt=d75c6025dd5f4e3d658be37aad5f91b5; '
              'sessionid=d75c6025dd5f4e3d658be37aad5f91b5; '
              'sessionid_ss=d75c6025dd5f4e3d658be37aad5f91b5; '
              'sid_ucp_v1=1.0.0-KGQ4Nzc4MjZiYWI1NWRmYTg5YjQyYmMyZjhmYjY1OWYyYzQzMDUyOGEKFAjo5IrYFxCPh9ifBhgYIAw4CEAFGgJobCIgZDc1YzYwMjVkZDVmNGUzZDY1OGJlMzdhYWQ1ZjkxYjU; '
              'ssid_ucp_v1=1.0.0-KGQ4Nzc4MjZiYWI1NWRmYTg5YjQyYmMyZjhmYjY1OWYyYzQzMDUyOGEKFAjo5IrYFxCPh9ifBhgYIAw4CEAFGgJobCIgZDc1YzYwMjVkZDVmNGUzZDY1OGJlMzdhYWQ1ZjkxYjU; '
              '__ac_nonce=063f604bf003948a3bad9; __ac_signature=_02B4Z6wo00f01SciCjgAAIDARCjKUZOPEREnAg6AACpBKsMzhMS3tmVlQF6xo9y4lk1.8f3BOblIBNOWtyn2ZteVVEle52JVejsr-gjz52x7fFDNHLhhWPSptiT342agtlzTUnp1SO2LBVZxb3; '
              'ixigua-a-s=3; '
              'odin_tt=5529039b6eb72ae52e2705d0db550fc06655c83bdbe61914be61c42152989c387a55ad2fa056636bfd1f880a86407f88; '
              'tt_scid=ORPDc-M6KS5eOmTgjaUrefaIL0yzO7y.HdHVQAZXahd0wmCZXjYo6rBN9gfC3xYF3559; '
              'ttwid=1%7CiWx9zpr2eLSL5pxwfW7PdpTasAnL2Tszm5jFlS0A_ac%7C1677067476%7C2d4446661479733452a7b0217ff6d0c80645ddd3f9f9e85f43547870d43654da; '
              'msToken=cSgsxZfj-6sePYrKBxT8cLGTA9Fe4h9FVEyqx2na-t6-TyoXHDL3Q_CQIxRvs9MrWsKeXvTH9OeSdsfiVqYu48Qcw-sEg2hF6sThIHy2b9J1L2mNumIx',
    'referer': 'https://www.ixigua.com',
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36'
}
url = 'https://www.ixigua.com/7253044068056302132?logTag=4f6491c94071f087289a'
response = requests.get(url=url, headers=headers)

response.encoding = "utf-8"
html_data = response.text
print(html_data)
# json_str = re.findall('window._SSR_HYDRATED_DATA=(.*?)</script>', html_data)[0]
# # 字典 undefined
# json_str = json_str.replace('undefined', 'null')
# json_data = json.loads(json_str)
# video_list = json_data['anyVideo']['gidInformation']['packerData']['video']['videoResource']['normal']['video_list']
# num = len(list(video_list.keys()))
# main_url = video_list.get(f'video_{num}').get("main_url")
# video_url = base64.b64decode(main_url).decode()
# print(video_url)
#
# title = re.findall('<title data-react-helmet="true">(.*?)</title>', html_data)[0]
# print(title)
# video_data = requests.get(video_url, headers=headers).content
# with open(title + '.mp4', mode='wb') as f:
#     f.write(video_data)
