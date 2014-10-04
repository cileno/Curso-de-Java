package br.com.bolsadevalores.view;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.bolsadevalores.model.entidade.Negocio;

@SuppressWarnings("serial")
public class NegociosTableModel extends AbstractTableModel {
	private final List<Negocio> negocios;
	
	public NegociosTableModel(List<Negocio> negocios) {
		this.negocios = negocios;
	}
	
	@Override
	//Marcandoa tabela como somente leitura
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	@Override
	// nomeando as colunas
	public String getColumnName(int column) {
		switch (column) {
		case 0: return "Preço";
		case 1: return "Quantidade";
		case 2: return "Data";
		}
		
		return null;
	}
	
	@Override
	public int getRowCount() {
		return negocios.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Negocio negocio = negocios.get(rowIndex);
		
		switch (columnIndex) {
		case 0: 
			NumberFormat nfNumero = NumberFormat.getCurrencyInstance();
			return nfNumero.format(negocio.getPreco());
		case 1: return negocio.getQuantidade();
		case 2:
			DateFormat dfData = new SimpleDateFormat("dd/MM/yyyy");
			return dfData.format(negocio.getData().getTime());
		}
		return null;
	}
}
