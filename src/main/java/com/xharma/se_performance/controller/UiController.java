package com.xharma.se_performance.controller;
import com.xharma.se_performance.entity.SePerformance;
import com.xharma.se_performance.service.impl.SePerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Controller class to handle HTML endpoints related to user login and performance.
 * Author: Akshay Sharma
 */
@Controller
public class UiController {

    @Autowired
    private SePerformanceService sePerformanceService;

    /**
     * Redirects to the login page.
     *
     * @param model the Spring model for passing attributes to the view
     * @return the login page view
     */
    @GetMapping("/")
    public String showLogin(Model model) {
        model.addAttribute("error", null);
        return "redirect:/login"; // Redirect to the login page
    }

    /**
     * Displays the login form.
     *
     * @param model the Spring model for passing attributes to the view
     * @return the login page view
     */
    @GetMapping("/login")
    public String showSeCodeForm(Model model) {
        return "login";
    }

    /**
     * Handles user login.
     *
     * @param username the username entered by the user
     * @param password the password entered by the user
     * @param model    the Spring model for passing attributes to the view
     * @return the appropriate view based on login success or failure
     */
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        if ("".equals(username)) {
            model.addAttribute("error", "Username cannot be blank");
            return "login"; // Return to the login page with an error message
        }
        if (!"password".equals(password)) {
            model.addAttribute("error", "Invalid password");
            return "login"; // Return to the login page with an error message
        }
        SePerformance sePerformance = sePerformanceService.getSePerformanceBySeCode(username);
        List<Integer> displayedColumnIndices = sePerformanceService.getDisplayedColumnIndices();
        if (sePerformance != null) {
            model.addAttribute("sePerformance", sePerformance);
            model.addAttribute("displayedColumnIndices", displayedColumnIndices);
            model.addAttribute("error", "");
            return "performance";
        } else {
            model.addAttribute("error", "Employee with se code \"" + username + "\" not found");
            return "login";
        }
    }
}

