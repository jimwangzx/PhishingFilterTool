package io.github.javicano.phishing.filter;

public final class PhishingFilterFactory {

	private PhishingFilterFactory() {}
	
	public static PhishingFilter getInstance() {
		return new PhishingFilterImpl();
	}
}
