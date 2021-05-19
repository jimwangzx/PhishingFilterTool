package io.github.javicano.phishing.filter;

import java.lang.reflect.Field;

@SuppressWarnings("unused")
class PhishingTermsFrequency {
	
	private static final int NUMBER_OF_PHISHING_TERMS = 19;
	
	private int accountCount = 0;
	
	private double accountTW = 33.157894;
	
	private int dearCount = 0;
	
	private double dearTW = 22.894737;
	
	private int paypalCount = 0;
	
	private double paypalTW = 2.7894738;
	
	private int loginCount = 0;
	
	private double loginTW = 6.631579;
	
	private int bankCount = 0;
	
	private double bankTW = 8.105263;
	
	private int verifyCount = 0;
	
	private double verifyTW = 10.736842;
	
	private int agreeCount = 0;
	
	private double agreeTW = 1.5789474;
	
	private int suspendCount = 0;
	
	private double suspendTW = 0.7894737;
	
	private int clickCount = 0;
	
	private double clickTW = 25.31579;
	
	private int passcodeCount = 0;
	
	private double passcodeTW = 5.5789475;
	
	private int hereCount = 0;
	
	private double hereTW = 17.157894;
	
	private int updateCount = 0;
	
	private double updateTW = 18.789474;
	
	private int helloCount = 0;
	
	private double helloTW = 3.5263157;
	
	private int requestCount = 0;
	
	private double requestTW = 6.5263157; 
	
	private int purchaseCount = 0;
	
	private double purchaseTW = 0.8947368; 
	
	private int urgentCount = 0;
	
	private double urgentTW = 2.368421; 
	
	private int importantCount = 0;
	
	private double importantTW = 15.157895; 
	
	private int payrollCount = 0;
	
	private double payrollTW = 0.42105263; 
	
	private int paymentCount = 0;
	
	private double paymentTW = 6.7894735; 


	public void increaseAccountCount() {
		this.accountCount ++;
	}

	public void increaseDearCount() {
		this.dearCount ++;
	}

	public void increasePaypalCount() {
		this.paypalCount ++;
	}

	public void increaseLoginCount() {
		this.loginCount ++;
	}

	public void increaseBankCount() {
		this.bankCount ++;
	}

	public void increaseVerifyCount() {
		this.verifyCount ++;
	}

	public void increaseAgreeCount() {
		this.agreeCount ++;
	}

	public void increaseSuspendCount() {
		this.suspendCount ++;
	}
	
	public void increaseClickCount() {
		this.clickCount ++;
	}
	
	public void increasePasscodeCount() {
		this.passcodeCount ++;
	}

	public void increaseHereCount() {
		this.hereCount ++;
	}
	
	public void increaseUpdateCount() {
		this.updateCount ++;
	}
	
	public void increaseHelloCount() {
		this.helloCount ++;
	}
	
	public void increaseRequestCount() {
		this.requestCount ++;
	}
	
	public void increasePurchaseCount() {
		this.purchaseCount ++;
	}
	
	public void increaseUrgentCount() {
		this.urgentCount ++;
	}
	
	public void increaseImportantCount() {
		this.importantCount ++;
	}

	public void increasePayrollCount() {
		this.payrollCount ++;
	}
	
	public void increasePaymentCount() {
		this.paymentCount ++;
	}
	
	public void getPhishingTermsFrequency() {
		System.out.println("accountCount: TDF=" + accountCount + " TW=" + accountCount/19);
		System.out.println("dearCount: TDF=" + dearCount + " TW=" + dearCount/19);
		System.out.println("paypalCount: TDF=" + paypalCount + " TW=" + paypalCount/19);
		System.out.println("loginCount: TDF=" + loginCount + " TW=" + loginCount/19);
		System.out.println("bankCount: TDF=" + bankCount + " TW=" + bankCount/19);
		System.out.println("verifyCount: TDF=" + verifyCount + " TW=" + verifyCount/19);
		System.out.println("agreeCount: TDF=" + agreeCount + " TW=" + agreeCount/19);
		System.out.println("suspendCount: TDF=" + suspendCount + " TW=" + suspendCount/19);
		System.out.println("clickCount: TDF=" + clickCount + " TW=" + clickCount/19);
		System.out.println("passcodeCount: TDF=" + passcodeCount + " TW=" + passcodeCount/19);
		System.out.println("hereCount: TDF=" + hereCount + " TW=" + hereCount/19);
		System.out.println("updateCount: TDF=" + updateCount + " TW=" + updateCount/19);
		System.out.println("helloCount: TDF=" + helloCount + " TW=" + helloCount/19);
		System.out.println("requestCount: TDF=" + requestCount + " TW=" + requestCount/19);
		System.out.println("purchaseCount: TDF=" + purchaseCount + " TW=" + purchaseCount/19);
		System.out.println("urgentCount: TDF=" + urgentCount + " TW=" + urgentCount/19);
		System.out.println("importantCount: TDF=" + importantCount + " TW=" + importantCount/19);
		System.out.println("payrollCount: TDF=" + payrollCount + " TW=" + payrollCount/19);
		System.out.println("paymentCount: TDF=" + paymentCount + " TW=" + paymentCount/19);		
	}

	public double getPhishingTermsWeight(Features features) {
		double totalWeight = 
				(features.isAccountTerm() ? this.accountTW : 0) +
				(features.isDearTerm() ? this.dearTW : 0) +
				(features.isPayPalTerm() ? this.paypalTW : 0) +
				(features.isLoginTerm() ? this.loginTW : 0) +
				(features.isBankTerm() ? this.bankTW : 0) +
				(features.isVerifyTerm() ? this.verifyTW : 0) +
				(features.isAgreeTerm() ? this.agreeTW : 0) +
				(features.isSuspendTerm() ? this.suspendTW : 0) +
				(features.isClickTerm() ? this.clickTW : 0) +
				(features.isPasscodeTerm() ? this.passcodeTW : 0) +
				(features.isHereTerm() ? this.hereTW : 0) +
				(features.isUpdateTerm() ? this.updateTW : 0) +
				(features.isHelloTerm() ? this.helloTW : 0) +
				(features.isRequestTerm() ? this.requestTW : 0) +
				(features.isPurchaseTerm() ? this.purchaseTW : 0) +
				(features.isUrgentTerm() ? this.urgentTW : 0) +
				(features.isImportantTerm() ? this.importantTW : 0) +
				(features.isPayrollTerm() ? this.payrollTW : 0) +
				(features.isPaymentTerm() ? this.paymentTW : 0);
		return totalWeight/NUMBER_OF_PHISHING_TERMS;
	}
	
	
	

}
