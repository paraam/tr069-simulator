tr069-simulator
===============

This is a Java based TR069 Simulator for CPE devices. Currently this simulator supports <a href="http://www.broadband-forum.org/cwmp/cwmp-1-0.xsd">cwmp-1-0.xsd</a>
schema. Jibx tool has been used to bind the schema file into java classes.

This simulator can support different type of CPE devices. Also you can simulate hundreds of devices using the same instance.

How to use:
To run this simulator, 
1. download the tr069-0.6.2-SNAPSHOT.jar available under target directory within this repository.
2. download the simulator.yml and the agent.csv files available from the root directory.

agent.csv file is the csv configuration file that contains the following:
Start IPAddress  
End IPAddress
ACS Server URL
Connection Request URL
Http Port
Period Inform Interval
Dump Location Path
Username
Password
Authtype

You can modify these parameter according to your requirements. To simulate multiple CPE devices, provide the start and
end ipaddress. Periodic Inform Interval is in seconds. Simulator will send Inform request based on this parameter. 

Dump Location Path is the directory path where simulator will read and load the CPE data. 
Simulator will check for two set of files.
1. getvalues.txt
2. getnames.txt

getvalues.txt contains Name/Value data as XML Nodes. Simulator will respond to the ACS Server based on this Name/Value Pair.
getnames.txt contains ParameterInfoStruct XML Nodes. Access detail about the parameters are retrieved from this file.

Currently, Femtocell device dump is being bundled with the JAR. If the user wish to simulate a different CPE, either they need to 
create these xml two files manually or they need to take a dump from the real CPE device by reading the GetParameterValuesResponse 
and GetParameterNamesResponse.

If the ACS Server supports HTTP Authentication, provide the username, password and authentication type. Basic and Digest 
methods are currently supported.

To run:
java -jar tr069-0.6.2-SNAPSHOT.jar server simulator.yml

Note: Java must be available in your system.




