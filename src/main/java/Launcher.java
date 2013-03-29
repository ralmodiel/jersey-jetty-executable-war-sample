/***************************************************************************8
 * Executable War File:
 *    http://internna.blogspot.com/2011/08/step-by-step-executable-war-files.html
 * To solve problem on loading jersey annotations on startup:
 *    http://jira.codehaus.org/browse/JETTY-1256
 * Annotation-based Resource configuration for Jersey:
 *    http://jersey.java.net/nonav/documentation/latest/jax-rs.html#d4e188
 *    see: Example 2.9. Deployment of a JAX-RS application using @ ApplicationPath with Servlet 3.0
 *
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.security.ProtectionDomain;
import java.util.Properties;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public final class Launcher {
	   public static void main(String[] args) throws Exception {
	      ProtectionDomain domain = Launcher.class.getProtectionDomain();
	      URL location = domain.getCodeSource().getLocation();
	      WebAppContext webapp = new WebAppContext();
	      webapp.setContextPath("/");
	     
	      webapp.setWar(location.toExternalForm());
	      //as enumerated from http://jira.codehaus.org/browse/JETTY-1256
	      String[] configurations = new String[]{
		          "org.eclipse.jetty.webapp.WebInfConfiguration"
		         ,"org.eclipse.jetty.webapp.WebXmlConfiguration"
		         ,"org.eclipse.jetty.webapp.MetaInfConfiguration"
		         ,"org.eclipse.jetty.webapp.FragmentConfiguration"
		         ,"org.eclipse.jetty.plus.webapp.EnvConfiguration"
		         //,"org.eclipse.jetty.plus.webapp.Configuration"
		         ,"org.eclipse.jetty.annotations.AnnotationConfiguration"
		         ,"org.eclipse.jetty.webapp.JettyWebXmlConfiguration"
		         //,"org.eclipse.jetty.annotations.ContainerInitializerConfiguration"
		         };
	      webapp.setAttribute("org.eclipse.jetty.webapp.configuration",  configurations);
	      webapp.setConfigurationClasses(configurations);

	      int port = 8282;
	      try{
	    	  //NOTE: default port in CONFIGPATH file is 8383
	    	  port = Integer.parseInt( load(new File(System.getProperty("CONFIGPATH"))).getProperty("jetty.port"));
	      }catch(Exception e){
	    	  e.printStackTrace();
	    	  System.out.println("ERROR: Invalid jetty.port value in configuration file.");
	      }
	      Server server = new Server(port);
	      server.setHandler(webapp);
	      server.start();
	      server.join();
	   }
	   
	   private static Properties load(File propsFile) throws IOException {
	        Properties props = new Properties();
	        FileInputStream fis = null;
	        try{
	            fis = new FileInputStream(propsFile);
	            props.load(fis);  
	        }finally{
	        	try{
	        		fis.close();
	        	}catch(Exception e){
	        	}
	        }  
	        return props;
	    }
	}
