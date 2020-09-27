package com.stitane.githubsortlanguages.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Repository details dto.
 */
public class RepositoryDetailsDto {
    private String name;
    @JsonProperty("html_url")
    private String htmlUrl;
    private String language;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets html url.
     *
     * @return the html url
     */
    public String getHtmlUrl() {
        return htmlUrl;
    }

    /**
     * Sets html url.
     *
     * @param htmlUrl the html url
     */
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    /**
     * Gets language.
     *
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets language.
     *
     * @param language the language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "RepositoryDetailsDto{" + "name='" + name + '\'' + ", htmlUrl='" + htmlUrl + '\'' + ", language='" + language + '\'' + '}';
    }
}
