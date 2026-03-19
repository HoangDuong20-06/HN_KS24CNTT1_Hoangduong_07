package rw.presentation;
import rw.business.WarehouseBusiness;
import rw.entiry.Product;
import java.util.Scanner;
public class WarehouseManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WarehouseBusiness business = WarehouseBusiness.getInstance();
        int choice;
        do {
            System.out.println("========== QUẢN LÝ KHO HÀNG ==========");
            System.out.println("1. Hiển thị danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhật sản phẩm theo ID");
            System.out.println("4. Xóa sản phẩm theo ID");
            System.out.println("5. Tìm kiếm theo tên");
            System.out.println("6. Cảnh báo sắp hết hàng");
            System.out.println("7. Sắp xếp theo giá tăng dần");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    business.displayAll();
                    break;
                case 2:
                    do {
                        Product p = new Product();
                        p.inputData(sc);
                        business.add(p);
                        System.out.print("Bạn có muôn tiếp tục thêm? (Y/N): ");
                        String option = sc.nextLine();
                        if (option.equalsIgnoreCase("N")) {
                            break;
                        }

                    } while (true);
                    break;
                case 3:
//                    System.out.print("Nhập ID cần update: ");
//                    String updateId = sc.nextLine();
//                    Product newData = new Product();
//                    System.out.println("Nhập thông tin mới:");
//                    newData.inputData(sc);
//                    business.update(updateId, newData);
                    break;
                case 4:
                    System.out.print("Nhập ID cần xóa: ");
                    String deleteId = sc.nextLine();
                    business.delete(deleteId);
                    break;
                case 5:
                    System.out.print("Nhập tên cần tìm: ");
                    String name = sc.nextLine();
                    business.findByName(name);
                    break;
                case 6:
                    business.warning();
                    break;
                case 7:
                    business.sortByPriceAsc();
                    break;
                case 8:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 8);
    }
}