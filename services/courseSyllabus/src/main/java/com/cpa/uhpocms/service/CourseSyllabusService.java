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

	CourseSyllabus createCourseSyllabus(CourseSyllabus courseSyllabus);

	CourseSyllabus getCourseSyllabusByid(int id);

	List<Object> getAllCourseSyllabuss();

	CourseSyllabus updateCourseSyllabusByid(CourseSyllabus courseSyllabus, int id);

	int deleteCourseSyllabusByid(int id);

}