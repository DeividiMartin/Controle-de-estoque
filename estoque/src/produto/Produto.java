package produto;

import java.util.Scanner;

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
    
}
