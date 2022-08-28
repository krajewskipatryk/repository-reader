package com.github.repository.reader.reporeader.Github.Api;

import com.github.repository.reader.reporeader.Github.Api.Model.RepositoryRest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GithubFacadeImpl implements GithubFacade {
    private final GithubService githubService;

    @Override
    public List<RepositoryRest> getUserRepositories(String username) {
        return githubService.getUserRepositories(username);
    }
}