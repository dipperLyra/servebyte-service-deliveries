package com.delivery.servebyte.persistence.repositories;

import com.delivery.servebyte.persistence.entities.DeliveryChannels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface DeliveryChannelRepository extends JpaRepository<DeliveryChannels, Long> {
}