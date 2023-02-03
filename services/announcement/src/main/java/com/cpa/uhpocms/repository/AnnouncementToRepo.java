package com.cpa.uhpocms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.AnnouncementTo;

@Repository
public interface AnnouncementToRepo extends JpaRepository<AnnouncementTo, Integer> {

}
