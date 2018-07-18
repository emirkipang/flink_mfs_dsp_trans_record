package main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import join.MfsDspLeftJoin;
import map.GetOrderIDFlatMap;
import map.TransRecordFlatMap;
import model.TransRecord;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.hadoop.mapred.HadoopInputFormat;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.core.fs.FileSystem.WriteMode;
import org.apache.flink.hadoopcompatibility.HadoopInputs;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.SequenceFileAsBinaryInputFormat;

import util.Constant;

public class Main {
	private HashMap<String, DataSet<String>> dataset_inputs = new HashMap<String, DataSet<String>>();
	private ExecutionEnvironment env;
	private int proses_paralel;
	private int sink_paralel;
	private Configuration parameter;
	private String outputPath;

	// tuples variable
	private DataSet<TransRecord> source_tuples;
	private DataSet<Tuple1<String>> current_hive_before_tuples;
	private DataSet<Tuple1<String>> current_hive_after_tuples;
	private DataSet<Tuple1<String>> output;

	public Main(int proses_paralel, int sink_paralel, String outputPath) {
		this.env = ExecutionEnvironment.getExecutionEnvironment();
		this.parameter = new Configuration();
		this.outputPath = outputPath;
		
		this.proses_paralel = proses_paralel;
		this.sink_paralel = sink_paralel;
		this.env.setParallelism(this.proses_paralel);
		this.parameter.setBoolean("recursive.file.enumeration", true);

		// BasicConfigurator.configure(); //remove log warn

	}

	private String getOutputPath() {
		return this.outputPath;
	}

	private Configuration getParameter() {
		return this.parameter;
	}

	private ExecutionEnvironment getEnv() {
		return this.env;
	}

	public int getSink_paralel() {
		return this.sink_paralel;
	}

	private void setInput(HashMap<String, String> files) throws IOException {
		

		for (Map.Entry<String, String> file : files.entrySet()) {
			
			
			
			dataset_inputs.put(
					file.getKey(),
					getEnv().readTextFile(file.getValue()).withParameters(
							getParameter()));
		}

	}

	public void processInput() {
		source_tuples = dataset_inputs.get("source").flatMap(
				new TransRecordFlatMap());
		current_hive_before_tuples = dataset_inputs.get("current_hive_before")
				.flatMap(new GetOrderIDFlatMap());
		current_hive_after_tuples = dataset_inputs.get("current_hive_after")
				.flatMap(new GetOrderIDFlatMap());

	}

	public void processAggregate() {
		current_hive_after_tuples = current_hive_before_tuples.union(
				current_hive_after_tuples).distinct();
		output = source_tuples.leftOuterJoin(current_hive_after_tuples)
				.where("ORDERID").equalTo(0).with(new MfsDspLeftJoin());

	}

	public void sink() throws Exception {
		output.writeAsCsv(getOutputPath(), "\n", "|", WriteMode.OVERWRITE)
				.setParallelism(getSink_paralel());

	}

	public static void main(String[] args) throws Exception {
		// set data input
		HashMap<String, String> files = new HashMap<String, String>();

		/** prod **/
		 ParameterTool params = ParameterTool.fromArgs(args);
		 
		 int proses_paralel = params.getInt("slot");
		 int sink_paralel = params.getInt("sink");
		 String source = params.get("source");
		 String current_hive_before = params.get("current_hive_before");
		 String current_hive_after = params.get("current_hive_after");
		 String output = params.get("output");
		
		 Main main = new Main(proses_paralel, sink_paralel, output);
		
		 files.put("source", source);
		 files.put("current_hive_before", current_hive_before);
		 files.put("current_hive_after", current_hive_after);

		/** dev **/
//		int proses_paralel = 2;
//		int sink_paralel = 1;
//
//		Main main = new Main(proses_paralel, sink_paralel, Constant.OUTPUT);
//		files.put("source", Constant.SOURCE);
//		files.put("current_hive_before", Constant.CURRENT_HIVE_BEFORE);
//		files.put("current_hive_after", Constant.CURRENT_HIVE_AFTER);

		/****/
		main.setInput(files);
		main.processInput();
		main.processAggregate();
		main.sink();
		
		try {
			main.getEnv().execute("job flink mfs dsp");
		} catch (Exception e) {
			// TODO Auto-generated catch blockF
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
