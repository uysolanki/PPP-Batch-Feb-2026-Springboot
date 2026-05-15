package com.itp.amazon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itp.amazon.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{

//	@Query(nativeQuery = true, value="select * from student where per > ?1")
//	public List<Student> getStudentsByPer(double basePer);
	
	public List<Student> findByPerGreaterThan(double basePer);
	
//	@Query(nativeQuery = true, value="select * from student where dname like ?1")
//	public List<Student> getStudentsByDeptname(String deptName);
	
	public List<Student> findByDname(String deptName);
	
	public List<Student> findByPerBetween(double a,double b);
	
}
