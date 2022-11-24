package menu;

import java.util.ArrayList;
import java.util.Scanner;


import login.Adm;
import login.Usuario;

public class Controle {
    Menu menu = new Menu();  
    Scanner scan = new Scanner(System.in);
    private boolean add;

    public ArrayList<Usuario> usuarioList = new ArrayList<>();
    String usuarioAtual;
    String senhaAtual;

    //LOGIN PARA SABER SE É ADM OU USUARIO
    public void login(){
        Adm adm = new Adm();
        boolean escolha = false;
        System.out.println("LOGIN HelpStok");

        System.out.print("\nLogin: ");
        String checkUser = scan.nextLine();

        System.out.print("Senha: ");
        String checkSenha = scan.nextLine();

        if(checkUser.contentEquals(adm.getAdmUsuario()) && checkSenha.contentEquals(adm.getAdmSenha()));{
            checkUser = usuarioAtual;
            checkSenha = senhaAtual;
            escolha = true;
            menu.menuAdm();
        }
        if(escolha == false){
            checkUser = usuarioAtual;
            checkSenha = senhaAtual;
            for (Usuario usuario : usuarioList) {
                if(checkUser.contentEquals(usuario.getUsuario()) && checkSenha.contentEquals(usuario.getSenha())){
                    menu.menuUsuario();
                    break;
                }     
            }
        }
        else{
            System.out.print("\nUsuario ou senha incorreto.\n[1]Tentar novamente\n[2]Finalizar programa\nEscolha uma opção: \n\n");
            int select =scan.nextInt();
            switch(select){
                case 1:{
                    login();
                    break;
                }
                case 2:{
                    System.exit(0);
                }
            }  
        }
    }

    //METODO PARA ADICIONAR USUARIO
    public void newUser(){
        Usuario usuario = new Usuario();
        System.out.println("\nADICIONAR NOVO USUARIO\nPreencha o cadastro de usuario");
        usuario.loginAdd();
        add = usuarioList.add(usuario);
        System.out.println("\nUsuario adicionado com sucesso!\n\n");
        menu.menuAdm();
    }

    //remover um usuario cadastrado
    public void removerUsuario(){
        boolean achou = false;
        System.out.print("\n\nREMOVER USUARIO\n");

        System.out.print("\nUsuario que deseja remover: ");
        String checkUser = scan.nextLine();

        System.out.print("\nSenha do usuario que deseja remover: ");
        String checkSenha = scan.nextLine();

        for (Usuario usuario : usuarioList) {
            achou = true;
            if(checkUser.contentEquals(usuario.getUsuario()) && checkSenha.contentEquals(usuario.getSenha()));{
                usuarioList.remove(usuario);
                System.out.println("Usuario removido com sucesso!");
                menu.menuAdm();
            }
        }
        if(achou == false){
            System.out.print("Usuario inexistente\n[1]Tentar novamente\n[2]Voltar para o menu\nFinalizar Programa\nEscolha uma opção: ");
            int select = scan.nextInt();
            switch(select){
                case 1:{
                    removerUsuario();
                }
                case 2:{
                    menu.menuAdm();
                }
                case 3:{
                    System.exit(0);
                }
            }
        }    
    }
    //editar o usuario
    public void editUsuario(){
        boolean achou = false;

        System.out.print("Digite o nome de usuario que deseja alterar: ");
        String checkUser = scan.nextLine();

        System.out.print("Digite a senha do usuario que deseja alterar: ");
        String checkSenha = scan.nextLine();

        for (Usuario usuario : usuarioList) {
            if(checkUser.contentEquals(usuario.getUsuario()) && checkSenha.contentEquals(usuario.getSenha())){
                achou = true;
                System.out.println("Oque deseja alterar?\n[1]Usuario\n[2]Senha");
                int select = scan.nextInt();
                switch(select){
                    case 1 :{
                        System.out.print("Escolha o novo nome de usuario: ");
                        usuario.setUsuario(scan.nextLine());
                        System.out.println("\nNome de usuario alterado com sucesso!\n");
                        menu.menuAdm();
                    }
                    case 2: {
                        System.out.print("Escolha uma nova senha para o usuario: ");
                        usuario.setSenha(scan.nextLine());
                        System.out.println("Senha alterada com sucesso!");
                        menu.menuAdm();
                    }
                }
            }   
        }
        if(achou == false){
            System.out.print("Usuario não encontrado.\n[1]Tentar novamente\n[2]Voltar para o menu\n[3]Finalizar programa\nEscolha uma opção: ");
            int select = scan.nextInt();
            switch(select){
                case 1 :{
                    editUsuario();
                    break;
                }
                case 2:{
                    menu.menuAdm();
                    break;
                }
                case 3:{
                    System.exit(0);
                }
            }
        }
    }
    //mostrar os usuarios cadastrados
    public void seeUsuarios(){

        int i = 0;
        System.out.println("\nUsuarios HelpStop\n\n");
        for (Usuario usuario : usuarioList) {
            i = i+1;
            System.out.println("\n\nUsuario "+i+"\nNome: "+usuario.getUsuario()+"\nSenha: "+usuario.getSenha()); 
            menu.menuAdm(); 
        }
    }
    


