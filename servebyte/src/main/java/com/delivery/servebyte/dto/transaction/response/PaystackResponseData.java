package com.delivery.servebyte.dto.transaction.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaystackResponseData {

    @JsonProperty("authorization_url")
    private String authorizationUrl;

    @JsonProperty("access_code")
    private String accessCode;

    private String reference;
}
