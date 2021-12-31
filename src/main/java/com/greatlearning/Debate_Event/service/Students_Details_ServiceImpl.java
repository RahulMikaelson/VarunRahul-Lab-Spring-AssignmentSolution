package com.greatlearning.Debate_Event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.Debate_Event.entity.Students_Details;
import com.greatlearning.Debate_Event.repository.Students_DetailsRepository;

@Service
public class Students_Details_ServiceImpl implements Students_Details_Service {

	@Autowired
	Students_DetailsRepository studentdrepository;

	@Override
	public List<Students_Details> findAll() {
		// TODO Auto-generated method stub
		List<Students_Details> books = studentdrepository.findAll();
		return books;

	}

	@Override
	public Students_Details findById(int theId) {
		// TODO Auto-generated method stub
		return studentdrepository.findById(theId).get();

	}

	@Override
	public void save(Students_Details theStudent) {
		// TODO Auto-generated method stub
		studentdrepository.save(theStudent);

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		studentdrepository.deleteById(theId);

	}

	@Override
	public List<Students_Details> searchBy(String name, String country) {
		// TODO Auto-generated method stub
		List<Students_Details> students = studentdrepository.findByNameContainsAndCountryContainsAllIgnoreCase(name,
				country);
		return students;

	}

}
