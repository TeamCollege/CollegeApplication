package com.virtusa.controller;


import com.virtusa.entities.UploadDownloadAssignments;
import com.virtusa.helper.FactoryStudentDB;
import com.virtusa.model.StudentModel;
import com.virtusa.model.UploadDownloadAssignmentsModel;
import com.virtusa.service.StudentService;
import com.virtusa.view.StudentView;

// log.info = Logger.getLogger(StudentController.class.getName());

public class StudentController {
	private StudentService studentService;
	StudentView studentView=new StudentView();
	
	
	public StudentController() {
		this.studentService=FactoryStudentDB.createStudentService();
	}        
// 12.10.19
	public void retrieveClassSchedule(String departmentName) {

		StudentModel students=studentService.handleRetrieveClassSchedule(departmentName);
		studentView.showClassSchedule(students);
	}

	public void retrieveExaminationSchedule(String departmentName) {
		StudentModel students=studentService.handleRetrieveExamintionSchedule(departmentName);
		studentView.showExamSchedule(students);

		
	}

	public void retrieveResults(int studentId) {
		StudentModel students=studentService.handleRetrieveResults(studentId);
		studentView.showResults(students);
		
	}

	

	public void retrievePlacementCalender() {
		StudentModel students=studentService.handleRetrievePlacementCalender();
		System.out.println(students);
		studentView.showPlacementCalender(students);
	}

	

	public void downloadAssignments() {
		// TODO Auto-generated method stub
		
	}
	public void uploadAssignments(String path) {
		// TODO Auto-generated method stub
		String result = studentService.handleUploadAssignments(path);
		if(result.contentEquals("success"))
			studentView.uploadSuccess();
		else
			studentView.uploadUnsuccessful();
	}
	
	

}
