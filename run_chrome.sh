#! /bin/sh

driver_path=/usr/local/bin/chromedriver
sbt -Dbrowser=chrome -Dwebdriver.chrome.driver=$driver_path clean 'test-only -- -n "uk.co.testcraft.tags.SmokeTest"'