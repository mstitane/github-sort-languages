package com.stitane.githubsortlanguages.exceptions;

/**
 * The type Rest error exception.
 */
public class RestErrorException extends RuntimeException {
    /**
     * Instantiates a new Rest error exception.
     *
     * @param url   the url
     * @param cause the cause
     */
    public RestErrorException(String url, Throwable cause) {
        super("An exception happened when calling [" + url + "] , caused by : " + cause.getMessage(), cause);
    }
}
