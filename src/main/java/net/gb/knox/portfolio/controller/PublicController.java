package net.gb.knox.portfolio.controller;

import net.gb.knox.portfolio.domain.Page;
import net.gb.knox.portfolio.domain.Project;
import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static net.gb.knox.portfolio.utility.StringUtility.sentenceCase;

@Controller
public class PublicController {

    private final GitHub gitHub;

    @Autowired
    public PublicController(GitHub gitHub) {
        this.gitHub = gitHub;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("currentPage", Page.HOME);
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("currentPage", Page.ABOUT);
        return "about";
    }

    @GetMapping("/projects")
    public String projects(Model model) throws IOException {
        var repositories = gitHub.getMyself().getAllRepositories();
        List<Project> projects = new ArrayList<>(repositories.size());

        repositories.forEach((key, repository) -> projects.add(new Project(sentenceCase(repository.getName()),
                repository.getDescription(), repository.getHtmlUrl().toString())));

        model.addAttribute("currentPage", Page.PROJECTS);
        model.addAttribute("projects", projects);
        return "projects";
    }
}
