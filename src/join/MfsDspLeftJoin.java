package join;

import model.TransRecord;

import org.apache.flink.api.common.functions.FlatJoinFunction;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.util.Collector;

import util.Helper;

public class MfsDspLeftJoin
		implements
		FlatJoinFunction<TransRecord, Tuple1<String>, Tuple1<String>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void join(TransRecord tr,
			Tuple1<String> rightElem, Collector<Tuple1<String>> out)
			throws Exception {
		// TODO Auto-generated method stub
		

		if (rightElem == null){			
			String dsp_debit = Helper.getDsp(tr.getMsisdn_debit());
			String dsp_credit = Helper.getDsp(tr.getMsisdn_credit());
			
			String Output = tr.getORDERID() + "|" + tr.getTRANS_STATUS() + "|"
					+ tr.getTRANS_INITATE_TIME() + "|" + tr.getTRANS_END_TIME()
					+ "|" + tr.getDEBIT_PARTY_ID() + "|" + tr.getDEBIT_PARTY_TYPE()
					+ "|" + tr.getDEBIT_PARTY_ACCOUNT() + "|"
					+ tr.getDEBIT_ACCOUNT_TYPE() + "|"
					+ tr.getDEBIT_PARTY_MNEMONIC() + "|" + tr.getCREDIT_PARTY_ID()
					+ "|" + tr.getCREDIT_PARTY_TYPE() + "|"
					+ tr.getCREDIT_PARTY_ACCOUNT() + "|"
					+ tr.getCREDIT_ACCOUNT_TYPE() + "|"
					+ tr.getCREDIT_PARTY_MNEMONIC() + "|" + tr.getEXPIRED_TIME()
					+ "|" + tr.getREQUEST_AMOUNT() + "|" + tr.getREQUEST_CURRENCY()
					+ "|" + tr.getEXCHANGE_RATE() + "|" + tr.getORG_AMOUNT() + "|"
					+ tr.getACTUAL_AMOUNT() + "|" + tr.getFEE() + "|"
					+ tr.getCOMMISSION() + "|" + tr.getTAX() + "|"
					+ tr.getACCOUNT_UNIT_TYPE() + "|" + tr.getCURRENCY() + "|"
					+ tr.getIS_REVERSED() + "|" + tr.getREMARK() + "|"
					+ tr.getIS_PARTIAL_REVERSED() + "|" + tr.getIS_REVERSING()
					+ "|" + tr.getCHECKER_ID() + "|" + tr.getREASON_TYPE() + "|"
					+ tr.getLAST_UPDATED_TIME() + "|" + tr.getVERSION() + "|"
					+ tr.getLOAD_DATA_TS() + "|" + tr.getACCUMULATOR_UPDATE() + "|"
					+ tr.getACCUMULATOR_REVERSAL() + "|"
					+ tr.getCHG_RATING_DETAILS() + "|" + tr.getBANK_CARD_ID() + "|"
					+ tr.getBANK_ACCOUNT_NUMBER() + "|" + tr.getBANK_ACCOUNT_NAME()
					+ "|" + tr.getFI_ACCOUNT_INFO() + "|" + tr.getDISCOUNT_AMOUNT()
					+ "|" + tr.getREDEEMED_POINT_AMOUNT() + "|"
					+ tr.getREDEEMED_POINT_TYPE() + "|" + dsp_debit + "|" + dsp_credit;
			
			out.collect(new Tuple1<String>(Output));
		}
			

	}

}
