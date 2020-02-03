package Negocio;

public class Carros extends Automovel{



    public Carros(){

    }
    public Carros(String placa, int tempo , int estacionado, int clientID){
        super(placa,tempo,estacionado,clientID);
    }

    public Carros(String placa, int tempo){
        super(placa, tempo);
    }
    @Override
    public String toString() {
        return "Carro:{" +
                "Placa ='" + placa + '\'' +
                ", Tempo =" + tempo +
                ", Estacionado =" + estacionado +
                '}';
    }
}
