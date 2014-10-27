package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import framework_azure.ConvertNameId;
import framework_azure.Pair;


/**
 * Servlet implementation class TestAjax
 */
@WebServlet("/getidname")
public class GetIdName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetIdName() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		String data = "Hello world";
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(data);
		*/
		
		
		
		ArrayList< Pair<String,String>> list;

		JSONObject json = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		String tableName = request.getParameter("name");
				
		ConvertNameId convert = ConvertNameId.getObject();
		try {
			list = convert.getListFromTable(tableName);		
			for(int i=0;i<list.size();i++)
			{
				JSONObject temJson = new JSONObject();
				temJson.put("id", list.get(i).getFirst());
				temJson.put("name", list.get(i).getSecound());
				jsonArray.add(temJson);
			}
			json.put("data", jsonArray);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(json);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}