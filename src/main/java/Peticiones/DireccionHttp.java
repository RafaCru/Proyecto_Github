package Peticiones;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;


import java.io.IOException;


public class DireccionHttp {
    private CloseableHttpClient httpClient;
    private CloseableHttpResponse response;
    private HttpGet httpGet;
    private  String resource;

   public DireccionHttp() {
        this.httpClient = HttpClients.createDefault();
        this.response = null;
        this.httpGet = null;
    }



    public String PeticionGet(String url) throws IOException {
        this.httpGet=new HttpGet(url);
        try {
            this.response=this.httpClient.execute(this.httpGet);
            this.resource = EntityUtils.toString(this.response.getEntity());
    }catch (Exception e){

        }
        return this.resource;
    }
}
