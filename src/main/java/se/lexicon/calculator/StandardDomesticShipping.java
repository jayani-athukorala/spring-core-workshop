package se.lexicon.calculator;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCostCalculator;

@Component
public class StandardDomesticShipping implements ShippingCostCalculator {

    @Value("${domestic.standard.base}")
    private double baseCost;

    @Value("${domestic.standard.perkg}")
    private double costPerKg;

    @PostConstruct
    public void init() {
        IO.println("✅ StandardDomesticShipping bean created.");
    }

    @Override
    public boolean supports(ShippingRequest r) {
        return r.destination() == Destination.DOMESTIC && r.speed() == Speed.STANDARD;
    }

    @Override
    public double calculate(ShippingRequest r) {
        return baseCost + costPerKg * r.weightKg();
    }
}