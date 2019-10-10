package com.ydurur.person.repository;

import com.ydurur.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ydurur
 */
@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {


}
