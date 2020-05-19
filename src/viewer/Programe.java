package viewer;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import controller.PhoneManage;

import java.util.Scanner;

public class Programe {
final  static String fileLocal= "D:\\Codegym Module\\Kiemtracuoimodule_2\\contacts.csv";
final static String fileRepository="D:\\Codegym Module\\Kiemtracuoimodule_2\\data.csv";
private PhoneManage phoneManage= new PhoneManage();
    public void run(){
        Scanner scanner= new Scanner(System.in);
        int choose;

        do {
            showMenu();
            choose= scanner.nextInt();
            switch (choose){
                case 1:
                    phoneManage.showPhone();
                    break;
                case 2:
                    phoneManage.addPhone();
                    break;
                case 3:
                    phoneManage.editPhone();
                    break;
                case 4:
                    phoneManage.deletePhone();
                    break;
                case 5:
                    phoneManage.searchPhone();
                    break;
                case 6:
                    System.out.println("Cập nhật file danh bạ mới, dữ liệu cũ sẽ không còn");
                    System.out.println("1. Đồng ý");
                    System.out.println("2. Thoát");
                    System.out.println("Lựa chọn của bạn là : ");
                    int choose1= scanner.nextInt();
                    if (choose1==1){
                        phoneManage.readFromFile(fileLocal);
                    } else {
                        break;
                    }

                    break;
                case 7:
                    System.out.println("Bạn có muốn lưu danh bạ vào file dữ liệu hay không");
                    System.out.println("1. Đồng ý");
                    System.out.println("2. Thoát");
                    System.out.println("Lựa chọn của bạn là : ");
                    int choose2= scanner.nextInt();
                    if (choose2==1){
                        phoneManage.saveToFile(fileRepository);
                    } else {
                        break;
                    }

                    break;
                case 8:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Bạn đã lựa chọn sai. Xin hãy lựa chọn lại");
                    break;
            }

        } while (choose!=8);
    }
    protected static void showMenu(){
        System.out.println("======CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ=======");
        System.out.println("Chọn chức năng theo số (để tiếp tục): ");
        System.out.println("1. Xem danh sách ");
        System.out.println("2. Thêm mới ");
        System.out.println("3. Cập nhật ");
        System.out.println("4. Xóa ");
        System.out.println("5. Tìm kiếm ");
        System.out.println("6. Đọc từ file ");
        System.out.println("7. Ghi ra file ");
        System.out.println("8. Thoát ");
        System.out.println("Chọn chức năng ");
    }
}
