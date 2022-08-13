package com.java.cinema.repository;

import com.java.cinema.entity.Ticket;
import com.java.cinema.entity.composite.TicketId;
import com.java.cinema.entity.statuses.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketsRepository extends JpaRepository<Ticket, TicketId> {

    void deleteTicketByTicketId(TicketId ticketId);

    List<Ticket> findTicketsByTicketIdIdScreeningAndStatus(Integer ticketId_idScreening, TicketStatus status);

    @Modifying
    @Query(nativeQuery = true, value = "update tickets " +
            "set status = 'OVERDUE' " +
            "from screening " +
            "where id_screening = screening.id and " +
            "now()>= screening.end_screening")
    void checkStatusTicket();
}
