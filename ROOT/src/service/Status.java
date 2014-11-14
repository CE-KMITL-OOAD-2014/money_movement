package service;

public enum Status {

	complete("complete"),error("error");
	
	private final String statusName;
	
	Status(String statusName)
	{
		this.statusName = statusName;
	}
	@Override
	public String toString() {
		
		return this.statusName;
	}
	
}
