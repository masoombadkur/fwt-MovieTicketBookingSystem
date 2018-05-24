package com.yash.mtbs.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtil {
	
	public static void mapObjectListToJSONFile(String filePath, String fileName, List objects){
		ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath.concat(fileName)), objects);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public static List mapJSONFileToObjectList(String filePath, String fileName){
		List screens = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			screens = mapper.readValue(new File("src/main/resources/json_files/result1.json"), List.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screens;
	}

}
