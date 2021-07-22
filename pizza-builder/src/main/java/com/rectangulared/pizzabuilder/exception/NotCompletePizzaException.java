package com.rectangulared.pizzabuilder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Pizza doesn't pass minimal requirements")
public class NotCompletePizzaException extends RuntimeException {

}
