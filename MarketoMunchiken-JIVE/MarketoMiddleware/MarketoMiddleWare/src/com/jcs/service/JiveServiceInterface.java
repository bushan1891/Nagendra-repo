package com.jcs.service;

import java.io.IOException;
import java.util.List;

import com.jcs.exception.AppException;

public interface JiveServiceInterface {
	public  List<String> getUserEmail(String id);
	public  int getUserID(String requestPayload);
}
