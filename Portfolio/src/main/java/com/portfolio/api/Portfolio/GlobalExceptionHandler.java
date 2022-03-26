package com.portfolio.api.Portfolio;

import com.portfolio.api.Portfolio.enumerations.StatusMessages;
import com.portfolio.api.Portfolio.exceptions.ResourceNotFoundException;
import com.portfolio.api.Portfolio.models.ResponseModel;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseModel resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ResponseModel reponse = new ResponseModel(false);
        return reponse;
    }

	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseModel exceptionHandler(DataIntegrityViolationException ex) {
		ex.printStackTrace();
		return new ResponseModel(false, "HHH", null);
	}

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseModel exceptionHandler(MethodArgumentNotValidException ex) {
        ex.printStackTrace();

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseModel(false, StatusMessages.UNPREDICTED_ERROR_OCCURRED.getStatusMessage(), errors);
    }

    @ExceptionHandler(Exception.class)
    // @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseModel globalExceptionHandler(Exception ex, WebRequest request) {
        ex.printStackTrace();
        ResponseModel reponse = new ResponseModel(false, StatusMessages.UNPREDICTED_ERROR_OCCURRED.getStatusMessage());
        return reponse;
    }
}
