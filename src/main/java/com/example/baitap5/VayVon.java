package com.example.baitap5;

public class VayVon {

    public static boolean duDieuKienVay(int tuoi, int thuNhap, boolean coTaiSan, int credit) {

        if (tuoi < 22) {
            return false;
        }

        if (thuNhap < 10000000) {
            return false;
        }

        if (coTaiSan || credit >= 700) {
            return true;
        }

        return false;
    }
}