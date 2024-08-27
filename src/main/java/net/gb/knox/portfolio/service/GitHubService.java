package net.gb.knox.portfolio.service;

import net.gb.knox.portfolio.domain.Project;
import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static net.gb.knox.portfolio.utility.StringUtility.sentenceCase;

@Service
public class GitHubService {

    private final GitHub gitHub;

    @Autowired
    public GitHubService(GitHub gitHub) {
        this.gitHub = gitHub;
    }

    @Cacheable("github")
    public List<Project> getProjects() throws IOException {
        var repositories = gitHub.getMyself().getAllRepositories();
        List<Project> projects = new ArrayList<>(repositories.size());

        repositories.forEach((key, repository) -> projects.add(new Project(sentenceCase(repository.getName()),
                repository.getDescription(), repository.getHtmlUrl().toString())));

        return projects;
    }
}
