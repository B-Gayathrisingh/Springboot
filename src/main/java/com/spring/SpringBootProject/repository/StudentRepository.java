package com.spring.SpringBootProject.repository;

import com.spring.SpringBootProject.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<Students,Integer> {



    Students findById(int id);

    Students deleteById(int id);



}
