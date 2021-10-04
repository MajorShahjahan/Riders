package com.example.riders;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.riders.adapter.RecyclerViewAdapter;
import com.example.riders.model.Rider;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private ArrayList<Rider> riderList;

    private ProgressBar progressBar;


    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.idPB);
        riderList = new ArrayList<>();
        getData();

        // calling method to
        // build recycler view.
        buildRecyclerView();


}

    private void getData() {
        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        // in this case the data we are getting is in the form
        // of array so we are making a json array request.
        // below is the line where we are making an json array
        // request and then extracting data from each json object.
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                "https://cdn.sixt.io/codingtask/cars", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);

                for (int i = 0; i < response.length(); i++) {
                    // creating a new json object and
                    // getting each object from our json array.
                    try {
                        // we are getting each json object.
                        JSONObject responseObj = response.getJSONObject(i);

                        String name = responseObj.getString("name");
                        String make = responseObj.getString("make");
                        String modelName = responseObj.getString("modelName");
                        String fuelType = responseObj.getString("fuelType");
                        String licensePlate = responseObj.getString("licensePlate");
                        String latitude = responseObj.getString("latitude");
                        String longitude = responseObj.getString("longitude");
                        String carImageUrl = responseObj.getString("carImageUrl");

//                        String courseName = responseObj.getString("courseName");
//                        String courseTracks = responseObj.getString("courseTracks");
//                        String courseMode = responseObj.getString("courseMode");
//                        String courseImageURL = responseObj.getString("courseimg");
                        riderList.add(new Rider("1", "", modelName, name, make,
                                "", "", "", fuelType, "", "",
                                licensePlate, latitude, longitude, "", carImageUrl));
                        buildRecyclerView();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Fail to get the data..", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonArrayRequest);
    }

    private void buildRecyclerView() {

        // initializing our adapter class.
        adapter = new RecyclerViewAdapter(riderList, MainActivity.this);

        // adding layout manager
        // to our recycler view.
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);

        // setting layout manager
        // to our recycler view.
        recyclerView.setLayoutManager(manager);

        // setting adapter to
        // our recycler view.
        recyclerView.setAdapter(adapter);
    }

    public void onBackPressed(){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Logout")
                .setMessage("Are you sure you want to exit?")

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with operation
                        finishAffinity();
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
