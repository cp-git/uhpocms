/**
 * @author  - Code Generator
 * @createdOn -  06-12-2022
 * @Description Entity class for Email Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.Email;

public interface EmailService {

	//CREATE EMAIL
	Email createEmail(Email email);

	//GET EMAIL BY TITLE 
	Email getEmailByTitle(String title);

	// GET ALL EMAILS
	List<Object> getAllEmails();

	//UPDATE EMAIL BY TITLE
	Email updateEmailByTitle(Email email, String title);

	//DELETE EMAIL BY TITLE
	int deleteEmailByTitle(String title);

}