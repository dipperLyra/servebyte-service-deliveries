package com.delivery.servebyte.dto.restaurantDTO;

public enum Cities {

    ABUJA("Abuja"),
    INDIA("India"),
    LAGOS("Lagos"),
    IBADAN("Ibadan"),
    UYO("Uyo"),
    PORT_HARCOURT("Port Harcourt"),
    ENUGU("Enugu"),
    ASABA("Asaba"),
    KANO("Kano"),
    UMUAHIA("Umuahia"),
    ONITSHA("Onitsha"),
    ABA("Aba"),
    OWERRI("Owerri");

    private final String displayName;

    Cities(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
