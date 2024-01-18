package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    // форма создания пользователя
    @GetMapping({"/new"})
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    // обработка POST данных из формы
    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    // удалить пользователя по id
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users"; // Перенаправление обратно на список пользователей
    }

    // выводим всех пользователей
    @GetMapping({"/", "/list", ""})
    public String listUsers(Model model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "listUsers";
    }
}
