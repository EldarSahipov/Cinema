package com.java.cinema.repository;

import com.java.cinema.entity.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository extends JpaRepository<Hall, Long> {
    Hall findHallByName(String name);
    Hall findHallById(Short id);
}
