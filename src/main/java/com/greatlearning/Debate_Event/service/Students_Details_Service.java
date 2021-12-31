package com.greatlearning.Debate_Event.service;

import java.util.List;

import com.greatlearning.Debate_Event.entity.Students_Details;

public interface Students_Details_Service {
	public List<Students_Details> findAll();

	public Students_Details findById(int theId);

	public void save(Students_Details theStudent);

	public void deleteById(int theId);

	public List<Students_Details> searchBy(String name, String country);

}
