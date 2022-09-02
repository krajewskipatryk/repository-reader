package com.github.repository.reader.reporeader.Github.Api;

import com.github.repository.reader.reporeader.Github.Api.Model.BranchGithubResponse;
import com.github.repository.reader.reporeader.Github.Api.Model.BranchRest;
import com.github.repository.reader.reporeader.Github.Api.Model.RepositoryGithubResponse;
import com.github.repository.reader.reporeader.Github.Api.Model.RepositoryRest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class GithubServiceImpl implements GithubService {
    private final GithubFeignClient githubFeignClient;

    @Override
    public List<RepositoryRest> getUserRepositories(String username) {
        List<RepositoryGithubResponse> githubRepositoryResponse = this.getGithubRepositories(username);
        List<RepositoryRest> githubRepositoriesList;

        githubRepositoriesList = githubRepositoryResponse.stream()
                .filter(repo -> !repo.isFork())
                .map(repo -> new RepositoryRest(repo.getOwner().getLogin(), repo.getName(), this.getRepositoryBranches(username, repo.getName())))
                .collect(Collectors.toList());

        return githubRepositoriesList;
    }

    private List<RepositoryGithubResponse> getGithubRepositories(String username) {
        RepositoryGithubResponse[] repositoryGithubResponses = githubFeignClient.getRepoList(username);

        return Arrays.stream(repositoryGithubResponses).collect(Collectors.toList());
    }

    private List<BranchGithubResponse> getGithubBranches(String username, String repositoryName) {
        BranchGithubResponse[] branchGithubResponses = githubFeignClient.getBranchList(username, repositoryName);

        return Arrays.stream(branchGithubResponses).collect(Collectors.toList());
    }

    private Set<BranchRest> getRepositoryBranches(String username, String repositoryName) {
        List<BranchGithubResponse> githubBranchResponse = this.getGithubBranches(username, repositoryName);

        return githubBranchResponse.stream()
                .map(branch -> new BranchRest(branch.getName(), branch.getCommit().getSha()))
                .collect(Collectors.toSet());
    }
}
