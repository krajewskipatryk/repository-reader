package com.github.repository.reader.reporeader.Github.Api;

import com.github.repository.reader.reporeader.Github.Api.Model.BranchGithubResponse;
import com.github.repository.reader.reporeader.Github.Api.Model.RepositoryGithubResponse;

import java.util.List;

interface GithubService {
    List<RepositoryGithubResponse> getGithubRepositories(String username);
    List<BranchGithubResponse> getGithubBranches(String username, String repositoryName);
}
