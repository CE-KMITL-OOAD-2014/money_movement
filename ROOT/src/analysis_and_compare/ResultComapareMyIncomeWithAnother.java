package analysis_and_compare;

import org.json.simple.JSONObject;

public class ResultComapareMyIncomeWithAnother extends ResultCompare {

	double sumMyIncomeOutlay;
	double sumAnotherIncomeOutlay;
	
	public ResultComapareMyIncomeWithAnother(double sumMyIncomeOutlay,
			double sumAnotherIncomeOutlay) {
		
		this.sumMyIncomeOutlay = sumMyIncomeOutlay;
		this.sumAnotherIncomeOutlay = sumAnotherIncomeOutlay;
	}

	@Override
	public JSONObject toJSONObject() {
		JSONObject json = new JSONObject();
		json.put("sumMyIncomeOutlay",this.sumMyIncomeOutlay);
		json.put("sumAnotherIncomeOutlay", this.sumAnotherIncomeOutlay);
		
		return json;
	}

}
