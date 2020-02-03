package URLConnection;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;



public class ConnectionServer extends AsyncTask<String,Void,JSONObject> {

    private JSONObject responseObj;
    private String link;
    private String type;
    private JSONObject body;

    public JSONObject getBody() {
        return body;
    }

    public void setBody(JSONObject body) {
        this.body = body;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public JSONObject getResponseObj() {
        return responseObj;
    }

    public void setResponseObj(JSONObject responseObj) {
        this.responseObj = responseObj;
    }

    public ConnectionServer() {
        this.type = "GET";
    }

    @Override
    protected JSONObject doInBackground(String... strings) {

        URL url;
        HttpURLConnection urlConnection = null;

        BufferedReader reader = null;

        JSONObject respObj = new JSONObject();

        try {
            url = new URL(link);

            urlConnection = (HttpURLConnection) url
                    .openConnection();


            if(this.type.equals("POST")){
                urlConnection.setRequestMethod("POST"); //fala que quer um post

                urlConnection.setRequestProperty("Content-type", "application/json"); //fala o que vai mandar

                urlConnection.setDoOutput(true); //fala que voce vai enviar algo


                PrintStream printStream = new PrintStream(urlConnection.getOutputStream());
                printStream.println(this.body); //seta o que voce vai enviar
            }else{
                urlConnection.setRequestMethod("GET");
            }
            urlConnection.connect();
            int status = urlConnection.getResponseCode();
            if(status < 400) {
                respObj.put("type", "success");
            } else {
                respObj.put("type", "error");
            }
            reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String linha;
            StringBuffer buffer = new StringBuffer();
            while((linha = reader.readLine()) != null) {
                buffer.append(linha);
                buffer.append("\n");
            }
            respObj.put("message",buffer.toString());
            return respObj;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return respObj;
    }

    @Override
    protected void onPostExecute (JSONObject dados) {
        try {
            setResponseObj(dados);
            Log.d("respApi",dados.get("type").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
