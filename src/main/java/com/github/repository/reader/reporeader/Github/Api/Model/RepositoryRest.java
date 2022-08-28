package com.github.repository.reader.reporeader.Github.Api.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryRest {
    private String login;
    private String repositoryName;
    private Set<BranchRest> branchList = new HashSet<>();
}
