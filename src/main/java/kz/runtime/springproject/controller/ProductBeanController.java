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

    @GetMapping(path = "/add", produces = "application/json")
    public Object addProductBean(@RequestParam(name = "category", required = false) String category,
                                @RequestParam(name = "product", required = false) String product,
                                @RequestParam(name = "price", required = false) Integer price)
    {
        if (!product.isEmpty() && !category.isEmpty() && (price > 0)) {
            productBean.add(category, product, price);
            return "Product added to list";
        }
        return "Product is empty";
    }
    @GetMapping(path = "/list", produces = "application/json")
    public Object getProductList(@RequestParam(name = "category", required = false) String category) {
        if (category != null) {
            return productBean.getProductByCategoryName(category);
        }
        return productBean.getProductList();

    }

}
