package com.developer.SpringMySql.models;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Tibi on 27/11/2017.
 */
public interface UsersRepository extends CrudRepository<User, Integer> {
}
