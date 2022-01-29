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
 * Use the {@link snacks#newInstance} factory method to
 * create an instance of this fragment.
 */
public class snacks extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    int quantity = 0;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public snacks() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment snacks.
     */
    // TODO: Rename and change types and number of parameters
    public static snacks newInstance(String param1, String param2) {
        snacks fragment = new snacks();
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
//        Toast.makeText(getActivity(), "Here also coming", Toast.LENGTH_LONG).show();
        // Inflate the layout for this fragment
        String[] snackList = {"Appam", "Pastry", "Banana chips", "Bhakarwadi", "BhelPuri", "Panipuri", "Basketpuri", "BlackPuri", "Chart", "Dosa", "Idli", "Ladoo", "Momos", "Pakora", "khichdi"};
        int[] prices = {10, 20, 30, 40, 50, 10, 20, 30, 40, 50,10, 20, 30, 40, 50};
        
        quantity = 0;
        
        View snackView = inflater.inflate(R.layout.fragment_snacks, container, false);
        LinearLayout ll = snackView.findViewById(R.id.linLayout);

        LayoutInflater layoutInflater = getLayoutInflater();

        for(int i = 0; i < snackList.length; ++i){
            View item = layoutInflater.inflate(R.layout.style, ll, false);
            TextView textViewName = item.findViewById(R.id.itemName);
            textViewName.setText(snackList[i]);

            TextView position = item.findViewById(R.id.itemPrice);
            position.setText("Price: " + String.valueOf(prices[i]) + "$");

            TextView txtCnt = item.findViewById(R.id.textView5);
            Button addItem = item.findViewById(R.id.buttonPlus);
            Button removeItem = item.findViewById(R.id.buttonMinus);

            addItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    quantity++;
                    txtCnt.setText(String.valueOf(quantity));
                }
            });

            removeItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(quantity == 0)
                    {
                        Toast.makeText(getActivity(), "Atleast 0 would be there",Toast.LENGTH_SHORT).show();
                        txtCnt.setText("0");
                    }
                    else{
                        quantity--;
                        txtCnt.setText(String.valueOf(quantity));
                    }
                }
            });

            ll.addView(item);
        }

        return snackView;
    }
}