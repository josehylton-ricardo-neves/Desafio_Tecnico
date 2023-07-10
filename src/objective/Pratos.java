package objective;

import javax.swing.JOptionPane;

public class Pratos {
	
	private Pratos pratoEscolhaSim;
	private Pratos pratoEscolhaNao;
	private String nomeDoPrato;
	
	
	public Pratos() {
		this.nomeDoPrato = null;
		this.pratoEscolhaNao = null;
		this.pratoEscolhaSim = null;
	}
	
	public void confirmaPrato(Pratos pratoAtual) {
		
		int retornoOpcaoEscolhida = JOptionPane.showConfirmDialog(null, "O prato que voce pensou é " + pratoAtual.getNomeDoPrato() +" ?",
				"Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		switch (retornoOpcaoEscolhida) {
		case 0:
			
			if(pratoAtual.getPratoSim() == null) {
				JOptionPane.showMessageDialog(null, "Acertei de novo !", "Jogo Gourmet", JOptionPane.INFORMATION_MESSAGE);
			} else {
				confirmaPrato(pratoAtual.getPratoSim());
			}
			break;
			
		case 1:
			
			if(pratoAtual.getPratoNao() != null) {
				confirmaPrato(pratoAtual.getPratoNao());
			} else {
				atualizaPratos(pratoAtual);
			}
			break;

		}
	}
	
	private void atualizaPratos(Pratos pratoAtual) {
		Pratos novoPratoSim = new Pratos();
		Pratos novoPratoNao = new Pratos();
		
		novoPratoNao.setNomeDoPrato(pratoAtual.getNomeDoPrato());

		String movoPratoNome = JOptionPane.showInputDialog(null, "Qual prato voce pensou ?", "Desisto", JOptionPane.QUESTION_MESSAGE);
		String novoPratoTipo = JOptionPane.showInputDialog(null, movoPratoNome + " é ____ mas " + pratoAtual.getNomeDoPrato() + " não.", "Complete", JOptionPane.INFORMATION_MESSAGE);

		novoPratoSim.setNomeDoPrato(movoPratoNome);
		
		pratoAtual.setNomeDoPrato(novoPratoTipo);
		pratoAtual.setPratoSim(novoPratoSim);
		pratoAtual.setPratoNao(novoPratoNao);
	}
	

	public Pratos getPratoSim() {
		return pratoEscolhaSim;
	}

	public void setPratoSim(Pratos pratoSim) {
		this.pratoEscolhaSim = pratoSim;
	}

	public Pratos getPratoNao() {
		return pratoEscolhaNao;
	}

	public void setPratoNao(Pratos pratoNao) {
		this.pratoEscolhaNao = pratoNao;
	}

	public String getNomeDoPrato() {
		return nomeDoPrato;
	}

	public void setNomeDoPrato(String nomeDoPrato) {
		this.nomeDoPrato = nomeDoPrato;
	}
	
}