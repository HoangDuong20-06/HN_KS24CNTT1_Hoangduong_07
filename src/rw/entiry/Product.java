package rw.entiry;

import java.util.Scanner;
public class Product {
    private String productId;
    private String productName;
    private double price;
    private int quantity;
    private String category;

    public Product() {
    }
    public Product(String productId, String productName, double price, int quantity, String category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }
    public void displayData() {
        System.out.println("ID: " + productId +
                " | Tên: " + productName +
                " | Giá: " + price +
                " | Số lượng: " + quantity +
                " | Danh mục: " + category);
    }
    public void inputData(Scanner sc) {
        while (true) {
            System.out.print("Nhập ID: ");
            String id = sc.nextLine().trim();
            if (id.isEmpty()) {
                System.out.println("ID không được để trống!");
            } else {
                this.productId = id;
                break;
            }
        }
        while (true) {
            System.out.print("Nhập tên sản phẩm: ");
            String name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Tên không được để trống!");
            } else {
                this.productName = name;
                break;
            }
        }
        while (true) {
            try {
                System.out.print("Nhập giá: ");
                double price = Double.parseDouble(sc.nextLine());
                if (price <= 0) {
                    System.out.println("Giá phải > 0!");
                } else {
                    this.price = price;
                    break;
                }
            } catch (Exception e) {
                System.out.println("Phải nhập số!");
            }
        }
        while (true) {
            try {
                System.out.print("Nhập số lượng: ");
                int quantity = Integer.parseInt(sc.nextLine());
                if (quantity < 0) {
                    System.out.println("Số lượng >= 0!");
                } else {
                    this.quantity = quantity;
                    break;
                }
            } catch (Exception e) {
                System.out.println("Phải nhập số nguyên!");
            }
        }
        while (true) {
            System.out.print("Nhập danh mục: ");
            String category = sc.nextLine().trim();
            if (category.isEmpty()) {
                System.out.println("Danh mục không được để trống!");
            } else {
                this.category = category;
                break;
            }
        }
    }
}