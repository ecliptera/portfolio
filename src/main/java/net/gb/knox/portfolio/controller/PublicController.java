package net.gb.knox.portfolio.controller;

import net.gb.knox.portfolio.domain.Page;
import net.gb.knox.portfolio.service.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class PublicController {

    private final GitHubService gitHubService;

    @Autowired
    public PublicController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
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
        model.addAttribute("currentPage", Page.PROJECTS);
        model.addAttribute("projects", gitHubService.getProjects());
        return "projects";
    }

    @GetMapping("/experience")
    public String experience(Model model) {
        model.addAttribute("currentPage", Page.EXPERIENCE);
        return "experience";
    }
}
