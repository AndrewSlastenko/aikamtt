package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.OrderPosition;

public class OrderPositionMapper implements RowMapper<OrderPosition> {

	@Override
	public OrderPosition mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderPosition entity = new OrderPosition();
		entity.setItemId(rs.getLong("id"));
		entity.setName(rs.getString("name"));
		entity.setPrice(rs.getDouble("price"));
		entity.setCount(rs.getInt("count"));
		entity.setTotal(rs.getDouble("total"));
		return entity;
	}

}
