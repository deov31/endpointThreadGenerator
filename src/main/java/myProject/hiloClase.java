package myProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
public class hiloClase extends Thread{

	private int tiempo;
	private String url;
	private final String USER_AGENT = "Mozilla/5.0";

	public hiloClase(Datos obj) {
		// TODO Auto-generated constructor stub
		this.tiempo = obj.time;
		this.url = obj.url;
	}

	@Override
	public void run() {
		System.out.println("Running...");
		this.esperarXsegundos(tiempo);
		try {
			this.sendPost(url);
			System.out.println("Done");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	
	private void esperarXsegundos(int tiempo) {
		try {
			Thread.sleep(tiempo);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	
	private void sendPost(String url) throws Exception {
		HttpPost httppost = new HttpPost(url);
		HttpClient client = new DefaultHttpClient();
		HttpResponse response;
		String jsondata = "{\"mensa\": \"I ran for  " + tiempo + "\"}";
		StringEntity jsonparam = new StringEntity(jsondata);
		jsonparam.setChunked(true);

		httppost.addHeader("content-type", "application/json;charset=UTF-8");
		httppost.setEntity(jsonparam);
		System.out.print("Sending response...");
		response = client.execute(httppost);

	}

}
