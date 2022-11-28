/**
 * 
 */
package codegen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.texen.util.FileUtil;

/**
 * @author gjmah
 *
 */
public class CodeGenerator {

	public static void generatePomXML(VelocityEngine velocityEngine, String moduleName, String serviceName, String path) {
		Template t = velocityEngine.getTemplate("pom.vm");

		VelocityContext context = new VelocityContext();
		context.put("service", serviceName);
		context.put("module", moduleName);
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		
		try {
			
			FileWriter fw = new  FileWriter(new File(path + "/pom.xml"));
			fw.write(writer.toString());
			fw.close();
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		
	}

	public static void generateAppPackageFiles(VelocityEngine velocityEngine , String path) {

		Template t = velocityEngine.getTemplate("servletinit.vm");

		VelocityContext context = new VelocityContext();
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		try {
			
			FileWriter fw = new  FileWriter(new File(path + "/src/main/java/com/cpa/uhpocms/ServletInitializer.java"));
			fw.write(writer.toString());
			fw.close();
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		
		t = velocityEngine.getTemplate("uhpocapp.vm");

		context = new VelocityContext();
		writer = new StringWriter();
		t.merge(context, writer);
		try {
			
			FileWriter fw = new  FileWriter(new File(path + "/src/main/java/com/cpa/uhpocms/UhpocmsApplication.java"));
			fw.write(writer.toString());
			fw.close();
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}

	}
	
	public static void generateAppYaml(VelocityEngine velocityEngine , String path) {
		Template t = velocityEngine.getTemplate("appyaml.vm");

		VelocityContext context = new VelocityContext();
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		try {
			
			FileWriter fw = new  FileWriter(new File(path));
			fw.write(writer.toString());
			fw.close();
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}

	}

	public static void generateLog4j(VelocityEngine velocityEngine , String path, String serviceName, String moduleName) {
		Template t = velocityEngine.getTemplate("log4j.vm");

		VelocityContext context = new VelocityContext();
		context.put("module", moduleName);
		context.put("service", serviceName);
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		try {
			
			FileWriter fw = new  FileWriter(new File(path));
			fw.write(writer.toString());
			fw.close();
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}

	}

	public static void generateController(VelocityEngine velocityEngine , HashMap<String, String> props, String path) {
		Template t = velocityEngine.getTemplate("controller.vm");

		VelocityContext context = new VelocityContext();
		for ( String key : props.keySet() ) {
			context.put(key, props.get(key));
		}
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		try {
			
			FileWriter fw = new  FileWriter(new File(path));
			fw.write(writer.toString());
			fw.close();
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}	
	
	public static void createDirectories(String serviceName) {
		try {
			File f1 = new File(serviceName+"/src/main/java/com/cpa/uhpocms");
			f1.mkdirs();
			f1 = new File(serviceName+"/src/main/resources");
			f1.mkdirs();
			f1 = new File(serviceName+"/src/test/java");
			f1.mkdirs();
			f1 = new File(serviceName+"/src/test/resources");
			f1.mkdirs();
			f1 = new File(serviceName+"/src/main/java/com/cpa/uhpocms/controller");
			f1.mkdirs();
			
			f1 = new File(serviceName+"/src/main/java/com/cpa/uhpocms/entity");
			f1.mkdirs();
			
			f1 = new File(serviceName+"/src/main/java/com/cpa/uhpocms/exception");
			f1.mkdirs();
			
			f1 = new File(serviceName+"/src/main/java/com/cpa/uhpocms/repository");
			f1.mkdirs();
			
			f1 = new File(serviceName+"/src/main/java/com/cpa/uhpocms/service");
			f1.mkdirs();
			
			f1 = new File(serviceName+"/src/main/java/com/cpa/uhpocms/serviceimpl");
			f1.mkdirs();
			
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		VelocityEngine velocityEngine = new VelocityEngine();
		Properties velocityProperties = new Properties();
		velocityProperties.put("resource.loader", "class");
		velocityProperties.put("class.resource.loader.description", "Velocity Classpath Resource Loader");
		velocityProperties.put("class.resource.loader.class",
				"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		velocityProperties.put("file.resource.loader.class",
				"org.apache.velocity.runtime.resource.loader.FileResourceLoader");
		velocityProperties.put("file.resource.loader.path", "src/main/resources");
		velocityProperties.put("file.resource.loader.cache", "false");
		velocityEngine.init(velocityProperties);
		

		LocalDateTime ldt = LocalDateTime.now();
        String genDate = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH)
                                  .format(ldt);
		String rootFolder = "c:/CodeGen/";
		String serviceName = "answer";
		String moduleName = "Teacher";
		String Cservice = "Answer";
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("service", serviceName);
		map.put("module", moduleName);
		map.put("Cservice", "Answer");
		map.put("param", "content");
		map.put("uri", "answer");
		map.put("entity", "Answer");
		map.put("genDate", genDate); 
		createDirectories(rootFolder + serviceName);
		generatePomXML(velocityEngine, moduleName, serviceName, rootFolder + serviceName);
		generateAppPackageFiles(velocityEngine, rootFolder + serviceName);
		generateAppYaml(velocityEngine, rootFolder + serviceName + "/src/main/resources/application.yml");
		generateLog4j(velocityEngine, rootFolder + serviceName + "/src/main/resources/log4j.xml", serviceName, moduleName);
		generateController(velocityEngine, map, rootFolder + serviceName + "/src/main/java/com/cpa/uhpocms/controller/" + Cservice + "Controller.java");
		
		
	}

}
