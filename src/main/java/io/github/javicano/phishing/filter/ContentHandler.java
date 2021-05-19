package io.github.javicano.phishing.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.parser.AbstractContentHandler;
import org.apache.james.mime4j.stream.BodyDescriptor;
import org.apache.james.mime4j.stream.Field;

class ContentHandler extends AbstractContentHandler {
	
	private final static String FROM = "From";
	
	private final static String MESSAGE_ID = "Message-Id";
	
	private final static String SUBJECT = "Subject";
	
	private String subject = "";
	
	private String fullBody = "";
	
	private String from;
	
	private String messageId;
	
	private Features features = new Features();
    
    public void endHeader() throws MimeException {
    	features.setDomainSender(FeaturesUtils.matchDomainSender(from, messageId));
    }
    
    public void field(Field field) throws MimeException {
    	if(field.getName().equalsIgnoreCase(FROM)) {
    		this.from = field.getBody();
    	}
    	if(field.getName().equalsIgnoreCase(MESSAGE_ID)) {
    		this.messageId = field.getBody();
    	}
    	if(field.getName().equalsIgnoreCase(SUBJECT)) {
    		this.subject = field.getBody();
    	}
    }
	
	public void body(BodyDescriptor bd, InputStream is)
            throws MimeException, IOException {
		
        String bodyStr = new BufferedReader(
        	      new InputStreamReader(is, StandardCharsets.UTF_8))
        	        .lines()
        	        .collect(Collectors.joining("\n"));
        
        fullBody = fullBody + bodyStr;
    }
	
    public void endMessage() throws MimeException {
    	features.setHtmlBody(FeaturesUtils.hasHTMLTags(fullBody));
        features.setScriptTag(FeaturesUtils.hasScriptTag(fullBody));
        features.setHexadecimalURLs(FeaturesUtils.numberOfUrlsWithHexaChars(FeaturesUtils.getURLs(fullBody)));
        features.setDomainsCount(FeaturesUtils.numberOfDomainsInUrls(fullBody));
        features.setDotsCount(FeaturesUtils.maxNumberOfDotsInUrl(fullBody));
        features.setImagesAsURL(FeaturesUtils.numberOfImageAsURL(fullBody));
        //Account Term
        features.setAccountTerm(FeaturesUtils.isTerm(PhishingTerms.ACCOUNT_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.ACCOUNT_TERM, subject));
        //Agree Term
        features.setAgreeTerm(FeaturesUtils.isTerm(PhishingTerms.AGREE_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.AGREE_TERM, subject) || 
        		FeaturesUtils.isTerm(PhishingTerms.AGREEMENT_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.AGREEMENT_TERM, subject));
        //Bank Term
        features.setBankTerm(FeaturesUtils.isTerm(PhishingTerms.BANK_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.BANK_TERM, subject) ||
        		FeaturesUtils.isTerm(PhishingTerms.BANKS_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.BANKS_TERM, subject) ||
        		FeaturesUtils.isTerm(PhishingTerms.BANKING_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.BANKING_TERM, subject));
        //Dear Term
        features.setDearTeam(FeaturesUtils.isTerm(PhishingTerms.DEAR_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.DEAR_TERM, subject));
        //Login Term     
        features.setLoginTerm(FeaturesUtils.isTerm(PhishingTerms.LOGIN_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.LOGIN_TERM, subject));
        //Paypal Term
        features.setPayPalTerm(FeaturesUtils.isTerm(PhishingTerms.PAYPAL_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.PAYPAL_TERM, subject));
        //Suspend Term
        features.setSuspendTerm(FeaturesUtils.isTerm(PhishingTerms.SUSPEND_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.SUSPEND_TERM, subject) ||
        		FeaturesUtils.isTerm(PhishingTerms.SUSPENDED_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.SUSPENDED_TERM, subject));
        //Verify Term
        features.setVerifyTerm(FeaturesUtils.isTerm(PhishingTerms.VERIFY_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.VERIFY_TERM, subject) ||
        		FeaturesUtils.isTerm(PhishingTerms.VERIFIED_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.VERIFIED_TERM, subject));
        //Suspend Term
        features.setSuspendTerm(FeaturesUtils.isTerm(PhishingTerms.SUSPEND_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.SUSPEND_TERM, subject));
        //Click Term
        features.setClickTerm(FeaturesUtils.isTerm(PhishingTerms.CLICK_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.CLICK_TERM, subject) || 
        		FeaturesUtils.isTerm(PhishingTerms.CLICKING_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.CLICKING_TERM, subject));
        //Passcode Term
        features.setPasscodeTerm(FeaturesUtils.isTerm(PhishingTerms.PASSWORD_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.PASSWORD_TERM, subject) ||
        		FeaturesUtils.isTerm(PhishingTerms.PASSCODE_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.PASSCODE_TERM, subject));
        //Here Term
        features.setHereTerm(FeaturesUtils.isTerm(PhishingTerms.HERE_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.HERE_TERM, subject));
        //Update Term
        features.setUpdateTerm(FeaturesUtils.isTerm(PhishingTerms.UPDATE_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.UPDATE_TERM, subject) ||
        		FeaturesUtils.isTerm(PhishingTerms.UPDATED_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.UPDATED_TERM, subject));
        //Hello Term
        features.setHelloTerm(FeaturesUtils.isTerm(PhishingTerms.HELLO_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.HELLO_TERM, subject));
        //Request Term
        features.setRequestTerm(FeaturesUtils.isTerm(PhishingTerms.REQUEST_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.REQUEST_TERM, subject));
        //Purchase Term
        features.setPurchaseTerm(FeaturesUtils.isTerm(PhishingTerms.PURCHASE_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.PURCHASE_TERM, subject));
        //Urgent Term
        features.setUrgentTerm(FeaturesUtils.isTerm(PhishingTerms.URGENT_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.URGENT_TERM, subject));
        //Important Term
        features.setImportantTerm(FeaturesUtils.isTerm(PhishingTerms.IMPORTANT_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.IMPORTANT_TERM, subject));
        //Payroll Term
        features.setPayrollTerm(FeaturesUtils.isTerm(PhishingTerms.PAYROLL_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.PAYROLL_TERM, subject));
        //Payment Term
        features.setPaymentTerm(FeaturesUtils.isTerm(PhishingTerms.PAYMENT_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.PAYMENT_TERM, subject) ||
        		FeaturesUtils.isTerm(PhishingTerms.PAYMENTS_TERM, fullBody) || FeaturesUtils.isTerm(PhishingTerms.PAYMENTS_TERM, subject));
        
        PhishingTermsFrequency phishingTermsFrequency = new PhishingTermsFrequency();
        features.setPhishingTermsWeight(phishingTermsFrequency.getPhishingTermsWeight(features));
    }
    
	public Features getFeatures() {		
    	return this.features;
    }

}
