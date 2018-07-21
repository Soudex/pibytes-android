package pibytes.pibytes_android;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHandler extends AsyncTask
{
    String url = "";

    HttpHandler(String url)
    {
        super();
        this.url = url;
    }

    @Override
    protected Object doInBackground(Object[] params)
    {
        if(params[0].toString() == "POST")
        {
            sendPostRequest(params[1].toString(), params[2].toString());
        }
        else
        {
            System.out.println("hallo");
        }

        return null;
    }

    public Boolean sendPostRequest(String command, String value)
    {
        OutputStream out = null;

        try {
            URL url = new URL(this.url);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);

            DataOutputStream stream = new DataOutputStream(urlConnection.getOutputStream());
            stream.writeBytes("command=" + command);
            stream.flush();
            stream.close();

            urlConnection.connect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
