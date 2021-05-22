package io.github.javicano.phishing.filter;

import java.io.File;

import java.io.IOException;
import java.net.URL;

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
	public Features getFeatures(File email) throws MimeException, IOException, StackOverflowError {
		EmailParser emailParser = new EmailParser();
		return emailParser.getEmailFeatures(email.getPath());
	}

	@Override
	public boolean isPhishingEmail(File email) throws StackOverflowError, MimeException {
		EasyPredictModelWrapper model;
		try {
			URL url = getClass().getClassLoader().getResource("./models/StackedEnsemble_AllModels_AutoML_20210516_182200.zip");
			model = new EasyPredictModelWrapper(MojoModel.load(url.getPath()));
			
			Features features = this.getFeatures(email);
			
			RowData row = new RowData();
			String[] fieldNames = features.fieldNames();
			String[] featuresArray = features.toArray();
			for (int i = 0; i < fieldNames.length; i ++) {
				row.put(fieldNames[i], featuresArray[i]);
			}
			
			BinomialModelPrediction p = model.predictBinomial(row);	
			System.out.println("Class probabilities: ");
			for (int i = 0; i < p.classProbabilities.length; i++) {
				if (i == 0) {
					System.out.println("  False:" + p.classProbabilities[i]);
				} else if ( i == 1) {
					System.out.println("  True:" + p.classProbabilities[i]);
				}
				
			}
			System.out.println("Is phishing?: " + p.label);
			System.out.println("");
			return p.label.equalsIgnoreCase("1") ? true : false;
		
		} catch (PredictException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	     
	}

}
