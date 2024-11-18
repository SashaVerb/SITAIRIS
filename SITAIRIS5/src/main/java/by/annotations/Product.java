package by.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Product {
    protected String name;
    protected float price;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Color(color = ANSIColor.CYAN)
    public void printName() {
        System.out.print(name);
    }

    @Color(color = ANSIColor.GREEN)
    public void printPrice() {
        System.out.printf("%.2f$", price);
    }

    void printInfo() {
        try {
            Method printMethod = null;
            System.out.print("Name: ");
            printMethod = this.getClass().getMethod("printName");
            processAnnotatedPrint(printMethod);
            System.out.print("\nPrice: ");
            printMethod = this.getClass().getMethod("printPrice");
            processAnnotatedPrint(printMethod);
            System.out.println();
        }
        catch (NoSuchMethodException e) {
            System.out.println("No such method");
        }

    }

    void processAnnotatedPrint(Method method) {
        Color color = method.getAnnotation(Color.class);
        if (color != null) {
            System.out.print(color.color().getCode());
            try {
                method.invoke(this);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.print(ANSIColor.RESET.getCode());
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
