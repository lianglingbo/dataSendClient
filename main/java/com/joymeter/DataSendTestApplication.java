package com.joymeter;

import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.alibaba.fastjson.JSONObject;
import com.joymeter.util.HttpClient;

@SpringBootApplication
@EnableAsync
public class DataSendTestApplication {
	public static final String url = "http://192.168.31.26:18080/monitor/event";
	public static final String url2 = "http://192.168.31.26:18080/monitor/xxx";
	public static void main(String[] args) {
		SpringApplication.run(DataSendTestApplication.class, args);

		
	}

	void random(){
		Random random = new Random();
		JSONObject jsonObject = new JSONObject();
		while (true) {
			jsonObject.put("deviceId", Integer.valueOf(random.nextInt(50000)));
			jsonObject.put("serverId", Integer.valueOf(random.nextInt(10)));
			jsonObject.put("type", Integer.valueOf(random.nextInt(5000)));
			jsonObject.put("event", "data");
			jsonObject.put("data", String.format("%.3f", new Object[] { Double.valueOf(Math.random()) }));
			jsonObject.put("datetime", Long.valueOf(System.currentTimeMillis()));

			HttpClient.sendPost(url, jsonObject.toString());
			try {
				Thread.sleep(100L);
			} catch (Exception e) {
				Logger.getLogger(DataSendTestApplication.class.getName()).log(Level.SEVERE, null, e);
			}
		}
	}
 
	void one(){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("deviceId", "100");
		jsonObject.put("gatewayId", "BEAC");
		jsonObject.put("project", "Vlinker");
		jsonObject.put("province", "上海");
		jsonObject.put("city", "市辖区");
		jsonObject.put("district", "浦东新区");
		jsonObject.put("community", "卡园二路");
		jsonObject.put("address", "卡园二路,7幢,1单元,A128");
		jsonObject.put("deviceState", "0");
		HttpClient.sendPost(url, jsonObject.toString());
	}
}
