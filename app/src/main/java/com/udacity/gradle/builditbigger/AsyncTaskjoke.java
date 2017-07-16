package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.hossam.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by Hossam on 3/15/2017.
 */

public class AsyncTaskjoke extends AsyncTask<Onjoke, Void, String> {
    private static MyApi myApiService = null;
    private Onjoke listener;

    @Override
    protected String doInBackground(Onjoke... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://jokes-1013.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        listener = params[0];

        try {
            return myApiService.sayHi().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        listener.onReceived(result);
    }

}
