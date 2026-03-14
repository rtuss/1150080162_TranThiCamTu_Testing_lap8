package com.example.baitap3;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TinhTienNuocTest {

    @Test
    public void TC01(){
        double result = TinhTienNuoc.tinhTienNuoc(-1, "dan_cu");
        assertEquals(result, 0);
    }

    @Test
    public void TC02(){
        double result = TinhTienNuoc.tinhTienNuoc(5, "ho_ngheo");
        assertEquals(result, 25000);
    }

    @Test
    public void TC03(){
        double result = TinhTienNuoc.tinhTienNuoc(8, "dan_cu");
        assertEquals(result, 60000);
    }

    @Test
    public void TC04(){
        double result = TinhTienNuoc.tinhTienNuoc(15, "dan_cu");
        assertEquals(result, 148500);
    }

    @Test
    public void TC05(){
        double result = TinhTienNuoc.tinhTienNuoc(25, "dan_cu");
        assertEquals(result, 285000);
    }

    @Test
    public void TC06(){
        double result = TinhTienNuoc.tinhTienNuoc(10, "kinh_doanh");
        assertEquals(result, 220000);
    }
}