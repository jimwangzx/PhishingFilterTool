package io.github.javicano.phishing.filter;

class PhishingTerms {
	
	public static final String ACCOUNT_TERM = "account";
	
	public static final String AGREE_TERM = "agree";
	public static final String AGREEMENT_TERM = "agreement";
	
	public static final String BANK_TERM = "bank";
	public static final String BANKS_TERM = "banks";
	public static final String BANKING_TERM = "banking";
	
	public static final String DEAR_TERM = "dear";
	
	public static final String LOGIN_TERM = "login";
	
	public static final String PAYPAL_TERM = "paypal";
	
	public static final String SUSPEND_TERM = "suspend";
	public static final String SUSPENDED_TERM = "suspended";
	
	public static final String VERIFY_TERM = "verify";
	public static final String VERIFIED_TERM = "verified";

	public static final String CLICK_TERM = "click";
	public static final String CLICKING_TERM = "clicking";

	public static final String PASSCODE_TERM = "passcode";
	public static final String PASSWORD_TERM = "password";

	public static final String HERE_TERM = "here";

	public static final String UPDATE_TERM = "update";
	public static final String UPDATED_TERM = "updated";

	public static final String HELLO_TERM = "hello";

	public static final String REQUEST_TERM = "request";

	public static final String PURCHASE_TERM = "purchase";

	public static final String URGENT_TERM = "urgent";

	public static final String IMPORTANT_TERM = "important";

	public static final String PAYROLL_TERM = "payroll";

	public static final String PAYMENT_TERM = "payment";
	public static final String PAYMENTS_TERM = "payments";

	
	
	/**
	 * Checks if the email contains the term “Account”
	 */
	private boolean isAccountTerm;
	
	/**
	 * Checks if the email contains the term “Dear”
	 */
	private boolean isDearTeam;
	
	/**
	 * Checks if the email contains the term “PayPal”
	 */
	private boolean isPayPalTerm;
	
	/**
	 * Checks if the email contains the term “Login”
	 */
	private boolean isLoginTerm;
	
	/**
	 * Checks if the email contains the term “Bank”
	 */
	private boolean isBankTerm;
	
	
	/**
	 * Checks if the email contains the term “Verify”
	 */
	private boolean isVerifyTerm;
	
	/**
	 * Checks if the email contains the term “Agree”
	 */
	private boolean isAgreeTerm;
	
	/**
	 * Checks if the email contains the term “Suspend”
	 */
	private boolean isSuspendTerm;
	
	/**
	 * Checks if the email contains the term “Click”
	 */
	private boolean isClickTerm;
	
	/**
	 * Checks if the email contains the term “PassCode”
	 */
	private boolean isPasscodeTerm;
	
	/**
	 * Checks if the email contains the term “Here”
	 */
	private boolean isHereTerm;
	
	/**
	 * Checks if the email contains the term “Update”
	 */
	private boolean isUpdateTerm;
	
	/**
	 * Checks if the email contains the term “Hello”
	 */
	private boolean isHelloTerm;
	
	/**
	 * Checks if the email contains the term “Request”
	 */
	private boolean isRequestTerm;
	
	/**
	 * Checks if the email contains the term “Purchase”
	 */
	private boolean isPurchaseTerm;
	
	/**
	 * Checks if the email contains the term “Urgent”
	 */
	private boolean isUrgentTerm;
	
	/**
	 * Checks if the email contains the term “Important”
	 */
	private boolean isImportantTerm;
	
	/**
	 * Checks if the email contains the term “Payroll”
	 */
	private boolean isPayrollTerm;
	
	/**
	 * Checks if the email contains the term “Payment”
	 */
	private boolean isPaymentTerm;
	
	
	public boolean isAccountTerm() {
		return isAccountTerm;
	}

	public void setAccountTerm(boolean isAccountTerm) {
		this.isAccountTerm = isAccountTerm;
	}

	public boolean isDearTerm() {
		return isDearTeam;
	}

	public void setDearTeam(boolean isDearTeam) {
		this.isDearTeam = isDearTeam;
	}
	
	public boolean isPayPalTerm() {
		return isPayPalTerm;
	}

	public void setPayPalTerm(boolean isPayPalTerm) {
		this.isPayPalTerm = isPayPalTerm;
	}

	public boolean isLoginTerm() {
		return isLoginTerm;
	}

	public void setLoginTerm(boolean isLoginTerm) {
		this.isLoginTerm = isLoginTerm;
	}

	public boolean isBankTerm() {
		return isBankTerm;
	}

	public void setBankTerm(boolean isBankTerm) {
		this.isBankTerm = isBankTerm;
	}

	public boolean isVerifyTerm() {
		return isVerifyTerm;
	}

	public void setVerifyTerm(boolean isVerifyTerm) {
		this.isVerifyTerm = isVerifyTerm;
	}

	public boolean isAgreeTerm() {
		return isAgreeTerm;
	}

	public void setAgreeTerm(boolean isAgreeTerm) {
		this.isAgreeTerm = isAgreeTerm;
	}

	public boolean isSuspendTerm() {
		return isSuspendTerm;
	}

	public void setSuspendTerm(boolean isSuspendTerm) {
		this.isSuspendTerm = isSuspendTerm;
	}

	public boolean isClickTerm() {
		return isClickTerm;
	}

	public void setClickTerm(boolean isClickTerm) {
		this.isClickTerm = isClickTerm;
	}

	public boolean isPasscodeTerm() {
		return isPasscodeTerm;
	}

	public void setPasscodeTerm(boolean isPasscodeTerm) {
		this.isPasscodeTerm = isPasscodeTerm;
	}

	public boolean isHereTerm() {
		return isHereTerm;
	}

	public void setHereTerm(boolean isHereTerm) {
		this.isHereTerm = isHereTerm;
	}

	public boolean isUpdateTerm() {
		return isUpdateTerm;
	}

	public void setUpdateTerm(boolean isUpdateTerm) {
		this.isUpdateTerm = isUpdateTerm;
	}

	public boolean isHelloTerm() {
		return isHelloTerm;
	}

	public void setHelloTerm(boolean isHelloTerm) {
		this.isHelloTerm = isHelloTerm;
	}

	public boolean isRequestTerm() {
		return isRequestTerm;
	}

	public void setRequestTerm(boolean isRequestTerm) {
		this.isRequestTerm = isRequestTerm;
	}

	public boolean isPurchaseTerm() {
		return isPurchaseTerm;
	}

	public void setPurchaseTerm(boolean isPurchaseTerm) {
		this.isPurchaseTerm = isPurchaseTerm;
	}

	public boolean isUrgentTerm() {
		return isUrgentTerm;
	}

	public void setUrgentTerm(boolean isUrgentTerm) {
		this.isUrgentTerm = isUrgentTerm;
	}

	public boolean isImportantTerm() {
		return isImportantTerm;
	}

	public void setImportantTerm(boolean isImportantTerm) {
		this.isImportantTerm = isImportantTerm;
	}

	public boolean isPayrollTerm() {
		return isPayrollTerm;
	}

	public void setPayrollTerm(boolean isPayrollTerm) {
		this.isPayrollTerm = isPayrollTerm;
	}

	public boolean isPaymentTerm() {
		return isPaymentTerm;
	}

	public void setPaymentTerm(boolean isPaymentTerm) {
		this.isPaymentTerm = isPaymentTerm;
	}

}
