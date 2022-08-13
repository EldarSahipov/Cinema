package com.java.cinema.repository;

import com.java.cinema.entity.HallRow;
import com.java.cinema.entity.composite.HallRowId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HallRowRepository extends JpaRepository<HallRow, HallRowId> {
    List<HallRow> findHallRowsByHallRowId_IdHall(Short hallRowId_idHall);
}
