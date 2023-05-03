/**
 * @author  - Code Generator
 * @createdOn -  31-01-2023
 * @Description Entity class for teacher_announcements
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

@Entity
@Table(name = "teacher_announcements")
public class Announcement {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "announcement_title")
	private String announcementTitle;

	@Column(name = "announcement_message")
	private String announcementMessage;

	@Column(name = "`to`")
	private String announcementTo;

	
	

	@Column(name = "sendby")
	private int announcementSendby;
	

	@Column(name = "createdby")
	private String announcementCreatedBy;
	
	@CreationTimestamp
	@Column(name = "created_on")
	private Date announcementCreatedOn;

	/**
	 * 
	 */
	public Announcement() {
		super();
	}

	/**
	 * @param announcementTitle
	 * @param announcementMessage
	 * @param announcementTo
	 */
	public Announcement(String announcementTitle, String announcementMessage, String announcementTo) {
		super();
		this.announcementTitle = announcementTitle;
		this.announcementMessage = announcementMessage;
		this.announcementTo = announcementTo;
		
	}

	/**
	 * @param id
	 * @param announcementTitle
	 * @param announcementMessage
	 * @param announcementTo
	 * @param announcementReadby
	 * @param announcementCreatedBy
	 * @param announcementCreatedOn
	 */
	public Announcement(int id, String announcementTitle, String announcementMessage, String announcementTo,
			int announcementSendby, String announcementCreatedBy,Date announcementCreatedOn) {
		super();
		this.id = id;
		this.announcementTitle = announcementTitle;
		this.announcementMessage = announcementMessage;
		this.announcementTo = announcementTo;
		this.announcementSendby = announcementSendby;
		this.announcementCreatedBy = announcementCreatedBy;
		this.announcementCreatedOn = announcementCreatedOn;
	}

	
		

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the announcementTitle
	 */
	public String getAnnouncementTitle() {
		return announcementTitle;
	}

	/**
	 * @param announcementTitle the announcementTitle to set
	 */
	public void setAnnouncementTitle(String announcementTitle) {
		this.announcementTitle = announcementTitle;
	}

	/**
	 * @return the announcementMessage
	 */
	public String getAnnouncementMessage() {
		return announcementMessage;
	}

	/**
	 * @param announcementMessage the announcementMessage to set
	 */
	public void setAnnouncementMessage(String announcementMessage) {
		this.announcementMessage = announcementMessage;
	}

	/**
	 * @return the announcementTo
	 */
	public String getAnnouncementTo() {
		return announcementTo;
	}

	/**
	 * @param announcementTo the announcementTo to set
	 */
	public void setAnnouncementTo(String announcementTo) {
		this.announcementTo = announcementTo;
	}

	/**
	 * @return the announcementReadby
	 */
	public int getAnnouncementSendby() {
		return announcementSendby;
	}

	/**
	 * @param announcementReadby the announcementReadby to set
	 */
	public void setAnnouncementSendby(int announcementSendby) {
		this.announcementSendby = announcementSendby;
	}

	/**
	 * @return the announcementCreatedBy
	 */
	public String getAnnouncementCreatedBy() {
		return announcementCreatedBy;
	}

	/**
	 * @param announcementCreatedBy the announcementCreatedBy to set
	 */
	public void setAnnouncementCreatedBy(String announcementCreatedBy) {
		this.announcementCreatedBy = announcementCreatedBy;
	}

	/**
	 * @return the announcementCreatedOn
	 */
	public Date getAnnouncementCreatedOn() {
		return announcementCreatedOn;
	}

	/**
	 * @param announcementCreatedOn the announcementCreatedOn to set
	 */
	public void setAnnouncementCreatedOn(Date announcementCreatedOn) {
		this.announcementCreatedOn = announcementCreatedOn;
	}

	@Override
	public String toString() {
		return "Announcement [id=" + id + ", announcementTitle=" + announcementTitle + ", announcementMessage="
				+ announcementMessage + ", announcementTo=" + announcementTo + ", announcementReadby="
				+ announcementSendby + ", announcementCreatedBy=" + announcementCreatedBy + ", isActive="
				+ ", announcementCreatedOn=" + announcementCreatedOn + "]";
	}

}
