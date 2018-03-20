package br.usp.icmc.intermidia.esm.rest.api.client.facade;

public class ApiAddress {
	
	/** Default value. */
	//private static final String REST_API_ADDRESS = "http://www.espim.com.br/ws-0.1/";
	private static final String REST_API_ADDRESS = "http://192.168.0.111:8000/";
	
	private static String restApiAddress = REST_API_ADDRESS;

	public static String getRestApiAddress() {
		return restApiAddress;
	}

	public static void setRestApiAddress(String address) {
		restApiAddress = address;
	}	

}
