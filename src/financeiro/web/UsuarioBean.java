package financeiro.web;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class UsuarioBean {

	private String nome;
	private String email;
	private String senha;
	private String confirmaSenha;
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	
	public String operacao(){
		//executa opera��o
	return "resultado";
	}
	
	
	public String novo(){
		return "usuario";
	}
	
	/**
	 * O m�todo salvar apenas verifica se a senha foi digitada corretamente, al�m de salvar o
	 * usu�rio no banco de dados. No teste da confirma��o da senha repare que se a senha n�o foi 
	 * confirmada corretamente o m�todo retorna "usu�rio". Se a senha estiver correta ser�
	 * retornado "sucesso" no final do m�todo.	 * 
	 * 
	 */ 
	
	public String salvar(){
		//FacesContext e FacesMessage s�o classes utilit�rias do JavaServer Faces e servem para 
		//obter informa��es de contexto (do momento da execu��o) e para criar mensagens de erro.a
		FacesContext context = FacesContext.getCurrentInstance();
		if (!this.senha.equalsIgnoreCase (this.confirmaSenha)){
			context.addMessage(null, new FacesMessage (FacesMessage.SEVERITY_ERROR,
		  "Senha confirmada incorretamente", ""));
			//poderia retornar null. ambas as op��es faz o formul�rio seja reexibido.
			return "usuario"; 
		}
		// salva o usuario
		return "sucesso";
	}
	
	/*
	 * Para que as p�ginas a serem criadas possam ter acesso �s propriedades e opera��es da classe
	 * UsuarioBean, � necess�rio fazer um mapeamento da classe. esse mapeamento pode ser feito no 
	 * arquivo faces-config.xml, que deve ficar na pasta WEB-INF, ou usando Annotations, o que � 
	 * muito mais pr�tico. Damos um apelido e que tem que ser como o nome de uma vari�vel, sem
	 * espa�os e nem caracteres especiais. Ex: O nome de mapeamento para a classe financeiro.web
	 * .UsuarioBean poder� ser: usuarioBean. O nome usuarioBean � o que utilizaremos nas p�ginas
	 * JSF para acessar o conte�do do Bean usuarioBean e para realizar as opera��es da classe.
	 */
	
	
	
}
