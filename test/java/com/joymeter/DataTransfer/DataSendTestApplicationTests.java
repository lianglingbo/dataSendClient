package com.joymeter.DataTransfer;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;
import com.joymeter.util.HttpClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSendTestApplicationTests {

	@Test
	public void contextLoads() {
		String url = "http://192.168.31.26:18080/monitor/register";
		HashMap<String, String> params = new HashMap<>();
		JSONObject jsonObject = new JSONObject();
		params.put("data", jsonObject.toString());
		jsonObject.put("deviceId", "626066");
		//jsonObject.put("dataUsed", "62579");
		//jsonObject.put("deviceState", "0");
		//jsonObject.put("simId", "8628");
		jsonObject.put("gatewayId", "745FW4");
		jsonObject.put("project", "没有乱码");
		jsonObject.put("province", "浙江省");
		jsonObject.put("city", "杭州市");
		jsonObject.put("district", "滨江区");
		jsonObject.put("community", "dm小区");
		jsonObject.put("address", "d楼m室");
		//jsonObject.put("simState", "0");
		//jsonObject.put("valveState", "0");

		params.replace("data", jsonObject.toString());
		String reslut = HttpClient.sendPost(url, jsonObject.toString());
		System.out.println(reslut);
	}

}
