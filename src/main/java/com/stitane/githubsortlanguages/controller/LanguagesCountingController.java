package com.stitane.githubsortlanguages.controller;

import com.stitane.githubsortlanguages.dto.LanguagesSortedDto;
import com.stitane.githubsortlanguages.dto.RepositoryDetailsDto;
import com.stitane.githubsortlanguages.dto.ResultResponse;
import com.stitane.githubsortlanguages.exceptions.EmptyResultException;
import com.stitane.githubsortlanguages.exceptions.RestErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * The type Languages counting controller.
 *
 * @author mohamed stitane
 */
@RestController
public class LanguagesCountingController {

    @Value("${github.api.url}")
    private String githubApiUrl;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * counting repositories by languages.
     *
     * @return the details of languages
     */
    @GetMapping("/counting")
    public List<LanguagesSortedDto> counting() {
        String date = LocalDate.now().minusDays(30L).toString();
        String url = githubApiUrl.replace("{date}", date);
        try {
            ResultResponse details = restTemplate.getForObject(url, ResultResponse.class);
            if (details == null || details.getItems() == null) {
                throw new EmptyResultException(url);
            }
            SortedMap<String, Set<RepositoryDetailsDto>> counter = countByLanguage(details);
            return createResponse(counter);
        } catch (Exception e) {
            throw new RestErrorException(url, e);
        }
    }

    /**
     * count languages, and group repositories by language
     *
     * @param details the all repositories result
     * @return a map represents a language and its repositories
     */
    private SortedMap<String, Set<RepositoryDetailsDto>> countByLanguage(ResultResponse details) {

        SortedMap<String, Set<RepositoryDetailsDto>> counter = new TreeMap<>();
        for (RepositoryDetailsDto detail : details.getItems()) {
            String language = detail.getLanguage() == null ? "NOT_SPECIFIED" : detail.getLanguage();
            counter.computeIfAbsent(language, k -> new HashSet<>()).add(detail);
        }
        return counter;
    }

    /**
     * create response from the computed map.
     *
     * @param counter a map
     * @return a list of number and a list of repositories by language
     */
    private List<LanguagesSortedDto> createResponse(SortedMap<String, Set<RepositoryDetailsDto>> counter) {
        return counter.entrySet().stream().map(k -> new LanguagesSortedDto(k.getKey(), k.getValue().size(), k.getValue()))
                .collect(Collectors.toList());
    }
}