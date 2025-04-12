//package com.example.management.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.ServletWebRequest;
//import org.springframework.web.context.request.WebRequest;
//
//import java.time.LocalDateTime;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<Map<String, Object>> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request) {
//        Map<String, Object> body = new LinkedHashMap<>();
//        body.put("timestamp", LocalDateTime.now());
//        body.put("status", HttpStatus.NOT_FOUND.value());
//        body.put("error", "Not Found");
//        body.put("message", ex.getMessage());
//        body.put("path", ((ServletWebRequest) request).getRequest().getRequestURI());
//
//        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
//    }
//
//    // Add other handlers here (e.g., MethodArgumentNotValidException)
//}
//
