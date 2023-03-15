/**
 * 
 * This class used to generate spring boot microservice as per the specificayion
 * Created on: 28-Nov-2022
 * Created by: Moorthy 
 * 
 */
package codegen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

/**
 * @author Moorthy
 *
 */
public class CodeGenerator {

	private static Properties props = new Properties();

	/**
	 * Load propject specific properties
	 * 
	 * @param propPath - actual file path
	 */
	public static void loadProperties(String propPath) {
		System.out.println("loadProperties started. The Parameters are :\n\tpropPath :: " + propPath + "\n");
		try {

			FileInputStream fis = new FileInputStream(propPath);
			props.load(fis);
			String findbys = props.get("findBy").toString().toLowerCase();
			props.put("findbys", findbys);

		} catch (Exception exp) {
			exp.printStackTrace();
		}
		System.out.println("loadProperties Ended.");
	}

	/**
	 * Create Directory Structure
	 * 
	 * @param serviceName - Name of the service - authuser or admin role etc
	 */
	public static void createDirectories(String serviceName) {
		System.out.println("createDirectories started. The Parameters are :\n\tserviceName :: " + serviceName + "\n");
		try {
			File f1 = new File(serviceName + Constants.PATH_APP);
			f1.mkdirs();
			System.out.println("\t" + serviceName + Constants.PATH_APP + " - Directory Created!!!");

			f1 = new File(serviceName + Constants.MAIN_RESOURCE);
			f1.mkdirs();
			System.out.println("\t" + serviceName + Constants.MAIN_RESOURCE + " - Directory Created!!!");

			f1 = new File(serviceName + Constants.MAIN_JAVA);
			f1.mkdirs();
			System.out.println("\t" + serviceName + Constants.MAIN_JAVA + " - Directory Created!!!");

			f1 = new File(serviceName + Constants.TEST_RESOURCE);
			f1.mkdirs();
			System.out.println("\t" + serviceName + Constants.TEST_RESOURCE + " - Directory Created!!!");

			f1 = new File(serviceName + Constants.PATH_CNTR);
			f1.mkdirs();
			System.out.println("\t" + serviceName + Constants.PATH_CNTR + " - Directory Created!!!");

			f1 = new File(serviceName + Constants.PATH_ENTITY);
			f1.mkdirs();
			System.out.println("\t" + serviceName + Constants.PATH_ENTITY + " - Directory Created!!!");

			f1 = new File(serviceName + Constants.PATH_EXCP);
			f1.mkdirs();
			System.out.println("\t" + serviceName + Constants.PATH_EXCP + " - Directory Created!!!");

			f1 = new File(serviceName + Constants.PATH_REPO);
			f1.mkdirs();
			System.out.println("\t" + serviceName + Constants.PATH_REPO + " - Directory Created!!!");

			f1 = new File(serviceName + Constants.PATH_HELP);
			f1.mkdirs();
			System.out.println("\t" + serviceName + Constants.PATH_HELP + " - Directory Created!!!");

			f1 = new File(serviceName + Constants.PATH_SERV);
			f1.mkdirs();
			System.out.println("\t" + serviceName + Constants.PATH_SERV + " - Directory Created!!!");

			f1 = new File(serviceName + Constants.PATH_IMPL);
			f1.mkdirs();
			System.out.println("\t" + serviceName + Constants.PATH_IMPL + " - Directory Created!!!");

			f1 = new File(serviceName + Constants.PATH_IMPL);
			f1.mkdirs();
			System.out.println("\t" + serviceName + Constants.PATH_IMPL + " - Directory Created!!!");

			f1 = new File(props.getProperty("rootFolder") + File.separator + props.getProperty("Cservice")
					+ Constants.PATH_DESIGN);
			f1.mkdirs();
			System.out.println("\t" + props.getProperty("rootFolder") + File.separator + props.getProperty("Cservice")
					+ Constants.PATH_DESIGN + " - Directory Created!!!");

		} catch (Exception exp) {
			exp.printStackTrace();
		}
		System.out.println("createDirectories Ended.");
	}

