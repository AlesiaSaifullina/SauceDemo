###### Technology Stack:

1. Java 17
2. Maven 3.8.5
3. Selenium 3.141.59

###### Maven HomeWork
1. Команда для запуска всех тестов: 
######mvn clean test
   Tests run: 21, Failures: 2, Errors: 0, Skipped: 8, Time elapsed: 210.237 s <<< FAILURE!
2. Команда для просмотра доступных обновлений:
######mvn versions:display-dependency-updates
   org.seleniumhq.selenium:selenium-java .............. 3.141.59 -> 4.1.3
3. Команда для автоматического обновления всех версий:
######mvn versions:use-latest-versions
   Major version changes allowed
   [INFO] ------------------------------------------------------------------------
   [INFO] BUILD SUCCESS
   [INFO] ------------------------------------------------------------------------
   [INFO] Total time:  4.106 s
   [INFO] Finished at: 2022-03-29T15:27:35+03:00
4. Команда для запуска тестов из одного класса:
###### mvn test -Dtest=CartTest
[ERROR] Tests run: 2, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 36.772 s <<< FAILURE! 
5. Команда для запуска одного метода из класса:
###### mvn test -Dtest=LoginTest#userNameShouldBeRequired
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0


