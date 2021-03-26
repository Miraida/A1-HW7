package com.geek.a1_hw7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment implements IFragment{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private List<UserContactModel> list;


    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
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
     View view = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        setupViews();
        return view;
    }
    private void setupViews() {
        list = new ArrayList<>();
        list.add(new UserContactModel("Miraida","Hey, What's up?",R.drawable.miraida));
        list.add(new UserContactModel("Artem","Hi, Haw are you?",R.drawable.artem));
        list.add(new UserContactModel("Lisa","Hello, is anybody there?",R.drawable.lisa));
        list.add(new UserContactModel("Miraida","Hey, What's up?",R.drawable.miraida));
        list.add(new UserContactModel("Artem","Hi, Haw are you?",R.drawable.artem));
        list.add(new UserContactModel("Lisa","Hello, is anybody there?",R.drawable.lisa));
        list.add(new UserContactModel("Miraida","Hey, What's up?",R.drawable.miraida));
        list.add(new UserContactModel("Artem","Hi, Haw are you?",R.drawable.artem));
        list.add(new UserContactModel("Lisa","Hello, is anybody there?",R.drawable.lisa));
        list.add(new UserContactModel("Miraida","Hey, What's up?",R.drawable.miraida));
        list.add(new UserContactModel("Artem","Hi, Haw are you?",R.drawable.artem));
        list.add(new UserContactModel("Lisa","Hello, is anybody there?",R.drawable.lisa));

        adapter = new  MainAdapter(list,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(this);
    }

    @Override
    public void displayDetails(UserContactModel model) {
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.displayDetails(model);
    }
}