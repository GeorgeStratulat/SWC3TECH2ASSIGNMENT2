package com.developer.SpringMySql.models;

import javax.persistence.*;

/**
 * Created by George Stratulat on 27/11/2017.
 */
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column(name = "course_id")
    public String course_id;

    public Teacher(int id, String course_id) {
        this.id = id;
        this.course_id = course_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }
}
