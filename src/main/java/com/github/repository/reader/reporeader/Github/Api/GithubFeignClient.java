package com.github.repository.reader.reporeader.Github.Api;

import com.github.repository.reader.reporeader.Github.Api.Model.BranchGithubResponse;
import com.github.repository.reader.reporeader.Github.Api.Model.RepositoryGithubResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "githubClient", url = "https://api.github.com")
interface GithubFeignClient {

    @GetMapping("/users/{username}/repos")
    RepositoryGithubResponse[] getRepoList(@PathVariable("username") String username);

    @GetMapping("/repos/{username}/{projectName}/branches")
    BranchGithubResponse[] getBranchList(@PathVariable("username") String username, @PathVariable("projectName") String projectName);
}
