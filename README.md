Configure 
   - edit jetty.port in sample.properties 

Run (Windows):
    package.bat
	run.bat

Run (non-Windows):
    mvn clean package
	java -DCONFIGPATH=.\sample.properties -jar .\target\jersey-jetty-executable-war-sample.war
	
Enable Enunciate (Javadocs):
    - edit pom.xml and un-comment the enunciate plugin
	- mvn clean package
	- check the docs generated inside the target folder
	