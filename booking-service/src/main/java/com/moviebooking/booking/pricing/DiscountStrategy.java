package com.moviebooking.booking.pricing;

import java.math.BigDecimal;

public interface DiscountStrategy {
    boolean applies(BookingContext ctx);
    BigDecimal apply(BigDecimal amount);
}
