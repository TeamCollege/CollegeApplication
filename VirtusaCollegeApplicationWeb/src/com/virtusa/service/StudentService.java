package com.virtusa.service;

import java.sql.SQLException;
import java.util.List;

import com.virtusa.entities.UploadDownloadAssignments;
import com.virtusa.model.ApplicantModel;
import com.virtusa.model.ClassScheduleModel;
import com.virtusa.model.StudentModel;
import com.virtusa.model.UploadDownloadAssignmentsModel;

public interface StudentService {
	//12.10.19
	public StudentModel handleRetrieveClassSchedule(String departmentName);

	public StudentModel handleRetrieveExamintionSchedule(String departmentName);

	public StudentModel handleRetrieveResults(int studentId);

	public StudentModel handleRetrievePlacementCalender();

	public String handleUploadAssignments(String path);
	
	public List<ClassScheduleModel> retrieveClassSchedule(String departmentName);
	

}     
