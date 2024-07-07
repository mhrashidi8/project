package ir.javapro.sesstion3.conroller;


import ir.javapro.sesstion3.dto.response.ExceptionResponse;
import ir.javapro.sesstion3.exception.RuleException;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {

    private final MessageSourceAccessor messageSourceAccessor;

    public ExceptionController(MessageSourceAccessor messageSourceAccessor) {
        this.messageSourceAccessor = messageSourceAccessor;
    }

    @ExceptionHandler(RuleException.class)
    private ResponseEntity<List<ExceptionResponse>> handlerRuleException (RuleException ruleException) {

        return ResponseEntity
                .status(400)
                .body(Collections.singletonList(ruleExceptionToExceotionResponse(ruleException)));

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionResponse> > handlerMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        return ResponseEntity.status(402)
                .body(MethodArgumentNotValidExceptionToExceptionResponse(methodArgumentNotValidException));

    }

    private List <ExceptionResponse> MethodArgumentNotValidExceptionToExceptionResponse(MethodArgumentNotValidException methodArgumentNotValidException) {
        return methodArgumentNotValidException.getFieldErrors()
                .stream().map(error->
                    ExceptionResponse.builder()
                            .message(error.getDefaultMessage())
                            .code(error.getField())
                            .build()


                ).collect(Collectors.toList());



    }

    private  ExceptionResponse ruleExceptionToExceotionResponse(RuleException ruleException) {

       return ExceptionResponse.builder()
                .message(messageSourceAccessor.getMessage(ruleException.getMessage()))
                .code(ruleException.getMessage())
                .build();
    }

}
