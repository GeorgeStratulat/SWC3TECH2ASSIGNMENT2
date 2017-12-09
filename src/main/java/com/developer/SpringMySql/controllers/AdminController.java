package com.developer.SpringMySql.controllers;

import com.developer.SpringMySql.models.Courses;
import com.developer.SpringMySql.models.CoursesRepository;
import com.developer.SpringMySql.models.Student;
import com.developer.SpringMySql.models.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.developer.SpringMySql.models.DatabaseConnection.getConnection;

/**
 * Created by George Stratulat on 27/11/2017.
 */
@Controller
public class AdminController {
    @Autowired
    StudentRepository StudentRepo;
    @Autowired
    CoursesRepository CourseRepo;

    @RequestMapping("/admin")
    public ModelAndView doHome() throws SQLException{

        ModelAndView mv = new ModelAndView("admin");

        List<Courses> listCourses = new ArrayList<>();
        List<Student> listStudents = new ArrayList<>();

        Iterable<Courses> ic = CourseRepo.findAll();
        Iterable<Student> is = StudentRepo.findAll();

        for (Courses course: ic) {
            listCourses.add(course);
        }

        for (Student student: is) {
            listStudents.add(student);
        }

        mv.addObject("courses", listCourses);
        mv.addObject("students", listStudents);

        return mv;
    }
}
