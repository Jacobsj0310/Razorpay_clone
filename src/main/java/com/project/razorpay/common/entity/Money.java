package com.project.razorpay.common.entity;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
/* EMBEDDED MEANS WE CAN USE THE TABLE IN THE CLASSES ONLY MEANS THIS CLASSES IS USABLE IN OTHER TABLES*/
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Money {

    private int amountUnits;
    private String currency;

    public static Money of(int amountUnits, String currency){
        return new Money(amountUnits, currency);
    }

    private static Money inr(int amountUnits){
        return new Money(amountUnits , "INR");
    }

    public Money add(Money other){
        if(this.currency.equals(other.currency)){
            throw new IllegalArgumentException("Can't add money with different currencies");
        }
        return new Money(this.amountUnits + other.amountUnits, this.currency);
    }

    public Money subtract(Money other){
        if(this.currency.equals(other.currency)){
            throw new IllegalArgumentException("Can't add money with different currencies");
        }
        return new Money(this.amountUnits + other.amountUnits, this.currency);
    }
}
