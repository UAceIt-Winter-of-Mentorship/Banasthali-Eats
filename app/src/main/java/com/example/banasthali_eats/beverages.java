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
 * Use the {@link beverages#newInstance} factory method to
 * create an instance of this fragment.
 */
public class beverages extends Fragment {
    private int quantity = 0;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public beverages() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment beverages.
     */
    // TODO: Rename and change types and number of parameters
    public static beverages newInstance(String param1, String param2) {
        beverages fragment = new beverages();
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
        String[] beverages = {"Water", "Milk", "Tea", "Coffee", "Sparkling drinks", "Lemon Juice", "Mango Juice", "Energy Drink", "Tomato juice", "Smoothie", "Milkshake", "Coconut milk", "Orange juice", "Lemonade", "Fruit juice", "Cocoa"};
        int[] prices = {10, 20, 30, 40, 50, 10, 20, 30, 40, 50, 10, 20, 30, 40, 50, 60};

        quantity = 0;

        View beverageView = inflater.inflate(R.layout.fragment_snacks, container, false);
        LinearLayout ll = beverageView.findViewById(R.id.linLayout);

        LayoutInflater layoutInflater = getLayoutInflater();

        for(int i = 0; i < beverages.length; ++i) {
            View item = layoutInflater.inflate(R.layout.style, ll, false);
            TextView textViewName = item.findViewById(R.id.itemName);
            textViewName.setText(beverages[i]);

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
                    if (quantity == 0) {
                        Toast.makeText(getActivity(), "Atleast 0 would be there", Toast.LENGTH_SHORT).show();
                        txtCnt.setText("0");
                    } else {
                        quantity--;
                        txtCnt.setText(String.valueOf(quantity));
                    }
                }
            });

            ll.addView(item);
        }
        return beverageView;
    }
}