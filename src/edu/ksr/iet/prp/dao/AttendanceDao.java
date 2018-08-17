package edu.ksr.iet.prp.dao;

import java.util.List;

public interface AttendanceDao {
	
	public int insertAttendance(List<String> studentIdsList,List<String> studentNameList,String date);

}
