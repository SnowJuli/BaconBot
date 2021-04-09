# Imports 
import PyInquirer
from instascrape import *
from selenium import webdriver

# Configuration
driver = webdriver.Firefox()
target = 'https://www.instagram.com/kinky_bacon/'
insta_profile = Profile(target)

# Query
insta_profile.scrape()
posts = insta_profile.get_posts(driver, amount=2, login_first=True, scrape=True, scrape_pause=5)

print(posts)