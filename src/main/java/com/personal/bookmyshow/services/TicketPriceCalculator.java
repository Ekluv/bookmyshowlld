package com.personal.bookmyshow.services;

import com.personal.bookmyshow.models.SeatType;
import com.personal.bookmyshow.models.Show;
import com.personal.bookmyshow.models.ShowSeat;
import com.personal.bookmyshow.models.ShowSeatType;
import com.personal.bookmyshow.repositories.ShowSeatTypeRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketPriceCalculator {
    private final ShowSeatTypeRepository showSeatTypeRepository;

    public double calculateTicketPrice(@NonNull List<ShowSeat> showSeats) {
        Show show = showSeats.get(0).getShow();
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
        List<SeatType> seatTypes = showSeats.stream()
                .map(showSeat -> showSeat.getSeat().getSeatType())
                .collect(Collectors.toList());
        return showSeatTypes.stream()
                .filter(showSeatType -> seatTypes.contains(showSeatType.getSeatType()))
                .mapToDouble(ShowSeatType::getPrice)
                .sum();
    }
}
