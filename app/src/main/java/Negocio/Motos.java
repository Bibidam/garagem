package Negocio;

public class Motos extends Automovel {

    public Motos(){

    }

    public Motos(String placa, int tempo){
        super(placa, tempo);
    }

    @Override
    public String toString() {
        return "Moto{" +
                "Placa ='" + placa + '\'' +
                ", Tempo =" + tempo +
                ", Estacionado =" + estacionado +
                '}';
    }
}
