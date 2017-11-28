package com.letsdecode.problems.cuncurrency;

public class RateLimiter {
	private WebResource webResouce;

	public RateLimiter(WebResource webresouce) {
		this.webResouce = webresouce;
	}

	interface WebResource {
		float getRate(String resourceKey);
	}
}
