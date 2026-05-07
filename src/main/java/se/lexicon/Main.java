package se.lexicon;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.calculator.ExpressInternationalShipping;
import se.lexicon.calculator.StandardDomesticShipping;
import se.lexicon.config.ShippingCostCalculatorConfig;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCalculatorFactory;
import se.lexicon.service.ShippingCostCalculator;
import se.lexicon.service.ShippingService;

import java.util.List;

public class Main {
    static void main() {

        IO.println("=== Creating Beans ===");

//        ApplicationContext context = new AnnotationConfigApplicationContext(ShippingCostCalculatorConfig.class);

        //Pricing for DEV
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.register(ShippingCostCalculatorConfig.class);
        context.refresh();

        ShippingService shippingService = context.getBean(ShippingService.class);

        ShippingRequest domesticStandardRequest = new ShippingRequest(Destination.DOMESTIC, Speed.STANDARD, 10.0);
        ShippingRequest internationalExpressRequest = new ShippingRequest(Destination.INTERNATIONAL, Speed.EXPRESS, 15.0);
        ShippingRequest lightDomesticRequest = new ShippingRequest(Destination.DOMESTIC, Speed.STANDARD, 5.0);
        ShippingRequest heavyInternationalExpressRequest = new ShippingRequest(Destination.INTERNATIONAL, Speed.EXPRESS, 20.0);
        // Test new Strategies
        ShippingRequest domesticExpress = new ShippingRequest(Destination.DOMESTIC, Speed.EXPRESS, 10);
        ShippingRequest internationalStandard = new ShippingRequest(Destination.INTERNATIONAL, Speed.STANDARD, 10);

        IO.println("\n=== Shipping Quote ===");

        IO.println("Domestic Standard (10kg)");
        IO.println("Estimated Charge: " + shippingService.quote(domesticStandardRequest));

        IO.println();

        IO.println("International Express (15kg)");
        IO.println("Estimated Charge: " + shippingService.quote(internationalExpressRequest));

        IO.println();

        IO.println("Domestic Standard (5kg)");
        IO.println("Estimated Charge: " + shippingService.quote(lightDomesticRequest));

        IO.println();

        IO.println("International Express (20kg)");
        IO.println("Estimated Charge: " + shippingService.quote(heavyInternationalExpressRequest));

        IO.println();

        IO.println("Domestic Express (10kg)");
        IO.println("Estimated Charge: " + shippingService.quote(domesticExpress));

        IO.println();

        IO.println("International Standard (10kg)");
        IO.println("Estimated Charge: " + shippingService.quote(internationalStandard));
    }
}
