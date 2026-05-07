package se.lexicon.calculator;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCostCalculator;

@Component
public class InternationalStandardShipping implements ShippingCostCalculator {

    @Value("${international.standard.base}")
    private double baseCost;

    @Value("${international.standard.perkg}")
    private double costPerKg;

    @PostConstruct
    public void init() {
        IO.println("✅ InternationalStandardShipping bean created.");
    }

    @Override
    public boolean supports(ShippingRequest r) {
        return r.destination() == Destination.INTERNATIONAL
                && r.speed() == Speed.STANDARD;
    }

    @Override
    public double calculate(ShippingRequest r) {
        return baseCost + costPerKg * r.weightKg();
    }
}