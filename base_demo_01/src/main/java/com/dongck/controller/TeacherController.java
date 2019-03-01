package com.dongck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dongck.dao.service.JpaTeacherRepository;
import com.dongck.pojo.Teacher;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private JpaTeacherRepository jpaTeacherRepository;
	
	@RequestMapping("/getAllTeachers")
	public List<Teacher> getTeachers(){
		return jpaTeacherRepository.findAll();
	}
	
	@RequestMapping("/insert")
	public Teacher insert(){
		Teacher t = new Teacher();
		t.setAge(19);
		t.setName("zs");
		return jpaTeacherRepository.saveAndFlush(t);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Teacher update(@RequestParam Long id,@RequestParam String name){
		Teacher t = jpaTeacherRepository.findById(id).get();
		t.setName(name);
		return jpaTeacherRepository.saveAndFlush(t);
	}
	
	@RequestMapping("/del")
	public void del(@RequestParam Long id){
		jpaTeacherRepository.deleteById(id);
	}
	

}
