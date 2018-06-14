package com.jd.cloud.dao;

import com.jd.cloud.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person, Integer> {

    // 通过id查找实体
    Person getById(Integer id);

    int deleteById(Integer id);

//    @Modifying
//    @Query("")
//    int addSomthing(Person person);
}
