package com.example.baitap3;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.example.XepLoaiService;

public class XepLoaiTest {

@Test
public void TC1_invalidScore(){
Assert.assertEquals(XepLoaiService.xepLoai(-1,false),"Diem khong hop le");
}

@Test
public void TC2_gioi(){
Assert.assertEquals(XepLoaiService.xepLoai(9,false),"Gioi");
}

@Test
public void TC3_kha(){
Assert.assertEquals(XepLoaiService.xepLoai(7.5,false),"Kha");
}

@Test
public void TC4_trungBinh(){
Assert.assertEquals(XepLoaiService.xepLoai(6,false),"Trung Binh");
}

@Test
public void TC5_thiLai(){
Assert.assertEquals(XepLoaiService.xepLoai(4,true),"Thi lai");
}

@Test
public void TC6_hocLai(){
Assert.assertEquals(XepLoaiService.xepLoai(4,false),"Yeu - Hoc lai");
}

}