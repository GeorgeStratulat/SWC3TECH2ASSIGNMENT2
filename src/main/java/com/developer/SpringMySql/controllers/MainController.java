package com.developer.SpringMySql.controllers;

import com.developer.SpringMySql.models.Courses;
import com.developer.SpringMySql.models.CoursesRepository;
import com.developer.SpringMySql.models.User;
import com.developer.SpringMySql.models.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.repository.CrudRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;
import java.io.IOException;

/**
 * Created by George Stratulat on 23/11/2017.
 */
@Controller
public class MainController {

    @Autowired
    CoursesRepository courseRepo;
    @Autowired
    UsersRepository ur;

    @GetMapping("/")
    public ModelAndView doHome(){
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @GetMapping("/logOut")
    public ModelAndView logOut(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public ModelAndView doLoginCheck(@RequestParam("authCode") int authCode, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("index");

        User user = new User();
        user = ur.findOne(authCode);

        if (user != null) {
            request.getSession().setAttribute("userId", authCode);

            if (user.type.equals("student")) {
                mv.setViewName("redirect:/student");
            }
            else if (user.type.equals("teacher")) {
                mv.setViewName("redirect:/teacher");
            }
            else if (user.type.equals("admin")) {
                mv.setViewName("redirect:/admin");
            }
        }

        return mv;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView doDelete(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("redirect:/");
        courseRepo.delete(id);
        return mv;
    }

}
