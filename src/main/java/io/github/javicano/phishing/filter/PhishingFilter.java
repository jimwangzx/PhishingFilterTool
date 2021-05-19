package io.github.javicano.phishing.filter;


/**
 * PhishingFilter
 * <p>
 * Provide the methods to extract the email features 
 */
public interface PhishingFilter {
	
    /**
     * Returns features from email 
     *
     * @param email 
     * @return features
     */
	Features getFeatures(String email);
	
    /**
     * Returns a boolean indicating is email is phishing 
     *
     * @param email 
     * @return isPhishing
     */
	boolean isPhishingEmail(String email);
	

}
