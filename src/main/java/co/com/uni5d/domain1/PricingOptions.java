package co.com.uni5d.domain1;

import java.util.ArrayList;

import lombok.Data;

@Data
public class PricingOptions {


    private ArrayList<Agents> Agents;

    private String QuoteAgeInMinutes;

    private String DeeplinkUrl;

    private Double Price;
}
