###  SAMPLE FRAMEWORK created by Sylwester Cieślak 30-31.12.2020
  
## PROJECT DESCRIPTION
  
  This framework is writed in Gradle 5.6.4 with tools:  Selenium, TestNG and Allure reports.
  Framework giving possibility automate operations on calculator page: https://web2.0calc.com/
  This framework is sample to show how can be framework to automate pages using mentioned tools.
  Project created on Windows 10. Tests can be runed on two browswers: Chrome and Firefox.
  
  
  Project have
   
## SYSYEM REQURIREMENTS

    Windows 10
    Java 8 or higher
    Gradle
    Allure 
   
  
## PROJECT SETUP  
  
#####    1. Project have folder **allure** with .zip file - please unzip file to other directory and setup Allure system environment variable
        
######   Check if Allure variable is correctly set using command in CMD:
            
      allure -v
                           
#####    2. Download gradle version 5.6.4 from page:
 
      https://gradle.org/releases/
      
#####    3. Unzip file and  setup Gradle system environment variable 

######   Check if Gradle variable is correctly set using command in CMD:

      gradle -v
 
#####    4. Project have folder: "libs" where are placed drivers for browsers. Check your browser version and download correct driver and put them in to the "libs" folder

######   For this moment is placed chromedriver for Chrome 87 and geckodriver for newest version Firefox              

#####    5. To setup browser type set variable: "chrome" or "firefox" in file: test.properties


 
## STARTING PROJECT



#####    1. Open system console and go to the project folder
#####    2. To run all tests enter command:

     gradle test -i
     
#####    3. To run single test class enter command:

     gradle test -i --tests scenarios.CalculatorCases
     
#####    4. To run single test class enter command:

     gradle test -i --tests scenarios.CalculatorCases     

#####    5. To run single test enter command:

     gradle test -i --tests scenarios.CalculatorCases.<testName>
     
#####    Comands explanation

     gradle test - main comand to run tests in gradle (task test is created in build.gradle file)
     -i          - this option printing logs in console
     --tests     - filter for tests
     scenarios.CalculatorCases.<testName> - path to test class and single test
     
     
## OPENING ALLURE REPORT

######    To open report is needed Allure which was set before.
      
      
#####    1. Open system console and go to the project folder
#####    2. Enter comand to generate and open report

        allure serve

 
 
