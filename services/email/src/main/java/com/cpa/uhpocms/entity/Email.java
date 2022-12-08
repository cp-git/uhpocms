/**
 * @author  - Code Generator
 * @createdOn -  07-12-2022
 * @Description Entity class for teacher_email
 * 
 */

package com.cpa.uhpocms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "teacher_email")
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emailid")
	private int emailId;
	
	@Column(name = "title" , unique = true)
	private String title ;
	
	@Column(name = "subject", nullable = false)
	private String subject;
	
	@Column(name = "content", nullable = false)
	private String content;
	
	@CreationTimestamp
	@Column(name = "createdon")
	private Date createdOn=new Date(System.currentTimeMillis());
	
	@Column(name = "createdby", nullable = false)
	private String createdBy;
	
	@UpdateTimestamp
	@Column(name="modifiedon", nullable = false)
	private Date modifiedOn=new Date(System.currentTimeMillis());
	
	
	@Column(name = "modifiedby")
	private String modifiedBy;
	
	@Column(name = "status", nullable = false)
	private boolean status;
	
	@Column(name = "readstatus", nullable = false)
	private boolean readStatus;
	
	@Column(name = "attachfile", nullable = false)
	private String attachFile;

	@Column(name = "isactive" , nullable = false)
	private boolean emailIsActive;

	/**
	 * @param emailId
	 * @param title
	 * @param subject
	 * @param content
	 * @param createdOn
	 * @param createdBy
	 * @param modifiedOn
	 * @param modifiedBy
	 * @param status
	 * @param readStatus
	 * @param attachFile
	 * @param emailIsActive
	 */
	public Email(int emailId, String title, String subject, String content, Date createdOn, String createdBy,
			Date modifiedOn, String modifiedBy, boolean status, boolean readStatus, String attachFile,
			boolean emailIsActive) {
		super();
		this.emailId = emailId;
		this.title = title;
		this.subject = subject;
		this.content = content;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.modifiedOn = modifiedOn;
		this.modifiedBy = modifiedBy;
		this.status = status;
		this.readStatus = readStatus;
		this.attachFile = attachFile;
		this.emailIsActive = emailIsActive;
	}

	/**
	 * 
	 */
	public Email() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the emailId
	 */
	public int getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(int emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the modifiedOn
	 */
	public Date getModifiedOn() {
		return modifiedOn;
	}

	/**
	 * @param modifiedOn the modifiedOn to set
	 */
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the readStatus
	 */
	public boolean isReadStatus() {
		return readStatus;
	}

	/**
	 * @param readStatus the readStatus to set
	 */
	public void setReadStatus(boolean readStatus) {
		this.readStatus = readStatus;
	}

	/**
	 * @return the attachFile
	 */
	public String getAttachFile() {
		return attachFile;
	}

	/**
	 * @param attachFile the attachFile to set
	 */
	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}

	/**
	 * @return the emailIsActive
	 */
	public boolean isEmailIsActive() {
		return emailIsActive;
	}

	/**
	 * @param emailIsActive the emailIsActive to set
	 */
	public void setEmailIsActive(boolean emailIsActive) {
		this.emailIsActive = emailIsActive;
	}

	@Override
	public String toString() {
		return "Email [emailId=" + emailId + ", title=" + title + ", subject=" + subject + ", content=" + content
				+ ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", modifiedOn=" + modifiedOn
				+ ", modifiedBy=" + modifiedBy + ", status=" + status + ", readStatus=" + readStatus + ", attachFile="
				+ attachFile + ", emailIsActive=" + emailIsActive + "]";
	}
	
	
	
	

}
