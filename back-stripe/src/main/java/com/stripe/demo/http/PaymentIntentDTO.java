/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stripe.demo.http;

import lombok.Data;

/**
 *
 * @author miguel-pc
 */
@Data
public class PaymentIntentDTO {

    public enum Currency {
        USD, EUR
    }
    private String description;
    private int amount;
    private Currency currency;
}
