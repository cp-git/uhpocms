//package com.cpa.uhpocms.serviceimpl;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.cpa.uhpocms.entity.Announcement;
//import com.cpa.uhpocms.repository.AnnouncementRepo;
//import com.cpa.uhpocms.service.AnnouncementService;
//
//@SpringBootTest
//public class AnnouncementServiceImplTest {
//
//	@MockBean
//	private static AnnouncementRepo announcementRepository;
//
//	@Autowired
//	private AnnouncementService announcementService;
//
//	private Announcement announcement;
//	private Announcement expect;
//
//	@BeforeEach
//	public void setUp() {
//		System.out.println("BeforeEach ");
//
//		Date createdOn = null;
//		try {
//			createdOn = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//
//		// actual announcement
//		this.announcement = new Announcement(1, "title", "msg", "abc@gmail.com", "mayur", "admin", createdOn);
//
//		// expected announcement
//		this.expect = new Announcement(1, "title", "msg", "abc@gmail.com", "mayur", "admin", createdOn);
//
//	}
//
//	@Test
//	public void testGetAnnouncementByTitle() {
//
//		Mockito.when(announcementRepository.findByAnnouncementTitle("title")).thenReturn(this.announcement);
//
//		// System.out.println("expect " + expect.toString());
//		Announcement result = announcementService.getAnnouncementByTitle("title");
//		// System.out.println("result " + result.toString());
//		assertEquals(this.expect.toString(), result.toString());
//
//	}
//
//	@Test
//	public void testGetAllAnnouncements() {
//
//		List<Object> list = new ArrayList<Object>();
//		list.add(this.announcement);
//		Mockito.when(announcementRepository.findByIdIsGreaterThan(0)).thenReturn(list);
//
//		System.out.println("expect " + expect.toString());
//		List<Object> result = announcementService.getAllAnnouncements();
//		System.out.println("result " + result.toString());
//		assertEquals(this.expect.toString(), result.get(0).toString());
//
//	}
//
//	@Test
//	public void testCreateAnnouncement() {
//
//		Date createdOn = null;
//		try {
//			createdOn = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//
//		// creating announcement to create entry in table
//		Announcement announcement = new Announcement(1, "title", "msg", "abc@gmail.com", "mayur", "admin", createdOn);
//
//		Mockito.when(announcementRepository.save(announcement)).thenReturn(this.announcement);
//
//		// result of announcement after creating
//		Announcement result = announcementService.createAnnouncement(announcement);
//
//		// comparing
//		assertEquals(this.expect.toString(), result.toString());
//	}
//
//	@Test
//	public void testUpdateAnnouncementByTitle() {
//
//		Date createdOn = null;
//		try {
//			createdOn = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
//		} catch (ParseException e) {
//
//			e.printStackTrace();
//		}
//
//		// exisiting announcement
//		Announcement existing = new Announcement(1, "title", "msg", "abc@gmail.com", "mayur", "admin", createdOn);
//
//		// updating announcement to update entry in table
//		Announcement announcement = new Announcement("title2", "msg2", "abc2@gmail.com");
//
//		// expected announcement
//		Announcement expect = new Announcement(1, "title2", "msg2", "abc2@gmail.com", "mayur", "admin", createdOn);
//
//		Mockito.when(announcementRepository.findByAnnouncementTitle("title")).thenReturn(existing);
//		Announcement toUpdateAnnouncement = announcementRepository.findByAnnouncementTitle("title");
//		Mockito.when(announcementRepository.save(toUpdateAnnouncement)).thenReturn(expect);
//
//		Announcement result = announcementService.updateAnnouncementByTitle(announcement, "title");
//
//		assertEquals(expect.toString(), result.toString());
//
//	}
//
//	@Test
//	public void testDeleteAnnouncementById() {
//		Mockito.when(announcementRepository.deleteByAnnouncementId(1)).thenReturn(1);
//
//		int count = announcementService.deleteAnnouncementById(1);
//
//		assertEquals(count, 1);
//
//	}
//
//	@AfterEach
//	public void tearDown() {
//		System.out.println("After");
//	}
//
//}
