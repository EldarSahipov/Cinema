package com.java.cinema.rest_controllers;

import com.java.cinema.entity.Hall;
import com.java.cinema.entity.HallRow;
import com.java.cinema.service.HallRowService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hallRow")
@AllArgsConstructor
@Log
public class HallRowController {

    @Autowired
    private HallRowService hallRowService;


    @GetMapping("/findHallRowsByIdHall")
    public List<HallRow> findHallRowsByIdHall(@RequestParam Short id) {
        log.info("Handling find by id hall request: " + id);
        return hallRowService.findHallRowsByIdHall(id);
    }

    @GetMapping("/findHallRowsAll")
    public List<HallRow> findHallRowsAll() {
        log.info("Handling find all halls request");
        return hallRowService.findHallRowsAll();
    }
}
