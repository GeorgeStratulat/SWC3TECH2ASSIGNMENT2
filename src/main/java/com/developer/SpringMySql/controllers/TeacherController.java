package com.developer.SpringMySql.controllers;

import com.developer.SpringMySql.models.Courses;
import com.developer.SpringMySql.models.CoursesRepository;
import com.developer.SpringMySql.models.Student;
import com.developer.SpringMySql.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static com.developer.SpringMySql.models.DatabaseConnection.getConnection;

/**
 * Created by George Stratulat on 27/11/2017.
 */
@Controller
public class TeacherController {


    @Autowired
    CoursesRepository courseRepo;

    @RequestMapping("/teacher")
        public ModelAndView doHome() throws SQLException {

        ModelAndView mv = new ModelAndView("teacher");
        List<Courses> listCourses = new ArrayList<>();
        Connection con = getConnection();
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM teachers WHERE id = 1");

        while (rs.next()) {
            Teacher teacher = new Teacher(rs.getInt(1), rs.getString(2));
            String course_ids = teacher.getCourse_id();
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
        return mv;
    }

    @RequestMapping(value = "/saveteacher", method = RequestMethod.POST)
    public ModelAndView doSaveCourse (@RequestParam("name_course_dk") String name_course_dk, @RequestParam("name_course_en") String name_course_en, @RequestParam("class_code") String class_code, @RequestParam("study_programme") String study_programme,
                                     @RequestParam("mandatory") String mandatory, @RequestParam("etcs") int etcs, @RequestParam("course_language") String course_language,
                                     @RequestParam("minimum_students") int minimum_students, @RequestParam("expected_students") int expected_students, @RequestParam("maximum_students") int maximum_students,
                                     @RequestParam("prerequisites") String prerequisites, @RequestParam("learning_outcome") String learning_outcome, @RequestParam("content") String content,
                                     @RequestParam("learning_activities") String learning_activities, @RequestParam("exam_form") String exam_form,
                                      @RequestParam("teachers") String teachers) throws SQLException{

        Connection con = getConnection();
        ModelAndView mv = new ModelAndView("redirect:/teacher");

        ResultSet rs = getConnection().createStatement().executeQuery("SELECT * FROM courses\n" +
                "WHERE id = (\n" +
                "    SELECT MAX(id) FROM courses)");
        while(rs.next()) {
            int number = rs.getInt(1) + 1;
            Courses course = new Courses();
            course.setId(number);
            course.setName_course_dk(name_course_dk);
            course.setName_course_en(name_course_en);
            course.setClass_code(class_code);
            course.setStudy_programme(study_programme);
            course.setMandatory(mandatory);
            course.setEtcs(etcs);
            course.setCourse_language(course_language);
            course.setMinimum_students(minimum_students);
            course.setExpected_students(expected_students);
            course.setMaximum_students(maximum_students);
            course.setPrerequisites(prerequisites);
            course.setLearning_outcome(learning_outcome);
            course.setContent(content);
            course.setLearning_activities(learning_activities);
            course.setExam_form(exam_form);
            course.setTeachers(teachers);
            courseRepo.save(course);

            ModelAndView mv2 = new ModelAndView("redirect:/teacher");


            ResultSet rs1 = con.createStatement().executeQuery("SELECT * FROM teachers WHERE id = 1");
            while (rs1.next()) {
                String course2 = rs1.getString(2);
                String aux = course2 + "," + course.getId();
                con.createStatement().executeUpdate("UPDATE teachers SET course_id = '" + aux + "'  WHERE id = 1");

            }

        return mv2;
    }
    return mv;
    }

    @RequestMapping(value = "/saveEdit", method = RequestMethod.POST)
    public ModelAndView doSave(@RequestParam("id") int id, @RequestParam("name_course_dk") String name_course_dk, @RequestParam("name_course_en") String name_course_en, @RequestParam("class_code") String class_code, @RequestParam("study_programme") String study_programme,
                               @RequestParam("mandatory") String mandatory, @RequestParam("etcs") int etcs, @RequestParam("course_language") String course_language,
                               @RequestParam("minimum_students") int minimum_students, @RequestParam("expected_students") int expected_students, @RequestParam("maximum_students") int maximum_students,
                               @RequestParam("prerequisites") String prerequisites, @RequestParam("learning_outcome") String learning_outcome, @RequestParam("content") String content,
                               @RequestParam("learning_activities") String learning_activities, @RequestParam("exam_form") String exam_form,
                               @RequestParam("teachers") String teachers){
        ModelAndView mv = new ModelAndView("redirect:/teacher");
        Courses course = new Courses();
        if(id != 0){
            course = courseRepo.findOne(id);
        }else{
            course = new Courses();
        }
        course.setName_course_dk(name_course_dk);
        course.setName_course_en(name_course_en);
        course.setClass_code(class_code);
        course.setStudy_programme(study_programme);
        course.setMandatory(mandatory);
        course.setEtcs(etcs);
        course.setCourse_language(course_language);
        course.setMinimum_students(minimum_students);
        course.setExpected_students(expected_students);
        course.setMaximum_students(maximum_students);
        course.setPrerequisites(prerequisites);
        course.setLearning_outcome(learning_outcome);
        course.setContent(content);
        course.setLearning_activities(learning_activities);
        course.setExam_form(exam_form);
        course.setTeachers(teachers);
        courseRepo.save(course);
        return mv;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView doEdit(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("edit");
        mv.addObject("lists", courseRepo.findOne(id));
        return mv;
    }

}