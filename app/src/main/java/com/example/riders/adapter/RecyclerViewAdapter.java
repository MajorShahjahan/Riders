package com.example.riders.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.riders.R;
import com.example.riders.googleMap;
import com.example.riders.model.Rider;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.example.riders.R.*;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

       private Context context;
   private ArrayList<Rider> riderList;

    public RecyclerViewAdapter(ArrayList<Rider> riderList, Context context) {
        this.riderList = riderList;
        this.context = context;
    }

//    where to get the single card as a ViewHolder Object
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        final Rider rider = riderList.get(position);

        holder.name.setText(rider.getName());
        holder.model.setText(rider.getMake() + ' ' + rider.getModelName());
        String a = rider.getFuelType();
        if(a.equals("D")){
        holder.fuel.setText("Diesel");
        } else {
            holder.fuel.setText("Petrol");
        }
        holder.number.setText(rider.getLicensePlate());

        Picasso.get().load(rider.getCarImageUrl())
                .fit()
                .placeholder(drawable.traffic)
                .error(drawable.traffic)
                .into(holder.img);

        holder.location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context.getApplicationContext(), googleMap.class);
                i.putExtra("lattitude", rider.getLatitude());
                i.putExtra("longitude", rider.getLongitude());
                i.putExtra("name", rider.getName());
                context.startActivity(i);
            }
        });

    }

//    what will happen after we create the ViewHolder Object
    @Override
    public int getItemCount() {
        return riderList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name, model, fuel, number;
        public ImageView img;
        public Button location;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            itemView.setOnClickListner(this);

            name = itemView.findViewById(R.id.name);
            model = itemView.findViewById(R.id.model);
            fuel = itemView.findViewById(R.id.fuel);
            number = itemView.findViewById(R.id.number);
            img = itemView.findViewById(R.id.img);
            location = itemView.findViewById(id.location);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
