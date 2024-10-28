package table;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import model.Customer;

public class TableCustomer extends AbstractTableModel{
	List<Customer> ls;
	private String[] columnNames = {"ID", "Name", "Address", "Hp"};
	public TableCustomer(List <Customer> ls) {
		this.ls = ls;
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return ls.size();
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}
	public String getColumnName (int column) {
		// TODO Auto-generated method stub
		return columnNames[column];
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0:
			return ls.get(rowIndex).getId();
		case 1 :
			return ls.get(rowIndex).getName();
		case 2 :
			return ls.get(rowIndex).getAddress();
		case 3 :
			return ls.get(rowIndex).getHp();
		default :
		return null;
		}
		
	}

}