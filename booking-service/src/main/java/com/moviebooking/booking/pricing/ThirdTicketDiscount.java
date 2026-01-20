package com.moviebooking.booking.pricing;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ThirdTicketDiscount implements DiscountStrategy {

    public boolean applies(BookingContext ctx) {
        return ctx.getSeatCount() >= 3;
    }

    public BigDecimal apply(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.5));
    }
}
