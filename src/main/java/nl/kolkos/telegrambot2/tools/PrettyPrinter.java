package nl.kolkos.telegrambot2.tools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PrettyPrinter {
	public static void prettyPrintObject(Object object) {
		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
		String json = gson.toJson(object);
		System.out.println(json);
		
	}
	
	public static String createJsonString(Object object) {
		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
		return gson.toJson(object);
	}
}
