package com.course.project.repository;

import com.course.project.model.entity.OrderItem;
import com.course.project.model.entity.pk.OrdemItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrdemItemPK> {
}
