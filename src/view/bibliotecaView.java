package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import modelo.cadastroLivros;

public class bibliotecaView extends JFrame{
	private JTable tabela;
	private JScrollPane painel;
	private JPanel painelSalvar = new JPanel();
	private JPanel painelAlterarDeletar = new JPanel();
	//Elementos do painel de salvar
	private JLabel textoMarca = new JLabel("Marca:");
	private JTextField campoMarca = new JTextField(15);
	private JLabel textoModelo = new JLabel("Modelo: ");
	private JTextField campoModelo = new JTextField(15);
	private JLabel textoMemoria = new JLabel("Mem�ria: ");
	private JTextField campoMemoria = new JTextField(15);
	private JButton botaoSalvar = new JButton("Salvar");
	//Elementos do painel de alterar e deletar
	private JLabel textoIdAlterar = new JLabel("Id do BD:");
	private JTextField campoIdAlterar = new JTextField(15);
	private JLabel textoMarcaAlterar = new JLabel("Marca:");
	private JTextField campoMarcaAlterar = new JTextField(15);
	private JLabel textoModeloAlterar = new JLabel("Modelo: ");
	private JTextField campoModeloAlterar = new JTextField(15);
	private JLabel textoMemoriaAlterar = new JLabel("Memória: ");
	private JTextField campoMemoriaAlterar = new JTextField(15);
	private JButton botaoAlterar = new JButton("Alterar");
	private JButton botaoDeletar = new JButton("Deletar");

	public bibliotecaView() {
		this.setSize(540,300);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void configurarComponentes(ActionListener ouvinte) {
		painelSalvar.add(textoMarca);
		painelSalvar.add(campoMarca);
		painelSalvar.add(textoModelo);
		painelSalvar.add(campoModelo);
		painelSalvar.add(textoMemoria);
		painelSalvar.add(campoMemoria);
		botaoSalvar.addActionListener(ouvinte);
		painelSalvar.add(botaoSalvar);
		painelSalvar.setPreferredSize(new Dimension(250, 135));
		this.add(painelSalvar);
		
		painelAlterarDeletar.add(textoIdAlterar);
		painelAlterarDeletar.add(campoIdAlterar);
		painelAlterarDeletar.add(textoMarcaAlterar);
		painelAlterarDeletar.add(campoMarcaAlterar);		
		painelAlterarDeletar.add(textoModeloAlterar);
		painelAlterarDeletar.add(campoModeloAlterar);
		painelAlterarDeletar.add(textoMemoriaAlterar);
		painelAlterarDeletar.add(campoMemoriaAlterar);
		botaoAlterar.addActionListener(ouvinte);
		botaoDeletar.addActionListener(ouvinte);
		painelAlterarDeletar.add(botaoAlterar);
		painelAlterarDeletar.add(botaoDeletar);
		painelAlterarDeletar.setPreferredSize(new Dimension(250, 135));
		this.add(painelAlterarDeletar);		
	
		this.limparCampos();
	}

	public void carregarTabela(List<cadastroLivros> listaLivro, MouseListener ouvinte2) {
		if(painel != null)
			this.remove(painel);
		String[] nomesColunas = new String[] {
				"idlivro","titulo", "ano", "locall","autor","editora"
		};

		Object[][] dados = new Object[listaLivro.size()][5];	
		for(int i=0; i<listaLivro.size(); i++) {
			dados[i][0] = listaLivro.get(i).getIdlivro();
			dados[i][1] = listaLivro.get(i).getTitulo();
			dados[i][2] = listaLivro.get(i).getAno();
			dados[i][3] = listaLivro.get(i).getAutor();
			dados[i][4] = listaLivro.get(i).getLocal();

		}
		tabela = new JTable(dados,nomesColunas);
		painel = new JScrollPane(tabela);
		painel.setPreferredSize(new Dimension(520, 115));
		this.tabela.addMouseListener(ouvinte2);
		this.add(painel);
		this.revalidate();
	}
	
	public void limparCampos() {
		this.campoIdAlterar.setText("");
		this.campoMarcaAlterar.setText("");
		this.campoMemoriaAlterar.setText("");
		this.campoModeloAlterar.setText("");
		this.campoMarca.setText("");
		this.campoMemoria.setText("");
		this.campoModelo.setText("");
		this.botaoAlterar.setEnabled(false);
		this.botaoDeletar.setEnabled(false);
	}

	
	
	public JTextField getCampoMarca() {
		return campoMarca;
	}

	public void setCampoMarca(JTextField campoMarca) {
		this.campoMarca = campoMarca;
	}

	public JTextField getCampoModelo() {
		return campoModelo;
	}

	public void setCampoModelo(JTextField campoModelo) {
		this.campoModelo = campoModelo;
	}

	public JTextField getCampoMemoria() {
		return campoMemoria;
	}

	public void setCampoMemoria(JTextField campoMemoria) {
		this.campoMemoria = campoMemoria;
	}

	public JButton getBotaoSalvar() {
		return botaoSalvar;
	}

	public void setBotaoSalvar(JButton botaoSalvar) {
		this.botaoSalvar = botaoSalvar;
	}

	public JButton getBotaoAlterar() {
		return botaoAlterar;
	}

	public void setBotaoAlterar(JButton botaoAlterar) {
		this.botaoAlterar = botaoAlterar;
	}

	public JButton getBotaoDeletar() {
		return botaoDeletar;
	}

	public void setBotaoDeletar(JButton botaoDeletar) {
		this.botaoDeletar = botaoDeletar;
	}

	public JTable getTabela() {
		return tabela;
	}

	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}

	public JTextField getCampoIdAlterar() {
		return campoIdAlterar;
	}

	public void setCampoIdAlterar(JTextField campoIdAlterar) {
		this.campoIdAlterar = campoIdAlterar;
	}

	public JTextField getCampoMarcaAlterar() {
		return campoMarcaAlterar;
	}

	public void setCampoMarcaAlterar(JTextField campoMarcaAlterar) {
		this.campoMarcaAlterar = campoMarcaAlterar;
	}

	public JTextField getCampoModeloAlterar() {
		return campoModeloAlterar;
	}

	public void setCampoModeloAlterar(JTextField campoModeloAlterar) {
		this.campoModeloAlterar = campoModeloAlterar;
	}

	public JTextField getCampoMemoriaAlterar() {
		return campoMemoriaAlterar;
	}

	public void setCampoMemoriaAlterar(JTextField campoMemoriaAlterar) {
		this.campoMemoriaAlterar = campoMemoriaAlterar;
	}
	
	
	
	
}
