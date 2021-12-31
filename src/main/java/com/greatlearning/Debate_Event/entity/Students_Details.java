package com.greatlearning.Debate_Event.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student_details")
@Data
@Getter
@Setter
public class Students_Details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	private String name;
	private String department;
	private String country;

	public Students_Details() {

	}

	public Students_Details(String name, String department, String country) {
		super();
		this.name = name;
		this.department = department;
		this.country = country;
	}

}
