import socket
import time
import requests
from fake_useragent import UserAgent

ua = UserAgent(verify_ssl=False)

print("Start : %s" % time.ctime())

socket.setdefaulttimeout(65)
headers = {'User-Agent':ua.random}
session = requests.Session()

r = session.get("http://quote.cfi.cn/stockList.aspx?t=16",headers=headers,timeout=65)
print(r.status_code)

print("End : %s" % time.ctime())