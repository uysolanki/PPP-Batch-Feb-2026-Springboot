package com.itp.amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.amazon.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{

}
