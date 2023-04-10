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

		@Column(name = "currentfileno", nullable = false)
		private int currentFileNo ;

		@Column(name = "currentquizno", nullable = false)
		private int currentquizno;

		@Column(name = "moduleid_id", nullable = false)
		private int moduleId;

		@Column(name = "studentid_id", nullable = false)
		private int studentId;

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
		 * @return the currentFileNo
		 */
		public int getCurrentFileNo() {
			return currentFileNo;
		}

		/**
		 * @param currentFileNo the currentFileNo to set
		 */
		public void setCurrentFileNo(int currentFileNo) {
			this.currentFileNo = currentFileNo;
		}

		/**
		 * @return the currentquizno
		 */
		public int getCurrentquizno() {
			return currentquizno;
		}

		/**
		 * @param currentquizno the currentquizno to set
		 */
		public void setCurrentquizno(int currentquizno) {
			this.currentquizno = currentquizno;
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
		 * @param id
		 * @param currentFileNo
		 * @param currentquizno
		 * @param moduleId
		 * @param studentId
		 */
		public ModuleProgress(int id, int currentFileNo, int currentquizno, int moduleId, int studentId) {
			super();
			this.id = id;
			this.currentFileNo = currentFileNo;
			this.currentquizno = currentquizno;
			this.moduleId = moduleId;
			this.studentId = studentId;
		}

		/**
		 * 
		 */
		public ModuleProgress() {
			super();
		}

		@Override
		public String toString() {
			return "ModuleProgress [id=" + id + ", currentFileNo=" + currentFileNo + ", currentquizno=" + currentquizno
					+ ", moduleId=" + moduleId + ", studentId=" + studentId + "]";
		}

		
}
