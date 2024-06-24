package kz.runtime.springproject.controller;


import kz.runtime.springproject.pojo.Human;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping(path = "/test_controller")
public class TestController {
    //http://localhost:8080/test_controller/test_page


    @GetMapping(path = "/test_page", produces = "image/jpeg")
    public byte[] testPage() throws IOException {
        //C:\Users\Dana1\Downloads
        Path path = Path.of("C:", "Users", "Dana1", "Downloads", "image.jpeg");
        byte[] bytes = Files.readAllBytes(path);
        return bytes;
    }

//    @GetMapping(path = "/test_page", produces = "text/html")
//    public String testPage() {
//        return "<b>TestController.testPage()</b>";
//    }

    @GetMapping(path = "/test_page2")
    public Object testPage2() {
        return new Human("Bill", 25);

    }

    @GetMapping(path = "/test_page3", produces = "text/html")
    public Object testPage3(
    @RequestParam(name = "name", required = true) String name,
    @RequestParam(name = "age", required = true)  int age
    ) {
        return "Name: <b>" + name + "</b>";
    }
}