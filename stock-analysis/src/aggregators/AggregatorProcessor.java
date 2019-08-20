package aggregators;

import java.io.IOException;
import java.util.List;

import fileprocessors.StockFileReader;

public class AggregatorProcessor<T extends Aggregator> {
	
	T aggregator;
	String file;
	
	public AggregatorProcessor(T aggregator, String file){
		super();
		this.aggregator = aggregator;
		this.file = file;
	}
	
	public double runAggregator(int columnId) throws IOException{
		StockFileReader fileReader = new StockFileReader(file);
		List<String> lines = fileReader.readFileData();
		columnId--;
		for(String line : lines){
			String[] numbers = line.split(",");
			Double val = Double.parseDouble(numbers[columnId]);
			aggregator.add(val);
		}
		
		double number = aggregator.calculate();
		return number;
		
	}

}
