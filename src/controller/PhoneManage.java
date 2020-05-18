package controller;

import model.Phone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneManage implements PhoneActivities {
    List<Phone> listPhone= new ArrayList<>();
    @Override
    public void showPhone() {
   for (Phone phone:listPhone){
       System.out.println(phone.toString());
   }
    }

    @Override
    public void addPhone() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Nhập vào SDT: ");
        String phone =scanner.nextLine();
        if (!vadiateEmail(phone)){
            System.out.println("Ban da nhap sai email");
            addPhone();
        }
        System.out.println("Nhập nhóm: ");
        String group = scanner.nextLine();
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giới tính: ");
        String sex= scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address= scanner.nextLine();
        System.out.println("Nhập ngày sinh: ");
        String birthDay= scanner.nextLine();
        System.out.println("Nhập email: ");
        String email= scanner.nextLine();
        if (!vadiateEmail(email)){
            System.out.println("Bạn đã nhập sai email");
            addPhone();
        }
        listPhone.add(new Phone(phone,group,name,sex,address,birthDay,email));

}
    @Override
    public void editPhone() {
        Scanner scanner= new Scanner(System.in);

        System.out.println("Bạn muốn sửa thông tin của sdt nào: ");
        String phoneNumber= scanner.nextLine();
        int index= -1;
        for (int i=0; i<listPhone.size();i++){
            if (listPhone.get(i).getPhoneNumber().equals(phoneNumber)){
                index=i;
                System.out.println("Đây là thông tin của SDT bạn cần tìm");
                System.out.println(listPhone.get(i).toString());
            }
        }
        if (index!=-1){
            int choose=scanner.nextInt();
            do {
                System.out.println("Bạn muốn sửa những thông tin nào trong số những thông tin sau: ");
                System.out.println("1. Sửa nhóm");
                System.out.println("2. Sửa họ và tên");
                System.out.println("3. Sửa giới tính");
                System.out.println("4. Sửa địa chỉ");
                System.out.println("5. Sửa ngày sinh");
                System.out.println("6. Sửa email");
                System.out.println("7. Thoát");
                System.out.println("Lựa chọn của bạn là ");
                switch (choose){
                    case 1:
                        System.out.println("Nhập nhóm mới");
                        String newGroup= scanner.nextLine();
                        listPhone.get(index).setGroup(newGroup);
                        break;
                    case 2:
                        System.out.println("Nhập họ và tên mới");
                        String newName= scanner.nextLine();
                        listPhone.get(index).setName(newName);
                        break;
                    case 3:
                        System.out.println("Nhập giới tính mới");
                        String newSex= scanner.nextLine();
                        listPhone.get(index).setSex(newSex);
                        break;
                    case 4:
                        System.out.println("Nhập địa chỉ  mới");
                        String newAddress= scanner.nextLine();
                        listPhone.get(index).setAddress(newAddress);
                        break;
                    case 5:
                        System.out.println("Nhập ngày sinh mới");
                        String newBirthday= scanner.nextLine();
                        listPhone.get(index).setBirthDay(newBirthday);
                        break;
                    case 6:
                        System.out.println("Nhập email mới");
                        String newEmail= scanner.nextLine();
                        listPhone.get(index).setEmail(newEmail);
                        break;
                    case 7:
                        System.out.println("Việc chỉnh sửa thông tin đã được lưu lại");
                        break;
                    default:
                        System.out.println("Bạn đã nhập sai lựa chọn. Xin hãy nhập lại");
                }

            } while (choose!=7);

        }

    }

    @Override
    public void searchPhone() {
        Scanner scanner= new Scanner(System.in);

        System.out.println("Bạn muốn sửa thông tin của sdt nào: ");
        String phoneNumber= scanner.nextLine();
        int index=-1;
        for (int i=0; i<listPhone.size();i++){
            if (listPhone.get(i).getPhoneNumber().equals(phoneNumber)){
                index=i;
            }
        }
        if (index!=-1){
            System.out.println("Đây là thông tin của SDT bạn cần tìm");
            System.out.println(listPhone.get(index).toString());
        } else {
            System.out.println("SDT mà bạn tìm kiếm không tồn tại");
        }

    }

    @Override
    public void deletePhone() {
        Scanner scanner= new Scanner(System.in);

        System.out.println("Bạn muốn xóa thông tin của sdt nào: ");
        String phoneNumber= scanner.nextLine();
        int index=-1;
        for (int i=0; i<listPhone.size();i++){
            if (listPhone.get(i).getPhoneNumber().equals(phoneNumber)){
                index=i;
            }
        }
        if (index!=-1){
            System.out.println("Đây là thông tin của SDT bạn cần xóa.");
            System.out.println(listPhone.get(index).toString());
            System.out.println("SDT này sẽ bị xóa khỏi danh bạ");
            listPhone.remove(index);
        } else {
            System.out.println("SDT mà bạn tìm kiếm không tồn tại");
        }
    }

    @Override
    public void readFromFile(String fileSource) {
        try{
            File file = new File(fileSource);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] phones = line.split(",");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveToFile(String filePath) {

    }

    static boolean vadiatePhoneNumber( String phoneNumber){
     String REGEX_PHONENUMBER ="^0[0-9]{7,}$";
        Pattern pattern= Pattern.compile(REGEX_PHONENUMBER);
        Matcher matcher= pattern.matcher(phoneNumber);
        return matcher.matches();

    }
    static boolean vadiateEmail(String email){
        String EMAIL_REGEX="^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        Pattern pattern= Pattern.compile(EMAIL_REGEX);
        Matcher matcher= pattern.matcher(email);
        return matcher.matches();
    }
}
