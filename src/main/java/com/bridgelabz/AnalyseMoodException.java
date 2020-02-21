package com.bridgelabz;

public class AnalyseMoodException extends RuntimeException{

    //public static Object ExceptionType;
    public  EnumExceptionType type;
    public  enum EnumExceptionType {
        EMPTY_MESSAGE,NULL_MESSAGE,CLASS_NOT_FOUND,NO_SUCH_METHOD;
    }//EnumExceptionType type;
    public AnalyseMoodException(EnumExceptionType type,String message) {
        super(message);
        this.type=type;
    }

    }