package com.java.cinema.service;

import com.java.cinema.entity.Ticket;
import com.java.cinema.entity.composite.TicketId;
import com.java.cinema.entity.statuses.TicketStatus;
import com.java.cinema.repository.TicketsRepository;
import lombok.AllArgsConstructor;
import org.aspectj.bridge.Message;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TicketsService {
    private final TicketsRepository ticketsRepository;

    public Ticket saveTicket(Ticket ticket){
        return ticketsRepository.save(ticket);
    }

    public List<Ticket> saveTickets(List<Ticket> ticketList) {
        return ticketsRepository.saveAll(ticketList);
    }

    public void deleteTicketById(TicketId ticketId){
        ticketsRepository.deleteTicketByTicketId(ticketId);
    }

    public Optional<Ticket> findTicketByTicketId(TicketId ticketId) {
        return ticketsRepository.findById(ticketId);
    }


    public List<Ticket> findTicketsAll(){
        return ticketsRepository.findAll();
    }

    public List<Ticket> findTicketsByTicketIdIdScreeningAndStatus(Integer screeningId, TicketStatus status) {
        checkStatusTickets();
        return ticketsRepository.findTicketsByTicketIdIdScreeningAndStatus(screeningId, status);
    }

    private void checkStatusTickets() {
        try {
            ticketsRepository.checkStatusTicket();
        } catch (Exception ignored) {

        }
    }
}
