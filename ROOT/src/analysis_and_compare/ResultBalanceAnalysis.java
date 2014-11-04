package analysis_and_compare;

import org.json.simple.JSONObject;

public class ResultBalanceAnalysis extends ResultAnalysis {

	private double low;
	private double avg;
	private double height;
	
		
	public ResultBalanceAnalysis(double low, double avg, double height) {
		
		this.low = low;
		this.avg = avg;
		this.height = height;
		
	}

	@Override
	public JSONObject toJSONObject() {
		// TODO Auto-generated method stub
		
		double sum = this.low+this.avg+this.height;
		double sizeOfLow = this.low/sum; 
		double sizeOfAvg = this.avg/sum;
		double sizeOfHeight = this.height/sum;
		
		JSONObject json = new JSONObject();
		
		json.put("sizeOfLow", sizeOfLow);
		json.put("sizeOfAvg", sizeOfAvg);
		json.put("sizeOfHeight", sizeOfHeight);
		
		return json;
	}

}
