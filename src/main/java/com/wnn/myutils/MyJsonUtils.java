package com.wnn.myutils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.List;

import net.sf.json.JSONArray;

import com.google.gson.Gson;

public class MyJsonUtils {
	
	private static Gson gson = new Gson();
	public static String getJson(Object obj){
		String json = gson.toJson(obj);
		try {
			json = URLEncoder.encode(json, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
	public static <T>T toJava(String json,Class<T> cla) {
		try {
			json= URLDecoder.decode(json, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		T t = gson.fromJson(json, cla);
		return t;
	}
	
	public static <T> List<T> toList(String json,Class<T> t){
		try {
			json= URLDecoder.decode(json, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JSONArray jsonArray = JSONArray.fromObject(json);
		List<T> list = (List<T>) JSONArray.toCollection(jsonArray,t);
		return list;
	}
	
	public static <T>String getJson(List<T> list){
		JSONArray jsonArray = JSONArray.fromObject(list);
		String json = jsonArray.toString();
		try {
			json= URLDecoder.decode(json, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return json;
	}
}
