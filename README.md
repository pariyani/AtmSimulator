AtmSimulator
============

In order to execute this project you need maven. Execute the following command mvn clean install. 
This will clean the target folder, execute the integrated tests (unless you set the flag to false), build the project, create a war file and will palce that war file in the target folder. 
You can install this war file to you application server. The second option is to use the comman mvn jetty:run. This will build the project and will run it on the jetty server. 

If you run it on the jetty server you can access the application on "http://localhost:8080/"

If you deploy it to your application server then you know which port and the application name you set in order to access it. 



ATM Simulator
