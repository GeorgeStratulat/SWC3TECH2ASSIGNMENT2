package com.developer.SpringMySql.models;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by George Stratulat on 27/11/2017.
 */
public interface StudentRepository extends CrudRepository<Student,Integer> {
}
