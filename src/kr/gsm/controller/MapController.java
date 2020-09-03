package kr.gsm.controller;

import java.io.*;
import java.net.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/map.do")
public class MapController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      	request.setCharacterEncoding("utf-8");
      	String location=request.getParameter("address");
        String addr = "https://dapi.kakao.com/v2/local/search/address.json";
        String apiKey = "KakaoAK d5a292203911b6b0a070e6559decb4c2";

        location = URLEncoder.encode(location, "UTF-8");
        String query = "query=" + location;
        
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(addr);
        stringBuffer.append("?");
        stringBuffer.append(query);
        
        System.out.println("stringBuffer.toString() "+ stringBuffer.toString());
        URL url = new URL(stringBuffer.toString());
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Authorization", apiKey);
        conn.setRequestMethod("GET");
        
        BufferedReader rd = null;          
        rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        StringBuffer docJson = new StringBuffer();
        
        String line;          
        while((line=rd.readLine())!=null){
            docJson.append(line);
        }          
        if(0<docJson.toString().length()){
            System.out.println("docJson    :"+docJson.toString());
        }     
        
        rd.close();          
        JSONObject jsonObject = new JSONObject(docJson.toString());          
        JSONArray jsonArray= (JSONArray) jsonObject.get("documents");          
        JSONObject tempObj = (JSONObject) jsonArray.get(0);
        response.setContentType("text/json;charset=euc-kr");
        PrintWriter out=response.getWriter();    
        out.println(tempObj.toString());
        //System.out.println("latitude : " + tempObj.getDouble("y"));
        //System.out.println("longitude : " + tempObj.getDouble("x"));
	}

}
