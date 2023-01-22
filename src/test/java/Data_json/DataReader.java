package Data_json;



import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	//json to string
	public List<HashMap<String,String>> getDataFromJSon() throws IOException
	{
	String JsonContent =	FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\Data_json\\purchaseOrder.json"),StandardCharsets.UTF_8);
	
    
	//string to hashmap
	
	ObjectMapper mapper = new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String, String>>>() {});
	return data;

}}

