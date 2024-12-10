package btjava;

import java.util.ArrayList;
import java.util.List;

public class ThuVien implements QuanLySach{
private int id;
private String tenThuVien;
private List<Sach> danhSachSachTrongThuVien;

public ThuVien(int id, String tenThuVien) {
	this.id = id;
	this.tenThuVien = tenThuVien;
	this.danhSachSachTrongThuVien = new ArrayList<>();
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getTenThuVien() {
	return tenThuVien;
}

public void setTenThuVien(String tenThuVien) {
	this.tenThuVien = tenThuVien;
}

public List<Sach> getDanhSachSachTrongThuVien() {
	return danhSachSachTrongThuVien;
}

public void setDanhSachSachTrongThuVien(List<Sach> danhSachSachTrongThuVien) {
	this.danhSachSachTrongThuVien = danhSachSachTrongThuVien;
}

@Override
public void themSachMoi(Sach sach) {
	danhSachSachTrongThuVien.add(sach);
	System.out.println("Da them sach: " + sach);
	
}

@Override
public void xoaSach(int id) {
	Sach sachToRemove = null;
	for(Sach sach : danhSachSachTrongThuVien) {
		if(sach.getId()==id) {
			sachToRemove=sach;
			break;
		}
	}
	if(sachToRemove != null) {
		danhSachSachTrongThuVien.remove(sachToRemove);
		System.out.println("Da xoa sach: " + sachToRemove);
	}else {
		System.out.println("Khong tim thay sach co id " + id);
	}
}

@Override
public Sach timKiemSach(String tenSach) {
	for(Sach sach:danhSachSachTrongThuVien) {
		if(sach.getTieuDe().contains(tenSach) || sach.getTacGia().contains(tenSach)) {
			return sach;
		}
	}
	return null;
}

@Override
public void hienThiDanhSachSach() {
	System.out.println("Danh sach sach trong thu vien " + tenThuVien + ":");
	for(Sach sach:danhSachSachTrongThuVien) {
		System.out.println(sach);
	}
}
public String toString() {
	return"id=" + id
			+"tenThuVien=" + tenThuVien 
			+"tongSoSach=" + danhSachSachTrongThuVien.size() ;
}
}
