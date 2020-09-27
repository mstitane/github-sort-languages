package com.stitane.githubsortlanguages.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * The type Languages sorted dto.
 */
public class LanguagesSortedDto {

    /**
     * the language used by the trending public repos on GitHub.
     */
    private String language;
    /**
     * Number of repos using this language
     */
    private Integer count;
    /**
     * The list of repos using this language
     */
    private Set<RepositoryDetailsDto> repositories;

    public LanguagesSortedDto() {
        repositories = new HashSet<>();
    }

    public LanguagesSortedDto(String language, Integer count, Set<RepositoryDetailsDto> repositories) {
        this.language = language;
        this.count = count;
        this.repositories = repositories;
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

    /**
     * Gets count.
     *
     * @return the count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Sets count.
     *
     * @param count the count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * Gets repositories.
     *
     * @return the repositories
     */
    public Set<RepositoryDetailsDto> getRepositories() {
        return repositories;
    }

    /**
     * Sets repositories.
     *
     * @param repositories the repositories
     */
    public void setRepositories(Set<RepositoryDetailsDto> repositories) {
        this.repositories = repositories;
    }
}
