package com.exam.examPortalServer.exception;

public class BadRequestException extends  Exception{
    public BadRequestException(String msg){
        super(msg);
    }
}
