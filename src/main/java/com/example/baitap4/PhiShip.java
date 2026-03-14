package com.example.baitap4;

public class PhiShip {

    public static double tinhPhiShip(double trongLuong, String vung, boolean laMember) {

        double phi = 10000; // phí cơ bản

        // Kiểm tra trọng lượng hợp lệ
        if (trongLuong <= 0) {
            throw new IllegalArgumentException("Trọng lượng không hợp lệ");
        }

        // Nội thành
        if (vung.equals("noi_thanh")) {

            if (trongLuong > 5) {
                phi += 10000;
            } else {
                phi += 5000;
            }

        }
        // Ngoại thành
        else if (vung.equals("ngoai_thanh")) {

            if (trongLuong > 3) {
                phi += 15000;
            } else {
                phi += 10000;
            }

        }
        // Vùng khác
        else {

            if (trongLuong > 2) {
                phi += 20000;
            } else {
                phi += 12000;
            }

        }

        // Giảm giá cho member
        if (laMember) {
            phi = phi * 0.9;
        }

        return phi;
    }
}