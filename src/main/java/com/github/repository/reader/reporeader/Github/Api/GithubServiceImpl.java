package com.github.repository.reader.reporeader.Github.Api;

import com.github.repository.reader.reporeader.Github.Api.Model.BranchGithubResponse;
import com.github.repository.reader.reporeader.Github.Api.Model.RepositoryGithubResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class GithubServiceImpl implements GithubService {
    private final GithubFeignClient githubFeignClient;

    @Override
    public List<RepositoryGithubResponse> getGithubRepositories(String username) {
        String jsonRepository;

        jsonRepository = githubFeignClient.getRepoList(username);

        return GsonDeserializer.jsonToGithubResponseRepoDecoder(jsonRepository);
    }

    @Override
    public List<BranchGithubResponse> getGithubBranches(String username, String repositoryName) {
        String jsonBranch = githubFeignClient.getBranchList(username, repositoryName);
        List<BranchGithubResponse> branchResponses = GsonDeserializer.jsonToGithubResponseBranchDecoder(jsonBranch);
        return branchResponses;

    }
}
