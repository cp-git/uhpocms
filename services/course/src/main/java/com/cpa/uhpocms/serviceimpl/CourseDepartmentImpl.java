package com.cpa.uhpocms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.uhpocms.entity.CourseDepartment;
import com.cpa.uhpocms.repository.CourseDepartmentRepo;
import com.cpa.uhpocms.service.CourseDepartmentService;

@Service
public class CourseDepartmentImpl implements CourseDepartmentService {

	@Autowired
	private CourseDepartmentRepo courseDepartmentRepo;

	private static Logger logger;

	public CourseDepartmentImpl() {
		logger = Logger.getLogger(CourseServiceImpl.class);
	}

	@Override
	public List<Object> getAllCoursesDepartmentIds() {

		logger.debug("Entering getAllCourses");
		List<Object> objectCourseDepartmentId = null;

		List<CourseDepartment> courseDepartmentId = courseDepartmentRepo.findAll();

		logger.info("Fetched all inactive course :" + courseDepartmentId);

		objectCourseDepartmentId = new ArrayList<Object>(courseDepartmentId);

		logger.info("Fetched all active course :" + objectCourseDepartmentId);
		return objectCourseDepartmentId;
	}

}
