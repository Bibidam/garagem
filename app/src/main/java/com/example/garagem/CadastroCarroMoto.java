package com.example.garagem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import Negocio.Carros;
import URLConnection.ConnectionServer;

public class CadastroCarroMoto extends AppCompatActivity {

    EditText placa;
    EditText tempo;
    EditText id;
    EditText idDono;
    CheckBox estacionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_carro_moto);

        this.placa = findViewById(R.id.placa);
        this.tempo = findViewById(R.id.time);
        this.id = findViewById(R.id.id);
        this.idDono = findViewById(R.id.idDono);
        this.estacionado = findViewById(R.id.checkBox);

    }

    public void submit(JSONObject body){
        ConnectionServer connectionServer = new ConnectionServer();
        connectionServer.setLink("https://api-gabrielm.herokuapp.com/cars/");
        connectionServer.setType("POST");
        connectionServer.setBody(body);


        JSONObject response = null;
        try {
            response = connectionServer.execute().get();
            Log.d("Resultado : " , response.toString());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void submitMoto(JSONObject body){
        ConnectionServer connectionServer = new ConnectionServer();
        connectionServer.setLink("https://api-gabrielm.herokuapp.com/moto/");
        connectionServer.setType("POST");
        connectionServer.setBody(body);


        JSONObject response = null;
        try {
            response = connectionServer.execute().get();
            Log.d("Resultado : " , response.toString());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void cadastrarMoto(View view) {

        String plc;
        String tmp;
        String ident;
        //int identCar;
        String estar;
        if(this.tempo.getText().toString() != null && this.idDono.getText().toString() != null ){
            plc = this.placa.getText().toString();
            tmp = this.tempo.getText().toString();
            ident = this.idDono.getText().toString();
            //identCar = Integer.parseInt(this.id.getText().toString());

            if(this.estacionado.isChecked()){
                estar = "1";
            }else{
                estar = "0";
            }

            Log.d("Placa: ", plc);
            Log.d("tempo: ", String.valueOf(tmp));
            Log.d("id: " , String.valueOf(ident));
            //Log.d("Id Carro: ", String.valueOf(identCar));
            Log.d("Estacionado : ", String.valueOf(estar));


            HashMap<String,Object> bodyMap = new <String,Object>HashMap();
            bodyMap.put("placa", plc);
            bodyMap.put("estacionado", estar);
            bodyMap.put("tempo", tmp);
            bodyMap.put("clientID", ident );
            JSONObject body = new JSONObject(bodyMap);

            submitMoto(body);

        }
        else{
            Log.d(" Error", "Falta Preencher dados");
        }


    }
    public void alterarMoto(View view) {

        String plc;
        String tmp;
        String ident;
        String identCar;
        String estar;
        if(this.tempo.getText().toString() != null && this.idDono.getText().toString() != null ){
            plc = this.placa.getText().toString();
            tmp = this.tempo.getText().toString();
            ident = this.idDono.getText().toString();
            identCar = this.id.getText().toString();

            if(this.estacionado.isChecked()){
                estar = "1";
            }else{
                estar = "0";
            }

            Log.d("Placa: ", plc);
            Log.d("tempo: ", String.valueOf(tmp));
            Log.d("id: " , String.valueOf(ident));
            //Log.d("Id Carro: ", String.valueOf(identCar));
            Log.d("Estacionado : ", String.valueOf(estar));


            HashMap<String,Object> bodyMap = new <String,Object>HashMap();
            bodyMap.put("placa", plc);
            bodyMap.put("estacionado", estar);
            bodyMap.put("tempo", tmp);
            bodyMap.put("clientID", ident );
            bodyMap.put("id", identCar);
            JSONObject body = new JSONObject(bodyMap);

            submitMoto(body);

        }
        else{
            Log.d(" Error", "Falta Preencher dados");
        }

    }


    public void cadastrarCarro(View view) {

        String plc;
        String tmp;
        String ident;
        //int identCar;
        String estar;
        if(this.tempo.getText().toString() != null && this.idDono.getText().toString() != null ){
            plc = this.placa.getText().toString();
            tmp = this.tempo.getText().toString();
            ident = this.idDono.getText().toString();
            //identCar = Integer.parseInt(this.id.getText().toString());

            if(this.estacionado.isChecked()){
                estar = "1";
            }else{
                estar = "0";
            }

            Log.d("Placa: ", plc);
            Log.d("tempo: ", String.valueOf(tmp));
            Log.d("id: " , String.valueOf(ident));
            //Log.d("Id Carro: ", String.valueOf(identCar));
            Log.d("Estacionado : ", String.valueOf(estar));


            HashMap<String,Object> bodyMap = new <String,Object>HashMap();
            bodyMap.put("placa", plc);
            bodyMap.put("estacionado", estar);
            bodyMap.put("tempo", tmp);
            bodyMap.put("clientID", ident );
            JSONObject body = new JSONObject(bodyMap);

            submit(body);

        }
        else{
          Log.d(" Error", "Falta Preencher dados");
        }




    }

    public void alterarCarro(View view) {

        String plc;
        String tmp;
        String ident;
        String identCar;
        String estar;
        if(this.tempo.getText().toString() != null && this.idDono.getText().toString() != null ){
            plc = this.placa.getText().toString();
            tmp = this.tempo.getText().toString();
            ident = this.idDono.getText().toString();
            identCar = this.id.getText().toString();

            if(this.estacionado.isChecked()){
                estar = "1";
            }else{
                estar = "0";
            }

            Log.d("Placa: ", plc);
            Log.d("tempo: ", String.valueOf(tmp));
            Log.d("id: " , String.valueOf(ident));
            //Log.d("Id Carro: ", String.valueOf(identCar));
            Log.d("Estacionado : ", String.valueOf(estar));


            HashMap<String,Object> bodyMap = new <String,Object>HashMap();
            bodyMap.put("placa", plc);
            bodyMap.put("estacionado", estar);
            bodyMap.put("tempo", tmp);
            bodyMap.put("clientID", ident );
            bodyMap.put("id", identCar);
            JSONObject body = new JSONObject(bodyMap);

            submit(body);

        }
        else{
            Log.d(" Error", "Falta Preencher dados");
        }




    }


}
