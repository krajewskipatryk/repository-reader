package com.github.repository.reader.reporeader.Github.Api;

import com.github.repository.reader.reporeader.Github.Api.Model.RepositoryRest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class GithubFacadeImpl implements GithubFacade {
    private final GithubService githubService;
    private final RepositoryReaderService repositoryReaderService;

    @Override
    public List<RepositoryRest> getUserRepositories(String username) {
        return repositoryReaderService.getUserRepositories(username);
    }
}
