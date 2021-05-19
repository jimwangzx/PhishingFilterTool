package io.github.javicano.phishing.filter;

import java.io.IOException;

import org.apache.james.mime4j.MimeException;

import hex.genmodel.MojoModel;
import hex.genmodel.easy.EasyPredictModelWrapper;
import hex.genmodel.easy.RowData;
import hex.genmodel.easy.exception.PredictException;
import hex.genmodel.easy.prediction.BinomialModelPrediction;

class PhishingFilterImpl implements PhishingFilter {
	
	PhishingFilterImpl() {
		
	}

	@Override
	public Features getFeatures(String emailPath) {
		EmailParser emailParser = new EmailParser();
		try {
			return emailParser.getEmailFeatures(emailPath);
		} catch (StackOverflowError | MimeException | IOException e) {
			e.printStackTrace();
		}
		return new Features();
	}

	@Override
	public boolean isPhishingEmail(String email) {
		EasyPredictModelWrapper model;
		try {
			String path = "/Users/jcano/Documents/phishing-email-detection/PhishingFilterTool/src/main/java/io/github/javicano/phishing/filter/StackedEnsemble_AllModels_AutoML_20210516_182200.zip";
			model = new EasyPredictModelWrapper(MojoModel.load(path));
			
			RowData row = new RowData();
			row.put("htmlBody", "True");
			row.put("scriptTag", "True");
			row.put("hexadecimalURLs", "0");
			row.put("domainsCount", "7");
			row.put("dotsCount", "3");
			row.put("isAccountTerm", "False");
			row.put("isDearTeam", "False");
			row.put("imagesAsURL", "121");
			row.put("ipUrls", "0");
			row.put("isPayPalTerm", "True");
			row.put("isLoginTerm", "False");
			row.put("isBankTerm", "False");
			row.put("isVerifyTerm", "False");
			row.put("isAgreeTerm", "False");
			row.put("isSuspendTerm", "False");
			row.put("phishingTermsWeight", "2.382271463157895");
			row.put("domainSender", "False");
			
			/*row.put("htmlBody", "True");
			row.put("scriptTag", "False");
			row.put("hexadecimalURLs", "0");
			row.put("domainsCount", "3");
			row.put("dotsCount", "3");
			row.put("isAccountTerm", "True");
			row.put("isDearTeam", "True");
			row.put("imagesAsURL", "0");
			row.put("ipUrls", "0");
			row.put("isPayPalTerm", "True");
			row.put("isLoginTerm", "False");
			row.put("isBankTerm", "False");
			row.put("isVerifyTerm", "True");
			row.put("isAgreeTerm", "False");
			row.put("isSuspendTerm", "False");
			row.put("phishingTermsWeight", "7.6842105157894744");
			row.put("domainSender", "False");*/

			BinomialModelPrediction p = model.predictBinomial(row);
			System.out.println("Has penetrated the prostatic capsule (1=yes; 0=no): " + p.label);
			System.out.print("Class probabilities: ");
			for (int i = 0; i < p.classProbabilities.length; i++) {
				if (i > 0) {
					System.out.print(",");
				}
				System.out.print(p.classProbabilities[i]);
			}
			System.out.println("");
			return p.label.equalsIgnoreCase("1") ? true : false;
		
		} catch (PredictException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	     
	}

}
