package com.greatlearning.Debate_Event.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.Debate_Event.entity.Students_Details;
import com.greatlearning.Debate_Event.service.Students_Details_Service;

@Controller
@RequestMapping("/students")
public class StudentDetailsController {

	@Autowired
	private Students_Details_Service stdservice;

	// add mapping for "/list"
	@RequestMapping
	public String listStudents(Model model) {
		// get Students from DB
		List<Students_Details> std = stdservice.findAll();

		// add to the spring model
		model.addAttribute("Students", std);
		return "list-students";

	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		// create model attribute to bind form data
		Students_Details thestudent = new Students_Details();

		model.addAttribute("Student", thestudent);

		return "student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model model) {

		// get the student from the service
		Students_Details thestudent = stdservice.findById(theId);

		// set student as a model attribute to pre-populate the form
		model.addAttribute("Student", thestudent);

		// send over to our form
		return "student-form";
	}

	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {

		System.out.println(id);
		Students_Details stddet = new Students_Details();
		if (id != 0) {
			stddet.setName(name);
			stddet.setDepartment(department);
			stddet.setCountry(country);

		} else
			stddet = new Students_Details(name, department, country);
		// save the student
		stdservice.save(stddet);

		// use a redirect to prevent duplicate submissions
		return "redirect:/students/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {

		// delete the Book
		stdservice.deleteById(theId);

		// redirect to /Books/list
		return "redirect:/students/list";

	}

	@RequestMapping("/search")
	public String search(@RequestParam("name") String name, @RequestParam("country") String country, Model theModel) {

		// check names, if both are empty then just give list of all Books

		if (name.trim().isEmpty() && country.trim().isEmpty()) {
			return "redirect:/students/list";
		} else {
			// else, search by first name and last name
			List<Students_Details> thestudent = stdservice.searchBy(name, country);

			// add to the spring model
			theModel.addAttribute("Students", thestudent);

			// send to list-Books
			return "list-Students";
		}

	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}
}