/**
 * @author  - Code Generator
 * @createdOn -  31-01-2023
 * @Description Entity class for Announcement Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.Announcement;

public interface AnnouncementService {

	
	//CREATE AN ANNOUNCEMENT
	Announcement createAnnouncement(Announcement announcement);

	//GET ALL ANNOUNCEMENT 
	List<Object> getAllAnnouncements();

	//DELETE AN ANNOUNCEMENT BY ID
	int deleteAnnouncementById(int announcementId);

	//GET LIST SEND ANNOUNCEMENT BY PROFILE ID 
	List<Object> sendAnnouncementToAll(int announcementId, Integer[] profileIds);

	//GET LIST OF ANNOUNCEMENT BY PROFILE ID
	List<Object> getAnnouncementsByProfiledId(int profileId);

	//GET LIST OF PROFILE BY ANNOUNCEMENT 
	List<Object> getProfileIdsByAnnouncementId(int announcementId);
	
	//GET LIST ANNOUNCEMENT SEND BY ANNOUNEMENT ID
	List<Object> getAnnoucementBySendby (int announcementSendby);
	
	
}