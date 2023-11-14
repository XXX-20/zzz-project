import json
import re

import requests

headers = {
    'cookie': r'ttwid=1%7CCfVHG3N-fYQvhYWPzVwxCV7diXk4I_-gpNZxn3Ljf_Q%7C1695179907%7C4e52f473c829bba0e5f56c9f28dbc4939d4391cd54ea67eb06019cf0d0cb30e4; s_v_web_id=verify_lmr6cpjl_130j4qNb_oEew_4r3s_BNsY_wLLGC65bxfUQ; ttcid=06a29b7191c449bf92101b2e8b9e913544; passport_csrf_token=3c7cd64419a9caf2e97de14b2a2018f3; passport_csrf_token_default=3c7cd64419a9caf2e97de14b2a2018f3; bd_ticket_guard_client_data=eyJiZC10aWNrZXQtZ3VhcmQtdmVyc2lvbiI6MiwiYmQtdGlja2V0LWd1YXJkLWl0ZXJhdGlvbi12ZXJzaW9uIjoxLCJiZC10aWNrZXQtZ3VhcmQtcmVlLXB1YmxpYy1rZXkiOiJCSmJiYnkra01RNGhxOTkzNVVlNDNHaTdiaGtIYmVteTJJTTJmRnlUVi9LQmVLbFc0WlJkVVhtVi9MN1hNaVk3UDNQYlBaVTNBaWtDeGJ4UTlEZGZRbzA9IiwiYmQtdGlja2V0LWd1YXJkLXdlYi12ZXJzaW9uIjoxfQ==; pwa2=%220%7C0%7C3%7C0%22; download_guide=%223%2F20230920%2F1%22; volume_info=%7B%22isUserMute%22%3Afalse%2C%22isMute%22%3Atrue%2C%22volume%22%3A0.5%7D; FORCE_LOGIN=%7B%22videoConsumedRemainSeconds%22%3A180%2C%22isForcePopClose%22%3A1%7D; __ac_signature=_02B4Z6wo00f018dGTSgAAIDDR0S3a55dTTfHZkmAAJTjOL6bs1H8YLj1YBqe9dpbW97Yblrv5G021WYWbOu2oh8dyepBm9QMHAdVGpWc7zphG7fUtE8GhFjo-g039Y38ApMF.MsXxmNRNkMu56; VIDEO_FILTER_MEMO_SELECT=%7B%22expireTime%22%3A1695879291138%2C%22type%22%3A1%7D; xgplayer_user_id=492843882636; douyin.com; device_web_cpu_core=20; device_web_memory_size=8; architecture=amd64; webcast_local_quality=null; strategyABtestKey=%221695343863.445%22; stream_recommend_feed_params=%22%7B%5C%22cookie_enabled%5C%22%3Atrue%2C%5C%22screen_width%5C%22%3A1746%2C%5C%22screen_height%5C%22%3A982%2C%5C%22browser_online%5C%22%3Atrue%2C%5C%22cpu_core_num%5C%22%3A20%2C%5C%22device_memory%5C%22%3A8%2C%5C%22downlink%5C%22%3A0.45%2C%5C%22effective_type%5C%22%3A%5C%224g%5C%22%2C%5C%22round_trip_time%5C%22%3A0%7D%22; home_can_add_dy_2_desktop=%221%22; msToken=8Y61FXAu9PFEbMrAsyKtUcwJgm2SrhIJwqBU_hBVD9H-YGOo1W32H3wlBQF1U5hu3TSGqrGczxxcy_0hLGgDVDsJUFQuZ7ovYN_dtDY39GaGBxxNwxOgOdasmrH8HKA=; msToken=copfJLq5pqzOZMph1K6_7oRBRRPWP8Ktac5MLQCzmMxrWn2En3ii8eIBQrqqp775Qu5UmSfho-covw_lfCl9XMlLkFH9EdFXP5RHmpQyDi5l3eq2kGpgTeMcs5oQM18=; tt_scid=zPJb8fJR9s4JO.I0ohC41TVjwYjBlNQH5a7sKaS6OCKCCG4DJpIeTOThjOwos4P8897c; IsDouyinActive=false',
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36',

}
url = 'https://www.douyin.com/discover?modal_id=7271578703501610300'
response = requests.get(url=url, headers=headers)

response.encoding = "utf-8"
html_data = response.text

video_info = re.findall('<script id="RENDER_DATA" type="application/json">(.*?)</script>', html_data)
# print(video_info)

html_data = requests.utils.unquote(video_info[0])

json_data = json.loads(html_data)


title = json_data['app']['videoDetail']['desc'].replace(' ', '')
print(title)

video_url = 'https:' + json_data['app']['videoDetail']['video']['playAddr'][0]['src']
print(video_url)

headers = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36"
}

# response.content获取响应体的二进制数据   m4s
video_content = requests.get(url=video_url, headers=headers).content

# 创建mp4文件，写入二进制数据
with open(title + ".mp4", mode="wb", ) as f:
    f.write(video_content)



