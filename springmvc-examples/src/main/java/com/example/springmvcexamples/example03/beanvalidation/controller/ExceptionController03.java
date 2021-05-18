package com.example.springmvcexamples.example03.beanvalidation.controller;

import com.example.springmvcexamples.vo.ResultVO;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@Slf4j
@RestControllerAdvice
public class ExceptionController03 {
    //属性校验失败
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO handleValidException(MethodArgumentNotValidException exception){
        StringBuilder stringBuilder = new StringBuilder();
        exception.getBindingResult()
                .getFieldErrors()
                .forEach(e -> {
                    stringBuilder.append(e.getField());
                    stringBuilder.append(": ");
                    stringBuilder.append(e.getDefaultMessage());
                    stringBuilder.append(": ");
                });
        return ResultVO.error(400, stringBuilder.toString());
    }
    //请求类型转换失败异常
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResultVO handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException exception,
            HttpServletRequest request){
        String msg = request.getRequestURI() +
                ": " + "请求地址参数" + exception.getValue() + "错误";
        return ResultVO.error(400, msg.toString());
    }
    //jackson json类型转换异常
    @ExceptionHandler(InvalidFormatException.class)
    public ResultVO handleInvalidFormatException(InvalidFormatException exception){
        StringBuilder stringBuilder = new StringBuilder();
        exception.getPath()
                .forEach(p -> {
                    stringBuilder.append("属性");
                    stringBuilder.append(p.getFieldName());
                    stringBuilder.append(", 您输入的值：").append(exception.getValue());
                    stringBuilder.append(", 错误类型！");
                });
        return ResultVO.error(400, stringBuilder.toString());
    }
    //方法级参数校验失败异常
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultVO handleConstraintViolationException(ConstraintViolationException exception){
        StringBuilder stringBuilder = new StringBuilder();
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        violations.forEach(v -> {
            stringBuilder.append(v.getMessage()).append("; ");
        });
        return ResultVO.error(400, stringBuilder.toString());
    }
}

