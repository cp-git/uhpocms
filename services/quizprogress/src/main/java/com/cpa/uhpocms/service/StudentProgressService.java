package com.cpa.uhpocms.service;

import org.springframework.stereotype.Service;

import com.cpa.uhpocms.entity.Quizprogress;
import com.cpa.uhpocms.entity.StudentProgress;


public interface StudentProgressService {
	
	StudentProgress createQuizprogress(StudentProgress studentProgress);
	
	StudentProgress updateQuizprogressByStudentIdAndQuizId(StudentProgress studentProgress);

}
