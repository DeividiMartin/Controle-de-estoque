package login;

import java.util.Scanner;

import produto.Produto;

public class Usuario {
    public Produto produto = new Produto();

    private String usuario;
    private String senha;


    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
 
    Scanner scan = new Scanner(System.in);

    //Adicionar usuario
    public void loginAdd(){

        System.out.print("Cadastre um novo usuario: ");
        setUsuario(scan.nextLine());

        System.out.print("Cadastre uma senha: ");
        setSenha(scan.nextLine());
    }

}
