package com.github.repository.reader.reporeader.Github.Api;

import com.github.repository.reader.reporeader.Github.Api.Model.RepositoryRest;

import java.util.List;

public interface GithubFacade {
    List<RepositoryRest> getUserRepositories(String username);
}
