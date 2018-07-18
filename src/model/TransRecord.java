package model;

public class TransRecord {
	String  ORDERID;//0
	String  TRANS_STATUS;//1
	String  TRANS_INITATE_TIME;//2
	String  TRANS_END_TIME ;//3
	String  DEBIT_PARTY_ID ;//4
	String  DEBIT_PARTY_TYPE;//5
	String  DEBIT_PARTY_ACCOUNT;//6
	String  DEBIT_ACCOUNT_TYPE;//7
	String  DEBIT_PARTY_MNEMONIC;//8
	String  CREDIT_PARTY_ID;//9
	String  CREDIT_PARTY_TYPE;//10
	String  CREDIT_PARTY_ACCOUNT;//11
	String  CREDIT_ACCOUNT_TYPE;//12
	String  CREDIT_PARTY_MNEMONIC;//13
	String  EXPIRED_TIME;//14
	String  REQUEST_AMOUNT ;//15
	String  REQUEST_CURRENCY;//16
	String  EXCHANGE_RATE;//17
	String  ORG_AMOUNT;//18
	String  ACTUAL_AMOUNT;//19
	String  FEE;//20
	String  COMMISSION;//21
	String  TAX;//22
	String  ACCOUNT_UNIT_TYPE;//23
	String  CURRENCY;//24
	String  IS_REVERSED;//25
	String  REMARK ;//26
	String  IS_PARTIAL_REVERSED;//27
	String  IS_REVERSING;//28
	String  CHECKER_ID;//29
	String  REASON_TYPE;//30
	String  LAST_UPDATED_TIME;//31
	String  VERSION;//32
	String  LOAD_DATA_TS;//33
	String  ACCUMULATOR_UPDATE;//34
	String  ACCUMULATOR_REVERSAL;//35
	String  CHG_RATING_DETAILS;//36
	String  BANK_CARD_ID;//37
	String  BANK_ACCOUNT_NUMBER;//38
	String  BANK_ACCOUNT_NAME;//39
	String  FI_ACCOUNT_INFO;//40
	String  DISCOUNT_AMOUNT;//41
	String  REDEEMED_POINT_AMOUNT;//42
	String  REDEEMED_POINT_TYPE;//43
	
	// tambahan
	String msisdn_debit; //44
	String msisdn_credit; //45
	
	String lac_debit; //-1
	String ci_debit; //-1
	String lac_credit; //-1
	String ci_credit; //-1
	
	
	public TransRecord(){
		
	}
	
	
	
	public String getMsisdn_credit() {
		return msisdn_credit;
	}



	public void setMsisdn_credit(String msisdn_credit) {
		this.msisdn_credit = msisdn_credit;
	}



	public String getMsisdn_debit() {
		return msisdn_debit;
	}



	public void setMsisdn_debit(String msisdn_debit) {
		this.msisdn_debit = msisdn_debit;
	}



	public String getLac_debit() {
		return lac_debit;
	}



	public void setLac_debit(String lac_debit) {
		this.lac_debit = lac_debit;
	}



	public String getCi_debit() {
		return ci_debit;
	}



	public void setCi_debit(String ci_debit) {
		this.ci_debit = ci_debit;
	}



	public String getLac_credit() {
		return lac_credit;
	}



	public void setLac_credit(String lac_credit) {
		this.lac_credit = lac_credit;
	}



	public String getCi_credit() {
		return ci_credit;
	}



	public void setCi_credit(String ci_credit) {
		this.ci_credit = ci_credit;
	}



