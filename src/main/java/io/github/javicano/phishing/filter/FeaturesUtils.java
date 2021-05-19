package io.github.javicano.phishing.filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FeaturesUtils {
	
	private static final Pattern EMAIL_DOMAIN_PATTERN = Pattern.compile("(?<=@)[a-zA-Z0-9\\.]+(?<=)");
	
	private static final String HTML_PATTERN = "<(\"[^\"]*\"|'[^']*'|[^'\">])*>";
	
	private static final Pattern IP_PATTERN = Pattern.compile("\\b(?:[0-9]{1,3}\\.){3}[0-9]{1,3}\\b");
	
	private static final String SCRIPT_PATTERN = "<script[\\s\\S]*?>[\\s\\S]*?<\\/script>";
	
	// Pattern for recognizing a URL, based off RFC 3986
	private static final Pattern URL_PATTERN = Pattern.compile(
		        "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
		                + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
		                + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)",
		        Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
	
	private static final Pattern URL_DOMAIN_PATTERN = Pattern.compile("(https?://)([^:^/]*)(:\\\\d*)?(.*)?");
	
	private static final Pattern URL_IMAGES_PATTERM = Pattern.compile("https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)(.jpeg|.jpg|.png|.tif|.tiff|.bmp|.gif|.eps|.raw)");
	

	
	public static boolean hasHTMLTags(String email){
		Pattern pattern = Pattern.compile(HTML_PATTERN);
	    Matcher matcher = pattern.matcher(email);
	    return matcher.find();
	}
	
	public static boolean hasScriptTag(String email){
		Pattern pattern = Pattern.compile(SCRIPT_PATTERN);
	    Matcher matcher = pattern.matcher(email.toLowerCase());
	    return matcher.find();
	}
	
	public static boolean hasURL(String email){
	    Matcher matcher = URL_PATTERN.matcher(email);
	    return matcher.find();
	}
	
	public static List<String> getURLs(String email){
		List<String> urls = new ArrayList<String>();
		Matcher matcher = URL_PATTERN.matcher(email);
		while(matcher.find()) {
			urls.add(matcher.group());
		}
		return urls;
	}
	
	public static int numberOfUrlsWithHexaChars(List<String> urls) {
		String [] hexaChars = {"24","26","2C","2F","3A","3B","3D","3F","40","20","22","3C","3E","23","25","7B","7D","7C","5C","5E","7E","5B","5D","60"}; 
		int counter = 0;
		for(String url: urls) {
			for(String hexaChar: hexaChars) {
				if(url.contains("%" + hexaChar)) {
					counter++;
				}
			}
		}
		return counter;
	}
	
	public static boolean isTerm(String term, String email){
		String IS_TERM_PATTERN = "\\b" + term.toLowerCase() + "\\b";
		Pattern pattern = Pattern.compile(IS_TERM_PATTERN);
		Matcher matcher = pattern.matcher(email.toLowerCase());
		return matcher.find();
	}
	
	public static int numberOfImageAsURL(String email){
		Matcher matcher = URL_IMAGES_PATTERM.matcher(email.toLowerCase());
		return matcher.results().toArray().length;
	}
		
	public static int numberOfIpUrls(String text){
		Matcher matcher = IP_PATTERN.matcher(text.toLowerCase());
		return matcher.results().toArray().length;
	}
	

	public static boolean matchDomainSender(String from, String messageId){
		boolean result = false;
		if(from != null && !from.equalsIgnoreCase("") && messageId != null && !messageId.equalsIgnoreCase("")) {
			Matcher fromMatcher = EMAIL_DOMAIN_PATTERN.matcher(from);
			Matcher messageIdMatcher = EMAIL_DOMAIN_PATTERN.matcher(messageId);
			if (fromMatcher.find() && messageIdMatcher.find()){
				String fromDomain = fromMatcher.group();
				String messageIdDomain = messageIdMatcher.group();
				if(!fromDomain.equalsIgnoreCase("") && !messageIdDomain.equalsIgnoreCase("")) {
					if(fromDomain.equalsIgnoreCase(messageIdDomain)) {
						result = true;
					}
					if(fromDomain.contains(messageIdDomain) || messageIdDomain.contains(fromDomain)) {
						result = true;
					}
					
				}
			}
		}
		return result;
		
	}
	
	public static int numberOfDomainsInUrls(String email) {
		Matcher urlDomainsMatcher = URL_DOMAIN_PATTERN.matcher(email);
		LinkedHashSet<String> hashSet = new LinkedHashSet<String>();
		while (urlDomainsMatcher.find()) {
			hashSet.add(urlDomainsMatcher.group(2));
		}
		return hashSet.size();
	}
	
	public static int maxNumberOfDotsInUrl(String email) {
		Matcher urlDomainsMatcher = URL_DOMAIN_PATTERN.matcher(email);
		List<Integer> numberOfDots = new ArrayList<Integer>();
		int count = 0;
		while (urlDomainsMatcher.find()) {
			String url = urlDomainsMatcher.group(2);
			numberOfDots.add(url.length() - url.replaceAll("[.]+", "").length());
		}
		if(numberOfDots.size() > 0) {
			Collections.sort(numberOfDots);
			count = numberOfDots.get(numberOfDots.size() - 1);
		}
		return count;
	}

}
