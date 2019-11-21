package com.squarehelp.squarehelp.controllers;
import com.squarehelp.squarehelp.models.SmokerInfo;
import com.squarehelp.squarehelp.models.User;
import com.squarehelp.squarehelp.repositories.SmokerInfoRepository;
import com.squarehelp.squarehelp.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DashboardController {
    private final SmokerInfoRepository smokeDao;
    private final UserRepository userDao;

    public DashboardController(SmokerInfoRepository smokeDao, UserRepository userDao) {
        this.smokeDao = smokeDao;
        this.userDao = userDao;
    }

    @GetMapping("/dashboard/{user_id}")
    public String showDashboard(Model model, @PathVariable long user_id) {
        SmokerInfo smokerInfo = smokeDao.getOne(user_id);

        // Calculate money saved
//        long moneySaved = smokerInfo.getCost_of_cigs_saved() * smokerInfo.getTotal_days_smoke_free();

        model.addAttribute("users", userDao.getOne(user_id));
        model.addAttribute("smoke", smokerInfo);
//        model.addAttribute("moneySaved", moneySaved);
        return "dashboard";
    }
}