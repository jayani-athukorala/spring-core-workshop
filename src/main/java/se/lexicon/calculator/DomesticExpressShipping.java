package se.lexicon.calculator;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCostCalculator;

@Component
public class DomesticExpressShipping implements ShippingCostCalculator {

    @Value("${domestic.express.base}")
    private double baseCost;

    @Value("${domestic.express.perkg}")
    private double costPerKg;

    @PostConstruct
    public void init() {
        IO.println("✅ DomesticExpressShipping bean created.");
    }

    @Override
    public boolean supports(ShippingRequest r) {
        return r.destination() == Destination.DOMESTIC && r.speed() == Speed.EXPRESS;
    }

    @Override
    public double calculate(ShippingRequest r) {
        return baseCost + costPerKg * r.weightKg();
    }
}
