package io.github.javicano.phishing.filter;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FeaturesUtilsTest {

    @Test
    public void test_hasHTMLTags_method(){
    	Assert.assertFalse(FeaturesUtils.hasHTMLTags("Hi, how are you today Regards \n"));
    	Assert.assertTrue(FeaturesUtils.hasHTMLTags("Hi, how are you today Regards <script>alert('Hei')</script>"));
    	Assert.assertTrue(FeaturesUtils.hasHTMLTags("Hi, how are you today </br> Regards"));
    	Assert.assertTrue(FeaturesUtils.hasHTMLTags("Hi, how are you today <customTag> Regards"));
    }
    
    @Test
    public void test_hasURLs_method(){	
    	List<String> result = FeaturesUtils.getURLs("Hi, "
    			+ "how are you today? "
    			+ "This are the links: "
    			+ "1.- http://10.15.22.2:8080/link1 "
    			+ "2.- https://10.15.22.2/link2 "
    			+ "3.- https://domain.com/link2 "
    			+ "4.- https://ivalidDomain/link2");
    	List<String> expected = new ArrayList<String>();
    	expected.add(" http://10.15.22.2:8080/link1");
    	expected.add(" https://10.15.22.2/link2");
    	expected.add(" https://domain.com/link2");
    	
    	Assert.assertArrayEquals(result.toArray(), expected.toArray());
    }
    
    @Test
    public void test_isTerm_account(){
    	String textWithAccount = "Please, add your ._ AcCount. number";
    	String textWithoutAccount = "He emphasized that accountability is not only about supply but also about demand.";
    	Assert.assertTrue(FeaturesUtils.isTerm(PhishingTerms.ACCOUNT_TERM, textWithAccount));
    	Assert.assertFalse(FeaturesUtils.isTerm(PhishingTerms.ACCOUNT_TERM, textWithoutAccount));
    }
    
    @Test
    public void test_isTerm_dear(){
    	String textWithDear = "Dear customer";
    	String textWithoutDear = "Deardrops is the name of the band";
    	Assert.assertTrue(FeaturesUtils.isTerm(PhishingTerms.DEAR_TERM, textWithDear));
    	Assert.assertFalse(FeaturesUtils.isTerm(PhishingTerms.DEAR_TERM, textWithoutDear));
    }
    
    @Test
    public void test_isTerm_paypal(){
    	String textWithPaypal = "Please, introduce your paypal credentials";
    	String textWithoutPaypal = "Just for testing purpose";
    	Assert.assertTrue(FeaturesUtils.isTerm(PhishingTerms.PAYPAL_TERM, textWithPaypal));
    	Assert.assertFalse(FeaturesUtils.isTerm(PhishingTerms.PAYPAL_TERM, textWithoutPaypal));
    }
    
    @Test
    public void test_isTerm_login(){
    	String textWithLogin = "Please, access to login page";
    	String textWithoutLogin = "Just for testing purpose";
    	Assert.assertTrue(FeaturesUtils.isTerm(PhishingTerms.LOGIN_TERM, textWithLogin));
    	Assert.assertFalse(FeaturesUtils.isTerm(PhishingTerms.LOGIN_TERM, textWithoutLogin));
    }
    
    @Test
    public void test_isTerm_bank(){
    	String textWithBank = "Please, access to your bank website";
    	String textWithoutBank = "Just for testing purpose";
    	Assert.assertTrue(FeaturesUtils.isTerm(PhishingTerms.BANK_TERM, textWithBank));
    	Assert.assertFalse(FeaturesUtils.isTerm(PhishingTerms.BANK_TERM, textWithoutBank));
    }
	
    @Test
    public void test_isTerm_verify(){
    	String textWithVerify = "Please verify your acces credentials";
    	String textWithoutVerify = "Just for testing purpose";
    	Assert.assertTrue(FeaturesUtils.isTerm(PhishingTerms.VERIFY_TERM, textWithVerify));
    	Assert.assertFalse(FeaturesUtils.isTerm(PhishingTerms.VERIFY_TERM, textWithoutVerify));
    }
	
    @Test
    public void test_isTerm_agree(){
    	String textWithAgree = "Do you agree with the new condition terms?";
    	String textWithoutAgree = "Just for testing purpose";
    	Assert.assertTrue(FeaturesUtils.isTerm(PhishingTerms.AGREE_TERM, textWithAgree));
    	Assert.assertFalse(FeaturesUtils.isTerm(PhishingTerms.AGREE_TERM, textWithoutAgree));
    }
	
    @Test
    public void test_isTerm_suspend(){
    	String textWithSuspend = "Unfortunately we are going to suspend your account";
    	String textWithoutSuspend = "Just for testing purpose";
    	Assert.assertTrue(FeaturesUtils.isTerm(PhishingTerms.SUSPEND_TERM, textWithSuspend));
    	Assert.assertFalse(FeaturesUtils.isTerm(PhishingTerms.SUSPEND_TERM, textWithoutSuspend));
    }
    
    @Test
    public void test_numberOfIpsURLs_method(){
    	String text = "http://123.168.10.1/ \n" + 
    			"http://123.168.10.2/ \n" + 
    			"http://123.168.10.3/";
    	Assert.assertEquals(FeaturesUtils.numberOfIpUrls(text), 3);
    }
    
    @Test
    public void test_numberOfImagesAsURL_method(){
    	String text = "https://s1.pir.fm/pf/blog/articles/How-to-copy-a-web-page-link-or-URL-1800x980.png \n" + 
    			"http://s2.pir.fm/pf/blog/articles/How-to-copy-a-web-page-link-or-URL-1800x980.jpeg \n" + 
    			"http://s3.pir.fm/pf/blog/articles/How-to-copy-a-web-page-link-or-URL-1800x980.jpg \n" + 
    			"http://s4.pir.fm/pf/blog/articles/How-to-copy-a-web-page-link-or-URL-1800x980.pdf";
    	Assert.assertEquals(FeaturesUtils.numberOfImageAsURL(text), 3);
    }
    
    @Test
    public void test_matchDomainSender_method(){
    	String from = "Robert Elz <kre@munnari.OZ.AU>";
    	String messageId = "<13258.1030015585@munnari.OZ.AU>";
    	Assert.assertTrue(FeaturesUtils.matchDomainSender(from, messageId));
    	from = "Robert Elz <kre@munnari.ZZ.AU>";
    	Assert.assertFalse(FeaturesUtils.matchDomainSender(from, messageId));
    }
    
    @Test
    public void test_mumberOfDomainsInUrls_method(){
    	String email= "https://play.google.com/store/apps/details?id=com.skgames.trafficracer%22\n" +
    			"id=com.skgames.trafficracer%22\n" +
    			"http://mplay.google.co.in/sadfask/asdkfals?dk=10 \n" + 
    			"http://lplay.google.co.in/sadfask/asdkfals?dk=10\n" + 
    			"http://play.google.co.in/sadfask/asdkfals?dk=10\n" + 
    			"http://play.google.co.in/sadfask/asdkfals?dk=10\n" + 
    			"http://www.google.co.in/sadfask/asdkfals?dk=10\n";
    	Assert.assertEquals(FeaturesUtils.numberOfDomainsInUrls(email), 5);
    }
    
    @Test
    public void test_maxNumberOfDotsInUrl_method(){
    	String email= "https://play.google.com/store/apps/details?id=com.skgames.trafficracer%22\n" +
    			"id=com.skgames.trafficracer%22\n" +
    			"http://mplay.google.co.in.es.com.tv/sadfask/asdkfals?dk=10 \n" + 
    			"http://lplay.google.co.in/sadfask/asdkfals?dk=10\n" + 
    			"http://play.google.co.in/sadfask/asdkfals?dk=10\n" + 
    			"http://play.google.co.in/sadfask/asdkfals?dk=10\n" + 
    			"http://www.google.co.in/sadfask/asdkfals?dk=10\n";
    	Assert.assertEquals(FeaturesUtils.maxNumberOfDotsInUrl(email), 6);
    }

}
