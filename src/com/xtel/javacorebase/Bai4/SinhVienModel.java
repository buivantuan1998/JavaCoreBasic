package com.xtel.javacorebase.Bai4;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.xtel.javacorebase.Bai4.SinhVienModel;

public class SinhVienModel {
	
	//Lay thong tin sinh vien
	public List<SinhVien> getInfoSinhVien() {
		Connection conn= null;
		CallableStatement callst = null;
		List<SinhVien> listsinhvien = new ArrayList<SinhVien>();
		ResultSet rs = null;
		try {
			conn = ConnectionDB.openConnection();
			callst = conn.prepareCall("{ call PKG_SINHVIEN.get_info_student(?,?,?)}");
			int i =1;
			callst.registerOutParameter(i++, Types.INTEGER);
			callst.registerOutParameter(i++, 12);
			callst.registerOutParameter(i++, -10);
			callst.execute();
			rs =(ResultSet)callst.getObject(3);
			if(rs != null) {
				while(rs.next()) {
					SinhVien sv = new SinhVien();
					sv.setId(rs.getInt("ID"));
					sv.setTenSV(rs.getString("STUDENT_NAME"));
					sv.setGioiTinh(rs.getInt("GENDER"));
					sv.setQueQuan(rs.getString("ADDRESS"));
					sv.setTuoi(rs.getInt("AGE"));
					listsinhvien.add(sv);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			ConnectionDB.closeConnection(conn, callst);
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
		return listsinhvien;
	}
	
//	them moi sinh vien
	public void insertSinhVien(SinhVien sv) throws IOException{
		Connection conn = null;
		CallableStatement callst = null;
		try {
			conn = ConnectionDB.openConnection();
			callst = conn.prepareCall("{call PKG_SINHVIEN.insert_sinhvien(?,?,?,?,?,?,?)}");
			int i=1;
			callst.registerOutParameter(i++, Types.INTEGER);
			callst.registerOutParameter(i++, Types.VARCHAR);
			callst.registerOutParameter(i++, Types.VARCHAR);
			callst.registerOutParameter(i++, Types.INTEGER);
			callst.registerOutParameter(i++, Types.VARCHAR);
			callst.registerOutParameter(i++, Types.INTEGER);
			callst.registerOutParameter(i++, Types.INTEGER);
			callst.setString(3, sv.getTenSV());
			callst.setInt(4, sv.getGioiTinh());
			callst.setString(5, sv.getQueQuan());
			callst.setInt(6, sv.getTuoi());
			
			callst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			ConnectionDB.closeConnection(conn, callst);
		}
	}
}
