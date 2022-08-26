package com.github.repository.reader.reporeader.RepoReader.Controller;

import com.github.repository.reader.reporeader.RepoReader.Model.Response.RepositoryRest;
import com.github.repository.reader.reporeader.RepoReader.Service.RepoReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path="repository")
@RestController
@RequiredArgsConstructor
public class RepoReaderController {
    private final RepoReaderService repoReaderService;

    @GetMapping(path = "/username/{username}")
    public List<RepositoryRest> getUserRepositories(@PathVariable String username) {
        return repoReaderService.getUserRepositories(username);
    }
}
