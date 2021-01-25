import requests
from bs4 import BeautifulSoup
# url = input("Enter the url: ")
# r = requests.get(url)
# soup = BeautifulSoup(r.content,'lxml')
page = 60
while page != 100:
    page += 1
    print(page)
    r = requests.get('https://euw.op.gg/ranking/ladder/page='+str(page))
    # print(html_content)

    print(r.content)
    # if len(matches) == 0:
    #    print('I did not find anything')
    # else:
    #    print('My string is in the html')
