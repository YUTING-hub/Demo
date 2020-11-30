# coding=gbk
import csv
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

r = session.get("http://quote.cfi.cn/stockList.aspx?t=16",headers=headers,timeout=65)
r.encoding = "utf-8"
soup = BeautifulSoup(r.text, "lxml")

a_href = soup.select('a[href*=".html"]')
company_code = re.findall('\w+.\d{6}.',str(a_href))
code = re.findall('\d{6}',str(company_code))
company = re.findall('\w+[^(\d{6})]',str(company_code))
session.close()

price = [1, ['7.07'], 2, ['2.23'], 3, ['2.30'], 4, ['0.89'], 5, ['3.93'], 6, ['3.33'], 7, ['5.22'], 8, ['5.75'], 9, ['22.39'], 10, ['0.00'], 11, ['3.24'], 12, ['4.84'], 13, ['3.24'], 14, ['4.21'], 15, ['3.17'], 16, ['1.66'], 17, ['2.49'], 18, ['6.14'], 19, ['0.20'], 20, ['1.07'], 21, ['1.44'], 22, ['4.71'], 23, ['2.51'], 24, ['2.85'], 25, ['2.88'], 26, ['3.28'], 27, ['1.62'], 28, ['1.66'], 29, ['2.18'], 30, ['2.64'], 31, ['5.66'], 32, ['3.73'], 33, ['1.92'], 34, ['13.32'], 35, ['82.10'], 36, ['2.76'], 37, ['4.19'], 38, ['2.82'], 39, ['2.97'], 40, ['4.54'], 41, ['1.60'], 42, ['8.12'], 43, ['15.40'], 44, ['2.94'], 45, ['3.05'], 46, ['6.71']]

price = re.findall('\d+.\d+',str(price))

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
