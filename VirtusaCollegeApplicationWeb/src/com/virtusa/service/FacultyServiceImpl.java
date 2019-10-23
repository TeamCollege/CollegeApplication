package com.virtusa.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.dao.FacultyDAO;
import com.virtusa.entities.ClassSchedule;
import com.virtusa.entities.ExamSchedule;
import com.virtusa.entities.Faculty;
import com.virtusa.entities.StaffMeeting;
import com.virtusa.entities.Student;
import com.virtusa.entities.UploadDownloadAssignments;
import com.virtusa.helper.FactoryFacultyDAO;
import com.virtusa.model.ClassScheduleModel;
import com.virtusa.model.ExamScheduleModel;
import com.virtusa.model.FacultyModel;
import com.virtusa.model.StaffMeetingModel;
import com.virtusa.model.StudentModel;
import com.virtusa.model.UploadDownloadAssignmentsModel;

public class FacultyServiceImpl implements FacultyService {
	
	private FacultyDAO facultyDAO=null;
	public FacultyServiceImpl() {
		this.facultyDAO=FactoryFacultyDAO.createFacultyDAO();
	}
 
	@Override      
	public List<ClassScheduleModel> retreiveClassSchedule(String departmentName) {
		//System.out.println("in service");

		List<ClassScheduleModel> classScheduleModelList = new ArrayList<>();
			try {
				List<ClassSchedule> classScheduleList = facultyDAO.viewCLassSchedule(departmentName);
				for(ClassSchedule classSchedule:classScheduleList) {
					ClassScheduleModel classScheduleModel = new ClassScheduleModel();
					classScheduleModel.setDay(classSchedule.getDay());
					classScheduleModel.setFirstHour(classSchedule.getFirstHour());
					classScheduleModel.setSecondHour(classSchedule.getSecondHour());
					classScheduleModel.setThirdHour(classSchedule.getThirdHour());
					classScheduleModel.setFourthHour(classSchedule.getFourthHour());
					classScheduleModelList.add(classScheduleModel);
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	
		return classScheduleModelList;
	}

	@Override
	public List<StaffMeetingModel> handleRetrieveStaffMeeting(String departmentName1) {
		List<StaffMeetingModel> staffMeetingModelList = new ArrayList<>();
		try {
			List<StaffMeeting> staffMeeting = facultyDAO.getStaffMeetingDetails(departmentName1);
			
			for(StaffMeeting staffMeeting1: staffMeeting) {
			StaffMeetingModel staffMeetingModel=new StaffMeetingModel();
			staffMeetingModel.setFacultyId(staffMeeting1.getFacultyId());
			staffMeetingModel.setStaffMeetingId(staffMeeting1.getStaffMeetingId());
			staffMeetingModel.setStaffMeetingAgenda(staffMeeting1.getStaffMeetingAgenda());
			staffMeetingModel.setLocation(staffMeeting1.getLocation());
			
			staffMeetingModelList.add(staffMeetingModel);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			 
			e.printStackTrace();
		}		
		return staffMeetingModelList;
	}
	
	@Override
	public List<ExamScheduleModel> handleRetrieveExamintionSchedule(String departmentName) {
		List<ExamScheduleModel> examScheduleModelList = new ArrayList<>();
		try {
		List<ExamSchedule> examSchedule=facultyDAO.getExaminationSchedule(departmentName);
		
		for(ExamSchedule examSchedule1: examSchedule) {
		ExamScheduleModel examScheduleModel = new ExamScheduleModel();
		examScheduleModel.setExamId(examSchedule1.getExamId());
		examScheduleModel.setExamType(examSchedule1.getExamType());
		examScheduleModel.setExamName(examSchedule1.getExamName());
		examScheduleModel.setExamDate(examSchedule1.getExamDate());
		examScheduleModel.setExamSubject1(examSchedule1.getExamSubject1());
		examScheduleModel.setExamSubject2(examSchedule1.getExamSubject2());
	
		examScheduleModelList.add(examScheduleModel);
		}
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	
	}
		return examScheduleModelList;
	}

	@Override
	public String uploadAssignments(UploadDownloadAssignmentsModel uploadDownloadAssignmentsModel) {
		UploadDownloadAssignments uploadDownloadAssignments=new UploadDownloadAssignments();
		uploadDownloadAssignments.setFileId(uploadDownloadAssignmentsModel.getFileId());
		uploadDownloadAssignments.setFileName(uploadDownloadAssignmentsModel.getFileName());
		uploadDownloadAssignments.setPath(uploadDownloadAssignmentsModel.getPath());
		uploadDownloadAssignments.setFileDescription(uploadDownloadAssignmentsModel.getFileDescription());
		String result = "failed";
		try {
		//System.out.println("before");
		boolean stored = facultyDAO.uploadDownloadAssignments(uploadDownloadAssignments);
		//System.out.println("after");
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


