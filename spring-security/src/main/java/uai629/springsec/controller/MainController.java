package uai629.springsec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uai629.springsec.service.ManagementService;

@Controller
public class MainController {
    
    @Autowired
    private ManagementService managementService;
    
    @RequestMapping(value="/user.html", method=RequestMethod.GET)
    public String renderUserPage() {
        System.out.println("Reading info...");
        managementService.readInfo();
        System.out.println("Setting info...");
        managementService.setInfo("NEW INFO");
        return "user";
    }

    @RequestMapping(value="/{page}.html", method=RequestMethod.GET)
    public String renderPage(@PathVariable String page) {
        return page;
    }
    
}
