package com.github.repository.reader.reporeader.Github.Api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "githubClient", url = "https://api.github.com")
interface GithubFeignClient {

    @GetMapping("/users/{username}/repos")
    String getRepoList(@PathVariable("username") String username);

    @GetMapping("/repos/{username}/{projectName}/branches")
    String getBranchList(@PathVariable("username") String username, @PathVariable("projectName") String projectName);

    @GetMapping("/users/{username}")
    String getUser(@PathVariable("username") String username);
}
