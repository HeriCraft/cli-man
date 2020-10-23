package tv.nosy.climanage.controllers;

import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import tv.nosy.climanage.models.beans.SubInfo;
import tv.nosy.climanage.models.dao.Code;
import tv.nosy.climanage.models.dao.Users;
import tv.nosy.climanage.models.job.SubmitLogin;

@Controller
public class MainController {
    
    @GetMapping(value = {"/", "/index", "/sign_in"})
    public String getLoginPage(){
        return "index";
    }
    @GetMapping(value = {"/signup", "/new"})
    public String getSignUpPage(){
        return "sign_up";
    }

    @PostMapping(value = {"/submission"})
    public String submission(@ModelAttribute SubInfo info, Model model){
        model.addAttribute("info", info);

        try{
            Users u = new Users(0, info.getFullName(), info.getUname(), null);
            Code cd = new Code(0, u, info.getPass(), Date.valueOf("2020-11-05"));
            u.setCd(cd);
            SubmitLogin.submit(u);
        }catch(Exception e){
            e.printStackTrace();
        }

        return "redirect:/";
    }
    @PostMapping(value = {"/auth"})
    public String authentification(){
        
        return "redirect:/auth";
    }
}
