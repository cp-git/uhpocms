/**
 * @author  - Code Generator
 * @createdOn -  27-02-2023
 * @Description Entity class for CourseSyllabus Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.CourseSyllabus;

public interface CourseSyllabusService {

	//INSERT COURSE SYLLABUS
	CourseSyllabus createCourseSyllabus(CourseSyllabus courseSyllabus);

	//GET COURSE SYLLABUS BY ID
	CourseSyllabus getCourseSyllabusByid(int id);

	//GET ALL COURSE SYLLABUS
	List<Object> getAllCourseSyllabuss();

	//UPDATE COURSE SYLLABUS BY ID
	CourseSyllabus updateCourseSyllabusByid(CourseSyllabus courseSyllabus, int id);

	//DELETE COURSE BY ID
	int deleteCourseSyllabusByid(int id);

}