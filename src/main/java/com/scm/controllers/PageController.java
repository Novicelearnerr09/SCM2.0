package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {

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
    
}
