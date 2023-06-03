package com.api;

import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RestService {

	private RequestSpecification rest;

	public RestService() {
		rest = RestAssured.given();
	}

	public <T> T post(String url, Object body, Class<T> responseClass) {
		return rest.body(body).post(url).as(responseClass);
	}

	public String post(String url, Object body) {
		return rest.body(body).post(url).asPrettyString();
	}

	public String post(String url, Object body, Map<String, String> headers) {

		return rest.body(body).headers(headers).post(url).asPrettyString();
	}

	public <T> T get(String url, Class<T> responseClass) {
		return rest.get(url).as(responseClass);
	}

	public <T> T put(String url, Object body, Class<T> responseClass) {
		return rest.body(body).put(url).as(responseClass);
	}

	public String delete(String url, Object body) {
		return rest.body(body).delete(url).asPrettyString();
	}

	public String delete(String url) {
		return rest.delete(url).asPrettyString();
	}

}
