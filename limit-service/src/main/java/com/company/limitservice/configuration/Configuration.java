package com.company.limitservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@org.springframework.context.annotation.Configuration
@ConfigurationProperties("limits-service")
public class Configuration {
	
	public int minimum;
	public int maximum;
	
	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

}
