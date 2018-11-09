package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Order;
import org.springframework.jdbc.core.RowMapper;

public class OrderNumberMapper implements RowMapper<Long> {

	@Override
	public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
		return rs.getLong("id");
		}
	
}
