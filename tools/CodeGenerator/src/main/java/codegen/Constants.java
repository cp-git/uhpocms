/**
 * For all the constants
 * Created on: 29-Nov-2022
 * Created by: Moorthy 

 */
package codegen;

/**
 * @author Moorthy
 *
 */
public interface Constants {

	public static final String MAIN_JAVA = "/src/main/java";

	public static final String MAIN_RESOURCE = "/src/main/resources";

	public static final String TEST_JAVA = "/src/test/java";

	public static final String TEST_RESOURCE = "/src/test/resources";

	public static final String VM_POM = "pom.vm";

	public static final String FILE_POM = "pom.xml";

	public static final String VM_SERVINIT = "servletinit.vm";

	public static final String FILE_SERVINIT = "ServletInitializer.java";

	public static final String PATH_SERVINIT = MAIN_JAVA + "/com/cpa/uhpocms";

	public static final String VM_APP = "uhpocapp.vm";

	public static final String FILE_APP = "Application.java";

	public static final String PATH_APP = PATH_SERVINIT;

	public static final String VM_APPYML = "appyaml.vm";

	public static final String FILE_APPYML = "application.yml";

	public static final String PATH_APPYML = MAIN_RESOURCE;

	public static final String VM_LOG4J = "log4j.vm";

	public static final String FILE_LOG4J = "log4j.xml";

	public static final String PATH_LOG4J = MAIN_RESOURCE;

	public static final String VM_CNTR = "controller.vm";

	public static final String PATH_CNTR = PATH_APP + "/controller";

	public static final String FILE_CNTR = "Controller.java";

	public static final String VM_ENTITY = "entity.vm";

	public static final String PATH_ENTITY = PATH_APP + "/entity";

	public static final String VM_REPO = "repo.vm";

	public static final String PATH_SERV = PATH_APP + "/service";

	public static final String VM_SERV = "service.vm";

	public static final String PATH_REPO = PATH_APP + "/repository";

	public static final String VM_EXCP = "exception.vm";

	public static final String PATH_EXCP = PATH_APP + "/exception";

	public static final String FILE_EXCP = "/CPException.java";

	public static final String PATH_HELP = PATH_APP + "/helper";

	public static final String VM_RESPP = "response.vm";

	public static final String FILE_RESP = "/ResponseHandler.java";

	public static final String PATH_IMPL = PATH_APP + "/serviceimpl";

	public static final String VM_IMPL = "impl.vm";

	public static final String VM_ERRUS = "errmsg.vm";

	public static final String FILE_ERRUS = "ErrorMessage_en_US.properties";

	public static final String PATH_ERRUS = MAIN_RESOURCE;
	
	public static final String PATH_DESIGN = "Design";
	
	public static final String VM_CLASS = "classdiag.vm";
	
	public static final String FILE_CLASS = "Class.txt";
	
	public static final String VM_POST = "postseq.vm";
	
	public static final String FILE_POST = "CreateSeq.txt";
	
	public static final String VM_GET = "getseq.vm";
	
	public static final String FILE_GET = "GetSeq.txt";
	
	public static final String VM_GETALL = "getall.vm";
	
	public static final String FILE_GETALL = "GetAllSeq.txt";
	
	public static final String VM_UPDATE = "updateseq.vm";
	
	public static final String FILE_UPDATE = "UpdateSeq.txt";

	public static final String VM_DELETE = "deleteseq.vm";
	
	public static final String FILE_DELETE = "DeleteSeq.txt";

}
