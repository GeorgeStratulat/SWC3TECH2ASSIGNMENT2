package com.developer.SpringMySql.controllers;

import com.developer.SpringMySql.models.Courses;
import com.developer.SpringMySql.models.CoursesRepository;
import com.developer.SpringMySql.models.User;
import com.developer.SpringMySql.models.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.repository.CrudRepository;

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

    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public ModelAndView doLoginCheck(@RequestParam("authCode") int authCode) {
        ModelAndView mv = new ModelAndView("index");

        User user = new User();
        user = ur.findOne(authCode);

        if (user != null) {
            if (user.type.equals("student")) {
                mv.setViewName("student");
            }
            else if (user.type.equals("teacher")) {
                mv.setViewName("teacher");
            }
            else if (user.type.equals("admin")) {
                mv.setViewName("admin");
            }
        }

        return mv;
    }

    /*@RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView doSave(@RequestParam("id") int id, @RequestParam("name_course_dk") String name_course_dk, @RequestParam("name_course_en") String name_course_en, @RequestParam("class_code") String class_code, @RequestParam("study_programme") String study_programme,
                               @RequestParam("mandatory") String mandatory, @RequestParam("etcs") int etcs, @RequestParam("course_language") String course_language,
                               @RequestParam("minimum_students") int minimum_students, @RequestParam("expected_students") int expected_students, @RequestParam("maximum_students") int maximum_students,
                               @RequestParam("prerequisites") String prerequisites, @RequestParam("learning_outcome") String learning_outcome, @RequestParam("content") String content,
                               @RequestParam("learning_activities") String learning_activities, @RequestParam("exam_form") String exam_form,
                               @RequestParam("teachers") String teachers){
        ModelAndView mv = new ModelAndView("redirect:/");
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

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public ModelAndView doView(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("view");
       mv.addObject("lists", courseRepo.findOne(id));
        return mv;
    }
*/
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView doDelete(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("redirect:/");
        courseRepo.delete(id);
        return mv;
    }

  /*  @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView doEdit(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("edit");
        mv.addObject("lists", courseRepo.findOne(id));
        return mv;
    }
*/


}
