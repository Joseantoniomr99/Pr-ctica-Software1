package blastGUI;

import java.awt.event.*;

import blast.BlastController;

public class Action implements ActionListener {
	private Panel p;

	public Action(Panel panel) {
		this.p = panel;
	}

	public void actionPerformed(ActionEvent e) {
		String secuencia = "";
		String porcentaje = "";
		float percent = -1;
		String resultado = "";
		try {
			secuencia = p.getCb().getSelectedItem().toString().toUpperCase();
			
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		if (secuencia == null) {
			System.out.println("Error secuencia nula o no identificada");
		}
		else if (secuencia.contentEquals("")) {
			System.out.println("Error secuencia vacía");
		}else if(need2add(secuencia)) {
			p.getCb().addItem(secuencia);
		}
		try {
			porcentaje = p.getTpercent().getText();
			percent = Float.parseFloat(porcentaje);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		if (porcentaje.equals("")) {
			System.out.println("No se ha aportado ningún valor");
		} else if (percent < 0 || percent > 1) {
			System.out.println();
		}
		BlastController bCnt = new BlastController();
		if (p.getRbprot().isSelected()) {
			try {
				
				resultado = bCnt.blastQuery('p', p.getCb_bd().getSelectedItem().toString(),
						p.getCb_indices().getSelectedItem().toString(), percent, secuencia);
			} catch (Exception ex) {
				
				System.out.println(ex.toString());
			}
		} else if (p.getRbnucleotido().isSelected()) {
			resultado = "Función con nucleótidos aún no implementada";
		}
		p.getTaresultado().setText(resultado);
	}
	private boolean need2add(String seq) {
		boolean need2add = true;
		for(int i = 0; i<p.getCb().getItemCount();i++) {
			if(p.getCb().getItemAt(i).equals(seq)){
				need2add = false;
			}
		}
		
		return need2add;
	}
}
