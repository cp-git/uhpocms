/**
 * @author - Code Generator
 * @createdOn 27-02-2023
 * @Description Controller class for courseSyllabus
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cpa.uhpocms.controller.CourseSyllabusController;
import com.cpa.uhpocms.entity.CourseSyllabus;
import com.cpa.uhpocms.repository.CourseSyllabusRepo;
import com.cpa.uhpocms.service.CourseSyllabusService;

@Service
public class CourseSyllabusServiceImpl implements CourseSyllabusService {

	@Autowired
	private CourseSyllabusRepo courseSyllabusRepo;
	private static Logger logger;

	public CourseSyllabusServiceImpl() {
		logger = Logger.getLogger(CourseSyllabusServiceImpl.class);
	}

	//INSERT COURSE SYLLABUS
	@Override
	public CourseSyllabus createCourseSyllabus(CourseSyllabus courseSyllabus) {
		logger.debug("Entering createCourseSyllabus");
		CourseSyllabus createdCourseSyllabus = null;
		int deletedCourseSyllabus = 0;

		courseSyllabus.setCreatedBy("admin");
		courseSyllabus.setModifiedBy("admin");

		deletedCourseSyllabus = courseSyllabusRepo.deleteCourseSyllabusByCourseId(courseSyllabus.getCourseId());
		createdCourseSyllabus = courseSyllabusRepo.save(courseSyllabus);
		logger.info("created CourseSyllabus :" + createdCourseSyllabus);
		return createdCourseSyllabus;
	}

	
	// GET COURSE SYLLABUS BY ID
	@Override
	public CourseSyllabus getCourseSyllabusByid(int id) {
		logger.debug("Entering getCourseSyllabusByid");

		CourseSyllabus courseSyllabus = courseSyllabusRepo.findByCourseSyllabusId(id);
		logger.info("Founded courseSyllabus :" + courseSyllabus);

		return courseSyllabus;
	}

	
	
	//GET LIST OF ACTIVE COURSE SYLLABUS
	@Override
	public List<Object> getAllCourseSyllabuss() {
		logger.debug("Entering getAllCourseSyllabuss");

		List<Object> courseSyllabuss = courseSyllabusRepo.findByCourseSyllabusIsActiveTrue();
		logger.info("Fetched all active courseSyllabus :" + courseSyllabuss);
		return courseSyllabuss;
	}


	//UPDATE COURSE SYLLABUS BY ID
	@Override
	public CourseSyllabus updateCourseSyllabusByid(CourseSyllabus courseSyllabus, int courseSyllabusId) {
		logger.debug("Entering updateCourseSyllabus");

		CourseSyllabus toUpdatedCourseSyllabus = null;
		CourseSyllabus updatedCourseSyllabus = null;

		toUpdatedCourseSyllabus = courseSyllabusRepo.findByCourseSyllabusId(courseSyllabusId);
		logger.info("exisitng CourseSyllabus :: " + toUpdatedCourseSyllabus);

		if (toUpdatedCourseSyllabus != null) {
			logger.debug("setting new data of CourseSyllabus to exisitng CourseSyllabus");

			toUpdatedCourseSyllabus.setSyllabusFile(courseSyllabus.getSyllabusFile());
			toUpdatedCourseSyllabus.setCourseSyllabusIsActive(courseSyllabus.isCourseSyllabusIsActive());
			toUpdatedCourseSyllabus.setCourseId(courseSyllabus.getCourseId());

			courseSyllabus.setCreatedBy("admin");
			courseSyllabus.setModifiedBy("admin");
//			courseSyllabus.setModifiedBy("admin");

			updatedCourseSyllabus = courseSyllabusRepo.save(toUpdatedCourseSyllabus);

			logger.info("updated CourseSyllabus :" + updatedCourseSyllabus);
		}

		return updatedCourseSyllabus;
	}


	//DELETE COURSE SYLLABUS BY ID
	@Override
	public int deleteCourseSyllabusByid(int id) {
		logger.debug("Entering deleteCourseSyllabusByid");

		int count = courseSyllabusRepo.deleteCourseSyllabusById(id);
		logger.info("deleted CourseSyllabus count : " + count);
		return count;
	}

}
