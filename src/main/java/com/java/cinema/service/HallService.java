package com.java.cinema.service;

import com.java.cinema.entity.Hall;
import com.java.cinema.repository.HallRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HallService {
    private HallRepository hallRepository;

    public Hall saveHall(Hall hall) {
        return hallRepository.save(hall);
    }

    public void deleteHallById(Long hallId) {
        hallRepository.deleteById(hallId);
    }

    public Hall findHallById(Short hallId) {
        return hallRepository.findHallById(hallId);
    }

    public Hall findHallByName(String hallName) {
        return hallRepository.findHallByName(hallName);
    }

    public List<Hall> findHallsAll() {
        return hallRepository.findAll();
    }
}
