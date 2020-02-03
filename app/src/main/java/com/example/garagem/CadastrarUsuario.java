package com.example.garagem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import URLConnection.ConnectionServer;

public class CadastrarUsuario extends AppCompatActivity {
    EditText nome;
    EditText idade;
    EditText valorDevedor;
    EditText id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);

        this.nome = findViewById(R.id.nome);
        this.idade = findViewById(R.id.idade);
        this.valorDevedor = findViewById(R.id.valorDevedor);
        this.id = findViewById(R.id.id);
    }

    public void showDialog(String titulo, String mensagem){
        new AlertDialog.Builder(getApplicationContext())
                .setTitle(titulo)
                .setMessage(mensagem)

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }


    public void submit(JSONObject body){
        ConnectionServer connectionServer = new ConnectionServer();
        connectionServer.setLink("https://api-gabrielm.herokuapp.com/users/");
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

    public void cadastrar(View view) {
        EditText nomeField = findViewById(R.id.nome);
        EditText idadeField = findViewById(R.id.idade);

        String name;
        String age;
        String valorDever;
        if(this.nome.getText().toString() != null && this.idade.getText().toString() != null){
            name = this.nome.getText().toString();
            age = this.idade.getText().toString();
            valorDever = this.valorDevedor.getText().toString();

            HashMap<String,Object> bodyMap = new <String,Object>HashMap();

            bodyMap.put("nome",name);
            bodyMap.put("idade",age);
            bodyMap.put("valorDevedor",valorDever);
            JSONObject body = new JSONObject(bodyMap);

            submit(body);
        }else{

            Log.d(" Error", "Falta Preencher dados");

        }

    }

    public void alterarUsuario(View view) {
        EditText nomeField = findViewById(R.id.nome);
        EditText idadeField = findViewById(R.id.idade);

        String name;
        String age;
        String valorDever;
        String idzada;
        if(this.nome.getText().toString() != null && this.idade.getText().toString() != null && id!= null){
            name = this.nome.getText().toString();
            age = this.idade.getText().toString();
            valorDever = this.valorDevedor.getText().toString();
            idzada = this.id.getText().toString();

            HashMap<String,Object> bodyMap = new <String,Object>HashMap();

            bodyMap.put("nome",name);
            bodyMap.put("idade",age);
            bodyMap.put("valorDevedor",valorDever);
            bodyMap.put("id" , idzada);
            JSONObject body = new JSONObject(bodyMap);

            submit(body);
        }else{

            Log.d(" Error", "Falta Preencher dados");

        }

    }
}
