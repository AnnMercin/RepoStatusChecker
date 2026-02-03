package com.example.RepoStatusChecker.Controller;

import com.example.RepoStatusChecker.Service.GitService;
import org.eclipse.jgit.api.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/git")
public class RepoStatusCheckerController {
    private final GitService gitService;

    public RepoStatusCheckerController(GitService gitService) { this.gitService = gitService; }

    @GetMapping("/repoStatus")
    public Status getUntracked() throws Exception {
        return gitService.getUntrackedFiles();
    }
}
