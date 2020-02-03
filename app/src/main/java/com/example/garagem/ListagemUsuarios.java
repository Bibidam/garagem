package com.example.garagem;

import androidx.appcompat.app.AppCompatActivity;

import Negocio.Clientes;
import URLConnection.*;
import android.os.Bundle;
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

public class ListagemUsuarios extends AppCompatActivity {
    public ArrayList<Clientes> clientes;
    public ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuarios);
        clientes = new ArrayList<Clientes>();
        list = (ListView)findViewById(R.id.list);

        getUsers();


    }

    public void getUsers(){
        try{
            ConnectionServer connectionServer = new ConnectionServer();
            connectionServer.setLink("https://api-gabrielm.herokuapp.com/users/");
            connectionServer.setType("GET");
            JSONObject response = connectionServer.execute().get();
            Log.d("Resultado : " , response.toString());

            JSONArray data = new JSONArray(response.get("message").toString());
            JSONObject tempOBJ;
            ArrayList<String> arrayList = new ArrayList<>();
            int z =0;
            for(int i=0;i<data.length();i++){

                z++;
                Clientes cliente = new Clientes();
                tempOBJ = (JSONObject) data.get(i);
                cliente.setNome((String) tempOBJ.get("nome"));
                cliente.setIdade((int) tempOBJ.get("idade"));
                cliente.setValorDevedor((int) tempOBJ.get("valorDevedor"));
                clientes.add(cliente);
                arrayList.add(" ID = " + z +" "+ cliente.getNome() + " Valor Devedor : " + cliente.getValorDevedor());
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
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }*/
}
