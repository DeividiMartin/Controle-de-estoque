package login;

import java.util.Scanner;

import application.Control;
import product.Produto;
public class Usuario {
    public Produto produto = new Produto();
    

    private String login;
    private String senha;





    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    Scanner scan = new Scanner(System.in);
    
    

    //Adiciona Usuario
    public void loginAdd(){    

        System.out.print("\nLogin: ");
        this.login = scan.nextLine();

        System.out.print("Senha: ");
        this.senha = scan.nextLine();
    }
        
    //Edita Usuario
    public void loginEdit(){

    
    //Mostra Todos Usuarios

    }   
}
