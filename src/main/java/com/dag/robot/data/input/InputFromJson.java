package com.dag.robot.data.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;
import org.neo4j.cypher.internal.compiler.v2_1.docbuilders.internalDocBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dag.robot.data.add.AddService;
import com.dag.robot.utils.PropertiesUtil;

@Service
public class InputFromJson {

	@Autowired
	private AddService addService;

	private String expertFilePath;
	private String paperFilePath;
	private String patentFilePath;

	public InputFromJson() {
		this.expertFilePath = PropertiesUtil.getValue("expertFilePath");
		this.paperFilePath = PropertiesUtil.getValue("paperFilePath");
		this.patentFilePath = PropertiesUtil.getValue("patentFilePath");
	}

	public void inputExpert(String fileName) {
		String string = readFile(expertFilePath, fileName);
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(string);
			JSONArray jsonArray = jsonObject.getJSONArray("expert");

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jObject = jsonArray.getJSONObject(i);
				String name = jObject.getString("name");
				String gender = jObject.getString("gender");
				String orgnization = jObject.getString("orgnization");
				String email = jObject.getString("email");
				String homepage = jObject.getString("homepage");
				String address = jObject.getString("address");
				String info = jObject.getString("info");
				String experience = jObject.getString("experience");
				String topic = jObject.getString("topic");
				String achievement = jObject.getString("achievement");
				int age = jObject.getInt("age");
				String field = jObject.getString("field");
				addService.addExpert(name, gender, email, address, homepage,
						experience, info, topic, achievement, orgnization, age,
						field);
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	public void inputPaper(String fileName) {
		String string = readFile(paperFilePath, fileName);
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(string);
			JSONArray jsonArray = jsonObject.getJSONArray("paper");

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jObject = jsonArray.getJSONObject(i);
				String title = jObject.getString("title");
				JSONArray jArray = jObject.getJSONArray("authors");
				String authors[] = new String[jArray.length()];
				for (int j = 0; j < jArray.length(); j++) {
					String author = jArray.getJSONObject(j).getString("name");
					authors[j] = author;
				}
				String abs = jObject.getString("abs");
				String keywords = jObject.getString("keywords");
				String type = jObject.getString("type");
				String issue = jObject.getString("issue");
				String journal = jObject.getString("journal");
				String conference = jObject.getString("conference");
				String time = jObject.getString("time");
				String orgnization = jObject.getString("orgnization");
				String coreJournal = jObject.getString("coreJournal");
				int referencedNum = Integer.parseInt(jObject
						.getString("referencedNum"));
				addService.addPaper(title, authors, abs, keywords, type,
						journal, issue, conference, time, orgnization,
						coreJournal, referencedNum);
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	public void inputPatent(String fileName) {
		String string = readFile(patentFilePath, fileName);
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(string);
			JSONArray jsonArray = jsonObject.getJSONArray("patent");

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jObject = jsonArray.getJSONObject(i);
				String title = jObject.getString("title");
				JSONArray jArray = jObject.getJSONArray("inventors");
				String inventors[] = new String[jArray.length()];
				for (int j = 0; j < jArray.length(); j++) {
					String author = jArray.getJSONObject(j).getString("name");
					inventors[j] = author;
				}
				String abs = jObject.getString("abs");
				String applicant = jObject.getString("applicant");
				String date = jObject.getString("date");
				String orgnization = jObject.getString("orgnization");
				addService.addPatent(title, applicant, abs, inventors, date,
						orgnization);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String readFile(String path, String fileName) {
		path = path + "/" + fileName;
		File file = new File(path);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String string = "";
		String temp;
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			while ((temp = bufferedReader.readLine()) != null) {
				string = string + temp;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return string;
	}

}
