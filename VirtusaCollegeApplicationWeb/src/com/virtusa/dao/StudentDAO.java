package com.virtusa.dao;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import com.virtusa.entities.ClassSchedule;
import com.virtusa.entities.Student;


public interface StudentDAO {

	public Student getClassSchedule(String departmentName)throws ClassNotFoundException, SQLException;

	public Student getExaminationSchedule(String departmentName)throws ClassNotFoundException, SQLException;

	public Student getResults(int studentId)throws ClassNotFoundException, SQLException;

	public Student getPlacementCalender()throws ClassNotFoundException, SQLException;

	public boolean handleRetrieveUploadAssignments(String path)throws ClassNotFoundException, SQLException, FileNotFoundException ;

	public  List<ClassSchedule> handleClassSchedule(String departmentName) throws ClassNotFoundException, SQLException;

}