	/**
	 * To generate ErrorMessage_en_US.properties using the errmsg.vm velocity
	 * template
	 * 
	 * @param velocityEngine - velocity engine
	 * @param path           - base path - where to generate the code
	 */
	public static void generateErrorMessageEnUSFile(VelocityEngine velocityEngine, String path) {
		System.out.println("generateErroMessage_en_US_File started. The Parameters are :\n\tvelocityEngine :: "
				+ velocityEngine + "\n\tPath :: " + path + "\n");
		Template t = velocityEngine.getTemplate(Constants.VM_ERRUS);

		VelocityContext context = new VelocityContext();

		context.put("Cservice", props.get("Cservice"));
		context.put("findBy", props.get("findBy"));

		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		try {

			FileWriter fw = new FileWriter(
					new File(path + Constants.PATH_ERRUS + File.separatorChar + Constants.FILE_ERRUS));
			fw.write(writer.toString());
			fw.close();
			System.out.println("\t" + path + Constants.PATH_ERRUS + File.separatorChar + Constants.FILE_ERRUS
					+ " - file created !!!");

		} catch (Exception exp) {
			exp.printStackTrace();
		}
		System.out.println("generateErroMessage_en_US_File Ended.");
	}

	/**
	 * To generate pom.xml using the pom.vm velocity template
	 * 
	 * @param velocityEngine - velocity engine
	 * @param moduleName     - Module name like Admin or Teacher or Student
	 * @param serviceName    - Name of the service - authuser or admin role etc
	 * @param path           - base path - where to generate the code
	 */
	public static void generatePomXML(VelocityEngine velocityEngine, String moduleName, String serviceName,
			String path) {
		System.out.println("generatePomXML started. The Parameters are :\n\tvelocityEngine :: " + velocityEngine
				+ "\n\tmoduleName :: " + moduleName + "\n\tserviceName :: " + serviceName + "\n\tPath :: " + path
				+ "\n");
		Template t = velocityEngine.getTemplate(Constants.VM_POM);

		VelocityContext context = new VelocityContext();
		context.put("service", serviceName);
		context.put("module", moduleName);
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		try {

			FileWriter fw = new FileWriter(new File(path + File.separatorChar + Constants.FILE_POM));
			fw.write(writer.toString());
			fw.close();
			System.out.println("\t" + path + File.separatorChar + Constants.FILE_POM + " - file created!!!");
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		System.out.println("generatePomXML Ended.");
	}

	/**
	 * Generate application page files like ServiceNameApplication.java and
	 * Servletinitializer.java
	 * 
	 * @param velocityEngine - velocity engine
	 * @param path           - base path - where to generate the code
	 * @param Cservice       - Service Name in Camel Case -> AuthUser etc
	 */
	public static void generateAppPackageFiles(VelocityEngine velocityEngine, String path, String Cservice) {

		System.out.println("generateAppPackageFiles started. The Parameters are :\n\tvelocityEngine :: "
				+ velocityEngine + "\n\tCservice :: " + Cservice + "\n\tPath :: " + path + "\n");
		Template t = velocityEngine.getTemplate(Constants.VM_SERVINIT);

		VelocityContext context = new VelocityContext();
		StringWriter writer = new StringWriter();
		context.put("Cservice", Cservice);
		t.merge(context, writer);
		try {

			FileWriter fw = new FileWriter(
					new File(path + Constants.PATH_SERVINIT + File.separatorChar + Constants.FILE_SERVINIT));
			fw.write(writer.toString());
			System.out.println("\t" + path + Constants.PATH_SERVINIT + File.separatorChar + Constants.FILE_SERVINIT
					+ " - file created!!!");
			fw.close();

		} catch (Exception exp) {
			exp.printStackTrace();
		}

		t = velocityEngine.getTemplate(Constants.VM_APP);

		writer = new StringWriter();
		t.merge(context, writer);
		try {

			FileWriter fw = new FileWriter(
					new File(path + Constants.PATH_APP + File.separatorChar + Cservice + Constants.FILE_APP));
			fw.write(writer.toString());
			fw.close();
			System.out.println("\t" + path + Constants.PATH_APP + File.separatorChar + Cservice + Constants.FILE_APP
					+ " - file created !!!");

		} catch (Exception exp) {
			exp.printStackTrace();
		}
		System.out.println("generateAppPackageFiles Ended.");
	}

	/**
	 * Generate application.yaml file
	 * 
	 * @param velocityEngine - velocity engine
	 * @param path           - base path - where to generate the code
	 */
	public static void generateAppYaml(VelocityEngine velocityEngine, String path) {
		System.out.println("generateAppYaml started. The Parameters are :\n\tvelocityEngine :: " + velocityEngine
				+ "\n\tPath :: " + path + "\n");
		Template t = velocityEngine.getTemplate(Constants.VM_APPYML);

		VelocityContext context = new VelocityContext();
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		try {

			FileWriter fw = new FileWriter(
					new File(path + Constants.PATH_APPYML + File.separatorChar + Constants.FILE_APPYML));
			fw.write(writer.toString());
			fw.close();
			System.out.println("\t" + path + Constants.PATH_APPYML + File.separatorChar + Constants.FILE_APPYML
					+ " - file created !!!");

		} catch (Exception exp) {
			exp.printStackTrace();
		}
		System.out.println("generateAppYaml Ended.");
	}

	/**
	 * Generate Log4j.xml file
	 * 
	 * @param velocityEngine - velocity engine
	 * @param path           - base path - where to generate the code
	 * @param serviceName    - Name of the service - authuser or admin role etc
	 * @param moduleName     - Module name like Admin or Teacher or Student
	 */
	public static void generateLog4j(VelocityEngine velocityEngine, String path, String serviceName,
			String moduleName) {
		System.out.println("generateLog4j started. The Parameters are :\n\tvelocityEngine :: " + velocityEngine
				+ "\n\tmoduleName :: " + moduleName + "\n\tserviceName :: " + serviceName + "\n\tPath :: " + path
				+ "\n");
		Template t = velocityEngine.getTemplate(Constants.VM_LOG4J);

		VelocityContext context = new VelocityContext();
		context.put("module", moduleName);
		context.put("service", serviceName);
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		try {

			FileWriter fw = new FileWriter(
					new File(path + Constants.PATH_LOG4J + File.separatorChar + Constants.FILE_LOG4J));
			fw.write(writer.toString());
			fw.close();
			System.out.println("\t" + path + Constants.PATH_LOG4J + File.separatorChar + Constants.FILE_LOG4J
					+ " - file created !!!");
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		System.out.println("generateLog4j Ended.");
	}

	/**
	 * To Generate Controller file.
	 * 
	 * @param velocityEngine - velocity engine
	 * @param path           - base path - where to generate the code
	 * @param serviceName    - Name of the service - authuser or admin role etc
	 * 
	 */
	public static void generateController(VelocityEngine velocityEngine, String path, String serviceName) {
		System.out.println("generateController started. The Parameters are :\n\tvelocityEngine :: " + velocityEngine
				+ "\n\tserviceName :: " + serviceName + "\n\tPath :: " + path + "\n");
		Template t = velocityEngine.getTemplate(Constants.VM_CNTR);

		VelocityContext context = new VelocityContext();

		context.put("genDate", props.get("genDate"));
		context.put("Cservice", props.get("Cservice"));
		context.put("service", props.get("service"));
		context.put("uri", props.get("uri"));
		context.put("param", props.get("param"));
		context.put("entity", props.get("entity"));
		context.put("TableName", props.get("TableName"));
		context.put("findBy", props.get("findBy"));
		context.put("findbys", props.get("findbys"));
		context.put("entity", props.get("entity"));

		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		try {

			FileWriter fw = new FileWriter(
					new File(path + Constants.PATH_CNTR + File.separatorChar + serviceName + Constants.FILE_CNTR));
			fw.write(writer.toString());
			fw.close();
			System.out.println("\t" + path + Constants.PATH_CNTR + File.separatorChar + serviceName
					+ Constants.FILE_CNTR + " - file created !!!");

		} catch (Exception exp) {
			exp.printStackTrace();
		}
		System.out.println("generateController Ended.");
	}

	/**
	 * To generate Entity class
	 * 
	 * @param velocityEngine
	 */
	public static void generateEntity(VelocityEngine velocityEngine) {
		System.out
				.println("generateEntity started. The Parameters are :\n\tvelocityEngine :: " + velocityEngine + "\n");
		Template t = velocityEngine.getTemplate(Constants.VM_ENTITY);
		VelocityContext context = new VelocityContext();
		context.put("TableName", props.get("TableName"));
		context.put("Cservice", props.get("Cservice"));
		context.put("service", props.get("service"));
		context.put("genDate", props.get("genDate"));

		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		try {

			FileWriter fw = new FileWriter(new File(props.getProperty("rootFolder") + props.get("service")
					+ Constants.PATH_ENTITY + File.separatorChar + props.get("Cservice") + ".java"));
			fw.write(writer.toString());
			fw.close();
			System.out.println("\t" + props.getProperty("rootFolder") + props.get("service") + Constants.PATH_ENTITY
					+ File.separatorChar + props.get("Cservice") + ".java  - file created !!!");
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		System.out.println("generateEntity Ended.");
	}

	public static void generateRepo(VelocityEngine velocityEngine) {
		System.out.println("generateRepo started. The Parameters are :\n\tvelocityEngine :: " + velocityEngine + "\n");
		Template t = velocityEngine.getTemplate(Constants.VM_REPO);
		VelocityContext context = new VelocityContext();
		context.put("TableName", props.get("TableName"));
		context.put("Cservice", props.get("Cservice"));
		context.put("service", props.get("service"));
		context.put("genDate", props.get("genDate"));
		context.put("param", props.get("param"));
		context.put("findBy", props.get("findBy"));
		context.put("findbys", props.get("findbys"));
		context.put("entity", props.get("entity"));

		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		try {

			FileWriter fw = new FileWriter(new File(props.getProperty("rootFolder") + props.get("service")
					+ Constants.PATH_REPO + File.separatorChar + props.get("Cservice") + "Repo.java"));
			fw.write(writer.toString());
			fw.close();
			System.out.println("\t" + props.getProperty("rootFolder") + props.get("service") + Constants.PATH_REPO
					+ File.separatorChar + props.get("Cservice") + "Repo.java  - file created !!!");
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		System.out.println("generateRepo Ended.");

	}

	/**
	 * To generate Service Class
	 * 
	 * @param velocityEngine
	 */
	public static void generateService(VelocityEngine velocityEngine) {
		System.out
				.println("generateService started. The Parameters are :\n\tvelocityEngine :: " + velocityEngine + "\n");
		Template t = velocityEngine.getTemplate(Constants.VM_SERV);
		VelocityContext context = new VelocityContext();
		context.put("Cservice", props.get("Cservice"));
		context.put("service", props.get("service"));
		context.put("genDate", props.get("genDate"));
		context.put("findBy", props.get("findBy"));
		context.put("findbys", props.get("findbys"));

		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		try {

			FileWriter fw = new FileWriter(new File(props.getProperty("rootFolder") + props.get("service")
					+ Constants.PATH_SERV + File.separatorChar + props.get("Cservice") + "Service.java"));
			fw.write(writer.toString());
			fw.close();
			System.out.println("\t" + props.getProperty("rootFolder") + props.get("service") + Constants.PATH_SERV
					+ File.separatorChar + props.get("Cservice") + "Service.java  - file created !!!");
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		System.out.println("generateService Ended.");

	}

	/**
	 * To generate CPException.java file
	 * 
	 * @param velocityEngine
	 */
	public static void generateException(VelocityEngine velocityEngine) {
		System.out.println(
				"generateException started. The Parameters are :\n\tvelocityEngine :: " + velocityEngine + "\n");
		Template t = velocityEngine.getTemplate(Constants.VM_EXCP);
		VelocityContext context = new VelocityContext();

		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		try {

			FileWriter fw = new FileWriter(new File(props.getProperty("rootFolder") + props.get("service")
					+ Constants.PATH_EXCP + Constants.FILE_EXCP));
			fw.write(writer.toString());
			fw.close();
			System.out.println("\t" + props.getProperty("rootFolder") + props.get("service") + Constants.PATH_EXCP
					+ Constants.FILE_EXCP + " - file created !!!");
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		System.out.println("generateException Ended.");

	}

	/**
	 * To generate Response Handler java file
	 * 
	 * @param velocityEngine
	 */
	public static void generateResponseHandler(VelocityEngine velocityEngine) {
		System.out.println(
				"generateResponseHandler started. The Parameters are :\n\tvelocityEngine :: " + velocityEngine + "\n");
		Template t = velocityEngine.getTemplate(Constants.VM_RESPP);
		VelocityContext context = new VelocityContext();

		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		context.put("genDate", props.get("genDate"));
		context.put("Cservice", props.get("Cservice"));
		try {

			FileWriter fw = new FileWriter(new File(props.getProperty("rootFolder") + props.get("service")
					+ Constants.PATH_HELP + Constants.FILE_RESP));
			fw.write(writer.toString());
			fw.close();
			System.out.println("\t" + props.getProperty("rootFolder") + props.get("service") + Constants.PATH_HELP
					+ Constants.FILE_RESP + " - file created !!!");
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		System.out.println("generateResponseHandler Ended.");

	}

	/**
	 * To generate Service IMPL class
	 * 
	 * @param velocityEngine
	 */
	public static void generateImpl(VelocityEngine velocityEngine) {
		System.out.println(
				"generateResponseHandler started. The Parameters are :\n\tvelocityEngine :: " + velocityEngine + "\n");
		Template t = velocityEngine.getTemplate(Constants.VM_IMPL);
		VelocityContext context = new VelocityContext();

		StringWriter writer = new StringWriter();

		context.put("genDate", props.get("genDate"));
		context.put("Cservice", props.get("Cservice"));
		context.put("service", props.get("service"));
		context.put("uri", props.get("uri"));
		context.put("param", props.get("param"));
		context.put("entity", props.get("entity"));
		context.put("TableName", props.get("TableName"));
		context.put("findBy", props.get("findBy"));
		context.put("findbys", props.get("findbys"));

		t.merge(context, writer);
		try {

			FileWriter fw = new FileWriter(new File(props.getProperty("rootFolder") + props.get("service")
					+ Constants.PATH_IMPL + File.separatorChar + props.get("Cservice") + "ServiceImpl.java"));
			fw.write(writer.toString());
			fw.close();
			System.out.println("\t" + props.getProperty("rootFolder") + props.get("service") + Constants.PATH_IMPL
					+ File.separatorChar + props.get("Cservice") + "ServiceImpl.java - file created !!!");
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		System.out.println("generateResponseHandler Ended.");

	}

	/**
	 * To generate class diagram plantuml text file
	 * 
	 * @param velocityEngine
	 */
	public static void generateClassDiagram(VelocityEngine velocityEngine) {
		System.out.println(
				"generateClassDiagram started. The Parameters are :\n\tvelocityEngine :: " + velocityEngine + "\n");
		Template t = velocityEngine.getTemplate(Constants.VM_CLASS);
		VelocityContext context = new VelocityContext();
		StringWriter writer = new StringWriter();
		context.put("Cservice", props.get("Cservice"));
		context.put("service", props.get("service"));
		context.put("findBy", props.get("findBy"));
		context.put("entity", props.get("entity"));
		t.merge(context, writer);
		try {

			FileWriter fw = new FileWriter(new File(props.getProperty("rootFolder") + File.separator
					+ props.getProperty("Cservice") + Constants.PATH_DESIGN + File.separatorChar + props.get("Cservice")
					+ Constants.FILE_CLASS));
			fw.write(writer.toString());
			fw.close();
			System.out.println("\t" + props.getProperty("rootFolder") + File.separator + props.getProperty("Cservice")
					+ Constants.PATH_DESIGN + File.separatorChar + props.get("Cservice") + Constants.FILE_CLASS
					+ " - file created !!!");
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		System.out.println("generateClassDiagram Ended.");
	}

	/**
	 * To generate Post Sequence diagram plantuml text file
	 * 
	 * @param velocityEngine
	 */
	public static void generatePostSeqDiagram(VelocityEngine velocityEngine) {
		System.out.println(
				"generatePostSeqDiagram started. The Parameters are :\n\tvelocityEngine :: " + velocityEngine + "\n");
		Template t = velocityEngine.getTemplate(Constants.VM_POST);
		VelocityContext context = new VelocityContext();
		StringWriter writer = new StringWriter();
		context.put("Cservice", props.get("Cservice"));
		context.put("service", props.get("service"));
		context.put("findBy", props.get("findBy"));
		t.merge(context, writer);
		try {
			FileWriter fw = new FileWriter(new File(props.getProperty("rootFolder") + File.separator
					+ props.getProperty("Cservice") + Constants.PATH_DESIGN + File.separatorChar + props.get("Cservice")
					+ Constants.FILE_POST));
			fw.write(writer.toString());
			fw.close();
			System.out.println("\t" + props.getProperty("rootFolder") + File.separator + props.getProperty("Cservice")
					+ Constants.PATH_DESIGN + File.separatorChar + props.get("Cservice") + Constants.FILE_POST
					+ " - file created !!!");
		} catch (Exception exp) {
			exp.printStackTrace();
		}

		System.out.println("generatePostSeqDiagram Ended.");
	}

	/**
	 * To generate Get Sequence diagram plantuml text file
	 * 
	 * @param velocityEngine
	 */
	public static void generateGetSeqDiagram(VelocityEngine velocityEngine) {
		System.out.println(
				"generateGetSeqDiagram started. The Parameters are :\n\tvelocityEngine :: " + velocityEngine + "\n");
		Template t = velocityEngine.getTemplate(Constants.VM_GET);
		VelocityContext context = new VelocityContext();
		StringWriter writer = new StringWriter();
		context.put("Cservice", props.get("Cservice"));
		context.put("service", props.get("service"));
		context.put("findbys", props.get("findbys"));
		context.put("findBy", props.get("findBy"));
		context.put("entity", props.get("entity"));
		t.merge(context, writer);
		try {
			FileWriter fw = new FileWriter(
					new File(props.getProperty("rootFolder") + File.separator + props.getProperty("Cservice")
							+ Constants.PATH_DESIGN + File.separatorChar + props.get("Cservice") + Constants.FILE_GET));
			fw.write(writer.toString());
			fw.close();
			System.out.println("\t" + props.getProperty("rootFolder") + File.separator + props.getProperty("Cservice")
					+ Constants.PATH_DESIGN + File.separatorChar + props.get("Cservice") + Constants.FILE_GET
					+ " - file created !!!");
		} catch (Exception exp) {
			exp.printStackTrace();
		}

		System.out.println("generateGetSeqDiagram Ended.");
	}

	/**
	 * To generate Get All Sequence diagram plantuml text file
	 * 
	 * @param velocityEngine
	 */
	public static void generateGetAllSeqDiagram(VelocityEngine velocityEngine) {
		System.out.println(
				"generateGetAllSeqDiagram started. The Parameters are :\n\tvelocityEngine :: " + velocityEngine + "\n");
		Template t = velocityEngine.getTemplate(Constants.VM_GETALL);
		VelocityContext context = new VelocityContext();
		StringWriter writer = new StringWriter();
		context.put("Cservice", props.get("Cservice"));
		context.put("service", props.get("service"));
		context.put("findbys", props.get("findbys"));
		context.put("findBy", props.get("findBy"));
		context.put("param", props.get("param"));
		t.merge(context, writer);
		try {
			FileWriter fw = new FileWriter(new File(props.getProperty("rootFolder") + File.separator
					+ props.getProperty("Cservice") + Constants.PATH_DESIGN + File.separatorChar + props.get("Cservice")
					+ Constants.FILE_GETALL));
			fw.write(writer.toString());
			fw.close();
			System.out.println("\t" + props.getProperty("rootFolder") + File.separator + props.getProperty("Cservice")
					+ Constants.PATH_DESIGN + File.separatorChar + props.get("Cservice") + Constants.FILE_GETALL
					+ " - file created !!!");
		} catch (Exception exp) {
			exp.printStackTrace();
		}

		System.out.println("generateGetAllSeqDiagram Ended.");
	}

	/**
	 * To generate Update Sequence diagram plantuml text file
	 * 
	 * @param velocityEngine
	 */
	public static void generateUpdateSeqDiagram(VelocityEngine velocityEngine) {
		System.out.println(
				"generateUpdateSeqDiagram started. The Parameters are :\n\tvelocityEngine :: " + velocityEngine + "\n");
		Template t = velocityEngine.getTemplate(Constants.VM_UPDATE);
		VelocityContext context = new VelocityContext();
		StringWriter writer = new StringWriter();
		context.put("Cservice", props.get("Cservice"));
		context.put("service", props.get("service"));
		context.put("findbys", props.get("findbys"));
		context.put("findBy", props.get("findBy"));
		context.put("param", props.get("param"));
		t.merge(context, writer);
		try {
			FileWriter fw = new FileWriter(new File(props.getProperty("rootFolder") + File.separator
					+ props.getProperty("Cservice") + Constants.PATH_DESIGN
					+ File.separatorChar + props.get("Cservice") + Constants.FILE_UPDATE));
			fw.write(writer.toString());
			fw.close();
			System.out.println("\t" + props.getProperty("rootFolder") + File.separator
					+ props.getProperty("Cservice") + Constants.PATH_DESIGN + File.separatorChar
					+ props.get("Cservice") + Constants.FILE_UPDATE + " - file created !!!");
		} catch (Exception exp) {
			exp.printStackTrace();
		}

		System.out.println("generateUpdateSeqDiagram Ended.");
	}

	/**
	 * To generate Delete Sequence diagram plantuml text file
	 * 
	 * @param velocityEngine
	 */
	public static void generateDeleteSeqDiagram(VelocityEngine velocityEngine) {
		System.out.println(
				"generateDeleteSeqDiagram started. The Parameters are :\n\tvelocityEngine :: " + velocityEngine + "\n");
		Template t = velocityEngine.getTemplate(Constants.VM_DELETE);
		VelocityContext context = new VelocityContext();
		StringWriter writer = new StringWriter();
		context.put("Cservice", props.get("Cservice"));
		context.put("service", props.get("service"));
		context.put("findbys", props.get("findbys"));
		context.put("findBy", props.get("findBy"));
		context.put("param", props.get("param"));
		t.merge(context, writer);
		try {
			FileWriter fw = new FileWriter(new File(props.getProperty("rootFolder")  + File.separator
					+ props.getProperty("Cservice") + Constants.PATH_DESIGN
					+ File.separatorChar + props.get("Cservice") + Constants.FILE_DELETE));
			fw.write(writer.toString());
			fw.close();
			System.out.println("\t" + props.getProperty("rootFolder") + File.separator
					+ props.getProperty("Cservice") +  Constants.PATH_DESIGN + File.separatorChar
					+ props.get("Cservice") + Constants.FILE_DELETE + " - file created !!!");
		} catch (Exception exp) {
			exp.printStackTrace();
		}

		System.out.println("generateDeleteSeqDiagram Ended.");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Code Generation started....");

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

		loadProperties(
				"F:\\uhpocms_project\\BE\\main_branch\\uhpocms\\tools\\CodeGenerator\\src\\main\\resources\\CodeGen.properties");

		String rootFolder = props.getProperty("rootFolder");
		String serviceName = props.getProperty("service");
		String moduleName = props.getProperty("module");
		String Cservice = props.getProperty("Cservice");
		createDirectories(rootFolder + serviceName);
		generatePomXML(velocityEngine, moduleName, serviceName, rootFolder + serviceName);
		generateAppPackageFiles(velocityEngine, rootFolder + serviceName, Cservice);
		generateAppYaml(velocityEngine, rootFolder + serviceName);
		generateLog4j(velocityEngine, rootFolder + serviceName, serviceName, moduleName);
		generateController(velocityEngine, rootFolder + serviceName, Cservice);
		generateErrorMessageEnUSFile(velocityEngine, rootFolder + serviceName);
		generateEntity(velocityEngine);
		generateRepo(velocityEngine);
		generateService(velocityEngine);
		generateException(velocityEngine);
		generateResponseHandler(velocityEngine);
		generateImpl(velocityEngine);
		generateClassDiagram(velocityEngine);
		generatePostSeqDiagram(velocityEngine);
		generateGetSeqDiagram(velocityEngine);
		generateGetAllSeqDiagram(velocityEngine);
		generateUpdateSeqDiagram(velocityEngine);
		generateDeleteSeqDiagram(velocityEngine);
		System.out.println(props.get("Cservice"));
		System.out.println("Code Generated under " + rootFolder + serviceName + " ...");
	}

}
