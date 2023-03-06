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

	/**
	 * @param : CourseSyllabus courseSyllabus
	 * @return : CourseSyllabus createdCourseSyllabus
	 * @description : For creating/inserting entry in teacher_coursesyllabus table
	 */
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

	/**
	 * @param : String id
	 * @return : CourseSyllabus courseSyllabus
	 * @description : For get entry in teacher_coursesyllabus table
	 */
	@Override
	public CourseSyllabus getCourseSyllabusByid(int id) {
		logger.debug("Entering getCourseSyllabusByid");

		CourseSyllabus courseSyllabus = courseSyllabusRepo.findByCourseSyllabusId(id);
		logger.info("Founded courseSyllabus :" + courseSyllabus);

		return courseSyllabus;
	}

	/**
	 * @return : List<Object> courseSyllabus
	 * @description : For fetching all courseSyllabus which are active state from
	 *              teacher_coursesyllabus table
	 */
	@Override
	public List<Object> getAllCourseSyllabuss() {
		logger.debug("Entering getAllCourseSyllabuss");

		List<Object> courseSyllabuss = courseSyllabusRepo.findByCourseSyllabusIsActiveTrue();
		logger.info("Fetched all active courseSyllabus :" + courseSyllabuss);
		return courseSyllabuss;
	}

	/**
	 * @param : CourseSyllabus to update
	 * @return : courseSyllabus
	 * @description : For updating courseSyllabus of teacher_coursesyllabus table
	 */
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

	/**
	 * @param : String id
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of
	 *              CourseSyllabus
	 * 
	 */
	@Override
	public int deleteCourseSyllabusByid(int id) {
		logger.debug("Entering deleteCourseSyllabusByid");

		int count = courseSyllabusRepo.deleteCourseSyllabusById(id);
		logger.info("deleted CourseSyllabus count : " + count);
		return count;
	}

}
