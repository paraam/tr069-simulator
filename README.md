tr069-simulator
===============

This is a Java based TR069 Simulator for CPE devices. Currently this simulator supports <a href="http://www.broadband-forum.org/cwmp/cwmp-1-0.xsd">cwmp-1-0.xsd</a>
schema. Jibx tool has been used to bind the schema file into java classes.

This simulator can support different type of CPE devices. Also you can simulate hundreds of devices using the same instance.

<b>How to use:</b><br>
To run this simulator,<br> 
1. download the project and unzip it to a suitable location.<br>
2. Modify the agent.csv configuration file available in the root directory.<br>

<b>agent.csv</b> file is the csv configuration file that contains the following:<br>
<div class="highlight"><pre>
<span class="c1">startip, endip, acs_url, conn_req_url, http_port, periodic_inform, dump_location, username, password, authtype</span>
<span class="kd">192.168.1.111, 192.168.1.120, http://tr069.me/tr069/ws?wsdl&probe=257ebf, /wsdl, 8035, 300, /dump/microcell/, user1, passwd1, basic</span>
<span class="kd">192.168.2.211, 192.168.2.220, http://tr069.me/tr069/ws?wsdl&probe=257ebf, /wsdl, 8035, 300, /dump/microcell/, user1, passwd1, basic</span>
</pre></div>
Start IPAddress <br> 
End IPAddress<br>
ACS Server URL<br>
Connection Request URL<br>
Http Port<br>
Period Inform Interval<br>
Dump Location Path<br>
Username<br>
Password<br>
Authtype<br>

You can modify these parameter according to your requirements. To simulate multiple CPE devices, provide the start and<br>
end ipaddress. Periodic Inform Interval is in seconds. Simulator will send Inform request based on this parameter.<br><br> 

Dump Location Path is the directory path where simulator will read and load the CPE data. <br>
Simulator will check for two set of files.<br>
<b>1. getvalues.txt</b><br>
<b>2. getnames.txt</b><br>

getvalues.txt contains Name/Value data as XML Nodes. Simulator will respond to the ACS Server based on this Name/Value Pair.<br>
getnames.txt contains ParameterInfoStruct XML Nodes. Access detail about the parameters are retrieved from this file.
<br>
Currently, Femtocell device dump is being bundled with the JAR. If the user wish to simulate a different CPE, either they need to <br>
create these xml two files manually or they need to take a dump from the real CPE device by reading the GetParameterValuesResponse
and GetParameterNamesResponse.<br>

If the ACS Server supports HTTP Authentication, provide the username, password and authentication type. basic and digest 
methods are currently supported. If authentication is not supported, these fields are not required.<br><br>

<b>To run:</b><br>
<div class="highlight"><pre>
java -jar target/tr069-0.6.2-SNAPSHOT.jar server simulator.yml<br>
</pre></div>
<b>Note:</b> Java must be available in your system.
<br>

<b>License</b><br>
MIT License.<br>

<h2>Do you need an ACS Server to test your CPE devices?</h2>
Our company <a href="http://nmsserver.com">nmsserver.com</a> has a hosted ACS Server that runs as a service. This ACSServer
can support different types of CPE devices from different vendor. You can get a private account to monitor/configure 
you CPEs. This is absolutely free.<br>

Email to siva@nmsserver.com to get an ACSServer account. 



