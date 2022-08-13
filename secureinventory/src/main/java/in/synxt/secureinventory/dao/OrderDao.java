package in.synxt.secureinventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.synxt.secureinventory.entities.Order;
@Repository
public interface OrderDao extends JpaRepository<Order,Integer>{
	Order findByOrderPid(String orderPid);
}
