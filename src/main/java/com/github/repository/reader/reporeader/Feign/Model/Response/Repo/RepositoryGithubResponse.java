package com.github.repository.reader.reporeader.Feign.Model.Response.Repo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryGithubResponse {
    @JsonProperty("name")
    private String name;
    @JsonProperty("owner")
    private RepositoryOwner owner;

}
