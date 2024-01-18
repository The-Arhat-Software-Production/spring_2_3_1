package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainPageController {
    @GetMapping(value="", produces = "text/html; charset=utf-8")
    public String mainPageView(Model model) {
        List<String> messages = new ArrayList<>();
        messages.add("Написать CRUD-приложение. Использовать Spring MVC + Hibernate.");
        messages.add("Должен быть класс {{User }}с произвольными полями (id, name и т.п.).");
        messages.add("В приложении должна быть страница, на которую выводятся все юзеры с возможностью добавлять," +
                " удалять и изменять юзера.");
        messages.add("Конфигурация Spring через {{JavaConfig }}и аннотации, по аналогии с предыдущими проектами. " +
                "Без использования xml. Без Spring Boot.");
        messages.add("Внесите изменения в конфигурацию для работы с базой данных. Вместо SessionFactory должен использоваться EntityManager.");
        model.addAttribute("messages", messages);
        return "index";
    }
}
