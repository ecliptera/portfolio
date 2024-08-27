package net.gb.knox.portfolio.controller;

import net.gb.knox.portfolio.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController {

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
}
