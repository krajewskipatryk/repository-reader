package com.github.repository.reader.reporeader.Github;

import com.github.repository.reader.reporeader.Github.Api.GithubFacade;
import com.github.repository.reader.reporeader.Github.Api.Model.GithubLoginRequestModel;
import com.github.repository.reader.reporeader.Github.Api.Model.RepositoryRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path="github")
class GithubController {
    private final GithubFacade githubFacade;

    @GetMapping(path = "/repos", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<RepositoryRest> getUserRepositories(@RequestBody GithubLoginRequestModel githubLoginRequestModel) {
        return githubFacade.getUserRepositories(githubLoginRequestModel.getUsername());
    }
}
