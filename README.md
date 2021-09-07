# dd-portal-regression

```
gradle clean build -Pbrowser=Chrome -Penv=Stage -Pmachine=local run testPortal copyTestResults
```
 docker run -v ${PWD}:/tmp jitesoft/tesseract-ocr /tmp/captcha.jpg stdout --psm 7