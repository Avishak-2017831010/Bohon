
package com.example.bohon_final__001;


import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask2 extends AsyncTask<String,Void,String> {
    Context ctx ;
    BackgroundTask2(Context ctx) {
        this.ctx = ctx ;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url = "https://bohon10.000webhostapp.com/datainsert.php";
        String phone = params[0];
        String pickupdis = params[1];
        String pickuparea = params[2];
        String desdis = params[3];
        String desarea = params[4];
        String transporttype = params[5];
        String weight=params[6];
        String feet=params[7];


        try {
            URL url = new URL(reg_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream OS = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
            String data = URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8") + "&" +
                    URLEncoder.encode("pickupdis", "UTF-8") + "=" + URLEncoder.encode(pickupdis, "UTF-8") + "&" +
                    URLEncoder.encode("pickuparea", "UTF-8") + "=" + URLEncoder.encode(pickuparea, "UTF-8") + "&"+
                    URLEncoder.encode("desdis", "UTF-8") + "=" + URLEncoder.encode(desdis, "UTF-8") + "&"+
                    URLEncoder.encode("desarea", "UTF-8") + "=" + URLEncoder.encode(desarea, "UTF-8") + "&"+
                    URLEncoder.encode("transporttype", "UTF-8") + "=" + URLEncoder.encode(transporttype, "UTF-8") + "&"+
                    URLEncoder.encode("weight", "UTF-8") + "=" + URLEncoder.encode(transporttype, "UTF-8") + "&"+
                    URLEncoder.encode("feet", "UTF-8") + "=" + URLEncoder.encode(transporttype, "UTF-8") + "&";
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            OS.close();
            InputStream IS = httpURLConnection.getInputStream();
            IS.close();
            return "Data insertion Successful!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Data insertion not Successful!";
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Toast.makeText(ctx,result,Toast.LENGTH_SHORT).show();
    }
}