package com.delivery.servebyte.dto.channelDTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ChannelRequest {
    private String channelName;
    private BigDecimal price;
}
