package com.bridgelabz;

public class AnalyseMoodException extends RuntimeException{

    public  EnumExceptionType type;

    public  enum EnumExceptionType {
        EMPTY_MESSAGE,NULL_MESSAGE;
    }//EnumExceptionType type;
    public AnalyseMoodException(EnumExceptionType type,String message) {
        super(message);
        this.type=type;
    }

    }