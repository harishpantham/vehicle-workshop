package com.vehicle.workshop.exception;

import com.vehicle.workshop.utils.YanResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public @ResponseBody
    YanResponse handleResourceNotFound(final ResourceNotFoundException exception,
                                       final HttpServletRequest request) {

        YanResponse vehicleResponse = new YanResponse();
        vehicleResponse.setStatus(HttpStatus.NO_CONTENT.value());
        vehicleResponse.setError(HttpStatus.NO_CONTENT.name());
        vehicleResponse.setMessage(exception.getMessage());
        return vehicleResponse;
    }

    @ExceptionHandler({DefaultException.class, Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    YanResponse handleException(final Exception exception, final HttpServletRequest request) {

        YanResponse vehicleResponse = new YanResponse();
        vehicleResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vehicleResponse.setError(HttpStatus.INTERNAL_SERVER_ERROR.name());
        vehicleResponse.setMessage(exception.getMessage());
        return vehicleResponse;
    }

    @ExceptionHandler({InvalidInputException.class, BadRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    YanResponse handleInvalidInputException(final Exception exception,
                                                final HttpServletRequest request) {

        YanResponse vehicleResponse = new YanResponse();
        vehicleResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        vehicleResponse.setError(HttpStatus.BAD_REQUEST.name());
        vehicleResponse.setMessage(exception.getMessage());
        return vehicleResponse;


    }
}