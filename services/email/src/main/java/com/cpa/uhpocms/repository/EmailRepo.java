/**
 * @author  - Code Generator
 * @createdOn -  06-12-2022
 * @Description Entity class for Email
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.Email;

@Repository
public interface EmailRepo extends JpaRepository<Email, Integer> {

	public Email findByTitle(String title);

	public List<Object> findByEmailIsActiveTrue();

	@Transactional
	@Modifying
	@Query(value = "UPDATE teacher_email SET isactive=false WHERE title = ?1", nativeQuery = true)
	public int deleteEmailByTitle(String title);

}
