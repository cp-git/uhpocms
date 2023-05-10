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

	Announcement createAnnouncement(Announcement announcement);

	Announcement getAnnouncementByTitle(String title);

	List<Object> getAllAnnouncements();

	Announcement updateAnnouncementByTitle(Announcement announcement, String title);

	int deleteAnnouncementById(int announcementId);

	List<Object> sendAnnouncementToAll(int announcementId, Integer[] profileIds);

	List<Object> getAnnouncementsByProfiledId(int profileId);

	List<Object> getProfileIdsByAnnouncementId(int announcementId);
	
	List<Object> getAnnoucementBySendby (int announcementSendby);
	
	
}