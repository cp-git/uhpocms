package com.cpa.uhpocms.service;

import org.springframework.stereotype.Service;

import com.cpa.uhpocms.entity.Quizprogress;
import com.cpa.uhpocms.entity.StudentProgress;


public interface StudentProgressService {
	
	//CREATE QUIZ PROGRESS FOR STUDENT
	StudentProgress createQuizprogress(StudentProgress studentProgress);
	
	//UPDATE THE QUIZ PROGRESS BY STUDENT ID AND QUIZ ID
	StudentProgress updateQuizprogressByStudentIdAndQuizId(StudentProgress studentProgress);

}
