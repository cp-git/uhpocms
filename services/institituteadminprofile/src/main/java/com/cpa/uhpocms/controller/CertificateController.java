package com.cpa.uhpocms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.http.MediaType;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;

import com.cpa.uhpocms.entity.EmailRequest;
import com.cpa.uhpocms.entity.InstituteAdmin;
import com.cpa.uhpocms.entity.PdfUtils;
import com.cpa.uhpocms.service.InstituteAdminService;
import com.itextpdf.text.DocumentException;

import java.io.File; // Add this import statement



@CrossOrigin
@RestController
@RequestMapping("/uhpocms")
public class CertificateController {
    
	@Autowired
    private JavaMailSender emailSender;
	
	@Autowired
	private InstituteAdminService profileServ; 

private SimpleMailMessage simpleMailMessage;
	

	
	@GetMapping("/profile/generateCertificate/{userId}/{instId}/{instName}/{instImg}/{sigImg}/{courName}")
    public String  generateCertificate(
            @PathVariable("userId") int userId,
            @PathVariable("instId") int instId,
            @PathVariable("instName") String instName,
            @PathVariable("instImg") String instImg,
            @PathVariable("sigImg") String sigImg,
            @PathVariable("courName") String courName,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
		
		
		System.out.println("userId  "+userId+"instId  "+instId+"instName  "+instName+"courName  "+ courName);
	    // Create the HTML content for the certificate
	    InstituteAdmin profile = profileServ.getProfileById(userId);
	    String firstName = profile.getFirstName();
	    String lastName = profile.getLastName();
	    String email = profile.getAdminEmail();
	    
	    instName = instName.toUpperCase();
	    firstName = firstName.toUpperCase();
	    lastName = lastName.toUpperCase();
	    // Get the current date
	    Date currentDate = new Date();

	    // Format the current date as per your requirement
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    String formattedDate = dateFormat.format(currentDate);

	    
	    
	    
	    // Read the content of the image file into a byte array
	    byte[] imageBytes = Files.readAllBytes(Paths.get("D:\\UHPOCMS\\institute\\" + instName + "_" + instId + "\\logo\\"+instImg));
	    byte[] sigImageBytes = Files.readAllBytes(Paths.get("D:\\UHPOCMS\\institute\\" + instName + "_" + instId + "\\signature\\"+sigImg));
	    // Encode the image bytes as Base64 for embedding in HTML
        String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
        String sigEncodedImage = Base64.getEncoder().encodeToString(sigImageBytes);
	
	    
	    // Create the HTML content for the certificate with the embedded image
        String certificateHtml = "<!DOCTYPE html>\r\n"
	            + "<html>\r\n"
	            + "<head>\r\n"
	            + "    <title>Certificate of Achievement</title>\r\n"
	            + "    <style>\r\n"
	            + "        body {\r\n"
	            + "            font-family: Arial, sans-serif;\r\n"
	            + "            background-color: #f4f4f4;\r\n"
	            + "        }\r\n"
	            + "        .certificate {\r\n"
	            + "            border: 7px ridge coral;\r\n"
	            + "            padding: 20px;\r\n"
	            + "            width: 600px;\r\n"
	            + "            margin: 0 auto;\r\n"
	            + "            text-align: center;\r\n"
	            + "            background-color: #fff;\r\n"
	            + "        }\r\n"
	            + "        .certificate h1 {\r\n"
	            + "            font-size: 24px;\r\n"
	            + "            color: #333;\r\n"
	            + "        }\r\n"
	            + "        .certificate p {\r\n"
	            + "            font-size: 18px;\r\n"
	            + "            color: #555;\r\n"
	            + "        }\r\n"
	            + "        .signature {\r\n"
	            + "            margin-top: 20px;\r\n"
	            + "        }\r\n"
	            + "        .seal1 {\r\n"
	            + "            width: 40%;\r\n"
	            + "        }\r\n"
	            + "        .seal2 {\r\n"
	            + "            width: 20%;\r\n"
	            + "            height:20%;\r\n"
	            + "        }\r\n"
	            + "    </style>\r\n"
	            + "</head>\r\n"
	            + "<body>\r\n"
	            + "    <div class=\"certificate\">\r\n"
	            + "        <img src=\"data:image/jpeg;base64," + encodedImage + "\" alt=\"Seal\" class=\"seal1\"/>\r\n"
	            + "        <h1>Certificate of Achievement</h1>\r\n"
	            + "        <p>This is to certify that</p>\r\n"
	            + "        <h2>" + firstName + "  " + lastName + "</h2>\r\n"
	            + "        <p>has successfully completed the course  " + "<b>" + courName + "</b></p>\r\n"
	            + "        <p>Date: " + formattedDate + "</p>\r\n" 

	            + "        <div class=\"signature\">\r\n"
	            + "            <p>Signature:</p>\r\n"
	            + "        <img src=\"data:image/jpeg;base64," + sigEncodedImage + "\" alt=\"Seal\" class=\"seal2\"/>\r\n"
	            + "        </div>\r\n"
	            + "    </div>\r\n"
	            + "</body>\r\n"
	            + "</html>";
//	    // Create a response map with the HTML code and a download link
	    try {
	    	sendCertificateAsAttachment(email, certificateHtml);
	    	  // Create a ByteArrayResource for the HTML content
	        byte[] certificateBytes = certificateHtml.getBytes();
	        ByteArrayResource resource = new ByteArrayResource(certificateBytes);

	        // Set the content type and provide a filename for download
	        HttpHeaders headers = new HttpHeaders();
	        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=certificate.html");

	        return certificateHtml;
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception appropriately
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
		return null;
    }

	

	    private void sendCertificateAsAttachment(String email,String certificateHtml) {
	        try {
	        	System.out.println("Entered in sendmessage");
	            MimeMessage message = emailSender.createMimeMessage();
	            MimeMessageHelper helper = new MimeMessageHelper(message, true);

	            // Set email properties (e.g., recipient, subject, etc.)
	            helper.setTo(email);
	            helper.setSubject("Certificate Of acheivement");
	            helper.setText("Certificate", certificateHtml);
	            
	            // Convert the HTML content to a byte array
	            byte[] certificateBytes = certificateHtml.getBytes();

//	           
	            
	            if (certificateBytes.length > 0) {
	                // Create a ByteArrayResource for the attachment
	                ByteArrayResource certificateResource = new ByteArrayResource(certificateBytes);
	              // Attach the certificate HTML as a file
	              helper.addAttachment("certificate.html", certificateResource);

	            } else {
	                // Handle the case where the HTML content is empty or null
	                throw new IllegalArgumentException("Certificate HTML content is empty.");
	            }

	            // Send the email

	            System.out.println("After Add attachment");
	            System.out.println(message);
	            // Send the email
	            emailSender.send(message);
	        } catch (MailSendException e) {
	          
	            e.printStackTrace(); // Handle the exception appropriately
	        } catch (MessagingException e) {
	           
	            e.printStackTrace(); // Handle the exception appropriately
	        }
	    }
	
	

}