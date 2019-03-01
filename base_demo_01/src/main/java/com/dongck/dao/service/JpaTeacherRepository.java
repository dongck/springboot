package com.dongck.dao.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dongck.pojo.Teacher;

public interface JpaTeacherRepository extends JpaRepository<Teacher,Long> {
	
	

}
