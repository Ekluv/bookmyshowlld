package com.personal.bookmyshow.services;

import com.personal.bookmyshow.exceptions.ApiException;
import com.personal.bookmyshow.exceptions.Error;
import com.personal.bookmyshow.models.*;
import com.personal.bookmyshow.repositories.ShowRepository;
import com.personal.bookmyshow.repositories.ShowSeatsRepository;
import com.personal.bookmyshow.repositories.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final ShowRepository showRepository;
    private final ShowSeatsRepository showSeatsRepository;
    private final TicketPriceCalculator ticketPriceCalculator;
    private final TicketRepository ticketRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(Long showId, List<Long> showSeatIds) {
        Show show = showRepository.findById(showId).orElseThrow(() -> new ApiException(Error.MOVIE_SHOW_NOT_FOUND));

        List<ShowSeat> showSeats = showSeatsRepository.findAllByIdIn(showSeatIds);
        boolean areAllSeatsAvailable = showSeats.stream()
                .allMatch(showSeat -> showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE));
        if(!areAllSeatsAvailable) throw new ApiException(Error.SEATS_NOT_AVAILABLE);
        showSeats.forEach(showSeat -> showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED));
        showSeatsRepository.saveAll(showSeats);
        double amount = ticketPriceCalculator.calculateTicketPrice(showSeats);
        Ticket ticket = Ticket.builder()
                .bookedSeats(showSeats)
                .show(show)
                .ticketStatus(TicketStatus.IN_PROGRESS)
                .amount(amount).build();
        ticketRepository.save(ticket);
        return ticket;
    }
}
