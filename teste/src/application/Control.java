package application;

import java.util.ArrayList;
import java.util.Scanner;

import login.Adm;
import login.Usuario;
import product.Produto;

public class Control {

    public ArrayList<Produto> produtoList = new ArrayList<>();
    public ArrayList<Usuario> usuarioList = new ArrayList<>();

    
    

    Scanner scan = new Scanner(System.in);
    private boolean add;
    private boolean remove;
    

    public void menuUsuario(){
        Usuario usuario = new Usuario();
        Produto produto = new Produto();
        System.out.print("MENU USUARIO\n\n[1]Adicionar produto\n[2]Pesquisar produto\n\nEscolha uma opção: ");
        int select = scan.nextInt();

        switch(select){
            case 1: {
                produto.addProduct();
            }
            case 2: {
                produto.seeProduct();
                System.out.print("[1]Alterar\n[2]Remover\n[3]Voltar ao menu\n[4]Finalizar programa\nEscolha uma opção: ");
                int select1 = scan.nextInt();

                switch(select1){
                    case 1:{
                        produto.editProduct();
                    }
                    case 2:{
                        produto.removeProduct();
                    }
                    case 3:{
                        menuUsuario();
                    }
                    case 4:{
                    }
                } 
            }
        }
    }


    public void menuAdm(){
        Usuario usuario = new Usuario();
        System.out.print("MENU ADM\n\n[1]Adicionar usuario\n[2]Remover usuario\n[3]Alterar usuario\n[4]Mostrar Usuarios\n[5]Logar com outra conta\n[6]Finalizar Programa\n\nEscolha uma opção: ");
        int select = scan.nextInt();

        switch(select){
            case 1: {
                adicionarUsuario();
            }
            case 2: {
               removeUsuario();
            }
            case 3: {
                usuario.loginEdit();
            }
            case 4: {
                loginSee();
                break;
            }
            case 5: {
                login();
            }
            case 6:{
            }
        }
    }

    public void adicionarUsuario(){
        System.out.println("\nADICIONAR USUARIO\nPreencha o cadastro de usuario");
        Usuario usuario = new Usuario();
        usuario.loginAdd();
        add = usuarioList.add(usuario);
        System.out.println("Usuario adicionado com sucesso!");
        menuAdm();
    }

    public void adicionaProduto(){
        Usuario usuario = new Usuario();
        Produto produto = new Produto();

        produto.addProduct();
        add = produtoList.add(usuario.produto);
        System.out.println("\nProduto adicionado com sucesso!");
        menuUsuario();
        
    }   

    //Checagem se é Usuario ou se é Administrador
    public void login(){
        
        Adm adm = new Adm();
        Control control = new Control();
        boolean escolha = false;
        System.out.print("\n\nLogin: ");
        String checkL = scan.nextLine();

        System.out.print("Senha: ");
        String checkS = scan.nextLine();

        if(checkL.contentEquals(adm.getLoginAdm()) && checkS.contentEquals(adm.getSenhaAdm())){
            escolha = true;
            control.menuAdm();
        }
        if(escolha == false){
            for (Usuario usuarioCheck : control.usuarioList) { 
                if(checkL.contentEquals(usuarioCheck.getLogin()) && checkS.contentEquals(usuarioCheck.getSenha()));
                    control.menuUsuario();
                    escolha = false;
            }
        }
        
    }

    public void removeUsuario(){
        boolean achou = false;
        System.out.print("\nREMOVER USUARIO\n");
        System.out.print("\nUsuario que deseja remover: ");
        String jump = scan.nextLine();
        String checkUser = scan.nextLine();
        System.out.print("\nSenha do usuario que deseja remover: ");
        String checkSenha = scan.nextLine();
        for (Usuario usuarios : usuarioList) {
            achou = true;
            if(checkUser.contentEquals(usuarios.getLogin()) && checkSenha.contentEquals(usuarios.getSenha()));{
                usuarioList.remove(usuarios);
                System.out.println("Usuario removido com sucesso!");
                menuAdm();
            }

        }
        if(achou == false){
            System.out.print("Usuario inexistente\n[1]Tentar novamente\n[2]Voltar para o menu\nFinalizar Programa\nEscolha uma opção: ");
            int select = scan.nextInt();
            switch(select){
                case 1:{
                    removeUsuario();
                }
                case 2:{
                    menuAdm();
                }
                case 3:{
                
                }
            }
        }    
        }
        
        
    

    public void loginSee(){
        Control control = new Control();
        int i = 0;
        System.out.println("\nUsuarios HelpStop\n\n");
        for (Usuario listUsuarios : usuarioList) {
            i = i+1;
            System.out.println("\n\nUsuario "+i+"\nNome: "+listUsuarios.getLogin()+"\nSenha: "+listUsuarios.getSenha()); 
        }
        control.menuAdm();

    }

}



