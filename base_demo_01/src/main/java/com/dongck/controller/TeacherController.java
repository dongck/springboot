package com.dongck.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dongck.dao.service.JpaTeacherRepository;
import com.dongck.pojo.Teacher;
import com.dongck.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping("/getAllTeachers")
	public List<Teacher> getTeachers(){
		return teacherService.getTeachers();
	}
	
	@RequestMapping("/insert")
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	public Teacher insert(){
		return teacherService.insert();
	}
	
	@RequestMapping("/update")
	public Teacher update(@RequestParam Long id,@RequestParam String name){
		return teacherService.update(id,name);
	}
	
	@RequestMapping("/del")
	public void del(@RequestParam Long id){
		teacherService.del(id);
	}

}
