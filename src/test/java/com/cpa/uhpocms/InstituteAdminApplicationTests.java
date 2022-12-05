package com.cpa.uhpocms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InstituteAdminApplicationTests {

	@Test
	void contextLoads() {
	}

//	@MockBean
//	private InstituteAdminRepository instituteAdminRepository;
//
//	@Autowired
//	private InstituteAdminService instituteAdminService;
//
//	private InstituteAdmin admin;
//
//	private InstituteAdmin admin1;
//
//	@BeforeEach
//	public void setUp() {
//
//		Date createdOn = null;
//		Date modifiedOn = null;
//
//		try {
//			createdOn = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
//			modifiedOn = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
//
//		} catch (ParseException e) {
//			e.printStackTrace();
//		} catch (java.text.ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		this.admin = new InstituteAdmin(1, "admin", "ravi", "g", "ravi", "12-10-2022", "1223", "Male", 1, "khradi",
//				"kharadi", "pune", "mh", "123", "ad", "admin", createdOn, "admin", modifiedOn, false, 1, 1);
//
//		this.admin1 = new InstituteAdmin(1, "admin", "ravi", "g", "ravi", "12-10-2022", "1223", "Male", 1, "khradi",
//				"kharadi", "pune", "mh", "123", "ad", "admin", createdOn, "admin", modifiedOn, false, 1, 1);
//
//	}
//
//	@Test
//	public void testInstituteAdminByFirstName() {
//
////		InstituteAdmin instituteAdmin = new InstituteAdmin(1, "admin", "ravi", "g", "ravi", "12-10-2022", "1223",
////				"Male", 1, "khradi", "kharadi", "pune", "mh", "123", "ad", "admin", dt, "admin", dt1, false, 1, 1);
////		InstituteAdmin instituteAdmin2 = new InstituteAdmin();
//		System.out.println("expect " + admin.toString());
//		Mockito.when(instituteAdminRepository.findByFirstName("ravi")).thenReturn(this.admin);
//		System.out.println("expect " + admin.toString());
//		InstituteAdmin adminResult = instituteAdminService.getInstitutebyName("ravi");
//		System.out.println("result " + adminResult.toString());
//		assertEquals(this.admin1.toString(), adminResult.toString());
//	}
//
//	@Test
//	public void testDeleteInstituteAdminByUserName() {
//		Mockito.when(instituteAdminRepository.deleteDepartmentById("ravi")).thenReturn(1);
//		int count = instituteAdminService.deleteDepartmentById("ravi");
//		assertEquals(count, 1);
//	}
//
//	@Test
//	public void testGetAllInstituteUser() {
//		List<InstituteAdmin> list = new ArrayList<InstituteAdmin>();
//		list.add(this.admin);
//		Mockito.when(instituteAdminRepository.findAll()).thenReturn(list);
//		System.out.println("expect " + admin1.toString());
//		List<Object> result = instituteAdminService.getAllInstitute();
//		System.out.println("result " + result.toString());
//		assertEquals(this.admin1.toString(), result.get(0).toString());
//	}
//
//	@Test
//	public void testCreateInstituteADminUser() {
//		Date dt = new Date();
//		Date dt1 = new Date();
//
//		InstituteAdmin insAdmin = new InstituteAdmin(1, "admin", "ravi", "g", "ravi", "12-10-2022", "1223", "Male", 1,
//				"khradi", "kharadi", "pune", "mh", "123", "ad", false, 1, 1);
//
//		insAdmin.setCreatedBy("admin");
//		insAdmin.setModifiedBy("admin");
//
//		Mockito.when(instituteAdminRepository.save(insAdmin)).thenReturn(this.admin);
//
//		InstituteAdmin admindata = instituteAdminService.saveInstituteAdmin(insAdmin);
//
//		assertEquals(this.admin1.toString(), admindata.toString());
//	}

//	@Test
//	public void testUpdateInstituteUser() {
//		Date createdOn = null;
//		Date modifiedOn = null;
//		
//		try {
//			createdOn = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
//			modifiedOn = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
//			
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		
//		InstituteAdmin insAdmin = new InstituteAdmin(1, "admin", "ravi", "g", "ravi", "12-10-2022", "1223", "Male", 1,
//				"khradi", "kharadi", "pune", "mh", "123", "ad", "admin", createdOn, "admin", modifiedOn, false, 1, 1);
//	
//		InstituteAdmin insAdmin1 = new InstituteAdmin(1,"admin", "ravindra", "g", "ravi", "12-10-2022", "1223", "Male", 1,
//				"khradi", "kharadi", "pune", "mh", "123", "ad", "admin", createdOn, "admin", modifiedOn, false, 1, 1);
//		
//		InstituteAdmin insAdmin2 = new InstituteAdmin(1, "admin", "ravindra", "g", "ravi", "12-10-2022", "1223", "Male", 1,
//				"khradi", "kharadi", "pune", "mh", "123", "ad", "admin", createdOn, "admin", modifiedOn, false, 1, 1);
//		Mockito.when(instituteAdminRepository.save(insAdmin)).thenReturn(insAdmin2);
//		InstituteAdmin insresult = instituteAdminService.updateInstituteAdmin(insAdmin, insAdmin1);
//		assertEquals(insAdmin2.toString(), insresult.toString());
//	}
}
