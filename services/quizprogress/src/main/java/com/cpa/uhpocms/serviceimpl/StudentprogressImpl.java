package com.cpa.uhpocms.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.uhpocms.entity.Quizprogress;
import com.cpa.uhpocms.entity.StudentProgress;
import com.cpa.uhpocms.repository.studentRepo;
import com.cpa.uhpocms.service.StudentProgressService;

@Service
public class StudentprogressImpl implements StudentProgressService {
	
	@Autowired
	private studentRepo Studentrepo;

	//CREATE QUIZ PROGRESS FOR STUDENT
	@Override
	public StudentProgress createQuizprogress(StudentProgress studentProgress) {
		// TODO Auto-generated method stub
		StudentProgress createdQuizAllprogress = null;

		createdQuizAllprogress = Studentrepo.save(studentProgress);
	
		return createdQuizAllprogress;
	}

	
	
	// UPDATE THE QUIZ PROGRESS BY STUDENT ID AND QUIZ ID
	@Override
	public StudentProgress updateQuizprogressByStudentIdAndQuizId(StudentProgress studentProgress) {
		// TODO Auto-generated method stub
		
		StudentProgress toUpdatedStudentprogress = null;
		StudentProgress updatedStudentprogress = null;
		
		toUpdatedStudentprogress = Studentrepo.getStudentprogressByStudentId(studentProgress.getStudentId());
		
		if (toUpdatedStudentprogress != null) {
		//logger.debug("setting new data of Quizprogress to exisitng Quizprogress");
		
		toUpdatedStudentprogress.setCourseId(studentProgress.getCourseId());
		toUpdatedStudentprogress.setMaxMarks(studentProgress.getMaxMarks());
		toUpdatedStudentprogress.setObtainMarks(studentProgress.getObtainMarks());
		toUpdatedStudentprogress.setPercentAge(studentProgress.getPercentAge());
		toUpdatedStudentprogress.setStudentGrade(studentProgress.getStudentGrade());
		toUpdatedStudentprogress.setStudentId(studentProgress.getStudentId());
		
		
		
		


		updatedStudentprogress = Studentrepo.save(toUpdatedStudentprogress);

//		logger.info("updated Quizprogress :" + toUpdatedStudentprogress);
	}
		return updatedStudentprogress;
	
	}

}
