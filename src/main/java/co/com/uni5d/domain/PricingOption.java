package co.com.uni5d.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PricingOption {
	
	@JsonView
	private Double Price;
	@JsonView
	private String DeeplinkUrl;
	
	
	
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public String getDeeplinkUrl() {
		return DeeplinkUrl;
	}
	public void setDeeplinkUrl(String deeplinkUrl) {
		DeeplinkUrl = deeplinkUrl;
	}
	@Override
	public String toString() {
		return "PricingOption [Price=" + Price + ", DeeplinkUrl=" + DeeplinkUrl + "]";
	}

	
	
}
