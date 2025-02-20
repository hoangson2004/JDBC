package test;

import java.util.ArrayList;

import dao.KhachHangDAO;
import dao.SachDAO;
import model.KhachHang;
import model.Sach;

public class TestSachDAO {
	public static void main(String[] args) {
//		Sach sach1 = new Sach("Kame", "7 vien ngoc rong", 50000, 2000);
//		Sach sach2 = new Sach("Galic", "Trai dat", 80000, 2011);
//		
//		SachDAO.getInstance().insert(sach2);
//		for (int i = 0; i < 1000; i++) {
//			Sach sach = new Sach("LT" + i, "Lap trinh "+ i, 20000+i*100, 2015);
//			SachDAO.getInstance().insert(sach);
//		}
		
		
//		Sach  sach2 = new Sach("LT1","Lap trinh 000", 100000, 2020);
//		SachDAO.getInstance().update(sach2);
		
//		for (int i = 10; i<1000; i++) {
//			Sach  sach = new Sach("LT"+i,"Lap trinh", 100000, 2020);
//			SachDAO.getInstance().delete(sach);
//		}
		
		ArrayList<Sach> list = SachDAO.getInstance().selectAll();
		for (Sach sach: list) {
			System.out.println(sach.toString());
		}
		
		System.out.println("-----------------");
		 
		Sach find = new Sach();
		find.setId("LT6");
		Sach sach3 = SachDAO.getInstance().selectById(find);
		System.out.println(sach3);
		
		System.out.println("-----------------");

		ArrayList<KhachHang> list2 = KhachHangDAO.getInstance().selectAll();
		for (KhachHang kh : list2) {
			System.out.println(kh.toString());
		}
	}
}
