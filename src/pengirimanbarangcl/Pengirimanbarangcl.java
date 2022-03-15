/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengirimanbarangcl;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author user
 */
public class Pengirimanbarangcl {

    static String postRequest(String endpoint, String input) {
        String result = "";
        try {
            URL url = new URL("http://localhost:2000/pbapi/api/pengiriman/findbynamapenerima1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                result = output;
            }

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    
    public static void main(String[] args) {
        String endpoint = "http://localhost:2000/pbapi/api/pengiriman/findbynamapenerima1";
       
        PostRequest prs = new PostRequest("a", "keuno");

        String input = new Gson().toJson(prs);
        String result = postRequest(endpoint, input);
        System.out.println(result);
        
        ResponseRest restObj = new Gson().fromJson(result, ResponseRest.class);
        
        for (String message : restObj.getMessages()) {
            System.out.println(message);
        }
        
        for (Pengiriman pengiriman : restObj.getData()) {
            System.out.println(pengiriman.getNama_penerima());
        }
    }
    
}
