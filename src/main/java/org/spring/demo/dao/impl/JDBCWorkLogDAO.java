package org.spring.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.spring.demo.dao.WorkLogDAO;
import org.spring.demo.model.WorkLog;
 
public class JDBCWorkLogDAO implements WorkLogDAO
{
	private DataSource dataSource;
 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
 
	public void insert(WorkLog worklog){
 
		String sql = "INSERT INTO worklogs " +
				"(author, content, date) VALUES (?, ?, ?)";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, worklog.getAuthor());
			ps.setString(2, worklog.getContent());
			ps.setString(3, worklog.getDate());
			ps.executeUpdate();
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
 
	public WorkLog findByWorkLogId(int wid){
 
		String sql = "SELECT * FROM worklogs WHERE wid = ?";
 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, wid);
			WorkLog worklog = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				worklog = new WorkLog(
					rs.getInt("wid"),
					rs.getString("author"), 
					rs.getString("content"),
					rs.getString("date")
				);
			}
			rs.close();
			ps.close();
			return worklog;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	public List<WorkLog> findAllWorkLogs()
	{
		String sql = "SELECT * FROM worklogs;";
		 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			List<WorkLog> worklogs = new ArrayList<WorkLog>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				WorkLog worklog = new WorkLog(
					rs.getInt("wid"),
					rs.getString("author"), 
					rs.getString("content"),
					rs.getString("date")
				);
				worklogs.add(worklog);
			}
			rs.close();
			ps.close();
			return worklogs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
}