package bitproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

public class Connection {
    
    public final String URL = "https://bitbay.net/API/Public/BTCPLN/trades.json";

    public String getURL() {
        return URL;
    }
    
    public Connection() throws IOException{
        
    }

    public String getJSON(String url) throws IOException {
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        try {
            inputStream = new URL(url).openStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            //System.out.println(readData(bufferedReader));
            return readData(bufferedReader);
        } catch (IOException e) {
            throw e;
        }finally{
            closeResource(inputStream);
            closeResource(bufferedReader);
        }
    }
    
//    private String getJSON(String url) throws IOException {
//        InputStream inputStream = null;
//        BufferedReader bufferedReader = null;
//        try {
//            inputStream = new URL(url).openStream();
//            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
//            System.out.println(readData(bufferedReader));
//            return readData(bufferedReader);
//        } catch (IOException e) {
//            throw e;
//        }finally{
//            closeResource(inputStream);
//            closeResource(bufferedReader);
//        }
//    }
   
    public void closeResource(AutoCloseable closable){
        try {
            if(closable != null){
                closable.close();
                System.out.println(closable.getClass().getName()+" CLOSED...");
            }
        } catch (Exception e) {
        }
    }
    
    private String readData(Reader reader) throws IOException{
       StringBuilder stringBuilder = new StringBuilder();
       int cp;
       
       while ((cp = reader.read()) != -1){
           stringBuilder.append((char)cp);
       }
       
       return stringBuilder.toString();
    }
}

