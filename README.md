Movies App Test
In this exercise, you will be automating the process of testing the Movies App.

Prerequisites
Install IntelliJ IDEA Community IDE Version 2018.3.6.
Install OpenJDK 11 and complete the configuration.
Install a Browser Driver(Chrome Driver).
Setup a Selenium project with the name MoviesAppTest.
Update the Build in pom.xml. Refer to previous exercises for reference.
Application URL : https://qamoviesapp.ccbp.tech

Test Instructions
Create a new package pages in the src/test/java directory.
Create classes in the pages package and define the required locators and methods for performing actions on the web pages.

List of Pages
Login Page
Home Page
Accounts Page
Popular Page
Search Page
You can create your own classes as per your requirement

Use TestNG, POM, and BDD concepts to write the test cases.

Tests

Note: The test cases should be executed in the same order as given below

Create a LoginPageTest class and write the test cases for the below test scenarios,

Test the Login Page UI
Test whether the Website logo image is displayed,
Test whether the Heading text is "Login",
Test whether the Username label text is "USERNAME",
Test whether the Password label text is "PASSWORD",
Test the "Login" button,
Close the browser window.
Test the Login Page Functionalities
Test the login functionality with empty input fields,
Test the login functionality with empty USERNAME,
Test the login functionality with an empty PASSWORD,
Test the login functionality with Invalid Credentials (correct username and wrong password),
Correct Login Credentials: Username: "rahul", Password: "rahul@2021"
Test the login functionality with Valid Credentials,
Close the browser window.
Create a HomePageTest class and write the test cases for the below test scenarios,

Test the Home Page
Test the heading texts of each section
Test whether the play button is displayed or not
Test whether the Movies are displayed, in the corresponding movies sections
Test the Contact Us Section
Close the browser window.
Create a HeaderSectionTest class and write the test cases for the below test scenarios,

Test the Header Section UI
Test whether the Website logo is displayed
Test the Navbar elements
Close the browser window.
Test the Header Section Functionalities
Test the navigation to Home and Popular pages through elements in header section
Test the navigation to account page through elements in header section
Close the browser window.
Create a PopularPageTest class and write the test cases for the below test scenarios,

Test the Popular Page UI
Test whether the movies are displayed
Create a SearchPageTest class and write the test cases for the below test scenarios,

Test the Search Functionality
Test the Search functionality by searching with some movie names and the count of movies displayed
Close the browser window.
Create a MovieDetailsPageTest class and write the test cases for the below test scenarios,

Test the Movie Details Page
In the Home Page click on any Movie and test all the UI elements present in it
In the Popular Page click on any Movie and test all the UI elements present in it
Close the browser window.
Create a AccountPageTest class and write the test cases for the below test scenarios,

Test the Account Page
Test all the UI elements present on the web page.
Test the Logout functionality
Close the browser window.
