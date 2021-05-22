package io.github.javicano.phishing.filter;

import java.io.File;
import java.io.IOException;

import org.apache.james.mime4j.MimeException;

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
     * @throws StackOverflowError 
     * @throws IOException 
     * @throws MimeException 
     */
	Features getFeatures(File email) throws MimeException, IOException, StackOverflowError;
	
    /**
     * Returns a boolean indicating is email is phishing 
     *
     * @param email 
     * @return isPhishing
     * @throws MimeException 
     * @throws StackOverflowError 
     */
	boolean isPhishingEmail(File email) throws StackOverflowError, MimeException;
	

}
