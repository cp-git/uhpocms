package com.cpa.uhpocms.serviceimpl;

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

import com.cpa.uhpocms.entity.Email;
import com.cpa.uhpocms.repository.EmailRepo;
import com.cpa.uhpocms.service.EmailService;

@SpringBootTest
public class EmailServiceImplTest {

	@MockBean
	private static EmailRepo emailRepository;

	@Autowired
	private EmailService emailService;

	private Email email;
	private Email expect;

	@BeforeEach
	public void setUp() {
		System.out.println("BeforeEach ");

		Date createdOn = null;
		Date modifiedOn = null;
		try {
			createdOn = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
			modifiedOn = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// actual email
		 this.email = new Email(2, "kaushik@gmail.com", "student", "student content", createdOn, "admin"
				 , modifiedOn,"admin", true, false, "yes" ,true ,1 );
		// expected email
		 this.expect = new  Email(2, "kaushik@gmail.com", "student", "student content", createdOn, "admin"
				 , modifiedOn,"admin", true, false, "yes" ,true ,1 );

	}

	@Test
	public void testGetEmailByTitle() {

		Mockito.when(emailRepository.findByTitle("user")).thenReturn(this.email);

		// System.out.println("expect " + expect.toString());
		Email result = emailService.getEmailByTitle("user");
		// System.out.println("result " + result.toString());
		assertEquals(this.expect.toString(), result.toString());

	}

	@Test
	public void testGetAllEmails() {

		List<Object> list = new ArrayList<Object>();
		list.add(this.email);
		Mockito.when(emailRepository.findByEmailIsActiveTrue()).thenReturn(list);

		System.out.println("expect " + expect.toString());
		List<Object> result = emailService.getAllEmails();
		System.out.println("result " + result.toString());
		assertEquals(this.expect.toString(), result.get(0).toString());

	}

	@Test
	public void testCreateEmail() {

		/* Date joinedDate = null;
		try {
			joinedDate = new SimpleDateFormat("dd-MM-yyyy").parse("22-11-2022");
		} catch (ParseException e) {
			e.printStackTrace();
		}*/

		// creating email to create entry in table
		 this.email = new Email("kaushik@gmail.com", "student", "student content", true, false, "yes" ,true ,1);

		Mockito.when(emailRepository.save(email)).thenReturn(this.expect);

		// result of email after creating
		Email result = emailService.createEmail(email);

		// comparing
		assertEquals(this.expect.toString(), result.toString());
	}

	@Test
	public void testUpdateEmailByTitle() {

		Date createdOn = null;
		Date modifiedOn = null;
		try {
			createdOn = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
			modifiedOn = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
		} catch (ParseException e) {

			e.printStackTrace();
		}

		// exisiting email
		 Email existing = new Email(2, "kaushik@gmail.com", "student", "student content", createdOn, "admin"
				 , modifiedOn,"admin", true, false, "yes" ,true ,1 );
		// updating email to update entry in table
		Email email = new Email("kaushik@gmail.com", "student123", "student content123", true, false, "yes" ,true ,1);

		// expected email
		 Email expect = new Email(2, "kaushik@gmail.com", "student123", "student content123", createdOn, "admin"
				 , modifiedOn,"admin", true, false, "yes" ,true ,1 );

		Mockito.when(emailRepository.findByTitle("kaushik@gmail.com")).thenReturn(existing);
		Email toUpdateEmail = emailRepository.findByTitle("kaushik@gmail.com");
		Mockito.when(emailRepository.save(toUpdateEmail)).thenReturn(expect);

		Email result = emailService.updateEmailByTitle(email, "kaushik@gmail.com");

		assertEquals(expect.toString(), result.toString());

	}

	@Test
	public void testDeleteEmailByTitle() {
		Mockito.when(emailRepository.deleteEmailByTitle("kaushik@gmail.com")).thenReturn(1);

		int count = emailService.deleteEmailByTitle("kaushik@gmail.com");

		assertEquals(count, 1);

	}

	@AfterEach
	public void tearDown() {
		System.out.println("After");
	}

}
