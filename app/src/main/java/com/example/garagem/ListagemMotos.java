package com.example.garagem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import Negocio.Carros;
import Negocio.Motos;
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


public class ListagemMotos extends AppCompatActivity {
    public ArrayList<Motos> motos;
    public ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_motos);
        motos = new ArrayList<Motos>();
        list = (ListView)findViewById(R.id.list);

        getMotos();

    }

    private void getMotos() {

        try {

            ConnectionServer connectionServer = new ConnectionServer();
            connectionServer.setLink("https://api-gabrielm.herokuapp.com/moto/");
            connectionServer.setType("GET");
            JSONObject response = connectionServer.execute().get();
            Log.d("Resultado : " , response.toString());

            JSONArray data = new JSONArray(response.get("message").toString());
            JSONObject tempOBJ;
            ArrayList<String> arrayList = new ArrayList<>();
            int z = 0;
            for(int i=0;i<data.length();i++){
                Motos moto = new Motos();
                tempOBJ = (JSONObject) data.get(i);
                moto.setPlaca((String) tempOBJ.get("placa"));
                moto.setEstacionado((int) tempOBJ.get("estacionado"));
                moto.setTempo((int) tempOBJ.get("tempo"));
                moto.setClientID((int) tempOBJ.get("clientID"));
                motos.add(moto);
                arrayList.add("ID - " + z + "Placa : " + moto.getPlaca() + " Tempo: " + moto.getTempo() + " Horas "+ " DONO ID: "+ moto.getClientID());
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
