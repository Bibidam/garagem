package com.example.garagem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import URLConnection.ConnectionServer;

public class Deletar_Algo extends AppCompatActivity {
    EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletar__algo);

        this.id = findViewById(R.id.id);
    }

    public void deleteUser(View view){

        String c = this.id.getText().toString();

        ConnectionServer connectionServer = new ConnectionServer();
        connectionServer.setType("DELETE");
        connectionServer.setLink("https://api-gabrielm.herokuapp.com/users/" + c );

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
}
