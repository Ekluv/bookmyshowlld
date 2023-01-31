package com.personal.bookmyshow.controllers;

import com.personal.bookmyshow.dto.TicketDto;
import com.personal.bookmyshow.models.Ticket;
import com.personal.bookmyshow.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;
    @PostMapping
    public ResponseEntity<Ticket> bookTicket(@RequestBody @Valid TicketDto.BookTicketRequest request) {
        Ticket ticket = ticketService.bookTicket(request.getShowId(), request.getShowSeatIds());
        return new ResponseEntity(ticket, HttpStatus.CREATED);
    }

}