    public void adicionarProduto(){
        for (Usuario usuarios : usuarioList) {
            if(usuarioAtual.contentEquals(usuarios.getUsuario())){
                System.out.print("Nome do produto: ");
                usuarios.produto.setName(scan.nextLine());

                System.out.print("Valor do produto: ");
                usuarios.produto.setValor(scan.nextDouble());

                System.out.print("Digite a quantidade: ");
                usuarios.produto.setQuantidade(scan.nextInt());

                System.out.print("Insira o codigo: ");
                usuarios.produto.setCodigo(scan.nextLong());

                System.out.println("Produto adicionado com sucesso!");    
            }
        }
    }

    public void seeProduto(){
        boolean achou = false;
    
        for (Usuario usuarios : usuarioList) {
            if(usuarioAtual.contentEquals(usuarios.getUsuario())){
                 
                System.out.print("insira o codigo do produto: ");
                long checkProduct = scan.nextLong();
                    
                if( checkProduct == usuarios.produto.getCodigo()){
                    achou = true;
                    System.out.println("Produto: "+usuarios.produto.getName()+"\nValor: "+usuarios.produto.getValor()+"\nQuantidade: "+usuarios.produto.getQuantidade()+"\nCodigo: "+usuarios.produto.getCodigo());
                }
                if(achou == false){
                    System.out.println("Produto não encontrado\n[1]Tentar novamente\n[2]Voltar para o menu\n");
                    int select = scan.nextInt();
                    switch(select){
                        case 1:{
                            seeProduto();
                            break;
                        }
                        case 2:{
                            menu.menuUsuario();
                            break;
                        }
                    }
                }       
            } 
        }
    }

    public void editarProduto(){
        for (Usuario usuarios : usuarioList) {
            if(usuarioAtual.contentEquals(usuarios.getUsuario())){
                System.out.println("Oque deseja editar?\n[1]Nome\n[2]Valor\n[3]Quantidade");
                int select = scan.nextInt();
                switch(select){
                    case 1 : {
                        usuarios.produto.setName(scan.nextLine());
                        System.out.println("Alteração feita com sucesso!");
                        menu.menuUsuario();
                        break;
                    }
                    case 2:{
                        usuarios.produto.setValor(scan.nextDouble());
                        System.out.println("Alteração feita com sucesso!");
                        menu.menuUsuario();
                        break;
                    }
                    case 3:{
                        usuarios.produto.setQuantidade(scan.nextInt());
                        System.out.println("Alteração feita com sucesso!");
                        menu.menuUsuario();
                        break;
                    }
                }
            }
        }  
    }


    public void removerProduto(){

        for (Usuario usuarios : usuarioList) {
            if(usuarioAtual.contentEquals(usuarios.getUsuario())){
                System.out.print("Digite o codigo do produto que deseja remover: ");
                long checkProduto = scan.nextLong();
                if(checkProduto == usuarios.produto.getCodigo()){
                    usuarioList.remove(usuarios.produto);
                    System.out.println("Produto removido com sucesso!");
                    menu.menuUsuario();
                }
            }
        }
    }
}
