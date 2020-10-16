package com.example.bank.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler {//} extends ResponseEntityExceptionHandler {
//    @ExceptionHandler(Exception.class)
//    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
//                request.getDescription(false));
//        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(ProposalNotFoundException.class)
//    public final ResponseEntity<Object> handleUserNotFoundException(ProposalNotFoundException ex, WebRequest request) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
//                request.getDescription(false));
//        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
//        String message = "";
//        if (ex.getParameter().getParameterIndex() == 0) {
//            message = "Erro na validação do nome. Favor verificar.";
//        }
//        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Erro de validação.",
////                ex.getBindingResult().toString());
//                message);
////                "Nome não pode ser nulo.");
//        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
//    }
}
