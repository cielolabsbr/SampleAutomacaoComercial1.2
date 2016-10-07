package lio;

import java.awt.Color;
import static java.awt.Color.WHITE;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.json.JSONArray;
import org.json.JSONObject;

public class tela3 extends JFrame {
    
    private JPanel pnlPrincipal;
    private JLabel ImagemTopoMeio;
    private JLabel titulo;
    private JButton btnSair;
    private JLabel campo1;
    private JLabel campo2;
    private JLabel campo3;
    List<pedidoAberto> lista;
    JSONArray transactions;
    JSONObject object;
    int amount=0;
    float valorTotal, valorPago;
    
    public tela3(String mesa) throws IOException {
        super("Cielo Labs - Inovação");
        initialize(mesa);
    }
    
    private void initialize(String mesa) throws IOException {
        setSize(1366, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(getPnlPrincipal(mesa));
        setLayout(null);  
        setResizable(false);
        ImageIcon icone = new ImageIcon("imagens/cielo.png");
        setIconImage(icone.getImage());
    }
    
    private JPanel getPnlPrincipal(String mesa) throws IOException {
        if (pnlPrincipal == null) {
            
            OKHTTP conexao = new OKHTTP();        
            lista = conexao.getOrders2();
            int n=0;

            for(int i=0;i<lista.size();i++){
                    String reference = lista.get(i).reference;
                    if(reference.equals(mesa)){
                        n=i;
                    }
            }
            
            pnlPrincipal = new JPanel();
            transactions = lista.get(n).transactions;
            for(int i=0; i< transactions.length(); i++){
                object = transactions.getJSONObject(i);
                amount = amount + object.getInt("amount");
            }
            pnlPrincipal.add(getLblTitulo(mesa));
            pnlPrincipal.add(getLblCampo1(n));
            pnlPrincipal.add(getLblCampo2(amount));
            pnlPrincipal.add(getLblCampo3(n));
            pnlPrincipal.add(getBtnSair());    
            //pnlPrincipal.add(getBtnAtualizar(mesa));
            pnlPrincipal.add(getImagemTopoMeio());           
        }
        return pnlPrincipal;
    }
    
    private JLabel getLblTitulo(String mesa){
            if(titulo == null){
            titulo = new JLabel(mesa);
            titulo.setFont(new Font("Exo",Font.ITALIC + Font.BOLD, 45));
            titulo.setForeground(WHITE);
            titulo.setBounds(440, 55,500,200);
        }
        return titulo;
    }
    
    private JLabel getLblCampo1(int n) throws IOException{
            if(campo1 == null){
            valorTotal=(float)lista.get(n).price/100;
            campo1 = new JLabel(String.format("Valor total:  R$%.2f",valorTotal));
            campo1.setFont(new Font("Exo",Font.ITALIC + Font.BOLD, 35));
            campo1.setForeground(new Color(1,161,240));
            campo1.setBounds(365, 230,700,50);
        }
        return campo1;
    }
    
    private JLabel getLblCampo2(int n) throws IOException{
           if(campo2 == null){
                valorPago=(float)n/100;
                campo2 = new JLabel(String.format("Valor pago: R$%.2f",valorPago));
                campo2.setFont(new Font("Exo",Font.ITALIC + Font.BOLD, 35));
                campo2.setForeground(new Color(1,161,240));
                campo2.setBounds(365, 280,700,50);
            }
       return campo2;
    }
    
    private JLabel getLblCampo3(int n) throws IOException{
            if(campo3 == null){
            float valorRestante=valorTotal-valorPago;
            campo3 = new JLabel(String.format("Restante:    R$%.2f",valorRestante));
            campo3.setFont(new Font("Exo",Font.ITALIC + Font.BOLD, 35));
            campo3.setForeground(new Color(1,161,240));
            campo3.setBounds(365, 330,700,50);
        }
        return campo3;
    }
    
   private JLabel getImagemTopoMeio(){
        if(ImagemTopoMeio == null){
            ImagemTopoMeio = new JLabel(new ImageIcon("imagens/topoMeio3.png"));
            ImagemTopoMeio.setBounds(0, 0, 1366, 768);
        }
        return ImagemTopoMeio;
    }
   
    private JButton getBtnSair() {
        if (btnSair == null) {
            ImageIcon ImgSair = new ImageIcon("imagens/sair.png");
            btnSair = new JButton(ImgSair);
            btnSair.setBounds(1025, 528,135,175);
            btnSair.setContentAreaFilled(false);
            btnSair.setBorderPainted(false);
            btnSair.addActionListener((ActionEvent arg0) -> {
                dispose();
            });
        }
        return btnSair;
    }
}