package map;

import model.Laccima;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

import util.Constant;



public class LacimaFlatMap implements
		FlatMapFunction<String, Tuple2<String, String>> {

	/**
* 
*/
	private static final long serialVersionUID = 1L;
	private String nodeType;

	public LacimaFlatMap(String nodeType) {
		this.nodeType = nodeType;
	}

	@Override
	public void flatMap(String in, Collector<Tuple2<String, String>> out)
			throws Exception {
		// TODO Auto-generated method stub
		String[] lines = in.split("\n");

		for (String line : lines) {

			String[] items = line.split("\\|", -1);
			String strArea = "";
			String lac = "";
			String ci = "";

			if (items[17].equalsIgnoreCase("SUMBAGSEL")
					|| items[17].equalsIgnoreCase("SUMBAGUT")
					|| items[17].equalsIgnoreCase("SUMBAGTENG")) {
				strArea = "AREA 1";
			} else if (items[17].equalsIgnoreCase("WESTERN JABOTABEK")
					|| items[17].equalsIgnoreCase("EASTERN JABOTABEK")
					|| items[17].equalsIgnoreCase("CENTRAL JABOTABEK")
					|| items[17].equalsIgnoreCase("JABAR")
					|| items[17].equalsIgnoreCase("SAD REGIONAL")) {
				strArea = "AREA 2";
			} else if (items[17].equalsIgnoreCase("JATENG-DIY")
					|| items[17].equalsIgnoreCase("JATIM")
					|| items[17].equalsIgnoreCase("BALI NUSRA")) {
				strArea = "AREA 3";
			} else if (items[17].equalsIgnoreCase("KALIMANTAN")
					|| items[17].equalsIgnoreCase("SULAWESI")
					|| items[17].equalsIgnoreCase("PAPUA")
					|| items[17].equalsIgnoreCase("MALUKU DAN PAPUA")) {
				strArea = "AREA 4";
			}

			switch (nodeType) {
			case "3G":
				lac = Constant.joinRule(items[0], 5);
				ci = Constant.joinRule(items[1], 5);
				break;
			case "4G":
				lac = Constant.joinRule(items[0], 7);
				ci = Constant.joinRule(items[1], 3);
				break;

			}
			String lacci = lac + "|" + ci;
			String region = items[17];
			String branch = items[18];
			String kabupaten = items[14];
			String kecamatan = items[15];
			String kelurahan = items[16];
			// String subbranch = items[19];
			String cluster = items[22];
			// String area = strArea;
			String propinsi = items[13];
			String agg = propinsi + "|" + kabupaten + "|" + kecamatan + "|"
					+ kelurahan + "|" + region + "|" + branch + "|" + cluster;

			out.collect(new Tuple2<String, String>(lacci, agg));

		}

	}
}
