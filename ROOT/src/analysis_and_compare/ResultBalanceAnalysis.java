package analysis_and_compare;

import org.json.simple.JSONArray;
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

		
		double refLow = (sum/10)*1; 
		double refAvg = (sum/10)*3;
		double refHeight = (sum/10)*6;
		
		
		
		
		JSONArray jsonArray = new JSONArray();
		
		JSONObject jsonLow = new JSONObject();
		JSONObject jsonAvg = new JSONObject();
		JSONObject jsonHeight = new JSONObject();
		
		jsonLow.put("type", "low");
		jsonLow.put("valueuse", this.low);
		jsonLow.put("valueref",refLow );
		
		jsonAvg.put("type", "avg");
		jsonAvg.put("valueuse", this.avg);
		jsonAvg.put("valueref",refAvg );
		
		jsonHeight.put("type", "height");
		jsonHeight.put("valueuse", this.height);
		jsonHeight.put("valueref",refHeight );
		
		jsonArray.add(jsonLow);
		jsonArray.add(jsonAvg);
		jsonArray.add(jsonHeight);
		
		JSONObject returnJson = new JSONObject();
		returnJson.put("result", jsonArray);
		
		return returnJson;
	}

}
