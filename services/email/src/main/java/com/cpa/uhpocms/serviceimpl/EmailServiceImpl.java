/**
 * @author - Code Generator
 * @createdOn 07-12-2022
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

	/**
	 * @param : Email email
	 * @return : Email createdEmail
	 * @description : For creating/inserting entry in teacher_email table
	 */
	@Override
	public Email createEmail(Email email) {
		logger.debug("Entering createEmail");
		Email createdEmail;

		email.setCreatedBy("admin");
		email.setModifiedBy("admin");

		createdEmail = emailRepo.save(email);
		logger.info("created Email :" + createdEmail);
		return createdEmail;
	}

	/**
	 * @param : String title
	 * @return : Email email
	 * @description : For get entry in teacher_email table
	 */
	@Override
	public Email getEmailByTitle(String title) {
		logger.debug("Entering getEmailByTitle");

		Email email = emailRepo.findByTitle(title);
		logger.info("Founded email :" + email);

		return email;
	}

	/**
	 * @return : List<Object> email
	 * @description : For fetching all email which are active state from teacher_email table
	 */
	@Override
	public List<Object> getAllEmails() {
		logger.debug("Entering getAllEmails");

		List<Object> emails = emailRepo.findByEmailIsActiveTrue();
		logger.info("Fetched all active email :" + emails);
		return emails;
	}

	/**
	 * @param : Email to update
	 * @return : email
	 * @description : For updating email of teacher_email table
	 */
	@Override
	public Email updateEmail (Email email, String title) {
		logger.debug("Entering updateEmail");

		Email toUpdatedEmail = null;
		Email updatedEmail = null;

		toUpdatedEmail = emailRepo.findByTitle(title);
		logger.info("exisitng Email :: " + toUpdatedEmail);

		if (toUpdatedEmail != null) {
			logger.debug("setting new data of Email to exisitng Email");

//			 Email.setSubject(email.getSubject());
//			  userEmail.setContent(email.getContent());	
//			  userEmail.setStatus(email.isStatus());
//			  userEmail.setReadStatus(email.isReadStatus());
//			  userEmail.setAttachFile(email.getAttachFile());
//			  userEmail.setEmailIsActive(email.isEmailIsActive());
			
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

	/**
	 * @param : String title
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of Email
	 * 
	 */
	@Override
	public int deleteEmailByTitle(String title) {
		logger.debug("Entering deleteEmailByTitle");

		
		return emailRepo.deleteByTitle(title);
	}

}
