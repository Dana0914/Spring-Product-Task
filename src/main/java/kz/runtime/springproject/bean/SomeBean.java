package kz.runtime.springproject.bean;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Component
@Scope("singleton")
//@Scope("prototype")
//@SessionScope
//@RequestScope
public class SomeBean {
    public int sum(int a, int b) {
        return a + b;
    }
}
