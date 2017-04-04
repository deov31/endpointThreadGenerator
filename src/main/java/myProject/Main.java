package myProject;
import static spark.Spark.*;

import java.util.*;

import com.google.gson.Gson;

import spark.Request;


import spark.Request;
import spark.Response;
import spark.Route;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		post("/", (req, res) -> {
			
			Gson gson = new Gson();
			
			Datos obj = new Gson().fromJson(req.body(),Datos.class);
			//System.out.print(obj.time);
			//System.out.println(obj.url);
			hiloClase hilo = new hiloClase(obj);
			hilo.start();
			
			
			return gson.toJson("Ok");
			
		});
	}
}
