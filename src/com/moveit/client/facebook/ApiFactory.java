package com.moveit.client.facebook;

/**
 * Creates javascript api.
 */
public class ApiFactory {
	
	
	private static FacebookApi apiClient;
	
	
	/**
	 * Create facebook api client
	 */
	public static FacebookApi getInstance () {
		
		if ( apiClient == null ) {
			apiClient = new FacebookApi ();
		} 
		return apiClient;
	}
}

