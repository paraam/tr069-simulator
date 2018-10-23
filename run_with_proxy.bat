cd "%~dp0"
java -Dhttp.proxyHost=localhost -Dhttp.proxyPort=8888 -jar target/tr069-0.7.0-SNAPSHOT.jar server simulator.yml