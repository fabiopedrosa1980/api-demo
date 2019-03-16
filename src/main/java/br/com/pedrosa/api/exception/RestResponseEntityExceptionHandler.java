package br.com.pedrosa.api.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<String>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getField() + ": " + error.getDefaultMessage());
		}
		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
		}

		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
		return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = ex.getParameterName() + " Faltou passar parametro";

		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	@ExceptionHandler({ SQLIntegrityConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolation(SQLIntegrityConstraintViolationException ex,
			WebRequest request) {
		List<String> errors = new ArrayList<String>();
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
			WebRequest request) {
		String error = ex.getName() + " Tipo utilizado errado " + ex.getRequiredType().getName();

		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	@ExceptionHandler({ DataIntegrityViolationException.class })
	public ResponseEntity<Object> sql(DataIntegrityViolationException ex, WebRequest request) {
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu o seguinte problema " + ex.getMostSpecificCause().getMessage(), "Erro ocorrido");
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	@ExceptionHandler({ JpaSystemException.class })
	public ResponseEntity<Object> sql(JpaSystemException ex, WebRequest request) {
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu o seguinte problema " + ex.getMostSpecificCause().getMessage(), "Erro ocorrido");
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu o seguinte problema " + ex.getLocalizedMessage(), "Erro ocorrido");
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

}
