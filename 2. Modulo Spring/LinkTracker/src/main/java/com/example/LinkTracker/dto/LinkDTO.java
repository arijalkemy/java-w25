package com.example.LinkTracker.dto;

public class LinkDTO {
    private int linkId;
    private String originalUrl;
    private String password;
    private int redirectCount;

    public LinkDTO(int linkId, String originalUrl, String password, int redirectCount) {
        this.linkId = linkId;
        this.originalUrl = originalUrl;
        this.password = password;
        this.redirectCount = redirectCount;
    }

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRedirectCount() {
        return redirectCount;
    }

    public void setRedirectCount(int redirectCount) {
        this.redirectCount = redirectCount;
    }
}
