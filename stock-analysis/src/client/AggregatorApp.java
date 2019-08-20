package client;

import java.io.IOException;

import aggregators.AggregatorProcessor;
import aggregators.MaxAggregator;
import aggregators.MinAggregator;

public class AggregatorApp {

	public static void main(String[] args) throws IOException {
		
		MinAggregator agg = new MinAggregator();
		AggregatorProcessor<MinAggregator> aggsProcessor = new AggregatorProcessor<MinAggregator>(agg, "table.csv");
		double value = aggsProcessor.runAggregator(1);
		System.out.println(value);
	}

}
