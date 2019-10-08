package com.ydurur.person.repository;

import com.ydurur.person.model.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ydurur
 */
public interface PersonRepository extends CrudRepository<Person,Long> {


}
