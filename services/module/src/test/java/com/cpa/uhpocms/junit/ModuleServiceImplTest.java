package com.cpa.uhpocms.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cpa.uhpocms.entity.Module;
import com.cpa.uhpocms.repository.ModuleRepo;
import com.cpa.uhpocms.service.ModuleService;

@SpringBootTest
public class ModuleServiceImplTest {
	@MockBean
	private static ModuleRepo moduleRepo;
	@Autowired
	private ModuleService moduleService;
	private Module module;
	private Module expect;

	@BeforeEach
	public void setUp() {
		System.out.println("BeforeEach ");
		Date createdDate = null;
		Date updatedDate = null;
		Date startDate = null;
		Date endDate = null;
		try {
			createdDate = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
			updatedDate = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-12");
			endDate = new SimpleDateFormat("yyyy-MM-dd").parse("2022-12-11");

		} catch (ParseException e) {
			e.printStackTrace();
		}
		// actual module
		this.module = new Module(8, "calculator", "chatting", true, startDate, endDate, 5, 5, 1, "admin", createdDate,
				"admin", updatedDate);
		// expected module
		this.expect = new Module(8, "calculator", "chatting", true, startDate, endDate, 5, 5, 1, "admin", createdDate,
				"admin", updatedDate);
	}

	@Test
	public void testGetModuleByName() {
		Mockito.when(moduleRepo.findByModuleName("calculator")).thenReturn(this.module);
		// System.out.println("expect " + expect.toString());
		Module result = moduleService.getModuleByName("calculator");
		// System.out.println("result " + result.toString());
		assertEquals(this.expect.toString(), result.toString());

	}

	@Test
	public void testGetAllModules() {
		List<Object> list = new ArrayList<Object>();
		list.add(this.module);
		Mockito.when(moduleRepo.findByModuleIsActiveTrue()).thenReturn(list);
		System.out.println("expect " + expect.toString());
		List<Object> result = moduleService.getAllModules();
		System.out.println("result " + result.toString());
		assertEquals(this.expect.toString(), result.get(0).toString());
	}

	@Test
	public void testCreateModule() {

		Date startDate = null;
		Date endDate = null;
		try {
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-12");
			endDate = new SimpleDateFormat("yyyy-MM-dd").parse("2022-12-11");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// creating module to create entry in table
		//Module module = new Module("calculator", "chatting", true, startDate, endDate, 5, 5, 1);
		Mockito.when(moduleRepo.save(module)).thenReturn(this.module);
		// result of module after creating
		Module result = moduleService.createModule(module);
		// comparing
		assertEquals(this.expect.toString(), result.toString());
	}

	@Test
	public void testUpdateModuleByName() {
		Date createdDate = null;
		Date updatedDate = null;
		Date startDate = null;
		Date endDate = null;
		try {
			createdDate = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
			updatedDate = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-12");
			endDate = new SimpleDateFormat("yyyy-MM-dd").parse("2022-12-11");

		} catch (ParseException e) {
			e.printStackTrace();
		}
		// exisiting module
		Module existing = new Module(8, "calculator", "chatting", true, startDate, endDate, 5, 5, 1, "admin",
				createdDate, "admin", updatedDate);
		// updating module to update entry in table
		//Module module = new Module("calculator", "calculation", false, startDate, endDate, 5, 5, 1);
		// expected module
		Module expect = new Module(8, "calculator", "calculation", false, startDate, endDate, 5, 5, 1, "admin",
				createdDate, "admin", updatedDate);

		Mockito.when(moduleRepo.findByModuleName("calculator")).thenReturn(existing);
		Module toUpdateQuestion = moduleRepo.findByModuleName("calculator");
		Mockito.when(moduleRepo.save(toUpdateQuestion)).thenReturn(expect);
		Module result = moduleService.updateModuleByName(module, "calculator");
		assertEquals(expect.toString(), result.toString());
	}

	@Test
	public void testDeleteModuleByName() {
		Mockito.when(moduleRepo.deleteModuleByName("calculator")).thenReturn(1);
		int count = moduleService.deleteModuleByName("calculator");
		assertEquals(count, 1);
	}

	@AfterEach
	public void tearDown() {
		System.out.println("After");
	}
}
