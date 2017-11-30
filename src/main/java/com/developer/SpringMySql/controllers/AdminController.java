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
    public ModelAndView doHome(HttpServletRequest request, HttpServletResponse response) throws SQLException{

        ModelAndView mv = new ModelAndView("admin");
        int adminId = (Integer)request.getSession().getAttribute("userId");

        Connection con = getConnection();
        List<Courses> listCourses = new ArrayList<>();
        List<String> listStudents = new ArrayList<>();
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM courses");
        while(rs.next()){
            String studentsEnrolled = "";
            Courses course = new Courses(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8),
                    rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16),
                    rs.getString(17));
            listCourses.add(course);

            ResultSet rs1 = con.createStatement().executeQuery("SELECT * FROM student");
            while(rs1.next()){
                int ok = 1;
                Student student = new Student(rs1.getInt(1), rs1.getString(2));
                String[] course_ids_split = student.getCourse_id().split(",");
                for(int i = 0; i < course_ids_split.length; i++){
                    if(Integer.parseInt(course_ids_split[i]) == course.getId()){
                     ok = 0;
                    }

                }
                if(ok == 0){
                    studentsEnrolled = studentsEnrolled + String.valueOf(student.getId()) + ",";
                }

            }
            if(studentsEnrolled.endsWith(",")){
                studentsEnrolled = studentsEnrolled.substring(0, studentsEnrolled.length() - 1);
            }

            listStudents.add(studentsEnrolled);
        }
        mv.addObject("courses", listCourses);
        mv.addObject("students", listStudents);
        return mv;
    }
}
