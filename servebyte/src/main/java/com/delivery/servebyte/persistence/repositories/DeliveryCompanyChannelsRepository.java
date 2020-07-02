package com.delivery.servebyte.persistence.repositories;

import java.util.Optional;

import com.delivery.servebyte.persistence.entities.DeliveryCompanyChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeliveryCompanyChannelsRepository extends JpaRepository<DeliveryCompanyChannel, Long> {

    Optional<DeliveryCompanyChannel> findByDeliveryChannelIdAndDeliveryCompanyId(long deliveryChannelId, long deliveryCompanyId);
}
