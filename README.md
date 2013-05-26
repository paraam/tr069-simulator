tr069-simulator
===============

This is a Java based TR069 Simulator for CPE devices. Currently this simulator supports <a href="http://www.broadband-forum.org/cwmp/cwmp-1-0.xsd">cwmp-1-0.xsd</a>
schema. Jibx tool has been used to bind the schema file into java classes.

This simulator can support different type of CPE devices. Also you can simulate hundreds of devices using the same instance.

<b>How to use:</b><br>
To run this simulator,<br> 
1. download the tr069-0.6.2-SNAPSHOT.jar available under target directory within this repository.<br>
2. download the simulator.yml and the agent.csv files available from the root directory.<br>

<b>agent.csv</b> file is the csv configuration file that contains the following:<br>
Start IPAddress <br> 
End IPAddress<br>
ACS Server URL<br>
Connection Request URL<br>
Http Port<br>
Period Inform Interval<br>
Dump Location Path<br>
Username<br>
Password<br>
Authtype<br><br>

You can modify these parameter according to your requirements. To simulate multiple CPE devices, provide the start and<br>
end ipaddress. Periodic Inform Interval is in seconds. Simulator will send Inform request based on this parameter.<br><br> 

Dump Location Path is the directory path where simulator will read and load the CPE data. <br>
Simulator will check for two set of files.<br>
<b>1. getvalues.txt</b><br>
<b>2. getnames.txt</b><br><br>

getvalues.txt contains Name/Value data as XML Nodes. Simulator will respond to the ACS Server based on this Name/Value Pair.<br>
getnames.txt contains ParameterInfoStruct XML Nodes. Access detail about the parameters are retrieved from this file.
<br><br>
Currently, Femtocell device dump is being bundled with the JAR. If the user wish to simulate a different CPE, either they need to <br>
create these xml two files manually or they need to take a dump from the real CPE device by reading the GetParameterValuesResponse <br>
and GetParameterNamesResponse.<br><br>

If the ACS Server supports HTTP Authentication, provide the username, password and authentication type. Basic and Digest 
methods are currently supported.<br><br>

<b>To run:</b><br>
java -jar tr069-0.6.2-SNAPSHOT.jar server simulator.yml<br><br>

<b>Note:</b> Java must be available in your system.<br>




