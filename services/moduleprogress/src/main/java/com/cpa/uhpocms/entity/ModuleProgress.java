/**
 * @author  - Code Generator
 * @createdOn -  04-04-2023
 * @Description Entity class for Teacher_studentmoduleprogress
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
@Table(name = "teacher_studentmoduleprogress")
public class ModuleProgress {


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private int id;

		@Column(name = "moduleid_id", nullable = false)
		private int moduleId;

		@Column(name = "studentid_id", nullable = false)
		private int studentId;
		
		@Column(name = "courseid_id", nullable = false)
		private int courseId;
		
		@Column(name = "progress", nullable = false)
		private int progress;

		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}

		/**
		 * @return the moduleId
		 */
		public int getModuleId() {
			return moduleId;
		}

		/**
		 * @param moduleId the moduleId to set
		 */
		public void setModuleId(int moduleId) {
			this.moduleId = moduleId;
		}

		/**
		 * @return the studentId
		 */
		public int getStudentId() {
			return studentId;
		}

		/**
		 * @param studentId the studentId to set
		 */
		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}

		/**
		 * @return the courseId
		 */
		public int getCourseId() {
			return courseId;
		}

		/**
		 * @param courseId the courseId to set
		 */
		public void setCourseId(int courseId) {
			this.courseId = courseId;
		}

		/**
		 * @return the progress
		 */
		public int getProgress() {
			return progress;
		}

		/**
		 * @param progress the progress to set
		 */
		public void setProgress(int progress) {
			this.progress = progress;
		}

		/**
		 * @param id
		 * @param moduleId
		 * @param studentId
		 * @param courseId
		 * @param progress
		 */
		public ModuleProgress(int id, int moduleId, int studentId, int courseId, int progress) {
			super();
			this.id = id;
			this.moduleId = moduleId;
			this.studentId = studentId;
			this.courseId = courseId;
			this.progress = progress;
		}

		/**
		 * 
		 */
		public ModuleProgress() {
			super();
		}

		@Override
		public String toString() {
			return "ModuleProgress [id=" + id + ", moduleId=" + moduleId + ", studentId=" + studentId + ", courseId="
					+ courseId + ", progress=" + progress + "]";
		}


		
}
