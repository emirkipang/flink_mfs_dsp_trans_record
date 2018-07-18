package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class Helper {
	public static String isNull(String text) {
		return (text == null) ? "UNKNOWN" : text;
	}

	public static String combineFileds(int start, int end, String[] items,
			String delimiter) {
		String result = items[start];
		for (int i = start + 1; i <= end; i++) {
			result = result + delimiter + items[i];
		}

		return result;
	}

	public static String joinRule(String in, int length) {
		int gap = length - in.length();

		if (gap != 0) {
			for (int i = 1; i <= gap; i++) {
				in = "0" + in;
			}
		}

		return in;
	}
	
	public static String getDsp(String msisdn) throws Exception {
		String url = "http://10.250.200.217:8001/?oprid=getAll&msisdn="+msisdn+"&show=json";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
		// add request header
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		//int responseCode = con.getResponseCode();
//		System.out.println("\nSending 'GET' request to URL : " + url);
//		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print in String
//		System.out.println(response.toString());

		// Read JSON response and print
		JSONObject myResponse = new JSONObject(response.toString());
		//System.out.println("result after Reading JSON Response");
		//String resultCode = myResponse.getString("ResultCode");
		
		String area = "";
		String osvendor = "";
		String regional = "";
		String ci = "";
		String imsi = "";
		String tvendor = "";
		String kabupaten = "";
		String branch = "";
		String lac = "";
		String propinsi = "";
		String ttype = "";
		String product_id = "";
		String imei = "";
		String ResultDesc = "";
		String osversion = "";
		String ResultCode = "";
		String sposname = "";
		
		area = myResponse.getString("area");
		osvendor = myResponse.getString("osvendor");
		regional = myResponse.getString("regional");
		ci = myResponse.getString("ci");
		imsi = myResponse.getString("imsi");
		tvendor = myResponse.getString("tvendor");
		kabupaten = myResponse.getString("kabupaten");
		branch = myResponse.getString("branch");
		lac = myResponse.getString("lac");
		propinsi = myResponse.getString("propinsi");
		ttype = myResponse.getString("ttype");
		product_id = myResponse.getString("product_id");
		imei = myResponse.getString("imei");
		ResultDesc = myResponse.getString("ResultDesc");
		osversion = myResponse.getString("osversion");
		ResultCode = myResponse.getString("ResultCode");
		sposname = myResponse.getString("sposname");
		
//		if (resultCode.equals("0")){
//			lac = myResponse.getString("lac");
//			ci = myResponse.getString("ci");			
//		}
		

//		System.out.println("lac : " + myResponse.getString("lac"));
//		System.out.println("ci : " + myResponse.getString("ci"));
		
		String dsp = area+ "|" +osvendor+ "|" +regional+ "|" +ci+ "|" +imsi+ "|" +tvendor+ "|" +kabupaten+ "|" +branch+ "|" +lac+ "|" +propinsi+ "|" +ttype+ "|" +product_id+ "|" +imei+ "|" +ResultDesc+ "|" +osversion+ "|" +ResultCode+ "|" +sposname;
		
		return dsp;
	}
}
