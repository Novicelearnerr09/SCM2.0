package com.scm.controllers;

import com.scm.entities.User;
//import com.scm.forms.UseForm;
import com.scm.forms.UserForm;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(Model model)
    {
        System.out.println("Home Page Handler");
        model.addAttribute("name","Substring technology");
        model.addAttribute("YoutubeChannel", "Durgesh IT");
        model.addAttribute("GithubRepository", "https://github.com/Novicelearnerr09");
        return "home";
    }

    //about 
    @RequestMapping("/about")
       public String aboutpage(Model model)
    {
        model.addAttribute("isLogin", true);
        System.out.println("About page loading");
        return "about";
    }

    //Services
    @RequestMapping("/services")
    public String servicesPage()
    {
        System.out.println("Services page loading");
        return "services";
    }

    @RequestMapping("/contact")
    public String contactPage()
    {
        System.out.println("contact page is loading");
        return "contact";
    }

    @RequestMapping("/login")
    public String loginPage()
    {
        System.out.println("login page is loading");
        return "login";
    }

    @RequestMapping("/register")
    public String registerPage(Model model)
    {
        UserForm userForm = new UserForm();
        userForm.setName("Shubham");
      //  model.addAttribute("userForm",userForm);
        model.addAttribute("userForm", userForm);
        System.out.println("Register page is loading");
        return "register";
    }

    //processing register
@RequestMapping(value="/do-register", method=RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm, HttpSession session) {
        System.out.println(" registration process working or not?");
        System.out.println(userForm);
        //fetch from data
        //userForm
        //validate form data
        //save to database
        //userservice
        ///creating user on basis of userForm
        
        //below code is not working for default value because of builder method
       /* 
        User user=User.builder()
        .name(userForm.getName())
        .email(userForm.getEmail())
        .password(userForm.getPassword())
        .about(userForm.getAbout())
        .phoneNumber(userForm.getPhoneNumber())
        .profilePic(userForm.profilePic="C:\\Users\\Novic\\OneDrive\\Desktop\\scm2.0\\src\\main\\resources\\static\\images\\profile.png ")
        .build();
        */
        
        //so we are manual creating user now
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("C:\\Users\\Novic\\OneDrive\\Desktop\\scm2.0\\src\\main\\resources\\static\\images\\profile.png");



        User saveUser = userService.saveUser(user);
        //message = " Registration successfull"
        System.out.println("User saved!");

        //add message

        session.setAttribute("message","Registration Successfull");




        return "redirect:/register";
    }
    
}
