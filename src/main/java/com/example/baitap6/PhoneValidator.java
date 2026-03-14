package com.example.baitap6;

public class PhoneValidator {

    public static boolean isValid(String phone) {

        if (phone == null || phone.isEmpty()) {
            return false;
        }

        // chỉ cho phép 0-9 + space
        if (!phone.matches("[0-9+ ]+")) {
            return false;
        }

        phone = phone.replace(" ", "");

        // chuẩn hóa +84
        if (phone.startsWith("+84")) {
            phone = "0" + phone.substring(3);
        }

        // phải bắt đầu bằng 0
        if (!phone.startsWith("0")) {
            return false;
        }

        // phải 10 chữ số
        if (phone.length() != 10) {
            return false;
        }

        // kiểm tra đầu số
        String prefix = phone.substring(0, 2);

        if (prefix.equals("03") ||
            prefix.equals("05") ||
            prefix.equals("07") ||
            prefix.equals("08") ||
            prefix.equals("09")) {

            return true;
        }

        return false;
    }
}