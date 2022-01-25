package com.example.banasthali_eats;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link chats#newInstance} factory method to
 * create an instance of this fragment.
 */
public class chats extends Fragment {
int ct;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public chats() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment chats.
     */
    // TODO: Rename and change types and number of parameters
    public static chats newInstance(String param1, String param2) {
        chats fragment = new chats();
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
        String[] name = {"Aloo Curry","Babycorn Masala","Chana masala","Malai kofta","lasuni palak","paneer kadai","paneer pasanda","paneer tikka","palak paneer","veg curry","dal fry","dal makhni","dal khichadi","chicken curry","veg phalao","veg fried rice","chicken biryani","fish fry","butter chicken","rice","tomato rice"};
        int position[] = {30,40,20,50,40,60,80,95,40,70,60,75,85,90,45,55,100,150,170,90,70};
        ct =0;

        View v= inflater.inflate(R.layout.fragment_chats, container, false);
        LinearLayout linLayout = (LinearLayout) v.findViewById(R.id.linLayout);

        LayoutInflater ltInflater = getLayoutInflater();

        for (int i = 0; i < name.length; i++) {
            View item = ltInflater.inflate(R.layout.styl, linLayout, false);
            TextView tvName = (TextView) item.findViewById(R.id.tvName);
            tvName.setText(name[i]);
            TextView tvPosition = (TextView) item.findViewById(R.id.tvPosition);
            tvPosition.setText("Rs "+ String.valueOf(position[i])+"/-");
            TextView tvcount = (TextView) item.findViewById(R.id.textView5);
            Button add = (Button)item.findViewById(R.id.button7);
            Button sub = (Button)item.findViewById(R.id.button8);


           add.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
               ct++;
               tvcount.setText(String.valueOf(ct));
               }
           });
           sub.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if(ct==0)
                   {
                       Toast toast=Toast.makeText(getActivity(),"Add items to cart",Toast.LENGTH_SHORT);
                       toast.show();
                       tvcount.setText("0");
                   }
                   else{
                       ct--;
                       tvcount.setText(String.valueOf(ct));
                   }

               }
           });



            linLayout.addView(item);
        }

        return v;
    }
}