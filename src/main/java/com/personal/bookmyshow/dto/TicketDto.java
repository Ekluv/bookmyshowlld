package com.personal.bookmyshow.dto;

import com.personal.bookmyshow.models.Ticket;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class TicketDto {
    @Getter
    @Setter
    public static class BookTicketRequest {
        @NotNull
        private Long showId;
        @NotEmpty
        private List<Long> showSeatIds;
    }

    @Getter
    @Setter
    public static class BookTicketResponse {
        private Ticket ticket;
    }
}
