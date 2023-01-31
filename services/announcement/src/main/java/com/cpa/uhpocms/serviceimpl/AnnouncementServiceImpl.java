/**
 * @author - Code Generator
 * @createdOn 31-01-2023
 * @Description Controller class for announcement
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cpa.uhpocms.controller.AnnouncementController;
import com.cpa.uhpocms.entity.Announcement;
import com.cpa.uhpocms.repository.AnnouncementRepo;
import com.cpa.uhpocms.service.AnnouncementService;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

	@Autowired
	private AnnouncementRepo announcementRepo;
	private static Logger logger;

	final int STARTFROM = 0;

	public AnnouncementServiceImpl() {
		logger = Logger.getLogger(AnnouncementServiceImpl.class);
	}

	/**
	 * @param : Announcement announcement
	 * @return : Announcement createdAnnouncement
	 * @description : For creating/inserting entry in teacher_announcements table
	 */
	@Override
	public Announcement createAnnouncement(Announcement announcement) {
		logger.debug("Entering createAnnouncement");
		Announcement createdAnnouncement = null;

		announcement.setAnnouncementCreatedBy("admin");

		createdAnnouncement = announcementRepo.save(announcement);
		logger.info("created Announcement :" + createdAnnouncement);
		return createdAnnouncement;
	}

	/**
	 * @param : String title
	 * @return : Announcement announcement
	 * @description : For get entry in teacher_announcements table
	 */
	@Override
	public Announcement getAnnouncementByTitle(String title) {
		logger.debug("Entering getAnnouncementBytitle");

		Announcement announcement = announcementRepo.findByAnnouncementTitle(title);
		logger.info("Founded announcement :" + announcement);

		return announcement;
	}

	/**
	 * @return : List<Object> announcement
	 * @description : For fetching all announcement which are active state from
	 *              teacher_announcements table
	 */
	@Override
	public List<Object> getAllAnnouncements() {
		logger.debug("Entering getAllAnnouncements");

		List<Object> announcements = announcementRepo.findByIdIsGreaterThan(STARTFROM);

		logger.info("Fetched all active announcement :" + announcements);

		return announcements;

	}

	/**
	 * @param : Announcement to update
	 * @return : announcement
	 * @description : For updating announcement of teacher_announcements table
	 */
	@Override
	public Announcement updateAnnouncementByTitle(Announcement announcement, String title) {
		logger.debug("Entering updateAnnouncement");

		Announcement toUpdatedAnnouncement = null;
		Announcement updatedAnnouncement = null;

		toUpdatedAnnouncement = announcementRepo.findByAnnouncementTitle(title);
		logger.info("exisitng Announcement :: " + toUpdatedAnnouncement);

		if (toUpdatedAnnouncement != null) {
			logger.debug("setting new data of Announcement to exisitng Announcement");

//			announcement.setModifiedBy("admin");
			toUpdatedAnnouncement.setAnnouncementTitle(announcement.getAnnouncementTitle());
			toUpdatedAnnouncement.setAnnouncementMessage(announcement.getAnnouncementMessage());
			toUpdatedAnnouncement.setAnnouncementTo(announcement.getAnnouncementTo());

			updatedAnnouncement = announcementRepo.save(toUpdatedAnnouncement);

			logger.info("updated Announcement :" + updatedAnnouncement);
		}

		return updatedAnnouncement;
	}

	/**
	 * @param : String title
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of
	 *              Announcement
	 * 
	 */
	@Override
	public int deleteAnnouncementByTitle(String title) {
		logger.debug("Entering deleteAnnouncementBytitle");

		int count = announcementRepo.deleteByAnnouncementTitle(title);
		logger.info("deleted Announcement count : " + count);
		return count;
	}

}
