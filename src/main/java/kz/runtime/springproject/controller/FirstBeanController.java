package kz.runtime.springproject.controller;


import kz.runtime.springproject.bean.SomeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/first_bean_controller")
public class FirstBeanController {

    private final SomeBean someBean;
    public FirstBeanController(SomeBean someBean) {
        this.someBean = someBean;
    }

    @GetMapping
    public Object page() {
        int r = someBean.sum(10, 15);
        return String.valueOf(r);
//        String str = """
//                Object: <b>%s</b><br/>
//                Result: <b>%d</b>
//                """;
//        return str.formatted(someBean.toString(), r);
    }

}
