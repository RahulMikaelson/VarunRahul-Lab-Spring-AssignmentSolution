package com.greatlearning.Debate_Event.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.Debate_Event.entity.Students_Details;

public interface Students_DetailsRepository extends JpaRepository<Students_Details, Integer> {

	List<Students_Details> findByNameContainsAndCountryContainsAllIgnoreCase(String name, String country);

}
