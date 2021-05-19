package io.github.javicano.phishing.filter;

public class Features extends PhishingTerms {
	
	private final static int NUMBER_OF_ATTRIBUTES = 18;
	
	
	
	/**
	 * Checks if the email body contains HTML content.
	 */
	private boolean htmlBody;
	
	/**
	 * Checks if the email body contains javascript script tag.
	 */
	private boolean scriptTag;
	
	/**
	 * The number of URLs consisting of hexadecimal characters in the email.
	 */
	private int hexadecimalURLs;
	
	/**
	 * The number of domains in the URLs that exists in the email.
	 */
	private int domainsCount;
	
	/**
	 * The maximum number of dots that exist in a URL in the email.
	 */
	private int dotsCount;
	
	
	/**
	 * The number of image URLs.
	 */
	private int imagesAsURL;
	
	/**
	 * The number of URLs whose domain is specified as an IP address.
	 */
	private int ipUrls;
	
	
	/**
	 * A weight that is assigned to each email and represents
	 * the sum of weights of the phishing terms that exists in that email
	 */
	private double phishingTermsWeight;
	
	/**
	 * 
	 */
	private boolean domainSender;
	
	
	/**
	 * Class attribute
	 */
	private boolean isPhishing;
	


	public boolean isHtmlBody() {
		return htmlBody;
	}

	public void setHtmlBody(boolean htmlBody) {
		this.htmlBody = htmlBody;
	}
	
	public boolean isScriptTag() {
		return scriptTag;
	}

	public void setScriptTag(boolean scriptTag) {
		this.scriptTag = scriptTag;
	}

	public int getHexadecimalURLs() {
		return hexadecimalURLs;
	}

	public void setHexadecimalURLs(int hexadecimalURLs) {
		this.hexadecimalURLs = hexadecimalURLs;
	}

	public int getDomainsCount() {
		return domainsCount;
	}

	public void setDomainsCount(int domainsCount) {
		this.domainsCount = domainsCount;
	}

	public int getDotsCount() {
		return dotsCount;
	}

	public void setDotsCount(int dotsCount) {
		this.dotsCount = dotsCount;
	}

	public int getImagesAsURL() {
		return imagesAsURL;
	}

	public void setImagesAsURL(int imagesAsURL) {
		this.imagesAsURL = imagesAsURL;
	}

	public int getIpUrls() {
		return ipUrls;
	}

	public void setIpUrls(int ipUrls) {
		this.ipUrls = ipUrls;
	}

	public double getPhishingTermsWeight() {
		return phishingTermsWeight;
	}

	public void setPhishingTermsWeight(double phishingTermsWeight) {
		this.phishingTermsWeight = phishingTermsWeight;
	}
	
	public boolean isPhishing() {
		return isPhishing;
	}

	public void setPhishing(boolean isPhishing) {
		this.isPhishing = isPhishing;
	}
	
	public boolean isDomainSender() {
		return domainSender;
	}

	public void setDomainSender(boolean domainSender) {
		this.domainSender = domainSender;
	}
	
	public String[] fieldNames() {
		String[] fieldNames = new String[NUMBER_OF_ATTRIBUTES];
		fieldNames[0] = "htmlBody";
		fieldNames[1] = "scriptTag";
		fieldNames[2] = "hexadecimalURLs";
		fieldNames[3] = "domainsCount";
		fieldNames[4] = "dotsCount";
		fieldNames[5] = "isAccountTerm";
		fieldNames[6] = "isDearTeam";
		fieldNames[7] = "imagesAsURL";
		fieldNames[8] = "ipUrls";
		fieldNames[9] = "isPayPalTerm";
		fieldNames[10] = "isLoginTerm";
		fieldNames[11] = "isBankTerm";
		fieldNames[12] = "isVerifyTerm";
		fieldNames[13] = "isAgreeTerm";
		fieldNames[14] = "isSuspendTerm";
		fieldNames[15] = "phishingTermsWeight";
		fieldNames[16] = "domainSender";
		fieldNames[17] = "isPhishing";
		return fieldNames;
	}
	
	public String[] toArray() {
		String[] featuresArr = new String[NUMBER_OF_ATTRIBUTES];
		// htmlBody
		featuresArr[0] = this.htmlBody ? "True" : "False";
		// scriptTag
		featuresArr[1] = this.scriptTag ? "True" : "False";
		// hexadecimalURLs
		featuresArr[2] = String.valueOf(this.hexadecimalURLs);
		// domainsCount
		featuresArr[3] = String.valueOf(this.domainsCount);
		// dotsCount
		featuresArr[4] = String.valueOf(this.dotsCount);
		// isAccountTerm
		featuresArr[5] = this.isAccountTerm() ? "True" : "False";
		// isDearTeam
		featuresArr[6] = this.isDearTerm() ? "True" : "False";
		// imagesAsURL
		featuresArr[7] = String.valueOf(this.imagesAsURL);
		// ipUrls
		featuresArr[8] = String.valueOf(this.ipUrls);
		// isPayPalTerm
		featuresArr[9] = this.isPayPalTerm() ? "True" : "False";
		// isLoginTerm
		featuresArr[10] = this.isLoginTerm() ? "True" : "False";
		// isBankTerm
		featuresArr[11] = this.isBankTerm() ? "True" : "False";
		// isVerifyTerm
		featuresArr[12] = this.isVerifyTerm() ? "True" : "False";
		// isAgreeTerm
		featuresArr[13] = this.isAgreeTerm() ? "True" : "False";
		// isSuspendTerm
		featuresArr[14] = this.isSuspendTerm() ? "True" : "False";
		// phishingTermsWeight
		featuresArr[15] = String.valueOf(this.phishingTermsWeight);
		// domainSender
		featuresArr[16] = this.domainSender ? "True" : "False";
		// Class field
		featuresArr[17] = this.isPhishing ? "True" : "False";
		
		return featuresArr;
	}
	

}
