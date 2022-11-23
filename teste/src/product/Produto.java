package product;
import java.util.Scanner;

import application.Control;


public class Produto {
    

    private String name;
    private double valor;
    private int quantidade;
    private long codigo;

    
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }


    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public double getValor() {
        return valor;
    }
  

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
   
    public int getQuantidade() {
        return quantidade;
    }
 
    Scanner scan = new Scanner(System.in);
    

    public void addProduct(){
        System.out.print("Nome do produto: ");
        this.name = scan.nextLine();

        System.out.print("Valor do produto: ");
        this.valor = scan.nextDouble();

        System.out.print("Digite a quantidade: ");
        this.quantidade = scan.nextInt();

        System.out.print("Insira o codigo: ");
        this.codigo = scan.nextLong();
    }

    public void removeProduct(){
        setName(name);
    }

    public void editProduct(){

    }

    public void seeProduct(){
        Control control = new Control();
        boolean achou = false;
        System.out.print("Insira o codigo do produto");
                long codeCheck = scan.nextLong();
                for (Produto checkCode : control.produtoList) {
                    if(checkCode.getCodigo() == codeCheck){
                        achou = true;
                        System.out.println("Produto: "+checkCode.getName()+"\nValor: "+checkCode.getValor()+"\nQuantidade: "+checkCode.getQuantidade()+"\nCodigo: "+checkCode.getCodigo());
                    }
                    
                }
                if(achou == false){
                    System.out.print("O produto não consta no estoque!\n[1]Tentar novamente\n[2]Voltar ao menu\n[3]Sair\nEscolha uma opçao: ");     
                }
    }
}
