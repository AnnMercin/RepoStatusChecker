package com.example.RepoStatusChecker.Service;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.Status;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Set;

@Service
public class GitService {
    public Set<String> getUntrackedFiles() throws Exception {
        String repoPath = System.getProperty("user.dir");
        try (Git git = Git.open(new File(repoPath))) {
            Status status = git.status().call();
            return status.getUntracked();
        }
    }
}
