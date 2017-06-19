package bitproject;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonDecode {
    
    private static List<BitBayAPI> listOfBitBayAPIObjects;
    
    private static Gson gson = new Gson();

    public JsonDecode(){
        
    }
    
    public static List<BitBayAPI> getBitBay(String SiteName) throws IOException{
        if(SiteName == "BitBay"){
            Connection conn = new Connection();

            // Starting point - JSON as a String...
            String jsonAsStringOriginal = conn.getJSON(conn.URL);

            System.out.println(jsonAsStringOriginal);
            // Remove [" "] at start, end...
            StringBuilder sb = new StringBuilder(jsonAsStringOriginal);
            sb.deleteCharAt(0);
            sb.setLength(sb.length() - 1);

            // Remove "," between }{ from the String
            String oldString = "},{";
            String newString = "} {";       
            String jsonAsString = sb.toString();
            jsonAsString = jsonAsString.replace(oldString, newString);

            // Parse String to String[]...
            List<String> listOfJsonObjects = new ArrayList<>(Arrays.asList(jsonAsString.split(" ")));

            // Convert JSON elements from listOfJsonObjects to BitBayAPI objects...     
            List<BitBayAPI> listOfBitBayAPIObjects = new ArrayList<>();        

            for(int i=0; i<listOfJsonObjects.size(); i++){
                BitBayAPI bb = gson.fromJson(listOfJsonObjects.get(i), BitBayAPI.class);            
                listOfBitBayAPIObjects.add(bb);
                System.out.println(listOfBitBayAPIObjects.get(i).getDate()+ " " + listOfBitBayAPIObjects.get(i).getPrice());
            }
            
            }   
        return listOfBitBayAPIObjects;
    }

}

    

