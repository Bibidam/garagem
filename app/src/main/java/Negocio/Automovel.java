package Negocio;

public class Automovel {

    String placa;
    int tempo;
    int estacionado;
    int clientID;


    public Automovel(){

    }

    public Automovel(String placa, int tempo){
        this.placa = placa;
        this.tempo = tempo;
        this.estacionado = 0;
        this.clientID = clientID;
    }

    public int getEstacionado() {
        return estacionado;
    }

    public Automovel(String placa, int tempo, int estacionado, int clientID){
        this.placa = placa;
        this.tempo = tempo;
        this.estacionado = estacionado;
        this.clientID = clientID;

    }

    public void estacionarCarro(int tempo){
        this.tempo = tempo;
        this.estacionado = 1;

    }

    public void retirarCarro(){
        this.tempo = 0;
        this.estacionado = 0;
    }


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int isEstacionado() {
        return estacionado;
    }

    public void setEstacionado(int estacionado) {
        this.estacionado = estacionado;
    }
    public void setClientID(int clientID){
        this.clientID = clientID;
    }

    public int getClientID(){

        return this.clientID;
    }

}
