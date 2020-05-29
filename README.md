# StepProject-tinder

The task

Create the MVP of a dating app similar to Tinder

You can find ready HTML templates of all needed pages in the templates folder.

Teamwork

All students will work on this project in groups of three persons. Group members may split the tasks on their own discretion.

A list of the working endpoints in a fully finished application:

/users
/liked
/messages/{id}
/login
Suggested order of tasks execution (you are not required to follow it):

Create a new Maven app. Add required dependencies
Launch Jetty web-server
Create a test servlet which will output simple message 'Hello world' in the browser window
Map the test servlet to the "/users" path
Output a static HTML page with four elements - name, photo (a link to any picture from the web) and two buttons - Yes/No when requesting the "/users" path
Wrap the page in an HTML form
When a Yes/No button is pressed - send a POST request to the server (there is no handler there at the moment)
Add POST request handler on the server and store the user's choice (yes or no) on the server (in any form)
The doPost method should forward the request to the "/users" GET path
Create a few profiles (name + link to a picture from the web)
When a Yes/No button is pressed - show the next profile, the picture and name on the page should change
When the list of the available profiles runs out - start showing them again
Create a DAO class, store collection of profiles there
Add a servlet with the "/liked" address, output a static (hardcoded) list of profiles that user "liked"
After the user had clicked on all the available profiles, redirect him to the "/liked" page
"/liked" page should only show the profiles for which we pressed Yes
Add an "id" field to all profiles
Add a servlet with the "/messages/{id}" address, show a static chat with harcoded messages there
When clicking on some profile on the "/liked" page, redirect to the "/messages/{id}" page where you will show a harcoded dialogue with the user
Connect app to MySQL/PostgreSQL database (local or remote)
Write a new implementation of the DAO classes so that all the users are stored in the database
Show real messages between users on the "/messages/{id}" page
Add a possibility to make a POST request on the server with a new message on this page
Create a doPost method in the corresponding servlet, which will save the new message to the database
Add a simple login page to the "/login" path
Use Bootstrap templates as a base for all webpages
Use Freemarker template to output HTML pages
Handle POST method from the login page that will allow the user to log into the app. Store the data about the current user in cookies
Create an HttpFilter, which will redirect the non-logged in user to the login page
Add a posibility to log in from different accounts. Store each user's likes separately
Use remote database
Assemble the project into the executable JAR archive. Test locally that it is working
Deploy the project on Heroku (or AWS)
