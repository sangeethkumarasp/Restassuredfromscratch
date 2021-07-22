package resources;

public  enum  Resouces {
	
	
	
	addplaceapi("/maps/api/place/add/json"),
Deleteapi("/maps/api/place/delete/json");
	
	
	private String resource;
	
	Resouces(String resource)
	{
		this.resource=resource;
	}
	
	public String getresouces()
	{
		return resource;
	}
	

}
