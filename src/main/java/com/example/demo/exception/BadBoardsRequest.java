package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class BadBoardsRequest extends Exception{
    // chain exceptions
    public BadBoardsRequest(Throwable t) {
        super("BadBoardsRequest: "+ t.getMessage(), t);
    }

    /*
    public String toString(){
        return ("BadBoardsRequest Occurred: " + str1) ;
    } */
}