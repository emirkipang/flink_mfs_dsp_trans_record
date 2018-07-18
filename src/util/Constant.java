package util;

public class Constant {
	public static String BASEDIR = "D:/Data/GIA/output";

	public static String SOURCE = BASEDIR + "/ref/mfs/in_";
	public static String SOURCE_BIN = BASEDIR + "/ref/mfs/in_bin";
	public static String SOURCE_SEQ = BASEDIR + "/ref/mfs/in_seq";

	public static String CURRENT_HIVE_BEFORE = BASEDIR + "/ref/mfs/hdfs/before";
	public static String CURRENT_HIVE_AFTER = BASEDIR + "/ref/mfs/hdfs/after";

	public static String OUTPUT = BASEDIR + "/ref/mfs/out/summary.csv";

	public static String joinRule(String in, int length) {
		int gap = length - in.length();

		if (gap != 0) {
			for (int i = 1; i <= gap; i++) {
				in = "0" + in;
			}
		}

		return in;
	}

}
