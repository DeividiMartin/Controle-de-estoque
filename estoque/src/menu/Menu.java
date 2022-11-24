package menu;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Controle controle = new Controle();
        controle.login();        
    }
    
    public  void menuAdm() {//menu onde somente o administrador tem acesso
        Controle controle = new Controle();
        Scanner scan = new Scanner(System.in);
        System.out.print("MENU ADMINISTRADOR\n\n[1]Adicionar usuario\n[2]Remover usuario\n[3]Alterar usuario\n[4]Mostrar Usuarios\n[5]Logar com outra conta\n[6]Finalizar Programa\n\nEscolha uma opção: ");
        int select = scan.nextInt();
        switch(select){
            case 1: {
                controle.newUser();
                break;
            }
            case 2: {
                controle.removerUsuario();
               break;
            }
            case 3: {
                controle.editUsuario();
                break;
            }
            case 4: {
                controle.seeUsuarios();
                break;
            }
            case 5: {
                controle.login();
                break;
            }
            case 6:{
                System.exit(0);
                break;
            }
        }
    }
    public void menuUsuario(){//menu onde os usuarios tem acesso
        Controle controle = new Controle();
        Scanner scan = new Scanner(System.in);
        System.out.print("\nMENU USUARIO\n\n[1]Adicionar produto\n[2]Pesquisar produto\n[3]Logar com outra conta\n[4]Finalizar programa\nEscolha uma opção: ");

        int select = scan.nextInt();
        switch(select){
            case 1: {
                controle.adicionarProduto();
            }
            case 2: {
                controle.seeUsuarios();
                System.out.println("[1]Alterar\n[2]Remover\n[3]Voltar ao menu\n[4]Finalizar programa\nEscolha uma opção: ");
                int select1 = scan.nextInt();
                switch(select1){
                    case 1:{
                        controle.editarProduto();
                        break;
                    }
                    case 2:{
                        controle.removerProduto();
                    }
                    case 3:{
                        menuUsuario();
                    }
                    case 4:{
                        System.exit(0);
                    }
                } 


            }
        }    

    }
}
