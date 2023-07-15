package pms.pojo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductDAO {
	Connection conn = DBUtil.getDBConnection();

	public int addProduct(Product pdt) {

		String insertQuery = "insert into product values(?,?,?,?)";

		int count = 0;

		try {
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);

			pstmt.setInt(1, pdt.getPid());
			pstmt.setString(2, pdt.getPname());
			pstmt.setDouble(3, pdt.getPrice());
			pstmt.setDate(4, pdt.getDom());

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	public int updateProduct(Product pdt) {

		String updateQuery = "update product set pname =? , price =? , dom =? where pid = ?";

		int count = 0;

		try {
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);

			pstmt.setString(1, pdt.getPname());
			pstmt.setDouble(2, pdt.getPrice());
			pstmt.setDate(4, pdt.getDom());
			pstmt.setInt(3, pdt.getPid());

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;

	}

	public Product getProduct(int pdID) {

		String selectQuery = "select * from product where pid = ?";

		Product pdt = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectQuery);

			pstmt.setInt(1, pdID);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				double price = rs.getDouble("price");
				Date dom = rs.getDate("dom");

				pdt = new Product();
				pdt.setPid(pid);
				pdt.setPname(pname);
				pdt.setPrice(price);
				pdt.setDom(dom);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pdt;
	}

	public int deleteProduct(int pdID) {

		// delete from dept where dno = ?;

		String deleteQuery = "delete from product where pid = ?";

		int count = 0;

		try {
			PreparedStatement pstmt = conn.prepareStatement(deleteQuery);

			pstmt.setInt(1, pdID);

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;

	}

	public List<Product> getAll() {

		String selectAllQuery = "select * from product";

		List<Product> list = new ArrayList<Product>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(selectAllQuery);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				double price = rs.getDouble("price");
				Date dom = rs.getDate("dom");

				Product pdt = new Product();
				list.add(pdt);

				pdt.setPid(pid);
				pdt.setPname(pname);
				pdt.setPrice(price);
				pdt.setDom(dom);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
}
