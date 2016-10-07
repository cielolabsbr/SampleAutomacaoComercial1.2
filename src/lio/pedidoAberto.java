package lio;

import org.json.JSONArray;

class pedidoAberto {

    int price;
    String reference;
    String status;
    String id;
    String number;
    JSONArray transactions;
    
    pedidoAberto(String status, int price, String reference, String id,String number,JSONArray transactions) {
        this.status=status;
        this.price=price;
        this.reference=reference;
        this.id=id;
        this.number=number;
        this.transactions=transactions;
    }   
}
