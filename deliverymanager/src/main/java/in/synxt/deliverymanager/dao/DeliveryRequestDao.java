package in.synxt.deliverymanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.synxt.deliverymanager.entity.DeliveryRequest;

@Repository
public interface DeliveryRequestDao extends JpaRepository<DeliveryRequest,Integer> {

}
