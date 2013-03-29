Download
   - git clone https://github.com/roqs23/jersey-jetty-executable-war-sample.git
   - cd jersey-jetty-executable-war-sample

Configure 
   - edit jetty.port in sample.properties

Run (Windows):
   - package.bat
   - run.bat

Run (non-Windows):
   - mvn clean package
   - java -DCONFIGPATH=.\sample.properties -jar .\target\jersey-jetty-executable-war-sample.war
   
Test:
   - http://localhost:8383/sample/hello/there/json
   - http://localhost:8383/sample/hello/there/xml/anything-goes-here
   
Enable Enunciate (Javadocs):
   - edit pom.xml and un-comment the enunciate plugin
   - mvn clean package
   - check the html generated inside the .\target\enunciate\build\docs\docs folder
   
