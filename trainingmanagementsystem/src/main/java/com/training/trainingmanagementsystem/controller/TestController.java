package com.training.trainingmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.training.trainingmanagementsystem.bean.AppRole;
import com.training.trainingmanagementsystem.bean.AppUser;
import com.training.trainingmanagementsystem.bean.User;
import com.training.trainingmanagementsystem.bean.UserRole;
import com.training.trainingmanagementsystem.dao.AppRoleRepository;
import com.training.trainingmanagementsystem.dao.AppUserRepository;
import com.training.trainingmanagementsystem.dao.UserRoleRepository;

@Controller
public class TestController {
	
	
	@Autowired
	AppRoleRepository appRoleRepository;
	
	@Autowired
	AppUserRepository appUserRepository;
	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	@GetMapping(value="/hello")
	
	public String print()
	{
		return "hello";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
 
        //model.setViewName("loginPage.jsp");
        return  "loginPage";
    }
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String loginPage1(Model model) {
 
        //model.setViewName("loginPage.jsp");
        return  "loginSuccessAdmin";
    }
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
    public String loginPage3(Model model) {
 
        //model.setViewName("loginPage.jsp");
        return  "error";
    }
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
    public String loginPage2(Model model) {
 
        //model.setViewName("loginPage.jsp");
        return  "loginSuccessUser";
    }
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
 
        //model.setViewName("loginPage.jsp");
        return  "register";
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPagePost(@ModelAttribute User user) {
 
        //model.setViewName("loginPage.jsp");
		AppRole role=new AppRole();
		role.setRoleName("ROLE_"+user.getRole_name().toUpperCase());
		AppUser users=new AppUser();
		
		users.setUserName(user.getUsername());
		users.setEnabled(0);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		users.setEncrytedPassword(hashedPassword);
		
		appRoleRepository.save(role);
		appUserRepository.save(users);
		
		UserRole userRole=new UserRole();
		userRole.setAppRole(role);
		userRole.setAppUser(users);
		userRoleRepository.save(userRole);
		
		
		
		
		
        return  "register";
    }

}
