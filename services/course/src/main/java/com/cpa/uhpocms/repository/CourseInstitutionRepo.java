package com.cpa.uhpocms.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.CourseInstitution;

@Repository
public interface CourseInstitutionRepo extends JpaRepository<CourseInstitution, Integer> {

	@Transactional
	public int deleteByCourseId(int courseId);

}
