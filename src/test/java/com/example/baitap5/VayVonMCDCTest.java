package com.example.baitap5;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VayVonMCDCTest {

    @Test(description="MC/DC - C1 thay đổi: tuoi < 22 làm kết quả false")
    public void testMCDC_TuoiDocLap_ThapHon22() {
        boolean result = VayVon.duDieuKienVay(20, 12000000, true, 750);
        Assert.assertFalse(result, "Tuổi < 22 thì không đủ điều kiện vay");
    }

    @Test(description="MC/DC - tất cả điều kiện đúng")
    public void testMCDC_AllTrue() {
        boolean result = VayVon.duDieuKienVay(25, 12000000, true, 750);
        Assert.assertTrue(result, "Đủ tuổi, đủ thu nhập, có tài sản -> được vay");
    }

    @Test(description="MC/DC - C4 thay đổi: credit < 700 nhưng có tài sản")
    public void testMCDC_CreditThapNhungCoTaiSan() {
        boolean result = VayVon.duDieuKienVay(25, 12000000, true, 650);
        Assert.assertTrue(result, "Có tài sản bảo lãnh nên vẫn được vay");
    }

    @Test(description="MC/DC - C3 thay đổi: không có tài sản nhưng credit >=700")
    public void testMCDC_KhongTaiSanNhungCreditTot() {
        boolean result = VayVon.duDieuKienVay(25, 12000000, false, 750);
        Assert.assertTrue(result, "Credit tốt nên vẫn được vay");
    }

    @Test(description="MC/DC - C3 và C4 đều sai -> không đủ điều kiện")
    public void testMCDC_KhongTaiSan_CreditThap() {
        boolean result = VayVon.duDieuKienVay(25, 12000000, false, 650);
        Assert.assertFalse(result, "Không tài sản và credit thấp -> không được vay");
    }
}