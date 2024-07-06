package kz.runtime.springproject.controller;


import kz.runtime.springproject.bean.ProductBean;
import kz.runtime.springproject.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/products")
public class ProductViewController {
    private final ProductBean productBean;
    @Autowired
    public ProductViewController(ProductBean productBean) {
        this.productBean = productBean;
    }
    @GetMapping(path = "/getcategory")
    public String getCategory(Model model, @RequestParam(name = "category", required = false) String category) {
        List<Product> collect = productBean.getProductList().stream()
                .filter(product -> product.getCategory().equals(category)).
                collect(Collectors.toList());
        model.addAttribute("products", collect).addAttribute("category", category);
        return "product_view_page_1";
    }
    @GetMapping(path = "/getproducts")
    public String getProductList(Model model) {
        model.addAttribute("products", productBean.getProductList());
        return "product_view_page_1";
    }

}
