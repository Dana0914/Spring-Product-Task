package kz.runtime.springproject.bean;


import kz.runtime.springproject.pojo.Product;
import lombok.Getter;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Getter
@Component
public class ProductBean {
    List<Product> productList = new ArrayList<>(Arrays.asList(
            new Product("smartphones", "samsung", 255000),
            new Product("smartphones", "oppo", 358000),
            new Product("tablet", "tablet", 485000),
            new Product("laptop", "asus", 550000)));

    public boolean add(String category, String product, Integer price) {
        if (!product.isEmpty() && !category.isEmpty() && (price > 0)) {
            return productList.add(new Product(category, product, price));
        }
        return false;
    }

    public List<Product> getProductByCategoryName(String category) {
        List<Product> categoryList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getCategory().equals(category)) {
                categoryList.add(product);
            }
        }
        return categoryList;
    }
}
