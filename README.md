# Автоматизации тестирования API на тестовом сайте https://reqres.in/api
## :link: <a target="_blank" href="https://reqres.in/api">https://reqres.in/api - ресурс для тестирования API</a>

## :page_with_curl: Содержание:

- <a href="#computer-сode_stack">Технологии и инструменты</a>
- <a href="#clipboard-реализованные-проверки">Реализованные проверки</a>
- <a href="#robot-сборки-в-Jenkins">Сборка в Jenkins</a>
- <a href="#keyboard-запуск-из-терминала">Запуск из терминала</a>
- <a href="#bar_chart-allure-отчет">Allure отчет</a>

## :computer: Технологии и инструменты
<p align="left">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Rest Assured" src="images/logo/Rest_assured.png">
</p>

## :clipboard: Реализованные проверки
- Проверка создания юзера :heavy_check_mark:
- Проверка обновления данных юзера :heavy_check_mark:


## :robot: Сборка в Jenkins
### <a target="_blank" href="https://jenkins.autotests.cloud/job/C12-Yuliya_B-RestApiDemoShop18">Cборка в Jenkins</a>
<p align="center">
<img title="Jenkins Job Run with parameters" src="images/screenshots/jenkins-run.png">
</p>
<p align="center">
<img title="Jenkins Dashboard" src="images/screenshots/jenkins-dashboard-all.png">
</p>

## :keyboard: Запуск из терминала
Локальный запуск всех тестов:
```
gradle clean test
```
Удаленный запуск всех тестов:
```
clean test
```
  
## :bar_chart: Allure отчет
- ### Главный экран отчета
<p align="center">
<img title="Allure Overview Dashboard" src="images/screenshots/allure-main-page.png">
</p>

- ### Страница с проведенными тестами
<p align="center">
<img title="Allure Test Page" src="images/screenshots/allure-test-page.png">
</p>
