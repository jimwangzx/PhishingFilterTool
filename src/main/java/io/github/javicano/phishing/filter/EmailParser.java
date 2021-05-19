package io.github.javicano.phishing.filter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.parser.MimeStreamParser;

class EmailParser extends MimeStreamParser {
	
	private ContentHandler contentHandler;
	
	private void parseFile(String filePath) throws FileNotFoundException, MimeException, IOException, StackOverflowError {
		contentHandler = new ContentHandler();
		this.setContentHandler(contentHandler);
		this.parse(new FileInputStream(filePath));
	}
	
	public Features getEmailFeatures(String filePath) throws FileNotFoundException, MimeException, IOException, StackOverflowError {
		this.parseFile(filePath);
		return contentHandler.getFeatures();
	}

}
