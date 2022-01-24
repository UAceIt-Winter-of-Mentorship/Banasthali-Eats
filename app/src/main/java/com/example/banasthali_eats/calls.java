package com.example.banasthali_eats;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link calls#newInstance} factory method to
 * create an instance of this fragment.
 */
public class calls extends Fragment {
int cp;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public calls() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment calls.
     */
    // TODO: Rename and change types and number of parameters
    public static calls newInstance(String param1, String param2) {
        calls fragment = new calls();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String[] name = { "Pepsi","Coke","Sprite","Fanta","Cocoa Milkshake","Rose Milk","Badam Milk","Chocolate thickshake","Lassi","Tea","Coffee" };
        int position[]={10,20,15,20,30,40,45,35,15,10,15};
        cp =0;
        View v= inflater.inflate(R.layout.fragment_chats, container, false);
        LinearLayout linLayout = (LinearLayout) v.findViewById(R.id.linLayout);

        LayoutInflater ltInflater = getLayoutInflater();

        for (int i = 0; i < name.length; i++) {
            View item = ltInflater.inflate(R.layout.styl, linLayout, false);
            TextView tvName = (TextView) item.findViewById(R.id.tvName);
            tvName.setText(name[i]);
            TextView tvPosition = (TextView) item.findViewById(R.id.tvPosition);
            tvPosition.setText("Rs "+String.valueOf(position[i])+"/-");
            TextView tvcount = (TextView) item.findViewById(R.id.textView5);
            Button add = (Button)item.findViewById(R.id.button7);
            Button sub = (Button)item.findViewById(R.id.button8);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cp++;
                    tvcount.setText(String.valueOf(cp));
                }
            });
            sub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(cp==0)
                    {
                        Toast toast=Toast.makeText(getActivity(),"Add items to cart",Toast.LENGTH_SHORT);
                        toast.show();
                        tvcount.setText("0");
                    }
                    else{
                        cp--;
                        tvcount.setText(String.valueOf(cp));
                    }

                }
            });

            linLayout.addView(item);
        }

        return v;
    }
}