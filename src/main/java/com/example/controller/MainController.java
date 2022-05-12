package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Customer;
import com.example.repo.CustomerRepository;

@Controller
public class MainController {
	
	@Autowired(required = true)
	private CustomerRepository custrepo;
	
	@GetMapping(value="/retrive")
	public String retrive() {
		return "retrive";
	}

	@GetMapping("/login")
	public String Login(Model model) {
		model.addAttribute("customers", new Customer());
		return "login";
	}

	@GetMapping("/desc")
	public String description() {

		return "desc";
	}

	// signup url
	@GetMapping("/signup")
	public String Signup(Model model) {
		model.addAttribute("customers", new Customer());

		return "signup";
	}

	@RequestMapping(value = "/onsignup", method = RequestMethod.POST)
	public @ResponseBody String doSignup(@ModelAttribute("customer") Customer cust, Model model,HttpSession session) {
		
			
		String txt = null;
		if (custrepo.existsByEmail(cust.getEmail())) {
			txt = "email is already taken";
		} else {
			txt = "loggin successfully";
			this.custrepo.save(cust);
		}
		return txt;
				
	}

	@RequestMapping(value = "/onlogin", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute("customer") Customer cust, Model model, HttpSession session) {

	//	if (null == session.getAttribute("name")) {
			String txt = null;
			if (custrepo.existsByEmailAndPassword(cust.getEmail(), cust.getPassword())) {
				txt = "1";
				model.addAttribute("name", cust.getEmail());
				session.setAttribute("name", cust.getEmail());
				return "/home";
			} else {
				txt = "0";
				return "/login";
			}
			
			
//		} 
//		return "/home";	
	}
	@GetMapping(value="/show")
	public String show() {
	return "show";
	}

}
