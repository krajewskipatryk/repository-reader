package com.github.repository.reader.reporeader.Github.Api;

import com.github.repository.reader.reporeader.Github.Api.Model.BranchGithubResponse;
import com.github.repository.reader.reporeader.Github.Api.Model.RepositoryGithubResponse;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


class GsonDeserializer {
    static List<RepositoryGithubResponse> jsonToGithubResponseRepoDecoder(String jsonResponse) {
        Gson gson = new Gson();
        RepositoryGithubResponse[] repositoryGithubResponses = gson.fromJson(jsonResponse, RepositoryGithubResponse[].class);
        return Arrays.stream(repositoryGithubResponses).collect(Collectors.toList());
    }

    static List<BranchGithubResponse> jsonToGithubResponseBranchDecoder(String jsonResponse) {
        Gson gson = new Gson();
        BranchGithubResponse[] branchGithubResponses = gson.fromJson(jsonResponse, BranchGithubResponse[].class);
        return Arrays.stream(branchGithubResponses).collect(Collectors.toList());
    }
}
