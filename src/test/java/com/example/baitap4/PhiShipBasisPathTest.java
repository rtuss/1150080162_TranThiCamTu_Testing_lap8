package com.example.baitap4;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PhiShipBasisPathTest {

    @Test(description = "Path 1: Trọng lượng không hợp lệ")
    public void testPath1_InvalidWeight() {
        Assert.assertThrows(
                IllegalArgumentException.class,
                () -> PhiShip.tinhPhiShip(-1, "noi_thanh", false)
        );
    }

    @Test(description = "Path 2: Nội thành <=5kg, không member")
    public void testPath2_NoiThanhNheKhongMember() {
        double expected = 15000;

        Assert.assertEquals(
                PhiShip.tinhPhiShip(3, "noi_thanh", false),
                expected,
                0.01
        );
    }

    @Test(description = "Path 3: Nội thành >5kg, không member")
    public void testPath3_NoiThanhNangKhongMember() {
        double expected = 20000;

        Assert.assertEquals(
                PhiShip.tinhPhiShip(7, "noi_thanh", false),
                expected,
                0.01
        );
    }

    @Test(description = "Path 4: Ngoại thành <=3kg, không member")
    public void testPath4_NgoaiThanhNheKhongMember() {
        double expected = 20000;

        Assert.assertEquals(
                PhiShip.tinhPhiShip(2, "ngoai_thanh", false),
                expected,
                0.01
        );
    }

    @Test(description = "Path 5: Ngoại thành >3kg, không member")
    public void testPath5_NgoaiThanhNangKhongMember() {
        double expected = 25000;

        Assert.assertEquals(
                PhiShip.tinhPhiShip(5, "ngoai_thanh", false),
                expected,
                0.01
        );
    }

    @Test(description = "Path 6: Vùng khác <=2kg, không member")
    public void testPath6_VungKhacNheKhongMember() {
        double expected = 22000;

        Assert.assertEquals(
                PhiShip.tinhPhiShip(1, "khac", false),
                expected,
                0.01
        );
    }

    @Test(description = "Path 7: Vùng khác >2kg, không member")
    public void testPath7_VungKhacNangKhongMember() {
        double expected = 30000;

        Assert.assertEquals(
                PhiShip.tinhPhiShip(4, "khac", false),
                expected,
                0.01
        );
    }

    @Test(description = "Path 8: Nội thành <=5kg, có member (giảm 10%)")
    public void testPath8_MemberDiscount() {
        double expected = 13500;

        Assert.assertEquals(
                PhiShip.tinhPhiShip(3, "noi_thanh", true),
                expected,
                0.01
        );
    }
}