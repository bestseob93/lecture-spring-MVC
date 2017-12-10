package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.DivisionGrade;
import kr.ac.hansung.model.Lecture;
import kr.ac.hansung.model.SemesterLecture;

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
							lecture.setUsername(rs.getString("username"));
							
							return lecture;
						}
		});
	}
	//query and return multiple objects
	public List<Lecture> getLectures(String username) {
		String sqlStatement = "select * from lecture where username=?";
		
		return jdbcTemplate.query(sqlStatement, new Object[] {username}, 
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
							lecture.setUsername(rs.getString("username"));
							
							return lecture;
						}
		});
	}
	
	public List<SemesterLecture> getSemesterLectures(String username) {
		String sqlStatement = "select years, semester, SUM(grades) as total_grade from lecture where username=? group by years, semester";
		
		System.out.println("=================");
		System.out.println(username);
		return jdbcTemplate.query(sqlStatement, new Object[] {username},
				new RowMapper<SemesterLecture>() {
					public SemesterLecture mapRow(ResultSet rs, int rowNum) throws SQLException {
						SemesterLecture semesterLecture = new SemesterLecture();
						
						semesterLecture.setYears(rs.getString("years"));
						semesterLecture.setSemester(rs.getString("semester"));
						semesterLecture.setTotalgrades(rs.getString("total_grade"));
						
						System.out.println("===============");
						System.out.println(semesterLecture);
						return semesterLecture;
					}
		});
	}
	
	public List<DivisionGrade> getDivisionGrades(String username) {
		String sqlStatement = "select division, SUM(grades) as total_grade from lecture where username=? group by division";
		
		return jdbcTemplate.query(sqlStatement, new Object[] {username},
				new RowMapper<DivisionGrade>() {
					public DivisionGrade mapRow(ResultSet rs, int rowNum) throws SQLException {
						DivisionGrade divisionGrade = new DivisionGrade();
						
						divisionGrade.setDivision(rs.getString("division"));
						divisionGrade.setDivision(rs.getString("total_grade"));
						
						return divisionGrade;
					}
		});
	}
	
	public boolean insert(Lecture lecture) {
		System.out.println(lecture);
		String years = lecture.getYears();
		String semester = lecture.getSemester();
		String classCode = lecture.getClass_code();
		String className = lecture.getClass_name();
		String division = lecture.getDivision();
		String grades = lecture.getGrades();
		String username = lecture.getUsername();
		
		String sqlStatement = "insert into lecture (years, semester, class_code, class_name, division, grades, username)"
								+ " values (?, ?, ?, ?, ?, ?, ?)";
		
		return (jdbcTemplate.update(sqlStatement,
					new Object [] {years, semester, classCode, className, division, grades, username}) == 1);
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
