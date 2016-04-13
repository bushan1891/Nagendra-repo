package com.jcs.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.jcs.exception.AppException;

public interface JiveServiceInterface {
	public  List<String> getUserEmail(String id);
	public  int getUserID(String requestPayload);
	public Map<String,String> getUserDetail(String id);
	public Map<String,String> getActivities(String endpointUrl);
	public String getJson(String url);
}
