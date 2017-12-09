package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Lecture;

@Repository
public class LectureDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int getRowCount() {
		String sqlStatement = "select count(*) from lecture";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}
	
	public Lecture getLecture(String className) {
		String sqlStatement = "select * from lecture where class_name = ?";
		
		return jdbcTemplate.queryForObject(sqlStatement, new Object[] {className}, 
					new RowMapper<Lecture>() {

						public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {
							
							Lecture lecture = new Lecture();
							lecture.setId(rs.getInt("id"));
							lecture.setYears(rs.getString("years"));
							lecture.setSemester(rs.getString("semester"));
							lecture.setClass_code(rs.getString("class_code"));
							lecture.setClass_name(rs.getString("class_name"));
							lecture.setDivision(rs.getString("division"));
							lecture.setGrades(rs.getString("grades"));
							
							return lecture;
						}
		});
	}
	//query and return multiple objects
	public List<Lecture> getLectures() {
		String sqlStatement = "select * from lecture";
		
		return jdbcTemplate.query(sqlStatement, new RowMapper<Lecture>() {

						public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {
							
							Lecture lecture = new Lecture();
							lecture.setId(rs.getInt("id"));
							lecture.setYears(rs.getString("years"));
							lecture.setSemester(rs.getString("semester"));
							lecture.setClass_code(rs.getString("class_code"));
							lecture.setClass_name(rs.getString("class_name"));
							lecture.setDivision(rs.getString("division"));
							lecture.setGrades(rs.getString("grades"));
							
							return lecture;
						}
		});
	}
	
	public boolean insert(Lecture lecture) {
		String years = lecture.getYears();
		String semester = lecture.getSemester();
		String classCode = lecture.getClass_code();
		String className = lecture.getClass_name();
		String division = lecture.getDivision();
		String grades = lecture.getGrades();
		
		String sqlStatement = "insert into lecture (years, semester, class_code, class_name, division, grades)"
								+ " values (?, ?, ?, ?, ?, ?)";
		
		return (jdbcTemplate.update(sqlStatement,
					new Object [] {years, semester, classCode, className, division, grades}) == 1);
	}
	
	public boolean update(Lecture lecture) {
		
		int id = lecture.getId();
		String years = lecture.getYears();
		String semester = lecture.getSemester();
		String classCode = lecture.getClass_code();
		String className = lecture.getClass_name();
		String division = lecture.getDivision();
		String grades = lecture.getGrades();
		
		String sqlStatement = "update lecture set years=?, semester=?, class_code=?, class_name=?,"
								+ " division=?, grades=? where id=?";
		
		return (jdbcTemplate.update(sqlStatement,
					new Object [] {years, semester, classCode, className, division, grades, id}) == 1);
	}
	
	public boolean delete(int id) {
		String sqlStatement = "delete from lecture where id=?";
		return (jdbcTemplate.update(sqlStatement, new Object[] {id}) == 1);
	}
}
