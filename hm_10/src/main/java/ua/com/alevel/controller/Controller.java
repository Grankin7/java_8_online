package ua.com.alevel.controller;

import ua.com.alevel.entity.Product;
import ua.com.alevel.service.ProductCrudService;
import ua.com.alevel.service.impl.ProductCrudServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

public class Controller {

    ProductCrudService productCrudService = new ProductCrudServiceImpl();
    public void start() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        menu();
        String position = "";
        while ((position = bufferedReader.readLine()) != null) {
            crud(position, bufferedReader);
            menu();
        }
    }

    public void menu() {
        System.out.println();
        System.out.println("If you want create product please enter 1");
        System.out.println("If you want find product please enter 2");
        System.out.println("If you want find all product please enter 3");
        System.out.println("If you want delete product please enter 4");
        System.out.println("If you want update product please enter 5");
        System.out.println("If you want close app please enter 0");
    }

    private void crud(String position, BufferedReader bufferedReader) throws IOException {
        switch (position) {
            case "1" -> create(bufferedReader);
            case "2" -> findOne(bufferedReader);
            case "3" -> findAll();
            case "4" -> delete(bufferedReader);
            case "5" -> update(bufferedReader);
            case "0" -> System.exit(0);
        }
    }

    private void findOne(BufferedReader reader) throws IOException {
        System.out.println("Please enter id");
        String id = reader.readLine();
        Product product = productCrudService.findOne(Long.parseLong(id));
        System.out.println("Id = " + product.getId());
        System.out.println("Product Name = " + product.getProductName());
        System.out.println("Product Quantity = " + product.getProductQuantity() + " units");
        System.out.println("Product Price = " + product.getProductPrice() + " $");
    }

    private void create(BufferedReader reader) throws IOException {
        System.out.println("Please enter product name");
        String name = reader.readLine();
        System.out.println("Please enter quantity of goods");
        int pq = Integer.parseInt(reader.readLine());
        System.out.println("Please enter price");
        int pp = Integer.parseInt(reader.readLine());
        Product product = new Product();
        product.setProductName(name);
        product.setProductQuantity(pq);
        product.setProductPrice(pp);
        productCrudService.create(product);
    }

    private void update(BufferedReader reader) throws IOException {
        System.out.println("Please enter id");
        String id = reader.readLine();
        System.out.println("Please enter product name");
        String name = reader.readLine();
        System.out.println("Please enter quantity of goods");
        int pq = Integer.parseInt(reader.readLine());
        System.out.println("Please enter price");
        int pp = Integer.parseInt(reader.readLine());
        Product product = new Product();
        product.setId(Long.parseLong(id));
        product.setProductName(name);
        product.setProductQuantity(pq);
        product.setProductPrice(pp);
        productCrudService.update(product);
    }

    private void delete(BufferedReader reader) throws IOException {
        System.out.println("Please enter id");
        String id = reader.readLine();
        productCrudService.delete(Long.parseLong(id));
    }

    private void findAll() {
        Collection<Product> products = productCrudService.findAll();
        products.forEach(product -> {
            System.out.println("Id = " + product.getId());
            System.out.println("Product Name = " + product.getProductName());
            System.out.println("Product Quantity = " + product.getProductQuantity() + " units");
            System.out.println("Product Price = " + product.getProductPrice() + " $");
        });
    }
}
