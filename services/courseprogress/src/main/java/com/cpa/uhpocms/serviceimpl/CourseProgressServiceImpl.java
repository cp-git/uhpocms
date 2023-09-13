/**
 * @author - Code Generator
 * @createdOn 05-04-2023
 * @Description Controller class for courseprogress
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cpa.uhpocms.controller.CourseProgressController;
import com.cpa.uhpocms.entity.CourseProgress;
import com.cpa.uhpocms.repository.CourseProgressRepo;
import com.cpa.uhpocms.service.CourseProgressService;

@Service
public class CourseProgressServiceImpl implements CourseProgressService {

	@Autowired
	private CourseProgressRepo courseprogressRepo;
	private static Logger logger;

	public CourseProgressServiceImpl() {
		logger = Logger.getLogger(CourseProgressServiceImpl.class);
	}

	/**
	 * @param : CourseProgress courseprogress
	 * @return : CourseProgress createdCourseProgress
	 * @description : For creating/inserting entry in teacher_studentcourseprogress
	 *              table
	 */
	@Override
	public CourseProgress createCourseProgress(CourseProgress courseprogress) {
		logger.debug("Entering createCourseProgress");
		CourseProgress createdCourseProgress = null;

		CourseProgress newcourseprogress = courseprogressRepo.findByCourseId_StudId(courseprogress.getCourseId(),
				courseprogress.getStudentId());

		System.out.println(newcourseprogress);
		if (newcourseprogress == null) {
			createdCourseProgress = courseprogressRepo.save(courseprogress);
			logger.info("created CourseProgress :" + createdCourseProgress);
			return createdCourseProgress;
//		
		}

		return null;

		// courseprogress.setCourseProgressCreatedBy("admin");
		// courseprogress.setCourseProgressModifiedBy("admin");

	}

	/**
	 * @param : String id
	 * @return : CourseProgress courseprogress
	 * @description : For get entry in teacher_studentcourseprogress table
	 */
	@Override
	public CourseProgress getCourseProgressByid(int id) {
		logger.debug("Entering getCourseProgressByid");

		CourseProgress courseprogress = courseprogressRepo.findById(id);
		logger.info("Founded courseprogress :" + courseprogress);

		return courseprogress;
	}

	/**
	 * @return : List<Object> courseprogress
	 * @description : For fetching all courseprogress which are active state from
	 *              teacher_studentcourseprogress table
	 */
	@Override
	public List<Object> getAllCourseProgresss() {

		logger.debug("Entering getAllCourseProgresss");
		List<Object> objectCoureProgress = null;
		List<CourseProgress> courseprogresss = courseprogressRepo.findAll();
		logger.info("Fetched all active courseprogress :" + courseprogresss);

		objectCoureProgress = new ArrayList<Object>(courseprogresss);

		return objectCoureProgress;
	}

	/**
	 * @param : CourseProgress to update
	 * @return : courseprogress
	 * @description : For updating courseprogress of teacher_studentcourseprogress
	 *              table
	 */
	@Override
	public CourseProgress updateCourseProgressByid(CourseProgress courseprogress, int id) {
		logger.debug("Entering updateCourseProgress");

		CourseProgress toUpdatedCourseProgress = null;
		CourseProgress updatedCourseProgress = null;

		toUpdatedCourseProgress = courseprogressRepo.findById(id);
		logger.info("exisitng CourseProgress :: " + toUpdatedCourseProgress);

		if (toUpdatedCourseProgress != null) {
			logger.debug("setting new data of CourseProgress to exisitng CourseProgress");

//			courseprogress.setModifiedBy("admin");
			toUpdatedCourseProgress.setCourseId(courseprogress.getCourseId());
			toUpdatedCourseProgress.setCurrentAssignNo(courseprogress.getCurrentAssignNo());
			toUpdatedCourseProgress.setCurrentModuleNo(courseprogress.getCurrentModuleNo());
			toUpdatedCourseProgress.setCurrentUnitNo(courseprogress.getCurrentUnitNo());
			toUpdatedCourseProgress.setGrade(courseprogress.getGrade());
			toUpdatedCourseProgress.setStudentId(courseprogress.getStudentId());
			toUpdatedCourseProgress.setProgress(courseprogress.getProgress());
			updatedCourseProgress = courseprogressRepo.save(toUpdatedCourseProgress);

			logger.info("updated CourseProgress :" + updatedCourseProgress);
		}

		return updatedCourseProgress;
	}

	
	/**
	 * @author shradha
	 * @desc get list of entry in table by course Id
	 * 
	 */
	public List<Object> getCourseProgressByCourseId(int courseId) {
		logger.debug("Entering getCourseProgressByCourseId");

		List<Object> objectCoureProgress = null;
		List<CourseProgress> courseprogresss = courseprogressRepo.findByCourseId(courseId);
		logger.info("Fetched all active courseprogress :" + courseprogresss);

		objectCoureProgress = new ArrayList<Object>(courseprogresss);

		return objectCoureProgress;

	}

	/**
	 * @author shradha
	 * @desc Function to get entries by course Id and student Id
	 */
	public CourseProgress getCourseProgressByCourseIdStudId(int courseId, int studId) {
		logger.debug("Entering getCourseProgressByCourseId");

		CourseProgress courseprogress = courseprogressRepo.findByCourseId_StudId(courseId, studId);
		logger.info("Fetched all active courseprogress :" + courseprogress);

		;

		return courseprogress;

	}

	@Override
	public int deleteCourseProgressByCourseIdAndStudentId(int courseId, int studId) {
		// TODO Auto-generated method stub
		return courseprogressRepo.deleteCourseProgressByCourseIdAndStudentId(courseId, studId);
	}

}
