package com.kata.thestartofthirdmodule.UserContoller;

import com.kata.thestartofthirdmodule.model.User;
import com.kata.thestartofthirdmodule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userServiceImpl;

    @GetMapping()
    public String index(Model model){
        List<User> users = userServiceImpl.index();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userServiceImpl.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userServiceImpl.showUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userServiceImpl.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userServiceImpl.delete(id);
        return "redirect:/users";
    }
}

