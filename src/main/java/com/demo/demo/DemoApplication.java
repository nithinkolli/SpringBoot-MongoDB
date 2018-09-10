package com.demo.demo;

import com.mongodb.*;
import com.mongodb.util.JSON;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.FileNotFoundException;
import java.io.FileReader;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



@Deprecated
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		JSONParser parser = new JSONParser();
		try
		{
			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("test");
			DBCollection collectionDemo = db.getCollection("coll1");
			Object object = parser.parse(new FileReader("C:\\Users\\hp\\Desktop\\test.json"));
			JSONObject jsonObject = (JSONObject)object;
            String s=new String(String.valueOf(jsonObject));
			DBObject dbObject;
			dbObject = (DBObject) JSON.parse(s);
			collectionDemo.insert(dbObject);

		}
		catch(FileNotFoundException fe)
		{
			fe.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}
}