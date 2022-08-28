package com.github.repository.reader.reporeader.Github.Api;

import com.github.repository.reader.reporeader.Github.Api.Model.BranchGithubResponse;
import com.github.repository.reader.reporeader.Github.Api.Model.BranchRest;
import com.github.repository.reader.reporeader.Github.Api.Model.RepositoryGithubResponse;
import com.github.repository.reader.reporeader.Github.Api.Model.RepositoryRest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

        return githubRepositoryResponse.stream()
                .map(repo -> new RepositoryRest(repo.getOwner().getLogin(), repo.getName(), this.getRepositoryBranches(username, repo.getName())))
                .collect(Collectors.toList());
    }

    private List<RepositoryGithubResponse> getGithubRepositories(String username) {
        String jsonRepository = githubFeignClient.getRepoList(username);

        return GsonDeserializer.jsonToGithubResponseRepoDecoder(jsonRepository);
    }

    private List<BranchGithubResponse> getGithubBranches(String username, String repositoryName) {
        String jsonBranch = githubFeignClient.getBranchList(username, repositoryName);

        return GsonDeserializer.jsonToGithubResponseBranchDecoder(jsonBranch);
    }

    private Set<BranchRest> getRepositoryBranches(String username, String repositoryName) {
        List<BranchGithubResponse> githubBranchResponse = this.getGithubBranches(username, repositoryName);

        return githubBranchResponse.stream()
                .map(branch -> new BranchRest(branch.getName(), branch.getCommit().getSha()))
                .collect(Collectors.toSet());
    }

}
