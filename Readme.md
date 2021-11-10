#### **1. Updates:**

   1.1. Command for possible updates: mvn versions:display-dependency-updates 
    
   _Output_: 
    
   [INFO] The following dependencies in Dependencies have newer versions:
                                                                     
   [INFO]   org.seleniumhq.selenium:selenium-java .............. 3.141.59 -> 4.0.0

   1.2. Command to update: mvn versions:use-latest-versions

   _Output_:
    
   [INFO] Major version changes allowed
    
   [INFO] Updated org.seleniumhq.selenium:selenium-java:jar:3.141.59 to version 4.0.0

___
#### **2. Mvn clean test**
 
   _Output_:
 
   [INFO] Tests run: 17, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 75.34 s - in TestSuite
    
___
#### **3. Command for running a certain test class:**

mvn clean -Dtest=DetailsTest test

**Command for running a certain test method:**

mvn clean -Dtest=DetailsTest#comparePriceOnDetailsPageTest test

**Command for running several test methods:**

mvn clean -Dtest=DetailsTest#comparePriceOnDetailsPageTest+compareNameOnDetailsPageTest test

___
#### **4. Command for parameters:**

mvn clean -Dtest=LoginTest#loginWithValidCredentialsTest -Dusername=standard_user -Dpassword=secret_sauce test

___
**Checklist to website https://www.saucedemo.com/**

1. Login (positive/negative tests) > checking the error message (for negative tests)
    
    _1.1 Login with valid credentials_
    
    _1.2 Login without username_
    
    _1.3 Login without password_
    
    _1.4 Login with empty fields_
2. Adding two articles into the cart > checking the number of elements in the cart
3. Deleting one element in the cart > checking the number of elements in the cart
4. Comparing details page name and price with ones on the products page
5. Filling fields on checkout page (positive/negative tests) > clicking Continue > checking error message (for negative tests)

    _5.1 Checkout with valid credentials_
    
    _5.2 Checkout without first name_
    
    _5.3 Checkout without last name_
    
    _5.4 Checkout without zip_
    
6. Checking the right page is opened after checkout is done