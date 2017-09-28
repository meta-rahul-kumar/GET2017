package main.java.com.metacube.layeredArchitecture.dao.product;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.metacube.layeredArchitecture.dao.GenericJdbcDao;
import main.java.com.metacube.layeredArchitecture.model.Product;

public class JdbcProductDao extends GenericJdbcDao<Product> implements ProductDao {

	protected String getTableName() {
		return "products";
	}

	protected Product extractResultSetRow(ResultSet resultSet) {
		Product product = new Product();

		try {
			product.setId(resultSet.getInt("id"));
			product.setName(resultSet.getString("name"));
			product.setPrice(resultSet.getFloat("price"));
			product.setSeller(resultSet.getString("seller"));
			product.setThumbnail(resultSet.getString("thumbnail"));
			product.setQuantity(resultSet.getInt("quantity"));
			product.setRating(resultSet.getFloat("rating"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return product;
	}

	protected String getPrimaryKeyColoumnName() {
		return "id";
	}
}
