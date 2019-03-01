package com.dongck.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dongck.dao.service.JpaTeacherRepository;
import com.dongck.pojo.Teacher;
import com.dongck.service.TTeacherService;
import com.dongck.service.TeacherService;

@Service
public class TTeacherServiceImpl implements TTeacherService {
	@Autowired
	private JpaTeacherRepository jpaTeacherRepository;
	
	@Override
	public List<Teacher> getTeachers() {
		return  jpaTeacherRepository.findAll();
	}

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	public Teacher insert() {
		Teacher t = new Teacher();
		t.setAge(19);
		t.setName("zs");
		return jpaTeacherRepository.saveAndFlush(t);
	}

	@Override
	public Teacher update(Long id, String name) {
		Teacher t = jpaTeacherRepository.findById(id).get();
		t.setName(name);
		System.out.println("########################################################");
		insert();
		System.out.println("########################################################");
		return jpaTeacherRepository.saveAndFlush(t);
	}

	@Override
	public void del(Long id) {
		jpaTeacherRepository.deleteById(id);
	}

}
