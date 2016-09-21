package lio;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class tela extends JFrame {
    
    private JPanel pnlPrincipal;

    private JLabel mesaTexto;
    
    private JLabel valorTotal;
    private JLabel valorTotalImagem;
    
    private JButton mesa1;
    private JButton mesa2;
    private JButton mesa3;
    private JButton mesa4;
    private JButton mesa5;
    private JButton mesa6;

    private JLabel pedidoTexto;
   
    private JButton btnLogin;
    private JButton btnCancelar;
    private JButton btnSair;
    
    private JButton addUva;
    private JLabel cinUva;
    private JButton remUva;
    
    private JButton addLar;
    private JLabel cinLar;
    private JButton remLar;
    
    private JButton addMan;
    private JLabel cinMan;
    private JButton remMan;
    
    private JButton addGoi;
    private JLabel cinGoi;
    private JButton remGoi;
    
    private JLabel ImagemTopoMeio;
    
    private JLabel qtdUva;
    private JLabel qtdLaranja;
    private JLabel qtdManga;
    private JLabel qtdGoiaba;

    float total=0;

    int pedido=1;
    int numeroMesa=0;
        
    float valorGoiaba = (float) 4.5;
    float valorUva = (float) 4.5;
    float valorLaranja = (float) 4.5;
    float valorManga = (float)4.5;
    
    int Goiaba = 0;
    int Uva = 0;
    int Laranja = 0;
    int Manga = 0;
    
    public tela() {
        super("Cielo Labs - Inovação");
        initialize();   
    }
 
    private void initialize() {
        setSize(1280, 730);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(getPnlPrincipal());
        setLayout(null);  
        setResizable(false);
        ImageIcon icone = new ImageIcon("cielo.png");
        setIconImage(icone.getImage());
    }
 
    private JPanel getPnlPrincipal() {
        if (pnlPrincipal == null) {
            
            pnlPrincipal = new JPanel();
            
            pnlPrincipal.add(getQtdUva());
            pnlPrincipal.add(getQtdLaranja());
            pnlPrincipal.add(getQtdManga());
            pnlPrincipal.add(getQtdGoiaba());
            
            pnlPrincipal.add(getLblCinzaUva());
            pnlPrincipal.add(getLblCinzaLaranja());
            pnlPrincipal.add(getLblCinzaManga());
            pnlPrincipal.add(getLblCinzaGoiaba());
            
            pnlPrincipal.add(getLblMesa());
            pnlPrincipal.add(getLblPedido());
            pnlPrincipal.add(getLblValor());
            pnlPrincipal.add(getLblValorTotalImagem());

            pnlPrincipal.add(getBtnCompra());
            pnlPrincipal.add(getBtnLimparPedido());
            pnlPrincipal.add(getBtnSair());
            
            pnlPrincipal.add(getBtnAddUva());
            pnlPrincipal.add(getBtnRemUva());
            pnlPrincipal.add(getBtnAddLaranja());
            pnlPrincipal.add(getBtnRemLaranja());
            pnlPrincipal.add(getBtnAddManga());
            pnlPrincipal.add(getBtnRemManga());
            pnlPrincipal.add(getBtnAddGoiaba());
            pnlPrincipal.add(getBtnRemGoiaba());
            
            pnlPrincipal.add(getBtnMesa1());
            pnlPrincipal.add(getBtnMesa2());
            pnlPrincipal.add(getBtnMesa3());
            pnlPrincipal.add(getBtnMesa4());
            pnlPrincipal.add(getBtnMesa5());
            pnlPrincipal.add(getBtnMesa6());

            pnlPrincipal.add(getImagemTopoMeio());  
        }
        return pnlPrincipal;
    }
    
    private JLabel getLblValorTotalImagem(){
            if(valorTotalImagem == null){
                valorTotalImagem = new JLabel(new ImageIcon("valor total.png"));
                valorTotalImagem.setBounds(370, 525,400,200);
        }
        return valorTotalImagem;
    }
    
    private JLabel getQtdUva(){
        if (qtdUva == null) {        
            qtdUva = new JLabel(String.valueOf(Uva));
            qtdUva.setForeground(new Color(105,17,176));
            qtdUva.setFont(new Font("Exo",Font.ITALIC + Font.BOLD, 35));
            qtdUva.setBounds(145, 473,60,55);
        }
        return qtdUva;
    }
    
    private JLabel getQtdLaranja(){
        if (qtdLaranja == null) {
            qtdLaranja = new JLabel(String.valueOf(Laranja));
            qtdLaranja.setForeground(new Color(105,17,176));
            qtdLaranja.setFont(new Font("Exo",Font.ITALIC + Font.BOLD, 35));
            qtdLaranja.setBounds(460, 473,60,55);
        }
        return qtdLaranja;
    }
    private JLabel getQtdManga(){
        if (qtdManga == null) {
            qtdManga = new JLabel(String.valueOf(Manga));
            qtdManga.setForeground(new Color(105,17,176));
            qtdManga.setFont(new Font("Exo",Font.ITALIC + Font.BOLD, 35));
            qtdManga.setBounds(755, 473,60,55);
        }
        return qtdManga;
    }
    private JLabel getQtdGoiaba(){
        if (qtdGoiaba == null) {
            qtdGoiaba = new JLabel(String.valueOf(Goiaba));
            qtdGoiaba.setForeground(new Color(105,17,176));
            qtdGoiaba.setFont(new Font("Exo",Font.ITALIC + Font.BOLD, 35));
            qtdGoiaba.setBounds(1070, 473,60,55);
        }
        return qtdGoiaba;
    }
    
    private JLabel getLblMesa() {
        if (mesaTexto == null) {
            if(numeroMesa==0)
                mesaTexto = new JLabel("Mesa ");
            else
                mesaTexto = new JLabel("Mesa " + numeroMesa );
                        
            mesaTexto.setFont(new Font("Exo",Font.ITALIC + Font.BOLD, 25));
            mesaTexto.setBounds(20, 555, 600, 20);
        }
        return mesaTexto;
    }
    
    private JLabel getLblValor() {
        if (valorTotal == null) {
            valorTotal = new JLabel(); 
            valorTotal.setText(String.format("R$%.2f",total));
            valorTotal.setForeground(new Color(255,255,255));
            valorTotal.setFont(new Font("Exo",Font.ITALIC + Font.BOLD, 45));
            valorTotal.setBounds(435, 605, 700, 100);
        }
        return valorTotal;
    }
     
    private JLabel getLblPedido() {
        if (pedidoTexto == null) {
            pedidoTexto = new JLabel("Pedido " + String.valueOf(pedido));
            pedidoTexto.setForeground(new Color(255,255,255));
            pedidoTexto.setFont(new Font("Exo",Font.ITALIC + Font.BOLD, 30));
            pedidoTexto.setBounds(1150, 20, 600, 20);
        }
        return pedidoTexto;
    }
    
    private JButton getBtnCompra() {
        if (btnLogin == null) {
            
            ImageIcon ImgEnviar = new ImageIcon("enviarr.png");
                          
            btnLogin = new JButton(ImgEnviar);
            btnLogin.setBounds(750, 528,135,175);
            btnLogin.setContentAreaFilled(false);
            btnLogin.setBorderPainted(false);
            btnLogin.addActionListener((ActionEvent arg0) -> {
                if(numeroMesa!=0){
                    if(total!=0 && 0<=Goiaba && 0<=Uva && 0<=Laranja && 0<=Manga){
                        OKHTTP conexao = new OKHTTP();
                        try {
                            conexao.post(String.valueOf(numeroMesa),total,pedido,Goiaba,Uva,Laranja,Manga,valorGoiaba,valorUva,valorLaranja,valorManga);
                        } catch (Exception ex) {
                            Logger.getLogger(tela.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JOptionPane.showMessageDialog(tela.this,"Pedido "+ (pedido) +" enviado!\nMesa: " + numeroMesa + "\n" + String.format("Total: R$%.2f",total));
                        pedido++;
                        Uva=0;
                        Goiaba=0;
                        Laranja=0;
                        Manga=0;
                        qtdGoiaba.setText(String.valueOf(Goiaba));
                        qtdUva.setText(String.valueOf(Uva));
                        qtdLaranja.setText(String.valueOf(Laranja));
                        qtdManga.setText(String.valueOf(Manga));
                        pedidoTexto.setText("Pedido " + String.valueOf(pedido));
                        numeroMesa=0;
                        mesaTexto.setText("Mesa ");
                        total=0;
                        valorTotal.setText(String.format("R$%.2f",total));
                    }
                    else{
                        JOptionPane.showMessageDialog(tela.this,"Por favor, preencha valores validos");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(tela.this,"Por favor, selecione uma mesa!");
                }
            });
        }
        return btnLogin;
    }
 
    private JButton getBtnLimparPedido() {
        if (btnCancelar == null) {
            
            ImageIcon ImgCancelar = new ImageIcon("Limpar Pedido.png");
            btnCancelar = new JButton(ImgCancelar);
            btnCancelar.setBounds(890, 528,130,175);
            btnCancelar.setBorderPainted(false);
            btnCancelar.setContentAreaFilled(false);
            btnCancelar.addActionListener((ActionEvent arg0) -> {
                numeroMesa=0;
                mesaTexto.setText("Mesa ");
                Uva=0;
                Goiaba=0;
                Laranja=0;
                Manga=0;
                qtdGoiaba.setText(String.valueOf(Goiaba));
                qtdUva.setText(String.valueOf(Uva));
                qtdLaranja.setText(String.valueOf(Laranja));
                qtdManga.setText(String.valueOf(Manga));
                total=0;
                valorTotal.setText(String.format("R$%.2f",total));
            });
        }
        return btnCancelar;
    }
 
    private JButton getBtnSair() {
        if (btnSair == null) {
            ImageIcon ImgSair = new ImageIcon("sair.png");
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
    
        private JButton getBtnAddUva() {
        if (addUva == null) {
            ImageIcon water = new ImageIcon("botaoMais.png");
            addUva = new JButton(water);
            addUva.setBorderPainted(false);
            addUva.setContentAreaFilled(false);
            addUva.setBorder(new RoundedBorder(10));
            addUva.setBounds(160, 470,140,55);
            addUva.addActionListener((ActionEvent arg0) -> {
                if(Uva!=99){
                    Uva++;
                    qtdUva.setText(String.valueOf(Uva));
                    total=(float)((Goiaba*valorGoiaba)+(Uva*valorUva)+(Laranja*valorLaranja)+(Manga*valorManga));
                    valorTotal.setText(String.format("R$%.2f",total));
                }
            });
        }
        return addUva;
    }
    
    private JButton getBtnRemUva() {
        if (remUva == null) {
            ImageIcon water = new ImageIcon("botaoMenos.png");
            remUva = new JButton(water);
            remUva.setBorderPainted(false);
            remUva.setContentAreaFilled(false);
            remUva.setBorder(new RoundedBorder(10));
            remUva.setBounds(20, 470,140,55);
            remUva.addActionListener((ActionEvent arg0) -> {
                if(Uva!=0){
                    Uva--;
                    qtdUva.setText(String.valueOf(Uva));
                    total=(float)((Goiaba*valorGoiaba)+(Uva*valorUva)+(Laranja*valorLaranja)+(Manga*valorManga));
                    valorTotal.setText(String.format("R$%.2f",total));
                }
            });
        }
        return remUva;
    }
    
    private JLabel getLblCinzaUva(){
            if(cinUva == null){
            cinUva = new JLabel(new ImageIcon("cinza.png"));
            cinUva.setBounds(120, 459,80,80);
        }
        return cinUva;
    }
 
    private JButton getBtnAddLaranja() {
        if (addLar == null) {
            ImageIcon water = new ImageIcon("botaoMais.png");
            addLar = new JButton(water);
            addLar.setBorderPainted(false);
            addLar.setContentAreaFilled(false);
            addLar.setBounds(470, 470,140,55);
            addLar.addActionListener((ActionEvent arg0) -> {
                if(Laranja!=99){
                    Laranja++;
                    qtdLaranja.setText(String.valueOf(Laranja));
                    total=(float)((Goiaba*valorGoiaba)+(Uva*valorUva)+(Laranja*valorLaranja)+(Manga*valorManga));
                    valorTotal.setText(String.format("R$%.2f",total));
                }
            });
        }
        return addLar;
    }
    
    private JButton getBtnRemLaranja() {
        if (remLar == null) {
            ImageIcon water = new ImageIcon("botaoMenos.png");
            remLar = new JButton(water);
            remLar.setBorderPainted(false);
            remLar.setContentAreaFilled(false);
            remLar.setBounds(330, 470,140,55);
            remLar.addActionListener((ActionEvent arg0) -> {
                if(Laranja!=0){
                    Laranja--;
                    qtdLaranja.setText(String.valueOf(Laranja));
                    total=(float)((Goiaba*valorGoiaba)+(Uva*valorUva)+(Laranja*valorLaranja)+(Manga*valorManga));
                    valorTotal.setText(String.format("R$%.2f",total));
                }
            });
        }
        return remLar;
    }
    
    private JLabel getLblCinzaLaranja(){
            if(cinLar == null){
            cinLar = new JLabel(new ImageIcon("cinza.png"));
            cinLar.setBounds(434, 459,80,80);
        }
        return cinLar;
    }
    
        private JButton getBtnAddManga() {
        if (addMan == null) {
            ImageIcon water = new ImageIcon("botaoMais.png");
            addMan = new JButton(water);
            addMan.setBorderPainted(false);
            addMan.setContentAreaFilled(false);
            addMan.setBounds(770, 470,140,55);
            addMan.addActionListener((ActionEvent arg0) -> {
                if(Manga!=99){
                    Manga++;
                    qtdManga.setText(String.valueOf(Manga));
                    total=(float)((Goiaba*valorGoiaba)+(Uva*valorUva)+(Laranja*valorLaranja)+(Manga*valorManga));
                    valorTotal.setText(String.format("R$%.2f",total));
                }
            });
        }
        return addMan;
    }
    
    private JButton getBtnRemManga() {
        if (remMan == null) {
             ImageIcon water = new ImageIcon("botaoMenos.png");
            
            remMan = new JButton(water);
            remMan.setBorderPainted(false);
            remMan.setContentAreaFilled(false);
            remMan.setBounds(630, 470,140,55);
            remMan.addActionListener((ActionEvent arg0) -> {
                if(Manga!=0){
                    Manga--;
                    qtdManga.setText(String.valueOf(Manga));
                    total=(float)((Goiaba*valorGoiaba)+(Uva*valorUva)+(Laranja*valorLaranja)+(Manga*valorManga));
                    valorTotal.setText(String.format("R$%.2f",total));
                }
            });
        }
        return remMan;
    }
    
        private JLabel getLblCinzaManga(){
            if(cinMan == null){
            cinMan = new JLabel(new ImageIcon("cinza.png"));
            cinMan.setBounds(730, 459,80,80);
        }
        return cinMan;
    }
    
    private JButton getBtnAddGoiaba() {
        if (addGoi == null) {
                      ImageIcon water = new ImageIcon("botaoMais.png");
            addGoi = new JButton(water);
            addGoi.setBorderPainted(false);
            addGoi.setContentAreaFilled(false);
            addGoi.setBounds(1085, 470,140,55);
            addGoi.addActionListener((ActionEvent arg0) -> {
                if(Goiaba!=99){
                    Goiaba++;
                    qtdGoiaba.setText(String.valueOf(Goiaba));
                    total=(float)((Goiaba*valorGoiaba)+(Uva*valorUva)+(Laranja*valorLaranja)+(Manga*valorManga));
                    valorTotal.setText(String.format("R$%.2f",total));
                }
            });
        }
        return addGoi;
    }
    
    private JButton getBtnRemGoiaba() {
        if (remGoi == null) {
             ImageIcon water = new ImageIcon("botaoMenos.png");
     
            remGoi = new JButton(water);
            remGoi.setBorderPainted(false);
            remGoi.setContentAreaFilled(false);
            remGoi.setBounds(945, 470,140,55);
            remGoi.addActionListener((ActionEvent arg0) -> {
                if(Goiaba!=0){
                    Goiaba--;
                    qtdGoiaba.setText(String.valueOf(Goiaba));
                    total=(float)((Goiaba*valorGoiaba)+(Uva*valorUva)+(Laranja*valorLaranja)+(Manga*valorManga));
                    valorTotal.setText(String.format("R$%.2f",total));
                }
            });
        }
        return remGoi;
    }

    private JLabel getLblCinzaGoiaba(){
            if(cinGoi == null){
            cinGoi = new JLabel(new ImageIcon("cinza.png"));
            cinGoi.setBounds(1045, 459,80,80);
        }
        return cinGoi;
    }
            
     private JLabel getImagemTopoMeio(){
        if(ImagemTopoMeio == null){
            ImagemTopoMeio = new JLabel(new ImageIcon("topoMeio.png"));
            ImagemTopoMeio.setBounds(0, 0, 1280, 720);
        }
        return ImagemTopoMeio;
    }
     
    private JButton getBtnMesa1() {
        if(mesa1 == null) {
            ImageIcon imgMesa = new ImageIcon("MESA01.png");
            mesa1 = new JButton(imgMesa);
            mesa1.setBorderPainted(false);
            mesa1.setContentAreaFilled(false);
            mesa1.setBounds(20, 590,101,41);
            mesa1.addActionListener((ActionEvent arg0) -> {
                numeroMesa=1;
                mesaTexto.setText("Mesa " + String.valueOf(numeroMesa));
            });
        }
        return mesa1;
    }
    private JButton getBtnMesa2() {
        if(mesa2 == null) {
            ImageIcon imgMesa = new ImageIcon("MESA02.png");
            mesa2 = new JButton(imgMesa);
            mesa2.setBorderPainted(false);
            mesa2.setContentAreaFilled(false);
            mesa2.setBounds(155, 590,101,41);
            mesa2.addActionListener((ActionEvent arg0) -> {
                numeroMesa=2;
                mesaTexto.setText("Mesa " + String.valueOf(numeroMesa));
            });
        }
        return mesa2;
    }
    private JButton getBtnMesa3() {
        if(mesa3 == null) {
            ImageIcon imgMesa = new ImageIcon("MESA03.png");
            mesa3 = new JButton(imgMesa);
            mesa3.setBorderPainted(false);
            mesa3.setContentAreaFilled(false);
            mesa3.setBounds(290, 590,101,41);
            mesa3.addActionListener((ActionEvent arg0) -> {
                numeroMesa=3;
                mesaTexto.setText("Mesa " + String.valueOf(numeroMesa));
            });
        }
        return mesa3;
    }
    private JButton getBtnMesa4() {
        if(mesa4 == null) {
            ImageIcon imgMesa = new ImageIcon("MESA04.png");
            mesa4 = new JButton(imgMesa);
            mesa4.setBorderPainted(false);
            mesa4.setContentAreaFilled(false);
            mesa4.setBounds(20, 645,101,41);
            mesa4.addActionListener((ActionEvent arg0) -> {
                numeroMesa=4;
                mesaTexto.setText("Mesa " + String.valueOf(numeroMesa));
            });
        }
        return mesa4;
    }
    private JButton getBtnMesa5() {
        if(mesa5 == null) {
            ImageIcon imgMesa = new ImageIcon("MESA05.png");
            mesa5 = new JButton(imgMesa);
            mesa5.setBorderPainted(false);
            mesa5.setContentAreaFilled(false);
            mesa5.setBounds(155, 645,101,41);
            mesa5.addActionListener((ActionEvent arg0) -> {
                numeroMesa=5;
                mesaTexto.setText("Mesa " + String.valueOf(numeroMesa));
            });
        }
        return mesa5;
    }
    private JButton getBtnMesa6() {
        if(mesa6 == null) {
            ImageIcon imgMesa = new ImageIcon("MESA06.png");
            mesa6 = new JButton(imgMesa);
            mesa6.setBorderPainted(false);
            mesa6.setContentAreaFilled(false);
            mesa6.setBounds(290, 645,101,41);
            mesa6.addActionListener((ActionEvent arg0) -> {
                numeroMesa=6;
                mesaTexto.setText("Mesa " + String.valueOf(numeroMesa));
            });
        }
        return mesa6;
    }
}