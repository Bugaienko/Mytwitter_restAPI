package dev.baluapp.twitter.common.exception;
/*
@date 31.12.2023
@author Sergey Bugaienko
*/

public class TwitterException  extends RuntimeException{
    public TwitterException(String message) {
        super(message);
    }
}
