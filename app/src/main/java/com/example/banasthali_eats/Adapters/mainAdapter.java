package com.example.banasthali_eats.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.banasthali_eats.Models.Mainmodel;
import com.example.banasthali_eats.R;

import java.util.ArrayList;

public class mainAdapter extends  RecyclerView.Adapter<mainAdapter.viewholder>{
  public static ArrayList<Mainmodel> list;
    Context context;

    public mainAdapter(ArrayList<Mainmodel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_layout,parent,false);
        return new viewholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
           Mainmodel model = list.get(position);
           holder.foodImage.setImageResource(model.getImage());
          holder.mainName.setText(model.getName());
          holder.price.setText(model.getPrice());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView foodImage;
        TextView mainName,price,Tcount;
        ImageButton add,minus;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            foodImage = itemView.findViewById(R.id.foodImage);
            mainName = itemView.findViewById(R.id.foodname);
            price = itemView.findViewById(R.id.foodPrice);
            add = itemView.findViewById(R.id.add);
            minus = itemView.findViewById(R.id.minus);
            Tcount = itemView.findViewById(R.id.Tcount);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  String tv = Tcount.getText().toString();
                  int b = 0;
                    for(int i=0;i< list.size();i++) {

                        if (list.get(i).getName().equalsIgnoreCase(mainName.getText().toString())) {
                        b = i;
                        break;
                    }
                }
                  //  Log.e("hi",list.toString());
                    int count = Integer.parseInt(tv)+1;
                    if(count <= 10) {
                        Tcount.setText(count + "");
                        Mainmodel t = list.get(b);
                        Mainmodel t1=new Mainmodel(t.getImage(),t.getName(),t.getPrice(),R.drawable.add,R.drawable.minus,count);
                        list.remove(b);
                        t.setTcount(count);
                        list.add(b,t1);
                     //   Toast.makeText(add.getContext(), b+" "+t1.getName()+" "+count+" "+t1.getTcount(),Toast.LENGTH_SHORT).show();


                    }
                }
            });
            minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  //  Toast.makeText(v.getContext(), "hi ",Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onClick(View v) {
           // Toast.makeText(context,"work is going",Toast.LENGTH_SHORT).show();
        }
    }
}
