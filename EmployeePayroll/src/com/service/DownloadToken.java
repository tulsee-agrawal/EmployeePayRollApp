package com.service;

/*
 * DownloadToken represents time-based access to files.
 * Ensures file access expires after fixed validity.
 */

public class DownloadToken {

    private long createdTime;
    private long expiryMillis;

    public DownloadToken() {
        createdTime = System.currentTimeMillis();
        expiryMillis = 5 * 60 * 1000; // 5 min default
    }

    public boolean isExpired() {
        long now = System.currentTimeMillis();
        return (now - createdTime) > expiryMillis;
    }
}