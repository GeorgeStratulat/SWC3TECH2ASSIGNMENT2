package com.developer.SpringMySql.models;

import org.springframework.stereotype.Controller;

import javax.persistence.*;

/**
 * Created by George Stratulat on 23/11/2017.
 */
@Entity
@Table(name = "courses")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column(name= "name_course_dk")
    public String name_course_dk;
    @Column(name = "name_course_en")
    public String name_course_en;
    @Column(name = "class_code")
    public String class_code;
    @Column(name = "study_programme")
    public String study_programme;
    @Column(name = "mandatory")
    public String mandatory;
    @Column(name = "etcs")
    public int etcs;
    @Column(name = "course_language")
    public String course_language;
    @Column(name = "minimum_students")
    public int minimum_students;
    @Column(name = "expected_students")
    public int expected_students;
    @Column(name = "maximum_students")
    public int maximum_students;
    @Column(name = "prerequisites")
    public String prerequisites;
    @Column(name = "learning_outcome")
    public String learning_outcome;
    @Column(name = "content")
    public String content;
    @Column(name = "learning_activities")
    public String learning_activities;
    @Column(name = "exam_form")
    public String exam_form;
    @Column(name = "teachers")
    public String teachers;

    public Courses() {
    }

    public Courses(int id,String name_course_dk, String name_course_en, String class_code, String study_programme, String mandatory, int etcs, String course_language, int minimum_students, int expected_students, int maximum_students, String prerequisites,String learning_outcome, String content, String learning_activities, String exam_form, String teachers) {
        this.id = id;
        this.name_course_dk = name_course_dk;
        this.name_course_en = name_course_en;
        this.class_code = class_code;
        this.study_programme = study_programme;
        this.mandatory = mandatory;
        this.etcs = etcs;
        this.course_language = course_language;
        this.minimum_students = minimum_students;
        this.expected_students = expected_students;
        this.maximum_students = maximum_students;
        this.prerequisites = prerequisites;
        this.learning_outcome = learning_outcome;
        this.content = content;
        this.learning_activities = learning_activities;
        this.exam_form = exam_form;
        this.teachers = teachers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_course_dk() {
        return name_course_dk;
    }

    public void setName_course_dk(String name_course_dk) {
        this.name_course_dk = name_course_dk;
    }

    public String getName_course_en() {
        return name_course_en;
    }

    public void setName_course_en(String name_course_en) {
        this.name_course_en = name_course_en;
    }

    public String getClass_code() {
        return class_code;
    }

    public void setClass_code(String class_code) {
        this.class_code = class_code;
    }

    public String getStudy_programme() {
        return study_programme;
    }

    public void setStudy_programme(String study_programme) {
        this.study_programme = study_programme;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }

    public int getEtcs() {
        return etcs;
    }

    public void setEtcs(int etcs) {
        this.etcs = etcs;
    }

    public String getCourse_language() {
        return course_language;
    }

    public void setCourse_language(String course_language) {
        this.course_language = course_language;
    }

    public int getMinimum_students() {
        return minimum_students;
    }

    public void setMinimum_students(int minimum_students) {
        this.minimum_students = minimum_students;
    }

    public int getExpected_students() {
        return expected_students;
    }

    public void setExpected_students(int expected_students) {
        this.expected_students = expected_students;
    }

    public int getMaximum_students() {
        return maximum_students;
    }

    public void setMaximum_students(int maximum_students) {
        this.maximum_students = maximum_students;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getLearning_outcome() {
        return learning_outcome;
    }

    public void setLearning_outcome(String learning_outcome) {
        this.learning_outcome = learning_outcome;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLearning_activities() {
        return learning_activities;
    }

    public void setLearning_activities(String learning_activities) {
        this.learning_activities = learning_activities;
    }

    public String getExam_form() {
        return exam_form;
    }

    public void setExam_form(String exam_form) {
        this.exam_form = exam_form;
    }

    public String getTeachers() {
        return teachers;
    }

    public void setTeachers(String teachers) {
        this.teachers = teachers;
    }
}
