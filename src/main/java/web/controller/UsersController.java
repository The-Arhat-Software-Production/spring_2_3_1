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
@RequestMapping("/users") // префикс для всех методов в классе
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    // CREATE
    // форма создания пользователя
    @GetMapping({"/new"})
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    // обработка POST данных из формы создания пользователя
    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    // READ
    @GetMapping("/details/{id}")
    public String getUserDetails(@PathVariable("id") Long id, Model model) {
        User user = userService.readUser(id);
        model.addAttribute("user", user);
        return "readUser";
    }

    // UPDATE
    // форма редактирования пользователя
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = userService.readUser(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    // обработка POST данных из формы редактирования пользователя
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    // DELETE
    // удалить пользователя по id
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    // выводим всех пользователей
    @GetMapping({"/", "/list", ""})
    public String listUsers(Model model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "listUsers";
    }
}
