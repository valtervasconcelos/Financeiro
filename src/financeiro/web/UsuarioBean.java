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
		//executa operação
	return "resultado";
	}
	
	
	public String novo(){
		return "usuario";
	}
	
	/**
	 * O método salvar apenas verifica se a senha foi digitada corretamente, além de salvar o
	 * usuário no banco de dados. No teste da confirmação da senha repare que se a senha não foi 
	 * confirmada corretamente o método retorna "usuário". Se a senha estiver correta será
	 * retornado "sucesso" no final do método.	 * 
	 * 
	 */ 
	
	public String salvar(){
		//FacesContext e FacesMessage são classes utilitárias do JavaServer Faces e servem para 
		//obter informações de contexto (do momento da execução) e para criar mensagens de erro.a
		FacesContext context = FacesContext.getCurrentInstance();
		if (!this.senha.equalsIgnoreCase (this.confirmaSenha)){
			context.addMessage(null, new FacesMessage (FacesMessage.SEVERITY_ERROR,
		  "Senha confirmada incorretamente", ""));
			//poderia retornar null. ambas as opções faz o formulário seja reexibido.
			return "usuario"; 
		}
		// salva o usuario
		return "sucesso";
	}
	
	/*
	 * Para que as páginas a serem criadas possam ter acesso às propriedades e operações da classe
	 * UsuarioBean, é necessário fazer um mapeamento da classe. esse mapeamento pode ser feito no 
	 * arquivo faces-config.xml, que deve ficar na pasta WEB-INF, ou usando Annotations, o que é 
	 * muito mais prático. Damos um apelido e que tem que ser como o nome de uma variável, sem
	 * espaços e nem caracteres especiais. Ex: O nome de mapeamento para a classe financeiro.web
	 * .UsuarioBean poderá ser: usuarioBean. O nome usuarioBean é o que utilizaremos nas páginas
	 * JSF para acessar o conteúdo do Bean usuarioBean e para realizar as operações da classe.
	 */
	
	
	
}
