package kz.runtime.springproject.controller;


import kz.runtime.springproject.bean.ProductBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "/product_bean_controller")
public class ProductBeanController {
    private final ProductBean productBean;

    public ProductBeanController(ProductBean productBean) {
        this.productBean = productBean;
    }

    @GetMapping(path = "/add_products", produces = "application/json")
    public Object addProductBean(@RequestParam(name = "category", required = false) String category,
                                @RequestParam(name = "product", required = false) String product,
                                @RequestParam(name = "price", required = false) Integer price)
    {
        if (productBean.add(category, product, price)) {
            return "Product has been added successfully";
        }
        return "Product is empty";

    }

    @GetMapping(path = "/get_list", produces = "application/json")
    public Object getProductList(@RequestParam(name = "category", required = false) String category) {
        if (!category.isEmpty()) {
            return productBean.getProductByCategoryName(category);
        }
        return productBean.getProductList();
    }
}
