package com.yash.mtbs.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.yash.mtbs.literals.MTBSConstants;
import com.yash.mtbs.model.Screen;

public class JSONUtil {

	static Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public static void writeJSONToFile(Object object, String filePath, String fileName) {
		try (FileWriter writer = new FileWriter(filePath.concat(fileName))) {
			gson.toJson(object, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String convertObjectToJSONString(Object object) {
		String jsonString = gson.toJson(object);
		System.out.println(jsonString);
		return jsonString;
	}

	public static List readJSONFromFile(String filePath, String fileName) {
		List list = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			list = objectMapper.readValue(new File(filePath.concat(fileName)), List.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static <T> T mapObjectToSpecificModelObject(Class<T> objectType, Object object) {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(object, objectType);
	}

}
