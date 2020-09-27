package com.stitane.githubsortlanguages.exceptions;

/**
 * The type Empty result exception.
 */
public class EmptyResultException extends RuntimeException {
    /**
     * Instantiates a new Empty result exception.
     *
     * @param url the url
     */
    public EmptyResultException(String url) {
        super("Result is empty after calling [" + url + "] ");
    }
}
