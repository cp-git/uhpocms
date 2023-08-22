package com.cpa.uhpocms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpa.uhpocms.entity.Quizprogress;
import com.cpa.uhpocms.entity.StudentProgress;

public interface studentRepo  extends JpaRepository<StudentProgress, Integer> {

}
