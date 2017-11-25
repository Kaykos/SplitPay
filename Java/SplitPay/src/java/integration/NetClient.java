/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author sala_a
 */
public class NetClient {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://10.192.70.21:64698/api/users";
    
    public NetClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI);
    }

  public String translate() throws ClientErrorException {
      String x = webTarget.request().get(String.class);
      System.out.println(x);
      return x;
  }
}