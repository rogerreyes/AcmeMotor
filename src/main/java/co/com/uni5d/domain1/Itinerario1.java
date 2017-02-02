package co.com.uni5d.domain1;

import java.util.ArrayList;

import lombok.Data;


@Data
public class Itinerario1
{
    private ArrayList<PricingOptions> PricingOptions;

    private InboundLegId InboundLegId;

    private BookingDetailsLink BookingDetailsLink;

    private String FormattedData;

    private OutboundLegId OutboundLegId;

   
}
	