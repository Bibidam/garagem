package com.example.garagem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import Negocio.Carros;
import Negocio.Clientes;
import URLConnection.*;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ListagemCarro extends AppCompatActivity {

    public ArrayList<Carros> carros;
    public ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_carro);
        carros = new ArrayList<Carros>();
        list = (ListView)findViewById(R.id.list);

        getCars();
    }

    private void getCars() {

        try {

            ConnectionServer connectionServer = new ConnectionServer();
            connectionServer.setLink("https://api-gabrielm.herokuapp.com/cars/");
            connectionServer.setType("GET");
            JSONObject response = connectionServer.execute().get();
            Log.d("Resultado : " , response.toString());

            JSONArray data = new JSONArray(response.get("message").toString());
            JSONObject tempOBJ;
            ArrayList<String> arrayList = new ArrayList<>();
            int z = 0;
            for(int i=0;i<data.length();i++){
                Carros carro = new Carros();
                tempOBJ = (JSONObject) data.get(i);
                carro.setPlaca((String) tempOBJ.get("placa"));
                carro.setEstacionado((int) tempOBJ.get("estacionado"));
                carro.setTempo((int) tempOBJ.get("tempo"));
                carro.setClientID((int) tempOBJ.get("clientID"));
                carros.add(carro);
                arrayList.add( " Carro = "+ z +"Placa: " + carro.getPlaca() + " Tempo: " + carro.getTempo() + " Horas "+ " DONO ID: "+ carro.getClientID());
            }
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,                   android.R.layout.simple_list_item_1, arrayList);
            list.setAdapter(arrayAdapter);
        }

        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
