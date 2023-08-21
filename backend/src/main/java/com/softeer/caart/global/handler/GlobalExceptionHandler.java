package com.softeer.caart.global.handler;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.UnexpectedTypeException;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.softeer.caart.global.ResultCode;
import com.softeer.caart.global.exception.BusinessException;
import com.softeer.caart.global.response.ErrorListResponseDto;
import com.softeer.caart.global.response.ErrorResponseDto;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ErrorResponseDto> handleMissingServletRequestParameterException(
		MissingServletRequestParameterException e) {
		log.error("handleMissingServletRequestParameterException : {}", e.getMessage());
		final ErrorResponseDto response = ErrorResponseDto.of(ResultCode.INVALID_METHOD_ARGUMENT, e.getMessage());
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

	@ExceptionHandler(BindException.class)
	public ResponseEntity<ErrorListResponseDto> handleBindException(BindException e) {
		List<String> errorMessage = convertFieldErrorMessageToString(e.getFieldErrors());
		log.error("handleBindException : {}", errorMessage);
		final ErrorListResponseDto response = ErrorListResponseDto.of(ResultCode.INVALID_REQUEST_PARAM, errorMessage);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

	private List<String> convertFieldErrorMessageToString(List<FieldError> fieldErrors) {
		return fieldErrors.stream()
			.map(DefaultMessageSourceResolvable::getDefaultMessage)
			.collect(Collectors.toList());
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorResponseDto> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		log.error("handleHttpMessageNotReadableException : {}", e.getRootCause().getMessage());
		final ErrorResponseDto response = ErrorResponseDto.from(ResultCode.INVALID_JSON);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		log.error("handleMethodArgumentNotValidException : {}", e.getMessage());
		final ErrorResponseDto response = ErrorResponseDto.from(ResultCode.INVALID_METHOD_ARGUMENT);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

	@ExceptionHandler(UnexpectedTypeException.class)
	public ResponseEntity<ErrorResponseDto> handleUnexpectedTypeException(UnexpectedTypeException e) {
		log.error("handleUnexpectedTypeException : {}", e.getMessage());
		final ErrorResponseDto response = ErrorResponseDto.from(ResultCode.INVALID_METHOD_ARGUMENT);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorResponseDto> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
		log.error("handleDataIntegrityViolationException : {}", e.getMessage());
		final ErrorResponseDto response = ErrorResponseDto.from(ResultCode.NOT_SATISFIED_DB_CONSTRAINT);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	protected ResponseEntity<ErrorResponseDto> handleHttpRequestMethodNotSupportedException(
		HttpRequestMethodNotSupportedException e) {
		log.error("handleHttpRequestMethodNotSupportedException : {}", e.getMessage());
		final ErrorResponseDto response = ErrorResponseDto.from(ResultCode.METHOD_NOT_ALLOWED);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

	@ExceptionHandler(UnsupportedOperationException.class)
	protected ResponseEntity<ErrorResponseDto> handleUnsupportedOperationException(UnsupportedOperationException e) {
		log.error("UnsupportedOperationException : {}", e.getMessage());
		final ErrorResponseDto response = ErrorResponseDto.from(ResultCode.METHOD_NOT_ALLOWED);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

	@ExceptionHandler(IllegalArgumentException.class)
	protected ResponseEntity<ErrorResponseDto> handleIllegalArgumentException(IllegalArgumentException e) {
		log.error("IllegalArgumentException : {}", e.getMessage());
		final ErrorResponseDto response = ErrorResponseDto.from(ResultCode.INVALID_METHOD_ARGUMENT);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErrorResponseDto> handleBusinessException(BusinessException e) {
		log.warn("BusinessException : {}", e.getMessage());
		final ErrorResponseDto response = ErrorResponseDto.from(e.getResultCode());
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ErrorResponseDto> handleException(Exception e) {
		log.error("Exception : {}", e.getMessage());
		log.error("Exception : {}", e.getClass());
		final ErrorResponseDto response = ErrorResponseDto.from(ResultCode.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}
}
