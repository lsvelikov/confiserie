package com.example.confiserie.service.impl;

import com.example.confiserie.model.entity.OrderPaymentMethod;
import com.example.confiserie.model.enums.OrderPaymentMethodEnum;
import com.example.confiserie.repository.OrderPaymentMethodRepository;
import com.example.confiserie.service.OrderPaymentService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderPaymentServiceImpl implements OrderPaymentService {

    private final OrderPaymentMethodRepository orderPaymentMethodRepository;

    public OrderPaymentServiceImpl(OrderPaymentMethodRepository orderPaymentMethodRepository) {
        this.orderPaymentMethodRepository = orderPaymentMethodRepository;
    }

    @Override
    public void orderPaymentMethodInit() {

        if (orderPaymentMethodRepository.count() == 0) {

            Arrays.stream(OrderPaymentMethodEnum.values())
                    .forEach(o -> {
                        OrderPaymentMethod orderPaymentMethod = new OrderPaymentMethod();
                        orderPaymentMethod.setName(o);
                        orderPaymentMethod.setOrder(List.of());

                        orderPaymentMethodRepository.save(orderPaymentMethod);
                    });
        }
    }
}
