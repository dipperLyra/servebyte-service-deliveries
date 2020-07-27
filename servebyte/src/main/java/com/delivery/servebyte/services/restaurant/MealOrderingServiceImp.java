package com.delivery.servebyte.services.restaurant;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/*
/ specify customer location, meal id and quantity
/ check that restaurant is available for location
/
/ calculate the meal price based on quantity + delivery cost
/ prompt user to pay total cost
/ make a Paystack api call with the user's card
/ save transaction,
/ send email for successful payment
// if there's free sms and WhatsApp services, use them as well.
 */
public class MealOrderingServiceImp {

    public MealOrderingServiceImp() throws IOException {

        URL url = new URL("www.ibeh.com");
        URLConnection connection = url.openConnection();
    }
}
