package com.bridgelabz;

public class AnalyseMoodException extends RuntimeException{
    public EnumExceptionType type;
    public enum EnumExceptionType {
        EMPTY_MESSAGE,NULL_MESSAGE,CLASS_NOT_FOUND,NO_SUCH_METHOD, NO_SUCH_FIELD, INVOCATION_ISSUE;
    }//EnumExceptionType type;
    public AnalyseMoodException(EnumExceptionType type,String message) {
        super(message);
        this.type=type;
    }

}