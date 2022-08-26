package com.github.repository.reader.reporeader.RepoReader.Service.impl;

import com.github.repository.reader.reporeader.Feign.Clients.JSONGithubClient;
import com.github.repository.reader.reporeader.Feign.Model.Response.Branch.BranchGithubResponse;
import com.github.repository.reader.reporeader.Feign.Model.Response.Repo.RepositoryGithubResponse;
import com.github.repository.reader.reporeader.Gson.Utils.GsonDeserializer;
import com.github.repository.reader.reporeader.RepoReader.Model.Response.BranchRest;
import com.github.repository.reader.reporeader.RepoReader.Model.Response.RepositoryRest;
import com.github.repository.reader.reporeader.RepoReader.Service.RepoReaderService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RepoReaderServiceImpl implements RepoReaderService {
    private final JSONGithubClient jsonGithubClient;

    @Override
    public List<RepositoryRest> getUserRepositories(String username) {
        String jsonRepository = jsonGithubClient.getRepoList(username);
        List<RepositoryGithubResponse> githubRepositoryResponse = GsonDeserializer.jsonToGithubResponseRepoDecoder(jsonRepository);

        return githubRepositoryResponse.stream()
                .map(repo -> new RepositoryRest(repo.getOwner().getLogin(), repo.getName(), this.getRepositoryBranches(username, repo.getName())))
                .collect(Collectors.toList());
    }

    @Override
    public Set<BranchRest> getRepositoryBranches(String username, String repositoryName) {
        String jsonBranch = jsonGithubClient.getBranchList(username, repositoryName);
        List<BranchGithubResponse> githubBranchResponse = GsonDeserializer.jsonToGithubResponseBranchDecoder(jsonBranch);

        return githubBranchResponse.stream()
                .map(branch -> new BranchRest(branch.getName(), branch.getCommit().getSha()))
                .collect(Collectors.toSet());
    }


}
