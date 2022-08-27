package com.github.repository.reader.reporeader.Github;

import com.github.repository.reader.reporeader.Github.Api.GithubFacade;
import com.github.repository.reader.reporeader.Github.Api.Model.RepositoryRest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path="repository")
@RestController
@RequiredArgsConstructor
class RepositoryReaderController {
    private final GithubFacade githubFacade;

    @GetMapping(path = "/username/{username}")
    public List<RepositoryRest> getUserRepositories(@PathVariable String username) {
        return githubFacade.getUserRepositories(username);
    }
}
