package analysis_and_compare;

import org.json.simple.JSONObject;

public class ResultComapareMyIncomeWithAnother extends ResultCompare {

	private JSONObject jsonObject;

	public ResultComapareMyIncomeWithAnother(JSONObject jsonObject) {

		this.jsonObject = jsonObject;
	}
	@Override
	public JSONObject toJSONObject() {
		// TODO Auto-generated method stub
		return this.jsonObject;
	}
}
