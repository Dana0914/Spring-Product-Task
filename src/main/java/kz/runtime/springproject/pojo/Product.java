package kz.runtime.springproject.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Product {
    private String category;
    private String name;
    private Integer price;


}