	public String getORDERID() {
		return ORDERID;
	}
	public void setORDERID(String oRDERID) {
		ORDERID = oRDERID;
	}
	public String getTRANS_STATUS() {
		return TRANS_STATUS;
	}
	public void setTRANS_STATUS(String tRANS_STATUS) {
		TRANS_STATUS = tRANS_STATUS;
	}
	public String getTRANS_INITATE_TIME() {
		return TRANS_INITATE_TIME;
	}
	public void setTRANS_INITATE_TIME(String tRANS_INITATE_TIME) {
		TRANS_INITATE_TIME = tRANS_INITATE_TIME;
	}
	public String getTRANS_END_TIME() {
		return TRANS_END_TIME;
	}
	public void setTRANS_END_TIME(String tRANS_END_TIME) {
		TRANS_END_TIME = tRANS_END_TIME;
	}
	public String getDEBIT_PARTY_ID() {
		return DEBIT_PARTY_ID;
	}
	public void setDEBIT_PARTY_ID(String dEBIT_PARTY_ID) {
		DEBIT_PARTY_ID = dEBIT_PARTY_ID;
	}
	public String getDEBIT_PARTY_TYPE() {
		return DEBIT_PARTY_TYPE;
	}
	public void setDEBIT_PARTY_TYPE(String dEBIT_PARTY_TYPE) {
		DEBIT_PARTY_TYPE = dEBIT_PARTY_TYPE;
	}
	public String getDEBIT_PARTY_ACCOUNT() {
		return DEBIT_PARTY_ACCOUNT;
	}
	public void setDEBIT_PARTY_ACCOUNT(String dEBIT_PARTY_ACCOUNT) {
		DEBIT_PARTY_ACCOUNT = dEBIT_PARTY_ACCOUNT;
	}
	public String getDEBIT_ACCOUNT_TYPE() {
		return DEBIT_ACCOUNT_TYPE;
	}
	public void setDEBIT_ACCOUNT_TYPE(String dEBIT_ACCOUNT_TYPE) {
		DEBIT_ACCOUNT_TYPE = dEBIT_ACCOUNT_TYPE;
	}
	public String getDEBIT_PARTY_MNEMONIC() {
		return DEBIT_PARTY_MNEMONIC;
	}
	public void setDEBIT_PARTY_MNEMONIC(String dEBIT_PARTY_MNEMONIC) {
		DEBIT_PARTY_MNEMONIC = dEBIT_PARTY_MNEMONIC;
	}
	public String getCREDIT_PARTY_ID() {
		return CREDIT_PARTY_ID;
	}
	public void setCREDIT_PARTY_ID(String cREDIT_PARTY_ID) {
		CREDIT_PARTY_ID = cREDIT_PARTY_ID;
	}
	public String getCREDIT_PARTY_TYPE() {
		return CREDIT_PARTY_TYPE;
	}
	public void setCREDIT_PARTY_TYPE(String cREDIT_PARTY_TYPE) {
		CREDIT_PARTY_TYPE = cREDIT_PARTY_TYPE;
	}
	public String getCREDIT_PARTY_ACCOUNT() {
		return CREDIT_PARTY_ACCOUNT;
	}
	public void setCREDIT_PARTY_ACCOUNT(String cREDIT_PARTY_ACCOUNT) {
		CREDIT_PARTY_ACCOUNT = cREDIT_PARTY_ACCOUNT;
	}
	public String getCREDIT_ACCOUNT_TYPE() {
		return CREDIT_ACCOUNT_TYPE;
	}
	public void setCREDIT_ACCOUNT_TYPE(String cREDIT_ACCOUNT_TYPE) {
		CREDIT_ACCOUNT_TYPE = cREDIT_ACCOUNT_TYPE;
	}
	public String getCREDIT_PARTY_MNEMONIC() {
		return CREDIT_PARTY_MNEMONIC;
	}
	public void setCREDIT_PARTY_MNEMONIC(String cREDIT_PARTY_MNEMONIC) {
		CREDIT_PARTY_MNEMONIC = cREDIT_PARTY_MNEMONIC;
	}
	public String getEXPIRED_TIME() {
		return EXPIRED_TIME;
	}
	public void setEXPIRED_TIME(String eXPIRED_TIME) {
		EXPIRED_TIME = eXPIRED_TIME;
	}
	public String getREQUEST_AMOUNT() {
		return REQUEST_AMOUNT;
	}
	public void setREQUEST_AMOUNT(String rEQUEST_AMOUNT) {
		REQUEST_AMOUNT = rEQUEST_AMOUNT;
	}
	public String getREQUEST_CURRENCY() {
		return REQUEST_CURRENCY;
	}
	public void setREQUEST_CURRENCY(String rEQUEST_CURRENCY) {
		REQUEST_CURRENCY = rEQUEST_CURRENCY;
	}
	public String getEXCHANGE_RATE() {
		return EXCHANGE_RATE;
	}
	public void setEXCHANGE_RATE(String eXCHANGE_RATE) {
		EXCHANGE_RATE = eXCHANGE_RATE;
	}
	public String getORG_AMOUNT() {
		return ORG_AMOUNT;
	}
	public void setORG_AMOUNT(String oRG_AMOUNT) {
		ORG_AMOUNT = oRG_AMOUNT;
	}
	public String getACTUAL_AMOUNT() {
		return ACTUAL_AMOUNT;
	}
	public void setACTUAL_AMOUNT(String aCTUAL_AMOUNT) {
		ACTUAL_AMOUNT = aCTUAL_AMOUNT;
	}
	public String getFEE() {
		return FEE;
	}
	public void setFEE(String fEE) {
		FEE = fEE;
	}
	public String getCOMMISSION() {
		return COMMISSION;
	}
	public void setCOMMISSION(String cOMMISSION) {
		COMMISSION = cOMMISSION;
	}
	public String getTAX() {
		return TAX;
	}
	public void setTAX(String tAX) {
		TAX = tAX;
	}
	public String getACCOUNT_UNIT_TYPE() {
		return ACCOUNT_UNIT_TYPE;
	}
	public void setACCOUNT_UNIT_TYPE(String aCCOUNT_UNIT_TYPE) {
		ACCOUNT_UNIT_TYPE = aCCOUNT_UNIT_TYPE;
	}
	public String getCURRENCY() {
		return CURRENCY;
	}
	public void setCURRENCY(String cURRENCY) {
		CURRENCY = cURRENCY;
	}
	public String getIS_REVERSED() {
		return IS_REVERSED;
	}
	public void setIS_REVERSED(String iS_REVERSED) {
		IS_REVERSED = iS_REVERSED;
	}
	public String getREMARK() {
		return REMARK;
	}
	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}
	public String getIS_PARTIAL_REVERSED() {
		return IS_PARTIAL_REVERSED;
	}
	public void setIS_PARTIAL_REVERSED(String iS_PARTIAL_REVERSED) {
		IS_PARTIAL_REVERSED = iS_PARTIAL_REVERSED;
	}
	public String getIS_REVERSING() {
		return IS_REVERSING;
	}
	public void setIS_REVERSING(String iS_REVERSING) {
		IS_REVERSING = iS_REVERSING;
	}
	public String getCHECKER_ID() {
		return CHECKER_ID;
	}
	public void setCHECKER_ID(String cHECKER_ID) {
		CHECKER_ID = cHECKER_ID;
	}
	public String getREASON_TYPE() {
		return REASON_TYPE;
	}
	public void setREASON_TYPE(String rEASON_TYPE) {
		REASON_TYPE = rEASON_TYPE;
	}
	public String getLAST_UPDATED_TIME() {
		return LAST_UPDATED_TIME;
	}
	public void setLAST_UPDATED_TIME(String lAST_UPDATED_TIME) {
		LAST_UPDATED_TIME = lAST_UPDATED_TIME;
	}
	public String getVERSION() {
		return VERSION;
	}
	public void setVERSION(String vERSION) {
		VERSION = vERSION;
	}
	public String getLOAD_DATA_TS() {
		return LOAD_DATA_TS;
	}
	public void setLOAD_DATA_TS(String lOAD_DATA_TS) {
		LOAD_DATA_TS = lOAD_DATA_TS;
	}
	public String getACCUMULATOR_UPDATE() {
		return ACCUMULATOR_UPDATE;
	}
	public void setACCUMULATOR_UPDATE(String aCCUMULATOR_UPDATE) {
		ACCUMULATOR_UPDATE = aCCUMULATOR_UPDATE;
	}
	public String getACCUMULATOR_REVERSAL() {
		return ACCUMULATOR_REVERSAL;
	}
	public void setACCUMULATOR_REVERSAL(String aCCUMULATOR_REVERSAL) {
		ACCUMULATOR_REVERSAL = aCCUMULATOR_REVERSAL;
	}
	public String getCHG_RATING_DETAILS() {
		return CHG_RATING_DETAILS;
	}
	public void setCHG_RATING_DETAILS(String cHG_RATING_DETAILS) {
		CHG_RATING_DETAILS = cHG_RATING_DETAILS;
	}
	public String getBANK_CARD_ID() {
		return BANK_CARD_ID;
	}
	public void setBANK_CARD_ID(String bANK_CARD_ID) {
		BANK_CARD_ID = bANK_CARD_ID;
	}
	public String getBANK_ACCOUNT_NUMBER() {
		return BANK_ACCOUNT_NUMBER;
	}
	public void setBANK_ACCOUNT_NUMBER(String bANK_ACCOUNT_NUMBER) {
		BANK_ACCOUNT_NUMBER = bANK_ACCOUNT_NUMBER;
	}
	public String getBANK_ACCOUNT_NAME() {
		return BANK_ACCOUNT_NAME;
	}
	public void setBANK_ACCOUNT_NAME(String bANK_ACCOUNT_NAME) {
		BANK_ACCOUNT_NAME = bANK_ACCOUNT_NAME;
	}
	public String getFI_ACCOUNT_INFO() {
		return FI_ACCOUNT_INFO;
	}
	public void setFI_ACCOUNT_INFO(String fI_ACCOUNT_INFO) {
		FI_ACCOUNT_INFO = fI_ACCOUNT_INFO;
	}
	public String getDISCOUNT_AMOUNT() {
		return DISCOUNT_AMOUNT;
	}
	public void setDISCOUNT_AMOUNT(String dISCOUNT_AMOUNT) {
		DISCOUNT_AMOUNT = dISCOUNT_AMOUNT;
	}
	public String getREDEEMED_POINT_AMOUNT() {
		return REDEEMED_POINT_AMOUNT;
	}
	public void setREDEEMED_POINT_AMOUNT(String rEDEEMED_POINT_AMOUNT) {
		REDEEMED_POINT_AMOUNT = rEDEEMED_POINT_AMOUNT;
	}
	public String getREDEEMED_POINT_TYPE() {
		return REDEEMED_POINT_TYPE;
	}
	public void setREDEEMED_POINT_TYPE(String rEDEEMED_POINT_TYPE) {
		REDEEMED_POINT_TYPE = rEDEEMED_POINT_TYPE;
	}

	
}
