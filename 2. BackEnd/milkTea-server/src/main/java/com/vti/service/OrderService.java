package com.vti.service;

import com.vti.entity.Orders;
import com.vti.form.OrderFilterForm;
import com.vti.form.OrderFormForCreatingOrUpdate;
import com.vti.repository.IOrderRepository;
import com.vti.specification.OrdersSpectification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;


     @Override
    public Page<Orders> getAllOrder ( Pageable pageable, OrderFilterForm form ) {
//        return orderRepository.findAll(OrdersSpectification.buildWhere(form),pageable);
         Specification<Orders> where = null;
         if (!StringUtils.isEmpty(form)) {
             OrdersSpectification nameSpecification = new OrdersSpectification("name", "LIKE", form);
             OrdersSpectification priceSpecification = new OrdersSpectification("price", "LIKE", form);
             OrdersSpectification infoSpecification = new OrdersSpectification("info", "LIKE", form);
             OrdersSpectification categorySpecification = new OrdersSpectification("category", "LIKE", form);
             where = Specification.where(nameSpecification).or(priceSpecification).or(infoSpecification)
                     .or(categorySpecification);
         }
         return orderRepository.findAll(where, pageable);

     }
    @Override
    public Orders getOrderById ( int id ) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Orders createOrUpdateOrder ( OrderFormForCreatingOrUpdate form ) {
//        Account account
//        Products product

//        return orderRepository.save(form.toProductReviews());
        return null;
    }

    @Override
    public void deleteOrder ( int id ) {
        orderRepository.deleteById(id);
    }

    @Override
    public int deleteManyOrder ( List<Integer> idDeleteList ) {
        return orderRepository.deleteManyReviews(idDeleteList);
    }
}
