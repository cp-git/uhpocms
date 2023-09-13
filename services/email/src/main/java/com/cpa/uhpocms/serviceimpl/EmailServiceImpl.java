/**
 * @author - Code Generator
 * @createdOn 06-12-2022
 * @Description Controller class for email
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cpa.uhpocms.controller.EmailController;
import com.cpa.uhpocms.entity.Email;
import com.cpa.uhpocms.repository.EmailRepo;
import com.cpa.uhpocms.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailRepo emailRepo;
	private static Logger logger;

	public EmailServiceImpl() {
		logger = Logger.getLogger(EmailServiceImpl.class);
	}

	
	//CREATE EMAIL
	@Override
	public Email createEmail(Email email) {
		logger.debug("Entering createEmail");
		Email createdEmail = null;

		email.setCreatedBy("admin");
		email.setModifiedBy("admin");
	

		createdEmail = emailRepo.save(email);
		logger.info("created Email :" + createdEmail);
		return createdEmail;
	}

	
	//GET EMAIL BY TITLE
	@Override
	public Email getEmailByTitle(String title) {
		logger.debug("Entering getEmailByTitle");

		Email email = emailRepo.findByTitle(title);
		logger.info("Founded email :" + email);

		return email;
	}

	
	//GET ALL EMAILS
	@Override
	public List<Object> getAllEmails() {
		logger.debug("Entering getAllEmails");

		List<Object> emails = emailRepo.findByEmailIsActiveTrue();
		logger.info("Fetched all active email :" + emails);
		return emails;
	}

	
	//UPDATE EMAIL BY TITLE
	@Override
	public Email updateEmailByTitle(Email email, String title) {
		logger.debug("Entering updateEmail");

		Email toUpdatedEmail = null;
		Email updatedEmail = null;

		toUpdatedEmail = emailRepo.findByTitle(title);
		logger.info("exisitng Email :: " + toUpdatedEmail);

		if (toUpdatedEmail != null) {
			logger.debug("setting new data of Email to exisitng Email");
		
			toUpdatedEmail.setTitle(email.getTitle());
			toUpdatedEmail.setSubject(email.getSubject());
			toUpdatedEmail.setContent(email.getContent());
			toUpdatedEmail.setStatus(email.isStatus());
			toUpdatedEmail.setReadStatus(email.isReadStatus());
			toUpdatedEmail.setAttachFile(email.getAttachFile());
			toUpdatedEmail.setEmailIsActive(email.isEmailIsActive());
			toUpdatedEmail.setEmailFormId(email.getEmailFormId());
			
		
						
			 updatedEmail = emailRepo.save(toUpdatedEmail);

			logger.info("updated Email :" + updatedEmail);
		}

		return updatedEmail;
	}

	
	//DELETE EMAIL BY TITLE
	@Override
	public int deleteEmailByTitle(String title) {
		logger.debug("Entering deleteEmailByTitle");

		int count =  emailRepo.deleteEmailByTitle(title);
		logger.info("deleted Email count : " + count);
		return count;
	}

}
