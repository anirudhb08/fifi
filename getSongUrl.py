#!/usr/bin python
import urllib2
from bs4 import BeautifulSoup
import webbrowser
import sys

url = 'http://gaana.com/search/'+sys.argv[1]
req = urllib2.Request(url);
response = urllib2.urlopen(req)
htmlCode = response.read()
soup = BeautifulSoup(htmlCode,'html.parser')

g = ""

for link in soup.find_all('a'):
	g = str(link.get('href'))
	f = g.find("/song/")
	if(f!=-1):
		#print(g)
		webbrowser.open(g, new = 0);
		break

songUrl = g

req = urllib2.Request(songUrl);
response = urllib2.urlopen(req)
htmlCode = response.read()
soup = BeautifulSoup(htmlCode,'html.parser')

allAnchor = soup.findAll("a")
songDuration = ""

for a in allAnchor:
	g = str(a.get('href'))
	f = g.find(songUrl)
	if(g==songUrl):
		timeTag = a.parent.find_next_sibling("li").find_next_sibling("li").findChildren()
		songDuration = timeTag[0].text
		break

timeInSeconds = int(songDuration[2])*60+(int(songDuration[4])*10+int(songDuration[5]))
print(timeInSeconds)
