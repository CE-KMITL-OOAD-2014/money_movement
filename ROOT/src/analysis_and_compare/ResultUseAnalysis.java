package analysis_and_compare;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

import manage_incomeoutlay.TypeOfUse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ResultUseAnalysis extends ResultAnalysis {

	
	Map<TypeOfUse,Double> map ;
	
	public ResultUseAnalysis(Map<TypeOfUse, Double> map) {
	
		this.map = map;
	}

	@Override
	public JSONObject toJSONObject() {
		// TODO Auto-generated method stub
		
		JSONArray jsonArray = new JSONArray();
		JSONObject returnJson = new JSONObject();
		
		for(Map.Entry<TypeOfUse, Double> entity : this.map.entrySet())
		{
			JSONObject json = new JSONObject();
			json.put("type",entity.getKey().getTypeName());
			json.put("value", entity.getValue());			
			jsonArray.add(json);
		}
		
		returnJson.put("result", jsonArray);
		
		return returnJson;
	}

}
