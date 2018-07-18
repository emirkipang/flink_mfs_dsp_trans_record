package map;


import model.TransRecord;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.util.Collector;

import util.Constant;



public class TransRecordFlatMap implements
		FlatMapFunction<String, TransRecord> {

	/**
* 
*/
	private static final long serialVersionUID = 1L;

	@Override
	public void flatMap(String in, Collector<TransRecord> out)
			throws Exception {
		// TODO Auto-generated method stub
		String[] lines = in.split("\n");

		for (String line : lines) {
			String[] items = line.split("\\|", -1);
			
			TransRecord tr = new TransRecord();
			
			tr.setORDERID(items[0]);
			tr.setTRANS_STATUS(items[1]);
			tr.setTRANS_INITATE_TIME(items[2]);
			tr.setTRANS_END_TIME(items[3]);
			tr.setDEBIT_PARTY_ID(items[4]);
			tr.setDEBIT_PARTY_TYPE(items[5]);
			tr.setDEBIT_PARTY_ACCOUNT(items[6]);
			tr.setDEBIT_ACCOUNT_TYPE(items[7]);
			tr.setDEBIT_PARTY_MNEMONIC(items[8]);
			tr.setCREDIT_PARTY_ID(items[9]);
			tr.setCREDIT_PARTY_TYPE(items[10]);
			tr.setCREDIT_PARTY_ACCOUNT(items[11]);
			tr.setCREDIT_ACCOUNT_TYPE(items[12]);
			tr.setCREDIT_PARTY_MNEMONIC(items[13]);
			tr.setEXPIRED_TIME(items[14]);
			tr.setREQUEST_AMOUNT(items[15]);
			tr.setREQUEST_CURRENCY(items[16]);
			tr.setEXCHANGE_RATE(items[17]);
			tr.setORG_AMOUNT(items[18]);
			tr.setACTUAL_AMOUNT(items[19]);
			tr.setFEE(items[20]);
			tr.setCOMMISSION(items[21]);
			tr.setTAX(items[22]);
			tr.setACCOUNT_UNIT_TYPE(items[23]);
			tr.setCURRENCY(items[24]);
			tr.setIS_REVERSED(items[25]);
			tr.setREMARK(items[26]);
			tr.setIS_PARTIAL_REVERSED(items[27]);
			tr.setIS_REVERSING(items[28]);
			tr.setCHECKER_ID(items[29]);
			tr.setREASON_TYPE(items[30]);
			tr.setLAST_UPDATED_TIME(items[31]);
			tr.setVERSION(items[32]);
			tr.setLOAD_DATA_TS(items[33]);
			tr.setACCUMULATOR_UPDATE(items[34]);
			tr.setACCUMULATOR_REVERSAL(items[35]);
			tr.setCHG_RATING_DETAILS(items[36]);
			tr.setBANK_CARD_ID(items[37]);
			tr.setBANK_ACCOUNT_NUMBER(items[38]);
			tr.setBANK_ACCOUNT_NAME(items[39]);
			tr.setFI_ACCOUNT_INFO(items[40]);
			tr.setDISCOUNT_AMOUNT(items[41]);
			tr.setREDEEMED_POINT_AMOUNT(items[42]);
			tr.setREDEEMED_POINT_TYPE(items[43]);
			tr.setMsisdn_debit(items[44]);
			tr.setMsisdn_credit(items[45]);
			
			out.collect(tr);

		}

	}
}
