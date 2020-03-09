package com.example.demo.exception;

public class Not200or304 extends Exception {
    int stat;
    public Not200or304(int code){
        super("Board request returned "+code+" instead of 200/304");
    }

}
