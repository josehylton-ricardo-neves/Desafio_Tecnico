package objective;

import javax.swing.JOptionPane;
import objective.Pratos;

public class JogoGourmet {
	
	private static Pratos pratos;

	public static void main(String[] args) {

		Pratos lasanha = new Pratos();
		Pratos boloDeChocolate = new Pratos();
		
		lasanha.setNomeDoPrato("Lasanha");
		boloDeChocolate.setNomeDoPrato("Bolo de chocolate");
		
		JogoGourmet.pratos = new Pratos();
		
		pratos.setNomeDoPrato("massa");
		pratos.setPratoSim(lasanha);
		pratos.setPratoNao(boloDeChocolate);
		
		while(true) {
						
			int continuar = JOptionPane.showConfirmDialog(null, "Pense em um prato que gosta", "Jogo Gourmet", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
			
			if(continuar == -1) {
				break;
			}
			
			int retornoOpcaoEscolhida = JOptionPane.showConfirmDialog(null, "O prato que voce pensou é " + pratos.getNomeDoPrato() +" ?", "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			switch (retornoOpcaoEscolhida) {
			case 0:
				pratos.confirmaPrato(pratos.getPratoSim());
				break;
			case 1:
				pratos.confirmaPrato(pratos.getPratoNao());
				break;
	
			}
		}
	}

}
