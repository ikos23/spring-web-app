cd /d E:\Edu\Java D3\LMS

call color 1F
call mode con: cols=100 lines=35
call mvn clean package -DskipTests

call cd /d E:\Edu\Java D3\jetty-distribution-9.3.11.v20160721\webapps
echo "+-------------------------------------------+"
echo "|   REMOVE OLD WAR                          |"
del /f /q "lms-web.war"
echo "+-------------------------------------------+"

echo "|   DEPLOY NEW WAR                          |"
echo "+-------------------------------------------+"

copy /Y "E:\Edu\Java D3\LMS\lms-web\target\lms-web.war" "E:\Edu\Java D3\jetty-distribution-9.3.11.v20160721\webapps"

echo "---------------------------------------------"
echo "---------------------------------------------"


