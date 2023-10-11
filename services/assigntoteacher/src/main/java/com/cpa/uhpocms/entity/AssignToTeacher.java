/**
 * @author  - Code Generator
 * @createdOn -  02-03-2023
 * @Description Entity class for teacher_course_assigntoteacher
 * 
 */

package com.cpa.uhpocms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "teacher_course_assigntoteacher")
public class AssignToTeacher {


	//TODO - add attributed and genrate setters and getters
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "id")
		private int assignToTeachercourseId;
		
		@Column(name = "course_id", nullable = false)
		private int courseId;
		
		@Column(name = "profile_id", nullable = false)
		private int profileId;
		
		public int getId() {
			return assignToTeachercourseId;
		}

		public void setId(int id) {
			this.assignToTeachercourseId = id;
		}

		public AssignToTeacher() {
			super();
			// TODO Auto-generated constructor stub
		}

		public AssignToTeacher(int id, int courseId, int profileId) {
			super();
			this.assignToTeachercourseId = id;
			this.courseId = courseId;
			this.profileId = profileId;
		}

		public int getCourseId() {
			return courseId;
		}

		public void setCourseId(int courseId) {
			this.courseId = courseId;
		}

		public int getProfileId() {
			return profileId;
		}

		public void setProfileId(int profileId) {
			this.profileId = profileId;
		}

	
//TODO - add attributed and genrate setters and getters

		@Override
		public String toString() {
			return "AssignToTeacher [id=" + assignToTeachercourseId + ", courseId=" + courseId + ", profileId=" + profileId + "]";
		}

}
