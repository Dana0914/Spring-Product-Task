package kz.runtime.springproject.controller;


import kz.runtime.springproject.pojo.Human;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/view_controller")
public class ViewController {

    @GetMapping(path = "/view_page_1")
    public String viewPage1(Model model) {
        String message = "Message from ViewController";
        model.addAttribute("message", message);
        return "view_page_1";
    }

    @GetMapping(path = "/view_page_2")
    public String viewPage2(Model model) {
        Human human = new Human("Will", 25);
        model.addAttribute("human", human);
        return "view_page_2";
    }

    @GetMapping(path = "/view_page_3")
    public String viewPage3(Model model) {
        Human[] humans = new Human[]{new Human("Will", 25),
                new Human("Bill", 34),
                new Human("Mark", 47),
                new Human("Ash", 20)
        };
        model.addAttribute("humans", humans);
        return "view_page_3";
    }

}
