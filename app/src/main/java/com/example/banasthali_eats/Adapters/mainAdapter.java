package com.example.banasthali_eats.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    ArrayList<Mainmodel> list;
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
     public static ArrayList<Mainmodel> model1 = new ArrayList<>();
    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
           Mainmodel model = list.get(position);
           model1.add(model);
          holder.foodImage.setImageResource(model.getImage());
          holder.mainName.setText(model.getName());
          holder.price.setText(model.getPrice());
       // Toast.makeText(context,model.getName(), Toast.LENGTH_SHORT).show();
      //  Toast.makeText(getContext().getApplicationContext(), "order placing", Toast.LENGTH_SHORT).show();
       /* holder.add.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                int val = Integer.parseInt(holder.Tcount.getText().toString())+1;
                model.setTcount(String.valueOf(val));
                holder.Tcount.setText(String.valueOf(val));

            }
        });*/
        /*  holder.add.setOnClickListener(new View.OnClickListener() {
              int count;
                int val = Integer.parseInt(holder.Tcount.getText().toString())+1;
              @Override
              public void onClick(View v) {
                  count = 0;
                 model.setCount(model.getCount()+1);
                  holder.Tcount.setText(String.valueOf(model.getCount()));
              }
          });*/
      /*  holder.minus.setOnClickListener(new View.OnClickListener() {
            int count;
            @Override
            public void onClick(View v) {
                if(model.getCount() > 0) {
                    model.setCount(model.getCount() - 1);
                    holder.Tcount.setText(String.valueOf(model.getCount()));
                }
            }
        });*/

       // holder.Tcount.setText(model.getTcount());
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
                  //  Toast.makeText(context,"work is going", Toast.LENGTH_SHORT).show();
                    String tv = Tcount.getText().toString();
                  //  Toast.makeText(context,tv+"work is going"+model.getName(), Toast.LENGTH_SHORT).show();
                    int b = 0;
                    for(int i=0;i< model1.size();i++) {

                        if (model1.get(i).getName().equalsIgnoreCase(mainName.getText().toString())) {
                            b = i;
                            break;
                        }
                    }
                    Toast.makeText(context,tv+"work is going"+model1.get(b).getName(), Toast.LENGTH_SHORT).show();
                    int count = Integer.parseInt(tv)+1;
                    if(count <= 10) {
                        Tcount.setText(count + "");
                        model1.get(b).setTcount(count+"");
                    }
                }
            });
            minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String tv = Tcount.getText().toString();
                    int count = Integer.parseInt(tv)-1;
                    if(count >= 0) {
                        Tcount.setText(count + "");
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {
           // Toast.makeText(context,"work is going",Toast.LENGTH_SHORT).show();
        }
    }
}
