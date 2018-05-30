package util;

public class Constant {
	public static String BASEDIR = "D:/Data/GIA/output";

	public static String FILE_UPCC = BASEDIR + "/ref/in/upcc";

	public static String FILE_LACIMA_3G = BASEDIR + "/ref/v_par_ref_lacima.csv";
	public static String FILE_LACIMA_4G = BASEDIR
			+ "/ref/v_par_ref_lacima_4g.csv";

	public static String OUTPUT = BASEDIR + "/out/upcc_summary.csv";

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
