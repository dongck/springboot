package com.dongck.service;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongck.pojo.Teacher;

public interface TTeacherService {

	public List<Teacher> getTeachers();
	
	public Teacher insert();
	
	public Teacher update(@RequestParam Long id,@RequestParam String name);
	
	public void del(@RequestParam Long id);

}
