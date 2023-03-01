/**
 * @author - Code Generator
 * @createdOn 31-01-2023
 * @Description Controller class for announcement
 * 
 */

package com.cpa.uhpocms.controller;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.uhpocms.entity.Announcement;
import com.cpa.uhpocms.entity.AuthenticationBean;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.AnnouncementService;

@RestController
@CrossOrigin
@RequestMapping("/uhpocms")
public class AnnouncementController {

	@Autowired
	private AnnouncementService announcementService;;

	private ResourceBundle resourceBundle;
	private static Logger logger;

	AnnouncementController() {
		resourceBundle = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(AnnouncementController.class);
	}

	@PostMapping("/announcement")
	public ResponseEntity<Object> createAnnouncement(@RequestBody Announcement announcement) throws CPException {
		logger.debug("Entering create Announcement");
		logger.info("data of creating Announcement  :" + announcement.toString());

		Announcement createdAnnouncement = null;
		try {

			Announcement toCheckAnnouncement = announcementService
					.getAnnouncementByTitle(announcement.getAnnouncementTitle());
			logger.debug("existing announcement :" + toCheckAnnouncement);

			if (toCheckAnnouncement == null) {

				// TODO: Uncomment below 2 lines and change the method name as per your Entity
				// class
				// announcement.setCreatedby("admin");
				// announcement.setUpdatedby("admin");

				createdAnnouncement = announcementService.createAnnouncement(announcement);
				logger.info("Announcement created :" + createdAnnouncement);

				return ResponseHandler.generateResponse(createdAnnouncement, HttpStatus.CREATED);

			} else {

				logger.error(resourceBundle.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed Announcement creation : " + ex.getMessage());
			throw new CPException("err003", resourceBundle.getString("err003"));
		}
	}

//	@GetMapping("/announcement/{title}")
//	public ResponseEntity<Object> getAnnouncementByTitle(@PathVariable("title") String title) throws CPException {
//		logger.debug("Entering getAnnouncementBytitle");
//		logger.info("entered user name :" + title);
//
//		Announcement announcement = null;
//
//		try {
//
//			announcement = announcementService.getAnnouncementByTitle(title);
//			logger.info("fetched Announcement :" + announcement);
//
//			if (announcement != null) {
//				logger.debug("Announcement fetched generating response");
//				return ResponseHandler.generateResponse(announcement, HttpStatus.OK);
//			} else {
//				logger.debug("Announcement not found");
//				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
//			}
//
//		} catch (Exception ex) {
//
//			logger.error("Failed getting announcement : " + ex.getMessage());
//			throw new CPException("err001", resourceBundle.getString("err001"));
//		}
//
//	}

	@GetMapping("/announcement")
	public ResponseEntity<List<Object>> getAllAnnouncements(@RequestParam(name = "title") String title)
			throws CPException {
		logger.debug("Entering getAllAnnouncement");
		logger.info("Parameter  :" + title);

		List<Object> announcements = null;

		try {

			if (title.equalsIgnoreCase("all")) {

				announcements = announcementService.getAllAnnouncements();
				logger.info("Fetched all Announcement :" + announcements);

				return ResponseHandler.generateListResponse(announcements, HttpStatus.OK);
			} else {

				logger.info(resourceBundle.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all announcements : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));

		}
	}

	@DeleteMapping("/announcement/{id}")
	public ResponseEntity<Object> deleteAnnouncementById(@PathVariable("id") int announcementId) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteAnnouncement  :" + announcementId);
		// TODO - implement the business logic

		int count = 0;

		try {
			count = announcementService.deleteAnnouncementById(announcementId);
			if (count >= 1) {
				logger.info("deleted Announcement : id = " + announcementId);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBundle.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete Announcement :" + ex.getMessage());
			throw new CPException("err005", resourceBundle.getString("err005"));
		}

	}

	@PutMapping("/announcement/{title}")
	public ResponseEntity<Object> updateAnnouncementBytitle(@RequestBody Announcement announcement,
			@PathVariable("title") String title) throws CPException {
		logger.debug("Entering updateAnnouncement");
		logger.info("entered  updateAnnouncement :" + announcement);

		Announcement updatedAnnouncement = null;

		try {
			updatedAnnouncement = announcementService.updateAnnouncementByTitle(announcement, title);

			if (updatedAnnouncement == null) {
				logger.info(resourceBundle.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated announcement : " + updatedAnnouncement);
				return ResponseHandler.generateResponse(updatedAnnouncement, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update Announcement : " + ex.getMessage());
			throw new CPException("err004", resourceBundle.getString("err004"));

		}

	}

	@PostMapping("/announcement/send/{id}")
	public ResponseEntity<Object> sendAnnouncements(@RequestBody Integer[] profilesId,
			@PathVariable("id") int announcementId) throws CPException {

		logger.debug("Entering sendAnnouncements");
		logger.info("data of send Announcement ID :" + announcementId);
		logger.info("data of profiles ID :" + profilesId.toString());

		List<Object> announcementsTo = null;
		try {
			if (profilesId.length > 0) {
				announcementsTo = announcementService.sendAnnouncementToAll(announcementId, profilesId);
				logger.info("Announcement To sent :" + announcementsTo);
				return ResponseHandler.generateResponse(announcementsTo, HttpStatus.CREATED);

			} else {

				logger.error(resourceBundle.getString("err006"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err006");

			}
		} catch (Exception ex) {
			logger.error("Failed Announcement sending : " + ex.getMessage());
			throw new CPException("err006", resourceBundle.getString("err006"));
		}

	}

	@GetMapping(path = "/basicauth")
	public AuthenticationBean basicauth() {
		return new AuthenticationBean("You are authenticated");
	}
	
	@GetMapping(path = "/announcement/profileid")
	public ResponseEntity<List<Object>> getAnnouncementsByProfileId(@RequestParam(name = "id") int profileId)
			throws CPException {

		logger.debug("Entering getAnnouncementsByProfileId");
		logger.info("parameter : " + profileId);

		List<Object> announcements = null;

		try {
			announcements = announcementService.getAnnouncementsByProfiledId(profileId);
			logger.info("Announcements Data : " + announcements);
			if (announcements != null) {
				return ResponseHandler.generateListResponse(announcements, HttpStatus.OK);
			} else {
				logger.info(resourceBundle.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}
		} catch (Exception ex) {

			logger.error("Failed getting announcements by profile id : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));
		}

		
	}

	
	@GetMapping(path = "/announcement/profileid/{id}")
	public ResponseEntity<List<Object>> getProfileIdsByAnnouncementId(@PathVariable("id") int announcementId)
			throws CPException {

		logger.debug("Entering getAnnouncementsByProfileId");
		logger.info("parameter : " + announcementId);

		List<Object> profileIds = null;

		try {
			profileIds = announcementService.getProfileIdsByAnnouncementId(announcementId);
			logger.info("AnnouncementsTo Data : " + profileIds);
			if (profileIds != null) {
				return ResponseHandler.generateListResponse(profileIds, HttpStatus.OK);
			} else {
				logger.info(resourceBundle.getString("err007"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err007");
			}
		} catch (Exception ex) {

			logger.error("Failed getting profile id by announcement id : " + ex.getMessage());
			throw new CPException("err007", resourceBundle.getString("err007"));
		}

		
	}

}
