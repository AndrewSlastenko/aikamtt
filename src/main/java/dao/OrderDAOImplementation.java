package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import model.OrderPosition;

public class OrderDAOImplementation implements OrderDAO {
	
	@Autowired
	public JdbcTemplate jdbcTemplate;

	public List<Long> findAll() {
		String request = "select distinct id from orders order by id asc;";
		return jdbcTemplate.query(request, new OrderNumberMapper());
	}

	public List<OrderPosition> findById(long id) {
		String request = "select i.id as id, i.name as name, i.price as price, o.count as count, (o.count*i.price) as total"
				+ " from items as i"
				+ " join orders as o on i.id = o.item_id"
				+ " where o.id = " + id +";";
		return jdbcTemplate.query(request, new OrderPositionMapper());
	}

}
