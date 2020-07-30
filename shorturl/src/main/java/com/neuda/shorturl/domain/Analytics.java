package com.neuda.shorturl.domain;

import java.util.Date;

public class Analytics {

	private String shortUrlId;
	
	private Metric metric;
	
	private Date created;

	public String getShortUrlId() {
		return shortUrlId;
	}

	public void setShortUrlId(String shortUrlId) {
		this.shortUrlId = shortUrlId;
	}

	public Metric getMetric() {
		return metric;
	}

	public void setMetric(Metric metric) {
		this.metric = metric;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	
	
}
