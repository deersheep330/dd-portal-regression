# dd-portal-regression

### Test Portal
```
gradle clean build -Pbrowser=Chrome -Penv=Stage -Pmachine=local run testPortal copyTestResults
```

### Test Login 
```
gradle clean build -Pbrowser=Chrome -Penv=Stage -Pmachine=local run testLogin copyTestResults
docker run -v ${PWD}:/tmp jitesoft/tesseract-ocr /tmp/captcha.jpg stdout --psm 7
```
