package co.com.uni5d.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Itinerario {
	@JsonView
	private String OutboundLegId;
	@JsonView
	private List<PricingOption> PricingOptions;
	
	
	
	
	public String getOutboundLegId() {
		return OutboundLegId;
	}
	public void setOutboundLegId(String outboundLegId) {
		OutboundLegId = outboundLegId;
	}
	public List<PricingOption> getPricingOptions() {
		return PricingOptions;
	}
	public void setPricingOptions(List<PricingOption> pricingOptions) {
		PricingOptions = pricingOptions;
	}
	@Override
	public String toString() {
		return "Itinerario [OutboundLegId=" + OutboundLegId + ", PricingOptions=" + PricingOptions + "]";
	}
	
	
	
	

}
