package com.github.repository.reader.reporeader.Github.Api.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryGithubResponse {
    private String name;
    private boolean fork;
    private RepositoryOwner owner;
}
