package utils;

import config.Config;
import model.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static <T> List<T> readFile(String path, String type) {
        List<T> datas = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] items = line.split(",");
                switch (type) {
                    case Config.TYPE_CUSTOMER:
                        parseTypeCustomer(items, datas);
                        break;
                    case Config.TYPE_GYMPACKAGES:
                        parseTypeGymPackages(items, datas);
                        break;
                    case Config.TYPE_PRODUCT:
                        parseTypeProduct(items, datas);
                        break;
                    case Config.TYPE_STAFF:
                        parseTypeStaff(items, datas);
                        break;
                    case Config.TYPE_PT:
                        parseTypePt(items, datas);
                        break;
                    case Config.TYPE_TICKET:
                        parseTypeTicket(items, datas);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }

    private static <T> void parseTypePt(String[] items, List<T> datas) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        long idPt = Long.parseLong(items[0]);
        long idStaff = Long.parseLong(items[1]);
        long idCustomer = Long.parseLong(items[2]);
        LocalTime idTimeStart = LocalTime.parse(items[3],formatter);
        String time = items[4];
        Pt pt = new Pt(idPt, idStaff, idCustomer, idTimeStart, time);
        datas.add((T) pt);
    }

    private static <T> void parseTypeTicket(String[] items, List<T> datas) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
        long idTicket = Long.parseLong(items[0]);
        long idCustomer = Long.parseLong(items[1]);
        long idGymPackages = Long.parseLong(items[2]);
        LocalDate dateStart = LocalDate.parse(items[3], formatter);
        LocalDate dateEnd = LocalDate.parse(items[4], formatter);
        LocalTime dateTime = items[5].equals("0") ? null :LocalTime.parse(items[5],formatter2);
        int time = Integer.parseInt(items[6]);
        long idPt = Long.parseLong(items[7]);
        Float fee = Float.parseFloat(items[8]);
        Float discount = Float.parseFloat(items[9]);
        Ticket ticket = new Ticket(idTicket,idCustomer,idGymPackages,dateStart,dateEnd,dateTime,time,idPt,fee,discount);
        datas.add((T) ticket);
    }

    private static <T> void parseTypeStaff(String[] items, List<T> datas) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        long idStaff = Long.parseLong(items[0]);
        String fullName = items[1];
        String phone = items[2];
        String address = items[3];
        LocalDate timeStart = LocalDate.parse(items[4], formatter);
        Float salary = Float.valueOf(items[5]);
        ERole eRole = ERole.findByName(items[6]);

        Staff staff = new Staff(idStaff, fullName, phone, address, timeStart, salary, eRole);
        datas.add((T) staff);
    }

    private static <T> void parseTypeProduct(String[] items, List<T> datas) {
        long idProduct = Long.parseLong(items[0]);
        String name = items[1];
        int quantity = Integer.parseInt(items[2]);
        String describe = items[3];
        Product product = new Product(idProduct, name, quantity, describe);
        datas.add((T) product);
    }

    private static <T> void parseTypeGymPackages(String[] items, List<T> datas) {
        long idGymPackages = Long.parseLong(items[0]);
        String name = items[1];
        float price = Float.parseFloat(items[2]);
        EPt ePt = EPt.findByName(items[3]);
        int month = Integer.parseInt(items[4]);
        GymPackages gymPackages = new GymPackages(idGymPackages, name, price, ePt, month);
        datas.add((T) gymPackages);
    }

    private static <T> void parseTypeCustomer(String[] items, List<T> datas) {
        long idCustomer = Long.parseLong(items[0]);
        String name = items[1];
        int age = Integer.parseInt(items[2]);
        String phone = items[3];
        String address = items[4];
        Customer customer = new Customer(idCustomer, name, age, phone, address);
        datas.add((T) customer);
    }

    public static <T> void writeFile(String path, List<T> datas) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (T p : datas) {
                bufferedWriter.write(p.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
