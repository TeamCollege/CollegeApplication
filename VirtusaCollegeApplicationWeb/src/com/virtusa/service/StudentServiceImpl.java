package com.virtusa.service;


import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.dao.StudentDAO;
import com.virtusa.entities.ClassSchedule;
import com.virtusa.entities.ExamSchedule;
import com.virtusa.entities.PlacementCalender;
import com.virtusa.entities.Results;
import com.virtusa.entities.Student;
import com.virtusa.entities.UploadDownloadAssignments;
import com.virtusa.helper.FactoryStudentDB;
import com.virtusa.model.ClassScheduleModel;
import com.virtusa.model.ExamScheduleModel;
import com.virtusa.model.PlacementCalenderModel;
import com.virtusa.model.ResultsModel;
import com.virtusa.model.StudentModel;
import com.virtusa.model.UploadDownloadAssignmentsModel;
import com.virtusa.model.StudentModel;

public class StudentServiceImpl implements StudentService {
	private StudentDAO studentDAO;
	public StudentServiceImpl() {
		this.studentDAO=FactoryStudentDB.createStudentDAO();
	}
//12.10.19
	@Override
	public StudentModel handleRetrieveClassSchedule(String departmentName) {
		Student students=null;
		StudentModel studentModel=new StudentModel();       
		try {
		students=studentDAO.getClassSchedule(departmentName);
		ClassSchedule classSchedule=students.getClassSchedule();
		ClassScheduleModel classScheduleModel=new ClassScheduleModel();
		classScheduleModel.setDay(classSchedule.getDay());
		classScheduleModel.setFirstHour(classSchedule.getFirstHour());
		classScheduleModel.setSecondHour(classSchedule.getSecondHour());
		classScheduleModel.setThirdHour(classSchedule.getThirdHour());
		classScheduleModel.setFourthHour(classSchedule.getFourthHour());
	
		studentModel.setClassScheduleModel(classScheduleModel);
	
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
	
	return studentModel;
	}
	
	public List<ClassScheduleModel> retrieveClassSchedule(String departmentName){
	 List<ClassScheduleModel> classScheduleModelList=new ArrayList<>();
	 try {
		List<ClassSchedule> classSchedule=studentDAO.handleClassSchedule(departmentName);
		for(ClassSchedule classSchedule1:classSchedule) {
			ClassScheduleModel classScheduleModel=new ClassScheduleModel();
			classScheduleModel.setDay(classSchedule1.getDay());
			classScheduleModel.setFirstHour(classSchedule1.getFirstHour());
			classScheduleModel.setSecondHour(classSchedule1.getSecondHour());
			classScheduleModel.setThirdHour(classSchedule1.getThirdHour());
			classScheduleModel.setFourthHour(classSchedule1.getFourthHour());
			classScheduleModelList.add(classScheduleModel);
		}
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	return classScheduleModelList;
	
	}
	
	@Override
	public StudentModel handleRetrieveExamintionSchedule(String departmentName) {
		// TODO Auto-generated method stub
		Student students=null;
		StudentModel studentModel=new StudentModel();
		try {
		students=studentDAO.getExaminationSchedule(departmentName);
		ExamSchedule examSchedule=students.getExamSchedule();
		ExamScheduleModel examScheduleModel=new ExamScheduleModel();
		examScheduleModel.setExamId(examSchedule.getExamId());
		examScheduleModel.setExamType(examSchedule.getExamType());
		examScheduleModel.setExamName(examSchedule.getExamName());
		examScheduleModel.setExamDate(examSchedule.getExamDate());
		examScheduleModel.setExamSubject1(examSchedule.getExamSubject1());
		examScheduleModel.setExamSubject2(examSchedule.getExamSubject2());
	
		studentModel.setExamScheduleModel(examScheduleModel);
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	}
		return studentModel;
}
	
	@Override
	public StudentModel handleRetrieveResults(int studentId) {
		// TODO Auto-generated method stub
		Student students=null;
		StudentModel studentModel=new StudentModel();
		try {
		students=studentDAO.getResults(studentId);
		Results results=students.getResults();
		ResultsModel resultsModel=new ResultsModel();
		resultsModel.setStudentId(results.getStudentId());
		resultsModel.setSubject1Name(results.getSubject1Name());
		resultsModel.setSubject1Marks(results.getSubject1Marks());
		resultsModel.setSubject2Marks(results.getSubject2Marks());
		resultsModel.setSubject2Name(results.getSubject2Name());
		resultsModel.setFinalresult(results.getFinalresult());
		
		studentModel.setResultsModel(resultsModel);
		
		
	}catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	}
		return studentModel;
}
	
	@Override
	public StudentModel handleRetrievePlacementCalender() {
		// TODO Auto-generated method stub
		Student students=null;
		StudentModel studentModel=new StudentModel();
		try {
		students=studentDAO.getPlacementCalender();
		PlacementCalender placementCalender=students.getPlacementCalender();
		PlacementCalenderModel placementCalenderModel=new PlacementCalenderModel();
		placementCalenderModel.setComapanyName(placementCalender.getComapanyName());
		placementCalenderModel.setDate(placementCalender.getDate());
		placementCalenderModel.setLocation(placementCalender.getLocation());
		placementCalenderModel.setEligibilityCriteria(placementCalender.getEligibilityCriteria());
		System.out.println(placementCalender.getEligibilityCriteria());
	}catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	}
		
		return studentModel;
}
	
	
	
	@Override
	public String handleUploadAssignments(String path)  {
		// TODO Auto-generated method stub
		UploadDownloadAssignments uploadDownloadAssignments=new UploadDownloadAssignments(); ;
		UploadDownloadAssignmentsModel uploadDownloadAssignmentsModel=new UploadDownloadAssignmentsModel();
		uploadDownloadAssignmentsModel.setFileId(uploadDownloadAssignments.getFileId());
		uploadDownloadAssignmentsModel.setFileName(uploadDownloadAssignments.getFileName());
		uploadDownloadAssignmentsModel.setPath(uploadDownloadAssignments.getPath());
		uploadDownloadAssignmentsModel.setFileDescription(uploadDownloadAssignments.getFileDescription());
		
		String result = "failed";
		try{
	
			boolean stored = studentDAO.handleRetrieveUploadAssignments(path);
		
			if(stored)
				result = "success";
		}
		catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("!ERROR[Upload failed due to some internal issue]");
		}
		
		return result;
	}
	}

	


