package com.delivery.servebyte.controllers.dto.channelDTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ChannelRequest {
    private String channelName;
    private BigDecimal price;
}
