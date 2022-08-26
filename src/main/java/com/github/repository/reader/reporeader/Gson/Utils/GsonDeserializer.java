package com.github.repository.reader.reporeader.Gson.Utils;

import com.github.repository.reader.reporeader.Feign.Model.Response.Branch.BranchGithubResponse;
import com.github.repository.reader.reporeader.Feign.Model.Response.Repo.RepositoryGithubResponse;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class GsonDeserializer {
    public static List<RepositoryGithubResponse> jsonToGithubResponseRepoDecoder(String jsonResponse) {
        Gson gson = new Gson();
        RepositoryGithubResponse[] repositoryGithubResponses = gson.fromJson(jsonResponse, RepositoryGithubResponse[].class);
        return Arrays.stream(repositoryGithubResponses).collect(Collectors.toList());
    }

    public static List<BranchGithubResponse> jsonToGithubResponseBranchDecoder(String jsonResponse) {
        Gson gson = new Gson();
        BranchGithubResponse[] branchGithubResponses = gson.fromJson(jsonResponse, BranchGithubResponse[].class);
        return Arrays.stream(branchGithubResponses).collect(Collectors.toList());
    }
}
