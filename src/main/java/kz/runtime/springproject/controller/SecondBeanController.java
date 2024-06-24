package kz.runtime.springproject.controller;

import kz.runtime.springproject.bean.SomeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/second_bean_controller")
public class SecondBeanController {
    private final SomeBean someBean;
    public SecondBeanController(SomeBean someBean) {
        this.someBean = someBean;
    }
    @GetMapping
    public Object page() {
        int r = someBean.sum(10, 15);
        String str = """
                Object: <b>%s</b><br/>
                Result: <b>%d</b>
                """;
        return str.formatted(someBean.toString(), r);
    }

}
