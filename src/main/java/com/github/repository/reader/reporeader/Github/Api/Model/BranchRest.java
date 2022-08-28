package com.github.repository.reader.reporeader.Github.Api.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchRest {
    private String branchName;
    private String sha;
}
