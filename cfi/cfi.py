# coding=gbk
import csv
import random
import re
import socket
import time
import requests
from bs4 import BeautifulSoup
from fake_useragent import UserAgent

ua = UserAgent(verify_ssl=False)

print("Start : %s" % time.ctime())

socket.setdefaulttimeout(65)
headers = {'User-Agent':ua.random}
session = requests.Session()

r = session.get("http://quote.cfi.cn/stockList.aspx?t=14",headers=headers,timeout=65)
r.encoding = "utf-8"
soup = BeautifulSoup(r.text, "lxml")

a_href = soup.select('a[href*=".html"]')
company_code = re.findall('\w+.\d{6}.',str(a_href))
code = re.findall('\d{6}',str(company_code))
company = re.findall('\w+[^(\d{6})]',str(company_code))
session.close()

# for c in code:
#     r = requests.get("http://quote.cfi.cn/quote_" + c + ".html").elapsed
#     print(r)

count = 0
for c in code:
    r = session.get("http://quote.cfi.cn/quote_" + c + ".html",headers=headers,timeout=65)
    if r.status_code == 200:
        r.encoding = "utf-8"
        soup = BeautifulSoup(r.text, "lxml")
        p = soup.find_all("span", attrs={"id": "last"})
        p1 = re.findall('[^<span id="last">]\d*.\d[^</span>]', str(p))
        count = count + 1
        if count <= 1:
            price = [count,p1]
        else:
            price = price + [count,p1]
        print(price)
        session.close()
        sleep_time = random.randint(30, 60) + random.random()
        time.sleep(sleep_time)
    else:
        print("fail...")

price = re.findall('\d+.\d+',str(price))
# print(price)

# for i in range(len(code)):
#     price = [0.0] * len(code)
# print(price)

d_code_company = dict(zip(code,company))
print(d_code_company)

d_code_price = dict(zip(code,price))
print(d_code_price)

l_code_company = list(d_code_company.items())
print(l_code_company)

l_code_price = list(d_code_price.items())
print(l_code_price)

with open('ChiNext_company.csv', 'w', newline='', encoding='utf-16') as f:
    writer = csv.writer(f, delimiter=',')
    writer.writerows(l_code_company)

with open('ChiNext_price.csv', 'w', newline='', encoding='utf-8-sig') as f:
    writer = csv.writer(f, delimiter=',')
    writer.writerows(l_code_price)

print("End : %s" % time.ctime())