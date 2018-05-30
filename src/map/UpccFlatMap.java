package map;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Upcc;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple14;
import org.apache.flink.api.java.tuple.Tuple15;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.tuple.Tuple4;
import org.apache.flink.api.java.tuple.Tuple5;
import org.apache.flink.util.Collector;

import util.Constant;
import util.Helper;

public class UpccFlatMap implements
		FlatMapFunction<String, Tuple4<Long, String, String, String>> {

	/**
* 
*/
	private static final long serialVersionUID = 1L;
	private String period;
	private String prcDate;

	public UpccFlatMap(String period) {
		// TODO Auto-generated constructor stub
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();

		this.period = period;
		this.prcDate = dateFormat.format(date);
	}

	@Override
	public void flatMap(String in,
			Collector<Tuple4<Long, String, String, String>> out)
			throws Exception {
		// TODO Auto-generated method stub
		String[] lines = in.split("\n");

		for (String line : lines) {
			
			String[] items = line.split(",", -1);
			int TriggerType = Integer.parseInt(items[0].trim());
			String BonusUsage = items[31].equals("") ? "0" : items[31];
			
			if ((TriggerType == 2 || TriggerType == 3) && Long.parseLong(BonusUsage) > 0){
				String MSISDN = items[4];
				String Date = items[1].substring(0, 10).replaceAll("-", "");
				String CallTime = null;
				switch (period) {
				case "1":
					CallTime = items[1].substring(11, 19).replaceAll(":", ""); // hour
																				// minute
																				// second
					break;
				case "2":
					CallTime = items[1].substring(11, 13).replaceAll(":", "")
							+ "0000"; // hour
					break;
				case "3":
					CallTime = items[1].substring(11, 16).replaceAll(":", "")
							+ "00"; // hour minute
					break;
				}
				
				String Date_CallTime = Date + "|" + CallTime;
				String MCC_MNC;
				String Country_Name = "Indonesia"; // still hardcode
				String APN = items[20];
				String ProfileName = items[24];
				// String RuleName = items[25];
				// String RuleName = "";
				String BonusID = items[26];			
				String BonusBalance = items[29].equals("") ? "0" : items[29];
				String PrePost = "Prepaid";
				String lacci;
				String lac;
				String ci; 
				String NetworkType;
				
				String Date_CallTime_BonusBalance = Date_CallTime + "|" + BonusBalance;

				String CGI;
				if (!items[10].trim().equals("")) { // 2G
					CGI = items[10];
					MCC_MNC = items[10].equals("") ? "N/A" : items[10].substring(0,
							5);
					NetworkType = "2G";
					items[10] = items[10].equals("") ? "0000000000" : items[10];
					lacci = Helper.joinRule(
							items[10].substring(5, items[10].length()), 10);
					lac = lacci.substring(0, 5);
					ci = lacci.substring(5, 10);
				} else if (!items[11].trim().equals("")) { // 3G
					CGI = items[11];
					MCC_MNC = items[11].equals("") ? "N/A" : items[11].substring(0,
							5);
					NetworkType = "3G";
					items[11] = items[11].equals("") ? "0000000000" : items[11];
					lacci = Helper.joinRule(
							items[11].substring(5, items[11].length()), 10);
					lac = lacci.substring(0, 5);
					ci = lacci.substring(5, 10);
				} else { // 4G
					CGI = items[46];
					MCC_MNC = items[46].equals("") ? "N/A" : items[46].substring(0,
							5);
					NetworkType = "4G";
					items[46] = items[46].equals("") ? "0000000000" : items[46];
					lacci = Helper.joinRule(
							items[46].substring(5, items[46].length()), 10);
					//lac = lacci.substring(0, 7);
					//ci = lacci.substring(7, 10);
					
					String lacci_bin = Long.toBinaryString(Long.parseLong(lacci));
					String ci_bin = lacci_bin.substring(lacci_bin.length()-8,lacci_bin.length());
					String lac_bin = lacci_bin.substring(0,lacci_bin.length()-8);
					lac = Helper.joinRule(Long.toString(Long.parseLong(lac_bin,2)), 7);
					ci = Helper.joinRule(Long.toString(Long.parseLong(ci_bin,2)), 3);
					
				}
				String IMEI = items[5];
				String sessionID = items[116];
				String str_lacci = lac + "|" + ci;

				String prcDate = this.prcDate;
				String agg = MSISDN + "|" + MCC_MNC + "|" + Country_Name + "|"
						+ APN + "|" + ProfileName + "|" + BonusID + "|"
						+ NetworkType + "|" + CGI + "|" + IMEI + "|" + sessionID
						+ "|" + PrePost + "|" + prcDate;

				out.collect(new Tuple4<Long, String, String, String>(Long
						.parseLong(BonusUsage), Date_CallTime_BonusBalance, str_lacci, agg));

			}			
		}

	}

}
