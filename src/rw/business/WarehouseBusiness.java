package rw.business;

import rw.entiry.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WarehouseBusiness {
    private static WarehouseBusiness instance;
    private List<Product> list;
    private WarehouseBusiness() {
        list = new ArrayList<>();
    }
    public static WarehouseBusiness getInstance() {
        if (instance == null) {
            instance = new WarehouseBusiness();
        }
        return instance;
    }
    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("Danh sách rỗng");
            return;
        }
        list.forEach(Product::displayData);
    }
    public void add(Product product) {
        boolean exists = list.stream()
                .anyMatch(p -> p.getProductId().equals(product.getProductId()));
        if (exists) {
            System.out.println("ID đã tồn tại");
        } else {
            list.add(product);
            System.out.println("Thêm thành công");
        }
    }
//    public void update(String id, Product newData) {
//        Optional<Product> optional = list.stream()
//                .filter(p -> p.getProductId().equals(id))
//                .findFirst();
//        if (optional.isPresent()) {
//            Product p = optional.get();
//            p.getProductName(newData.getProductName());
//            p.setPrice(newData.getPrice());
//            p.setQuantity(newData.getQuantity());
//            p.setCategory(newData.getCategory());
//            System.out.println("Cập nhật thành công");
//        } else {
//            System.out.println("Không tìm thấy sản phẩm");
//        }
//    }
    public void delete(String id) {
        boolean removed = list.removeIf(p -> p.getProductId().equals(id)); // lambda
        if (removed) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Không tìm thấy sản phẩm");
        }
    }
    public List<Product> findByName(String name) {
        List<Product> result = list.stream()
                .filter(p -> p.getProductName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm");
        } else {
            result.forEach(Product::displayData);
        }
        return result;
    }
    public void warning() {
        List<Product> lowStock = list.stream()
                .filter(p -> p.getQuantity() < 5)
                .collect(Collectors.toList());
        if (lowStock.isEmpty()) {
            System.out.println("Không có sản phẩm sắp hết");
        } else {
            System.out.println("===== CẢNH BÁO =====");
            lowStock.forEach(Product::displayData);
        }
    }
    public void sortByPriceAsc() {
        list.sort(Comparator.comparing(Product::getPrice));
        System.out.println("Đã sắp xếp theo giá tăng dần");
        displayAll();
    }
}