package tv.nosy.climanage.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tv.nosy.climanage.models.dao.Users;


@Controller
public class LoggedInController {
    @RequestMapping(value="/home", method=RequestMethod.GET)
    public String getHomePage(Model model, HttpSession session) {
        Users usr = (Users) session.getAttribute("cm_users");

        if(usr == null){
            model.addAttribute("error", "Session expir&eacute;");
            return "redirect:/";
        }
        model.addAttribute("user", usr);

        return "home";
    }
    
}
