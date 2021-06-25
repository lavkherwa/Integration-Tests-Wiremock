package com.example.demo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestFileUtils {

	public static JSONArray getFileContentAsJsonArray(String file) throws IOException, JSONException {
		return new JSONArray(TestFileUtils.getFileContentAsString(file));
	}

	public static String getFileContentAsString(String file) throws IOException {
		File testFile = TestFileUtils.getFile(file);
		return FileUtils.readFileToString(testFile);
	}

	public static File getFile(String file) throws IOException {
		ClassLoader classLoader = TestFileUtils.class.getClassLoader();
		return new File(classLoader.getResource(file).getFile());
	}

	public static FileInputStream getFileStream(String file) throws IOException {
		ClassLoader classLoader = TestFileUtils.class.getClassLoader();
		return new FileInputStream(new File(classLoader.getResource(file).getFile()));
	}

	public static JsonNode getFileAsJsonNode(String file) throws IOException {
		return new ObjectMapper().readValue(IOUtils.toByteArray(TestFileUtils.getFileStream(file)), JsonNode.class);
	}
}
