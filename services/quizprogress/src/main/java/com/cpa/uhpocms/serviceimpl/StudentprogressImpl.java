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

	@Override
	public StudentProgress createQuizprogress(StudentProgress studentProgress) {
		// TODO Auto-generated method stub
		StudentProgress createdQuizAllprogress = null;

		createdQuizAllprogress = Studentrepo.save(studentProgress);
	
		return createdQuizAllprogress;
	}

	@Override
	public StudentProgress updateQuizprogressByStudentIdAndQuizId(StudentProgress studentProgress) {
		// TODO Auto-generated method stub
		
//		StudentProgress createdQuizAllprogress = null;
//
//		createdQuizAllprogress = quizprogressRepo.save(studentProgress);
//		logger.info("created Quizprogress :" + createdQuizAllprogress);
		return null;
	
	}

}
