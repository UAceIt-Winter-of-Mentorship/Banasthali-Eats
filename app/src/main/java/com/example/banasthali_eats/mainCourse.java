package com.example.banasthali_eats;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.banasthali_eats.Adapters.mainAdapter;
import com.example.banasthali_eats.Models.Mainmodel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link mainCourse#newInstance} factory method to
 * create an instance of this fragment.
 */
public class mainCourse extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public mainCourse() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment mainCourse.
     */
    // TODO: Rename and change types and number of parameters
    public static mainCourse newInstance(String param1, String param2) {
        mainCourse fragment = new mainCourse();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    RecyclerView recyclerView;
    Button order;
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
        View view = inflater.inflate(R.layout.fragment_main_course, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        order = view.findViewById(R.id.order);
        recyclerView.setHasFixedSize(true);

        ArrayList<Mainmodel> list = new ArrayList<>();
        list.add(new Mainmodel(R.drawable.pizza, "Pizza", "80",R.drawable.add,R.drawable.minus,"0"));
        list.add(new Mainmodel(R.drawable.pizza, "Momos", "60",R.drawable.add,R.drawable.minus,"0"));
        list.add(new Mainmodel(R.drawable.pizza, "burger", "35",R.drawable.add,R.drawable.minus,"0"));
        list.add(new Mainmodel(R.drawable.pizza, "sandwich", "30",R.drawable.add,R.drawable.minus,"0"));
        list.add(new Mainmodel(R.drawable.pizza, "Pizza", "80",R.drawable.add,R.drawable.minus,"0"));
        list.add(new Mainmodel(R.drawable.pizza, "Pizza", "80",R.drawable.add,R.drawable.minus,"0"));

        recyclerView.setAdapter(new mainAdapter(list,getContext()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Mainmodel> list1 = mainAdapter.model1;
                for(int i=0;i<list1.size();i++){
                    String a = list1.get(i).getTcount();
                    int n = Integer.parseInt(a);
                    Toast.makeText(getContext().getApplicationContext(), list1.get(i).getName()+list1.get(i).getTcount(), Toast.LENGTH_SHORT).show();
                    if(n > 0){
                        Toast.makeText(getContext().getApplicationContext(), "order placing", Toast.LENGTH_SHORT).show();
                    }
                    else
                     Toast.makeText(getContext().getApplicationContext(), n+"order is not placing", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // Inflate the layout for this fragment roj
        return view;
    }
}