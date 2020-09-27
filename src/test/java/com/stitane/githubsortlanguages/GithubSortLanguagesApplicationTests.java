package com.stitane.githubsortlanguages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The type Github sort languages application tests.
 */
@SpringBootTest
@AutoConfigureMockMvc
class GithubSortLanguagesApplicationTests {

    private Logger log = LogManager.getLogger(GithubSortLanguagesApplicationTests.class);

    @Autowired
    private MockMvc mockMvc;

    /**
     * Return a list of repositories by languages since the last 30 days.
     */
    @Test
    void returnListOfReposByLanguagesSinceTheLast30Days() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/counting")).andExpect(status().isOk()).andReturn();
        String json = mvcResult.getResponse().getContentAsString();
        log.info("################# RESULT ###################");
        log.info(json);
    }

}
