package com.stitane.githubsortlanguages.dto;

import java.util.ArrayList;
import java.util.List;

public class ResultResponse {
    private String totalCount;
    private List<RepositoryDetailsDto> items;
    public ResultResponse() {
        items = new ArrayList<>();
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public List<RepositoryDetailsDto> getItems() {
        return items;
    }

    public void setItems(List<RepositoryDetailsDto> items) {
        this.items = items;
    }
}
