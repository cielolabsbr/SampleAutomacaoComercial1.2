package lio;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OKHTTP {
      
    

void post(String mesa, float valorTotal, int pedido,int qtdGoiaba, int qtdUva, int qtdLaranja, int qtdManga, float valorGoiaba, float valorUva, float valorLaranja, float valorManga) throws IOException {

    String Goiaba="",Uva="",Laranja="",Manga="", todos="";

    if (qtdGoiaba!=0){
        valorGoiaba = valorGoiaba*100;
        Goiaba = "{\n            \"name\":\"Suco Goiaba\",\n            \"sku\":\"0000001\",\n            \"unit_price\":"+(int)valorGoiaba+",\n            \"quantity\":"+qtdGoiaba+",\n            \"unit_of_measure\":\"EACH\"\n        },\n";
    }
    if (qtdUva!=0){
        valorUva = valorUva*100;
        Uva = "{\n            \"name\":\"Suco de Uva\",\n            \"sku\":\"0000010\",\n            \"unit_price\":"+(int)valorUva+",\n            \"quantity\":"+qtdUva+",\n            \"unit_of_measure\":\"EACH\"\n        },\n";
    }
    if (qtdLaranja!=0){
        valorLaranja = valorLaranja*100;
        Laranja = "{\n            \"name\":\"Suco de Laranja\",\n            \"sku\":\"0000011\",\n            \"unit_price\":"+(int)valorLaranja+",\n            \"quantity\":"+qtdLaranja+",\n            \"unit_of_measure\":\"EACH\"\n        },\n";
    }
    if (qtdManga!=0){
        valorManga = valorManga*100;
        Manga = "{\n            \"name\":\"Suco de Manga\",\n            \"sku\":\"0000100\",\n            \"unit_price\":"+(int)valorManga+",\n            \"quantity\":"+qtdManga+",\n            \"unit_of_measure\":\"EACH\"\n        },\n";
    }

    todos = Goiaba + Uva + Laranja + Manga;

     if (!todos.isEmpty()) todos = todos.substring (0, todos.length() - 2);

    valorTotal = valorTotal*100;
    String corpo = "{\n    \"number\":\"0992f1d5-cee5-40d9-a964-8f4d6a9e4aa6\",\n    \"reference\":\"Pedido Mesa#"+mesa+"\",\n    \"status\":\"ENTERED\",\n    \"items\":[\n        "+todos+"\n    ],\n    \"notes\":\"Mesa "+mesa+"\",\n    \"price\":"+(int)valorTotal+"\n}";

    //System.out.println(corpo);

    OkHttpClient client = new OkHttpClient();

    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = RequestBody.create(mediaType, corpo);

    Request request = new Request.Builder()
      .url("https://api.cielo.com.br/order-management/v1/orders")
      .post(body)
      .addHeader("client-id","************") //Essa informacao eh gerada a partir do portal de desenvolvedores da Cielo (http://desenvolvedores.cielo.com.br/)
      .addHeader("access-token", "************")//Essa informacao eh gerada a partir do portal de desenvolvedores da Cielo (http://desenvolvedores.cielo.com.br/)
      .addHeader("merchant-id", "********-****-****-****-************") //Essa informacao eh gerada a partir do portal de desenvolvedores da Cielo (http://desenvolvedores.cielo.com.br/)
      .addHeader("content-type", "application/json")
      .addHeader("cache-control", "no-cache")
      .addHeader("postman-token", "dfe8fe39-2c24-d825-4096-332ab99178c5")
      .build();

    Response response = client.newCall(request).execute();
    put(response);
}


void put(Response responsePost) throws IOException {

    OkHttpClient client = new OkHttpClient();
    
    String resposta = responsePost.body().string();

    if (!resposta.isEmpty()) resposta = resposta.substring (7, resposta.length() - 2);
    //System.out.println(resposta);
    
    String urlPut = "https://api.cielo.com.br/order-management/v1"+resposta+"?operation=PLACE";
    //System.out.println(urlPut);
    
    MediaType mediaType = MediaType.parse("");
    RequestBody body = RequestBody.create(mediaType, "");

    Request request = new Request.Builder()
    .url(urlPut)
    .put(body)
    .addHeader("client-id","************") //Essa informacao eh gerada a partir do portal de desenvolvedores da Cielo (http://desenvolvedores.cielo.com.br/)
    .addHeader("access-token", "************")//Essa informacao eh gerada a partir do portal de desenvolvedores da Cielo (http://desenvolvedores.cielo.com.br/)
    .addHeader("merchant-id", "********-****-****-****-************") //Essa informacao eh gerada a partir do portal de desenvolvedores da Cielo (http://desenvolvedores.cielo.com.br/)
	.addHeader("content-type", "application/json")
    .addHeader("cache-control", "no-cache")
    .addHeader("postman-token", "dfe8fe39-2c24-d825-4096-332ab99178c5")
    .build();

    Response response = client.newCall(request).execute();
}

}