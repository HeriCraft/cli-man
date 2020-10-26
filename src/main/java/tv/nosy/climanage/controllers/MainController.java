package tv.nosy.climanage.controllers;

import java.sql.Date;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import tv.nosy.climanage.models.beans.AuthInfo;
import tv.nosy.climanage.models.beans.SubInfo;
import tv.nosy.climanage.models.dao.Code;
import tv.nosy.climanage.models.dao.Users;
import tv.nosy.climanage.models.job.SubmitLogin;

@Controller
public class MainController {
    

    @GetMapping(value = { "/", "/index", "/sign_in" })
    public String getLoginPage(HttpSession session){
        if(session.getAttribute("cm_users") != null){
            return("redirect:/home");
        }
        return "index";
    }
    @GetMapping(value = {"/signup", "/new"})
    public String getSignUpPage(HttpSession session){
        if(session.getAttribute("cm_users") != null){
            return("redirect:/home");
        }
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
    public String authentification(@ModelAttribute AuthInfo info, Model model, HttpSession session){
        model.addAttribute("info", info);
        

        try{
            Users u = SubmitLogin.login(Long.parseLong(info.getLogin()), info.getPass());
            session.setAttribute("cm_users", u);
            return "redirect:/home";
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return "redirect:/auth";
    }
}
