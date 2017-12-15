package it.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ProdottiaggiuntiTableModel extends AbstractTableModel {

    private ArrayList<Prodotto> prodottoAggiunti;
    public ProdottiaggiuntiTableModel (ArrayList<Prodotto> prodottoAggiunti){
        this.prodottoAggiunti=prodottoAggiunti;
    }
    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }


}
