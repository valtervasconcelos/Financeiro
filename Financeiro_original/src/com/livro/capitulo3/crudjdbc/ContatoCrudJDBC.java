package com.livro.capitulo3.crudjdbc;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class ContatoCrudJDBC {

	// Parei na página 119

	public void salvar(Contato contato) {

		System.out.println("Estou em salvar contato, mas antes vou me conectar ao banco");

		Connection conexao = this.geraConexao();
		PreparedStatement insereSt = null;
		
		System.out.println("Agora vou inserir um contato");
		
    //  Não precisa passar o parâmetro codigo pois o mesmo é alto inclemento (lembrar de retirar ou colocar uma "?")
	//	String sql = "INSERT INTO `agenda`.`contato` (`codigo`,`nome`,`telefone`,`email`,`dat_cad`,`obs`) VALUES (?, ?, ?, ?, ?, ?)";
		
		String sql = "INSERT INTO `agenda`.`contato` (`nome`,`telefone`,`email`,`dat_cad`,`obs`) VALUES (?, ?, ?, ?, ?)";

		try {
			insereSt = conexao.prepareStatement(sql);
		//	insereSt.setLong(1, contato.getCodigo());
			insereSt.setString(1, contato.getNome());
			insereSt.setString(2, contato.getTelefone());
			insereSt.setString(3, contato.getEmail());
			insereSt.setDate(4, contato.getDatacadastro());
			insereSt.setString(5, contato.getObservacao());
			insereSt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Erro ao incluir um contato.  Mensagem: "
					+ e.getMessage());
		} finally {
			try {
				insereSt.close();
				conexao.close();

			} catch (Throwable e) {
				System.out
						.println("Erro ao fechar operações de inserção. Mensagem: "
								+ e.getMessage());
			}
		}

	}

	public void atualizar(Contato contato) {
	}

	public void excluir(Contato contato) {

		System.out.println("Agora estou em excluir um contato");

	}
	
	
	
	

	public List<Contato> listar() {

		System.out.println("Agora estou em Listar contato");

		Connection conexao = this.geraConexao();
		List<Contato> contatos = new ArrayList<Contato>();
		Statement consulta = null;
		ResultSet resultado = null;
		Contato contato = null;

		String sql = "SELECT * FROM `contato` WHERE 1";
		
		try {
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);

			while (resultado.next()) {
				contato = new Contato();
				contato.setCodigo(new Integer(resultado.getInt("codigo")));
				contato.setNome(resultado.getString("nome"));
				contato.setTelefone(resultado.getString("telefone"));
				contato.setEmail(resultado.getString("email"));
				contato.setDatacadastro(resultado.getDate("dat_cad"));
				contato.setObservacao(resultado.getString("obs"));
				contatos.add(contato);
				
				
			    System.out.println("Código: " + contato.getCodigo());
				System.out.println("Nome: " + contato.getNome());
				System.out.println("Data Cadastro: " + contato.getDatacadastro());
				System.out.println("E-mail: " + contato.getEmail()); 
				System.out.println("---------------");
				
			}

		} catch (SQLException e) {
			System.out.println("Erro ao buscar código do contato. Mensagem: "
					+ e.getMessage());

		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();

			} catch (Throwable e) {
				System.out
						.println("Erro ao fechar operações de consulta. Mensagem:  "
								+ e.getMessage());

			}
		}

		return contatos;

	}

	// public Contato buscaContato(int valor) {
	//
	// //Parei na página 119
	// }
	//

	public Connection geraConexao() {

		System.out.println("O método geraConexao foi chamado");

		Connection conexao = null;

		try {
			// registrando a classe JDBC no sistema em tempo de execução
			String url = "jdbc:mysql://localhost/agenda";
			String usuario = "root";
			String senha = "root";
			conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Banco conectado!");
			System.out.println("--------------------");

		} catch (SQLException e) {
			System.out.println("Ocorreu um erro no acesso ao banco!"
					+ "Erro:  " + e.getMessage());

		}
		
		return conexao;

	}

	// Parei na página 119

	public static void main(String[] args) {
		
		System.out.println("Vou criar e depois inserir um novo contato");

		ContatoCrudJDBC contatoCRUDJDBC = new ContatoCrudJDBC();
		Contato beltrano = new Contato();
	//	beltrano.setCodigo(003);  //Não preciso passar o codigo pois o mesmo é alto inclemento
		beltrano.setNome("Elton Farias");
		beltrano.setTelefone("(81) 8832-1987");
		beltrano.setEmail("Carlos@teste.com.br");
		beltrano.setDatacadastro(new Date(System.currentTimeMillis()));
		beltrano.setObservacao("Novo cliente");
		
		contatoCRUDJDBC.salvar(beltrano);

		System.out.println("contatos cadastrados:  "
				+ contatoCRUDJDBC.listar().size());
			
     //  contatoCRUDJDBC.excluir(beltrano);
	}

}
