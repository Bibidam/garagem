package Negocio;

import java.util.ArrayList;

public class Clientes {

     String nome; // Nome do Cliente
     private int idade; //idade do cliente
     private ArrayList<Carros> meusCarros = new ArrayList<Carros>();
     private ArrayList<Motos> minhasMotos = new ArrayList<Motos>();
     private int valorDevedor; //O valor que devedor

    public Clientes(){

    }

    public Clientes(String nome,int idade){
        this.nome = nome;
        this.idade = idade;
        //como é o cadastro do cliente, logo ele não possui salvado devedor, com isso seta-se 0 no saldo
        this.valorDevedor = 0;

    }

    public void adicionarCarro(Carros carroAdicionar){
        this.meusCarros.add(carroAdicionar);

    }

    public boolean removerCarro(Carros carroRemover){
        if(this.meusCarros.contains(carroRemover)){
            meusCarros.remove(carroRemover);
            return true;
        }
        else{
            return false;
        }
    }

    public void adicionarMoto(Motos motoAdicionar){
        this.minhasMotos.add(motoAdicionar);

    }

    public boolean removermoto(Motos motoRemover){
        if(this.minhasMotos.contains(motoRemover)){
            minhasMotos.remove( motoRemover);
            return true;
        }
        else{
            return false;
        }
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public ArrayList<Carros> getMeusCarros() {
        return meusCarros;
    }

    public void setMeusCarros(ArrayList<Carros> meusCarros) {
        this.meusCarros = meusCarros;
    }

    public ArrayList<Motos> getMinhasMotos() {
        return minhasMotos;
    }

    public void setMinhasMotos(ArrayList<Motos> minhasMotos) {
        this.minhasMotos = minhasMotos;
    }

    public int getValorDevedor() {
        return valorDevedor;
    }

    public void setValorDevedor(int valorDevedor) {
        this.valorDevedor = valorDevedor;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", Carros =" + meusCarros +
                ", Motos =" + minhasMotos +
                ", Valor devedor =" + valorDevedor +
                '}';
    }
}
