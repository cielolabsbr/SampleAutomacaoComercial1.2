package lio;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class tela2 extends JFrame {
    
    private JPanel pnlPrincipal;
    private JLabel ImagemTopoMeio;
    private JList jlista;
    private JButton btnSair;
    private JButton btnDetalhes;
    
    public tela2() throws IOException {
        super("Cielo Labs - Inovação");
        initialize();   
    }
    private void initialize() throws IOException {
        setSize(1366, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(getPnlPrincipal());
        setLayout(null);  
        setResizable(false);
        ImageIcon icone = new ImageIcon("imagens/cielo.png");
        setIconImage(icone.getImage());
    }
    private JPanel getPnlPrincipal() throws IOException {
        if (pnlPrincipal == null) {
            pnlPrincipal = new JPanel();
            OKHTTP conexao = new OKHTTP();        
            List<String> lista = conexao.getOrders();
            pnlPrincipal.add(getListaJF(lista)); 
            pnlPrincipal.add(getBtnDetalhes());
            pnlPrincipal.add(getBtnSair());
            pnlPrincipal.add(getImagemTopoMeio());
            
        }
        return pnlPrincipal;
    } 
    private JList getListaJF(List<String> lista){
        if(jlista == null){
            Collections.sort(lista);
            jlista = new JList(lista.toArray());
            jlista.setForeground(new Color(1,161,240));
            jlista.setOpaque(false);      
            jlista.setFixedCellHeight(47);
            jlista.setFont(new Font("Exo",Font.ITALIC + Font.BOLD, 45));
            jlista.setBounds(400, 220, 200, 600);
            DefaultListCellRenderer renderer = (DefaultListCellRenderer) jlista.getCellRenderer();
            renderer.setHorizontalAlignment(SwingConstants.CENTER);
        }
        return jlista;
    }  
    private JLabel getImagemTopoMeio(){
        if(ImagemTopoMeio == null){
            ImagemTopoMeio = new JLabel(new ImageIcon("imagens/topoMeio2.png"));
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
    private JButton getBtnDetalhes() {
        
        if (btnDetalhes == null) {
            ImageIcon ImgDetalhes = new ImageIcon("imagens/detalhes do pedido.png");
            btnDetalhes = new JButton(ImgDetalhes);
            btnDetalhes.setBounds(895, 528,130,175);
            btnDetalhes.setBorderPainted(false);
            btnDetalhes.setContentAreaFilled(false);
            btnDetalhes.addActionListener((ActionEvent arg0) -> {
                    final List<String> selectedValuesList = jlista.getSelectedValuesList();
                    String listString = "";
                    listString = selectedValuesList.stream().map((s) -> s).reduce(listString, String::concat);
                    if("".equals(listString)){
                        JOptionPane.showMessageDialog(tela2.this,"Selecione uma mesa!");
                    }
                    else{
                        try {
                            new tela3(listString).setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(tela.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            });
        }
        return btnDetalhes;
    }
}
