/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Giancarlo
 */
@Path("VerificaCEp")
public class VerificaCEpResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of VerificaCEpResource
     */
    public VerificaCEpResource() {
    }

    /**
     * Retrieves representation of an instance of Controller.VerificaCEpResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{CEP}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCep(@PathParam("CEP") String cep) {
         try {
            URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != 200) {
                throw new RuntimeException("Erro ->" + conexao.getResponseCode());
            }

            BufferedReader Bufresposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String resposta = ""; 
            String json = "";
            while ((resposta = Bufresposta.readLine()) != null) {
                json += resposta;
            }
            
            return json;

        } catch (Exception e) {
            return "{error: true}";
        }
    }

}
