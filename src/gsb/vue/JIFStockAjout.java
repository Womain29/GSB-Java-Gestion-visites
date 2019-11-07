package gsb.vue;

import gsb.service.StockService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JIFStockAjout extends JIFStock implements ActionListener {

    private JButton JBValider;
    private JButton JBAnnuler;

    private StockService unStockService = new StockService();

    public JIFStockAjout() {
        super();

        JBValider = new JButton("Valider");
        JBValider.addActionListener(this);
        JBAnnuler = new JButton("Annuler");
        JBAnnuler.addActionListener(this);

        pBoutons.add(JBValider);
        pBoutons.add(JBAnnuler);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Ajout d'un stock");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == JBValider) {
        	String qte = JTQteStock.getText();
        	
        	int quantite = Integer.parseInt(qte);
            unStockService.ajoutStock(JTDepotLegal.getText().toString(),JTMatricule.getText().toString(), quantite);
            this.videTexte();
        }
        if(source == JBAnnuler) {
            this.videTexte();
        }
    }
}
