/**
 * @author  - Code Generator
 * @createdOn -  31-01-2023
 * @Description Entity class for Announcement
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cpa.uhpocms.entity.Announcement;

@Repository
public interface AnnouncementRepo extends JpaRepository<Announcement, Integer> {

	public Announcement findByAnnouncementTitle(String title);

	public List<Object> findByIdIsGreaterThan(int NUMBER);

	@Transactional
	@Modifying
	public int deleteByAnnouncementTitle(String title);

//	@Query(value = "INSERT INTO teacher_announcements_to_list VALUES(?,?,?)", nativeQuery = true)
//	public List<AnnouncementTo> sendToAll();

}