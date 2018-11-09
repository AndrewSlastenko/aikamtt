package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.OrderDAO;
import model.OrderPosition;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	public OrderDAO orderDAO;
	
	@GetMapping("")
	public String index() {
		return "index";
	}
	
	@GetMapping("orders")
	public String getAll(Model model) {
		model.addAttribute("orders", orderDAO.findAll());
		return "ordersPage";
	}
	
	@GetMapping("order/{id}")
	public String getOrderDetail(@PathVariable("id") long id, Model model) {
		List<OrderPosition> orderPositions =  orderDAO.findById(id);
		double orderSum = 0;
		for (OrderPosition pos : orderPositions) 
			orderSum += pos.getTotal();
		model.addAttribute("orderNumber", id);
		model.addAttribute("orderPositions", orderPositions);
		model.addAttribute("orderSum", orderSum);
		return "orderDetailPage";
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		model.addAttribute("message", e.getMessage());
		return "errorPage";
	}

}
