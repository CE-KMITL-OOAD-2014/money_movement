package framework_azure;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ConvertNameId {
	
	public static volatile  ConvertNameId gen = null;
	private ArrayList<Pair<String, ArrayList<Pair<String, String>>>> data ; 
	public static ConvertNameId getObject()
	{
		if(gen==null)
		{
			synchronized (ConvertNameId.class) 
			{
				if(gen==null)
				{
					gen =new ConvertNameId();
				}
			}
		}
		
		return gen;
	}
	
	private ConvertNameId()
	{
		this.data = new ArrayList<Pair<String, ArrayList<Pair<String, String>>>>();
	}
	
	public String idToName(String tableName,String id) throws Exception
	{
		if(!checkHaveTableInArrayList(tableName))
		{
			synchronized (this) {
				this.getIdNameToArrayList(tableName);
			}
		}
		
		for(int i=0;i<data.size();i++)
		{
			Pair<String, ArrayList<Pair<String, String>>> temPair = data.get(i);
			if(temPair.getFirst().compareTo(tableName)==0)
			{
				ArrayList<Pair<String, String>> inArrayList = temPair.getSecound();
				for(int j=0;j<inArrayList.size();j++)
				{
					Pair<String,String> value = inArrayList.get(j);
					if(value.getFirst().compareTo(id)==0)
					{
						return value.getSecound();
					}
				}	
			}
		}
		return null;
	}
	public String nameToId(String tableName,String name) throws Exception
	{
		if(!checkHaveTableInArrayList(tableName))
		{
			synchronized (this) {
				this.getIdNameToArrayList(tableName);
			}
		}
		
		for(int i=0;i<data.size();i++)
		{
			Pair<String, ArrayList<Pair<String, String>>> temPair = data.get(i);
			if(temPair.getFirst().compareTo(tableName)==0)
			{
				ArrayList<Pair<String, String>> inArrayList = temPair.getSecound();
				for(int j=0;j<inArrayList.size();j++)
				{
					Pair<String,String> value = inArrayList.get(j);
					if(value.getSecound().compareTo(name)==0)
					{
						return value.getFirst();
					}
				}	
			}
		}
		return null;
	}
	
	public boolean checkHaveTableInArrayList(String tableName)
	{
		for(int i=0;i<data.size();i++)
		{
			Pair<String,ArrayList<Pair<String,String>>> temPair = data.get(i);
			if(temPair.getFirst().compareTo(tableName)==0 )
			{
				return true;
			}
		}
		return false;
	}
	
	public void getIdNameToArrayList(String tableName) throws Exception
	{
		if(!checkHaveTableInArrayList(tableName))
		{
			Connection conection = ManangeConnection.getConnection();
			Statement statement = null;
			ResultSet resultSet = null;
			String sqlCommand = "select * from "+tableName;
			try
			{
				statement = conection.createStatement();
				resultSet = statement.executeQuery(sqlCommand);
				ArrayList<Pair<String,String>> temPair = new ArrayList<Pair<String,String>>() ;
				
				while(resultSet.next())
				{
					String id = String.valueOf(resultSet.getInt(1));
					String name = resultSet.getString(2);
					Pair<String,String> tem = new Pair(id,name);
					temPair.add(tem);
				}
				Pair<String, ArrayList<Pair<String,String>>> tableAndPair = new  Pair<String, ArrayList<Pair<String,String>>>(tableName,temPair) ;
				data.add(tableAndPair);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	@Override
	public String toString()
	{
		
		
		
		return null;
	}
	
}
