package com.delivery.servebyte.projections;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public interface DeliveryCompanyResponseInterface {

    String getName();
    String getLogo();
    String getEmail();
    String getPhone_Number();
    Timestamp getCreated_On();
    List<ChannelSummary> getChannels();

    interface ChannelSummary {
        String getName();
        BigDecimal getPrice();
    }
}
