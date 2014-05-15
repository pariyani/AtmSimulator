AtmSimulator
============

In order to execute this project you need maven. Execute the following command mvn clean install. 
This will clean the target folder, execute the integrated tests (unless you set the flag to false), build the project, create a war file and will palce that war file in the target folder. 
You can install this war file to you application server. The second option is to use the comman mvn jetty:run. This will build the project and will run it on the jetty server. 

If you run it on the jetty server you can access the application on "http://localhost:8080/"

If you deploy it to your application server then you know which port and the application name you set in order to access it. 


"It should be possible to tell it that it has so many of each type of note during

initialisation. After initialisation, it is only possible to remove notes. 

 

It must know how many of each type of bank note it has and it should be able 

to report back how much of each note it has. 

 

It must support $20 and $50 notes. 

 

It should be able to dispense only legal combinations of notes. For example, a 

request for $100 can be satisfied by either five $20 notes or two $50 notes. It 

is not required to present a list of options. 

 

If a request cannot be satisfied due to failure to find a suitable combination of 

notes, it should report an error condition in some fashion. For example, in an 

ATM with only $20 and $50 notes, it is not possible to dispense $30. 

 

Dispensing money should reduce the amount of available cash in the 

machine. 

 

Failure to dispense money due to an error should not reduce the amount of 

available cash in the machine."


ATM Simulator
