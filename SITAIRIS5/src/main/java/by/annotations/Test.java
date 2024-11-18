package by.annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("Apple", 1.99f));
        products.add(new Product("Banana", 5.99f));
        products.add(new Product("Smartphone", 2.99f));
        products.add(new Product("Table", 0.99f));
        products.add(new Product("Lightbulb", 6.99f));

        for (Product product : products) {
            product.printInfo();
            System.out.println();
        }
    }
}
