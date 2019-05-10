package assignment5;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;



@RestController
@RequestMapping("/nbaplayer")

public class NbaplayerController {

	@GetMapping
	public ArrayList<Nbaplayer> getAll() throws IOException{
		ArrayList<Nbaplayer> list = readJSON();
		return list;
	}
	
	

	@GetMapping("/{id}")
	public Nbaplayer getOne(@PathVariable int id) throws ResourceNotFoundException, IOException {
		ArrayList<Nbaplayer> list = readJSON();
		
		if(list.get(id) != null) {
			return list.get(id);
		} else {
			throw new ResourceNotFoundException();
		}
	}
	
	private ArrayList<Nbaplayer> readJSON() throws IOException {
		URL url = new URL("https://api.myjson.com/bins/yn8lq");
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	    connection.setRequestMethod("GET");
	    connection.connect();

	    BufferedReader json  = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        Gson gson = new Gson();
        ArrayList<Nbaplayer> al = gson.fromJson(json, new TypeToken<ArrayList<Nbaplayer>>(){}.getType());
		return al;		
	}
	
}
