package com.cpa.uhpocms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher_announcements_to_list")
public class AnnouncementTo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "announcements_id")
	private int announcementId;

	@Column(name = "profile_id")
	private int profileId;

	/**
	 * 
	 */
	public AnnouncementTo() {
		super();
	}

	/**
	 * @param announcementId
	 * @param profileId
	 */
	public AnnouncementTo(int announcementId, int profileId) {
		super();
		this.announcementId = announcementId;
		this.profileId = profileId;
	}

	/**
	 * @param id
	 * @param announcementId
	 * @param profileId
	 */
	public AnnouncementTo(int id, int announcementId, int profileId) {
		super();
		this.id = id;
		this.announcementId = announcementId;
		this.profileId = profileId;
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
	 * @return the announcementId
	 */
	public int getAnnouncementId() {
		return announcementId;
	}

	/**
	 * @param announcementId the announcementId to set
	 */
	public void setAnnouncementId(int announcementId) {
		this.announcementId = announcementId;
	}

	/**
	 * @return the profileId
	 */
	public int getProfileId() {
		return profileId;
	}

	/**
	 * @param profileId the profileId to set
	 */
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	@Override
	public String toString() {
		return "AnnouncementTo [id=" + id + ", announcementId=" + announcementId + ", profileId=" + profileId + "]";
	}

}
