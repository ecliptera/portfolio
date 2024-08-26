package net.gb.knox.portfolio.controller;

import net.gb.knox.portfolio.domain.Image;
import net.gb.knox.portfolio.domain.Page;
import net.gb.knox.portfolio.domain.Tenant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PublicController {

    private final List<Tenant> tenants;

    public PublicController() {
        var teamwork = new Tenant(new Image("/images/teamwork.svg", "A group of people collaborating"),
                "Teamwork and collaboration",
                "Teamwork and collaboration are vital for effective software development. " +
                        "By embracing diverse perspectives and fostering open communication, a team can feel free to drive innovation and solve problems more efficiently. " +
                        "I have worked on many teams as a Software Engineer, and it has been clear to me that strong teamwork is key to continuous improvement and achieving shared goals.");

        var software = new Tenant(new Image("/images/software.svg", "A man with a software system"),
                "Software design and architecture",
                "Software design and architecture are foundational to creating scalable, maintainable, and robust systems. " +
                        "My experience as a Software Engineer has shown me the importance of well-thought-out architecture in ensuring long-term success. " +
                        "By focusing on clean design principles and architectural patterns, I have helped build solutions that are not only efficient but also adaptable to changing requirements.");

        var communication = new Tenant(new Image("/images/communication.svg", "Employees of a company communicating with each other"),
                "Communication and documentation",
                "Effective communication and thorough documentation are critical for aligning teams and ensuring continuity in software projects. " +
                        "In my role as a Software Engineer, I have consistently prioritized clear communication to bridge gaps between technical and non-technical stakeholders. " +
                        "And by creating comprehensive documentation, I have made it easier for colleagues to navigate and collaborate on shared codebases.");

        var observability = new Tenant(new Image("/images/observability.svg", "Two people monitoring a cloud system"),
                "Observability and monitoring",
                "Observability and monitoring are essential for maintaining the health and performance of software systems. " +
                        "Throughout my career, I have implemented robust monitoring solutions that provide real-time insights, enabling proactive issue resolution and system optimization. " +
                        "Treating observability as a necessity is crucial, because it helps ensure that systems are resilient and capable of meeting the demands of users, ultimately driving higher reliability and user satisfaction.");

        tenants = List.of(teamwork, software, communication, observability);
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("currentPage", Page.HOME);
        model.addAttribute("tenants", tenants);
        return "home";
    }
}
