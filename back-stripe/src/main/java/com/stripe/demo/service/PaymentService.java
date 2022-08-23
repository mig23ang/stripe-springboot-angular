/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stripe.demo.service;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.demo.http.PaymentIntentDTO;
import com.stripe.exception.StripeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author miguel-pc
 */
@Service
public class PaymentService {

    @Value("$stripe.key.secret")
    String secretKey;

    //creamos el paymentIntent luego agregamos los campos basicos que pide la documentacion de stripe
    public PaymentIntent paymentIntent(PaymentIntentDTO paymentIntentDTO) throws StripeException {

        Stripe.apiKey = secretKey;
        Map<String, Object> params = new HashMap<>();
        params.put("amountt", paymentIntentDTO.getAmount());
        params.put("currency", paymentIntentDTO.getCurrency());
        params.put("description", paymentIntentDTO.getDescription());
        ArrayList payment_method_types = new ArrayList<>();
        payment_method_types.add("card");
        params.put("payment_method_types", payment_method_types);
        return PaymentIntent.create(params);
    }

    //aca recuperamos el pago creado, confirmamos el pago y el tipo de pago en este caso tarjeta
    public PaymentIntent confirm(String id) throws StripeException {

        Stripe.apiKey = secretKey;
        PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
        Map<String, Object> params = new HashMap<>();
        params.put("payment_method_types", "pm_card_visa");
        paymentIntent.confirm(params);
        return paymentIntent;
    }

    //cancelamos el pago
    public PaymentIntent cancel(String id) throws StripeException {

        Stripe.apiKey = secretKey;
        PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
        paymentIntent.cancel();
        return paymentIntent;
    }
}
