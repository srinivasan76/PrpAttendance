package edu.ksr.iet.prp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

import edu.ksr.iet.prp.dao.AttendanceDao;
import edu.ksr.iet.util.DBUtil;

public class AttendanceDaoImpl implements AttendanceDao{

	public AttendanceDaoImpl(){
		
	}

	@Override
	public int insertAttendance(List<String> studentIdsList,List<String> studentNameList,String date) {
		String sql = "insert into attendance(studentid,studentname,date) values(?,?,?)";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try{
		connection  = DBUtil.getConnection();
		connection.setAutoCommit(false);
		//java.util.Date currentDate = new java.util.Date();
		//java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
		int i = 0;
		for (i = 0; i < studentIdsList.size() ; i++) {
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, studentIdsList.get(i));
			prepareStatement.setString(2, studentNameList.get(i));
		//	System.out.println(studentid);
			//prepareStatement.setString(2, studentid);
			prepareStatement.setString(3,date);
			prepareStatement.executeUpdate();
		}
		connection.commit();
		}catch(Exception e){
			try{
				connection.rollback();
			}catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			DBUtil.close(connection, prepareStatement, null);
		}
		return studentIdsList.size();
	}
}







