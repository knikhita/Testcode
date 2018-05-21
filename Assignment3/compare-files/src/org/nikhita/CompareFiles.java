package org.nikhita;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

class UrlContent {
	public String bodyString;
	public boolean isJSON;
	public boolean isXML;
	
	public UrlContent(String bodyString, boolean isJSON, boolean isXML) {
		this.bodyString = bodyString;
		this.isJSON = isJSON;
		this.isXML = isXML;
	}
	
}

public class CompareFiles {
	public static void main(String args[]) {
		try {
			BufferedReader reader1 = new BufferedReader(new FileReader(new File("file1.txt")));
			BufferedReader reader2 = new BufferedReader(new FileReader(new File("file2.txt")));
			String line1 = reader1.readLine();
			String line2 = reader2.readLine();

			while (line1 != null && line2 != null) {
				System.out.println(line1);
				System.out.println(line2);
				// processing
				UrlContent response1 = makeHttpCall(line1);
				UrlContent response2 = makeHttpCall(line2);
				
				if(response1 == null || response2 == null) {
					System.out.println("Comparison cannot be done");
					continue;
				}
				if(response1.isJSON == true && response2.isJSON == true) {
					compareJSON(response1, response2);
				}
				else if(response1.isXML == true && response2.isXML == true) {
					compareXML(response1, response2);
				}
				else {
					compareJSONAndXml(response1, response2);
				}
				line1 = reader1.readLine();
				line2 = reader2.readLine();
			}

			reader1.close();
			reader2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void compareJSONAndXml(UrlContent response1, UrlContent response2) {
		// TODO Auto-generated method stub
		
	}

	private static void compareXML(UrlContent response1, UrlContent response2) {
		// TODO Auto-generated method stub
		
	}

	private static void compareJSON(UrlContent response1, UrlContent response2) {
		JsonParser parser = new JsonParser();
		JsonElement e1 = parser.parse(response1.bodyString);
		JsonElement e2 = parser.parse(response2.bodyString);
		assertEquals(e1, e2);
	}

	private static UrlContent makeHttpCall(String url) throws IOException {
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder().url(url).get().build();

		Response response = client.newCall(request).execute();
		
		String bodyString = response.body().string();
		
		String header = response.header("Content-type").split(";")[0];
		System.out.println(header);
		
		switch(header) {
		case "application/json":
			System.out.println("Processing JSON");
			return new UrlContent(bodyString, true, false);
		case "text/xml":
			System.out.println("processing XML");
			return new UrlContent(bodyString, false, true);
		default:
			System.out.println("Content-type not supported");
			return null;
		}
	}
}
