package com.moviebooking.booking.pricing;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PriceCalculator {

    private static final BigDecimal PRICE_PER_SEAT =
            BigDecimal.valueOf(250);

    public BigDecimal calculate(int seatCount) {
        return PRICE_PER_SEAT.multiply(
                BigDecimal.valueOf(seatCount)
        );
    }
}
