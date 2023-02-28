package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.CourseDepartment;

@Repository
public interface CourseDepartmentRepo extends JpaRepository<CourseDepartment, Integer> {
	@Transactional
	public int deleteByCourseId(int courseid);

	List<CourseDepartment> findAll();
}
