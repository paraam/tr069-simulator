cd "%~dp0"
java -Dhttps.proxyHost=127.0.0.1 -Dhttps.proxyPort=8888 -jar target/tr069-0.7.0-SNAPSHOT.jar server simulator.yml