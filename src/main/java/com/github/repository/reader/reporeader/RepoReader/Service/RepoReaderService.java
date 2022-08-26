package com.github.repository.reader.reporeader.RepoReader.Service;

import com.github.repository.reader.reporeader.RepoReader.Model.Response.BranchRest;
import com.github.repository.reader.reporeader.RepoReader.Model.Response.RepositoryRest;

import java.util.List;
import java.util.Set;

public interface RepoReaderService {
    List<RepositoryRest> getUserRepositories(String username);
    Set<BranchRest> getRepositoryBranches(String username, String repositoryName);
}
