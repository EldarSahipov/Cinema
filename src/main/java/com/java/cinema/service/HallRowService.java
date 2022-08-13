package com.java.cinema.service;

import com.java.cinema.entity.Hall;
import com.java.cinema.entity.HallRow;
import com.java.cinema.repository.HallRowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HallRowService {

    private HallRowRepository hallRowRepository;

    public List<HallRow> findHallRowsByIdHall(Short idHall) {
        return hallRowRepository.findHallRowsByHallRowId_IdHall(idHall);
    }

    public List<HallRow> findHallRowsAll() {
        return hallRowRepository.findAll();
    }

}
