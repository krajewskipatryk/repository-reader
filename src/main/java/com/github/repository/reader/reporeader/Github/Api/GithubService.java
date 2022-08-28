package com.github.repository.reader.reporeader.Github.Api;

import com.github.repository.reader.reporeader.Github.Api.Model.BranchGithubResponse;
import com.github.repository.reader.reporeader.Github.Api.Model.RepositoryGithubResponse;
import com.github.repository.reader.reporeader.Github.Api.Model.RepositoryRest;

import java.util.List;

interface GithubService {
    List<RepositoryRest> getUserRepositories(String username);
}
