package com.example.springmvcexamples.example02.handlingexception.exception;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyException extends RuntimeException{
    private int code;
    public MyException(int code, String message){
        super(message);
        this.code = code;
    }
}
