package dao;
import java.util.List;

import model.OrderPosition;

public interface OrderDAO {
	public List<Long> findAll();
	public List<OrderPosition> findById(long id);
}
