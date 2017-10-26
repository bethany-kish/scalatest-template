
# scalatest-template

This project is intended as a template or exemplar which can be extended to allow the running of Selenium tests written in ScalaTest.

System properties can be used to specify the browser type with which the tests should be run.

The following options are currently supported:

```
browser = chrome / headless / firefox
```
Note that chrome is the default and will be used should no alternative be provided.


As an example, to run those tests tagged as `SmokeTest` locally using chrome, the following can be run from a shell script
```
driver_path=/usr/local/bin/chromedriver
sbt -Dbrowser=chrome -Dwebdriver.chrome.driver=$driver_path clean 'test-only -- -n "uk.co.testcraft.tags.SmokeTest"'
```
    
Similarly, to run all tests using firefox, use:
    
```
driver_path=/usr/local/bin/geckodriver
sbt -Dbrowser=firefox -Dwebdriver.gecko.driver=${driver_path} test
```

The latest versions of the firefox and chrome browsers and their respective drivers should be installed.