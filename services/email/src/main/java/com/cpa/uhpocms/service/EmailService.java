/**
 * @author  - Code Generator
 * @createdOn -  07-12-2022
 * @Description Entity class for Email Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.Email;

public interface EmailService {

	Email createEmail(Email email);

	Email getEmailByTitle(String title);

	List<Object> getAllEmails();

	Email updateEmail(Email email, String title);

	int deleteEmailByTitle(String title);

}