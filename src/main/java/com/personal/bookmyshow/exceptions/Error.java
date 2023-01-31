package com.personal.bookmyshow.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum Error {
    RESOURCE_NOT_FOUND("Resource not found", HttpStatus.NOT_FOUND),
    MOVIE_SHOW_NOT_FOUND("movie not found", HttpStatus.NOT_FOUND),
    SEATS_NOT_AVAILABLE("seats not avail", HttpStatus.BAD_REQUEST);
    private final String message;
    private final HttpStatus status;

    Error(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}