package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.AddressPoint;
import entity.Merchant;
import util.DatabaseUtil;

public class MerchantDao {
	public void findAll() {

	}

	/**
	 * 根据商家名称查询数据库返回商家地址坐标.
	 * 
	 * @param mName
	 * @return
	 */
	public AddressPoint getMerchantIdByName(String mName) {
		/*
		 * 从数据库读取所有信息
		 */
		List<Merchant> merchants = new ArrayList<Merchant>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getDataSourceConnection();
			String xSql = "select * from test01";
			ps = conn.prepareStatement(xSql);
			rs = ps.executeQuery();
			System.out.println("start query");
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String line = rs.getString(3);
				String[] data = line.split(",");
				AddressPoint ap = new AddressPoint();
				ap.setLng(Double.parseDouble(data[0]));
				ap.setLat(Double.parseDouble(data[1]));
				Merchant m = new Merchant();
				m.setMerchantId(id);
				m.setMerchantName(name);
				m.setMerchantAddressPoint(ap);
				merchants.add(m);
			}
			System.out.println(merchants.size());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeDataSource(conn, ps, rs);
			System.out.println("close done");
		}
		/*
		 * 遍历对比查找
		 */
		for (Merchant m : merchants) {
			if (mName.equals(m.getMerchantName())) {
				System.out.println("m.getMerchantName():" + m.getMerchantName());
				return m.getMerchantAddressPoint();
			}
		}
		return null;
	}

}