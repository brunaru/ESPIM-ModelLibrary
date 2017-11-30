package br.usp.icmc.intermidia.esm.rest.api.client.facade;

public class ApiAddress {
	
	//public static final String REST_API_ADDRESS = "http://ec2-54-233-190-255.sa-east-1.compute.amazonaws.com:8080/esm-rest-service-0.1.0/";
	/** Default value. */
	private static final String REST_API_ADDRESS = "http://esm-rest-service.herokuapp.com/";
	
	private static String restApiAddress = REST_API_ADDRESS;

	public static String getRestApiAddress() {
		return restApiAddress;
	}

	public static void setRestApiAddress(String address) {
		restApiAddress = address;
	}	

}
