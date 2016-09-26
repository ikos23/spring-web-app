call color 2f
call mode con: cols=90 lines=35
cd /d "E:\Edu\Java D3\jetty-distribution-9.3.11.v20160721"

start java -Xdebug -Xrunjdwp:transport=dt_socket,address=8585,server=y,suspend=n -jar start.jar
