package com.github.repository.reader.reporeader.Github;

import com.github.repository.reader.reporeader.Github.Api.GithubService;
import com.github.repository.reader.reporeader.Github.Api.Model.RepositoryRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path="github")
class GithubController {
    private final GithubService githubService;

    @GetMapping(path = "/user/{username}/repos", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<RepositoryRest> getUserRepositories(@PathVariable String username) {
        return githubService.getUserRepositories(username);
    }
}
