package com.developer.SpringMySql.controllers;
import com.developer.SpringMySql.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.developer.SpringMySql.models.DatabaseConnection.getConnection;

/**
 * Created by George Stratulat on 27/11/2017.
 */
@Controller
public class StudentController {

    @Autowired
    StudentRepository StudentRepo;
    @Autowired
    CoursesRepository CourseRepo;

    @RequestMapping("/student")
    public ModelAndView doHome() throws SQLException {

            ModelAndView mv = new ModelAndView("student");
            List<Courses> listCourses = new ArrayList<>();
            Connection con = getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM student WHERE id = 2");

                while (rs.next()) {
                    Student student = new Student(rs.getInt(1), rs.getString(2));
                    String course_ids = student.getCourse_id();
                    String[] course_ids_split = course_ids.split(",");
                    int[] course_ids2 = new int[course_ids_split.length];
                    for (int i = 0; i < course_ids_split.length; i++) {
                        course_ids2[i] = Integer.parseInt(course_ids_split[i]);
                        ResultSet rs2 = con.createStatement().executeQuery("SELECT * FROM courses WHERE id = '" + course_ids2[i] + "'");
                        while (rs2.next()) {
                            Courses course = new Courses(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getString(5), rs2.getString(6), rs2.getInt(7), rs2.getString(8),
                                    rs2.getInt(9), rs2.getInt(10), rs2.getInt(11), rs2.getString(12), rs2.getString(13), rs2.getString(14), rs2.getString(15), rs2.getString(16),
                                    rs2.getString(17));
                            listCourses.add(course);
                        }
                    }
                }

            mv.addObject("courses", listCourses);
            mv.addObject("lists",CourseRepo.findAll());
            return mv;
        }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView doSignUp(@RequestParam("course_id") int course_id) throws SQLException {
        Connection con = getConnection();
        ResultSet rs1 = con.createStatement().executeQuery("SELECT * FROM student WHERE id = 2");
        while (rs1.next()) {
            String course = rs1.getString(2);
            String aux = course + "," + course_id;
            con.createStatement().executeUpdate("UPDATE student SET course_id = '"+aux+"'  WHERE id = 2");

        }
        ModelAndView mv = new ModelAndView("redirect:/student");
        return mv;
    }

}
