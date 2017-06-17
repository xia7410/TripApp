package com.example.icf.tripappclient.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.icf.tripappclient.R;
import com.example.icf.tripappclient.activities.MainActivity;
import com.example.icf.tripappclient.adapters.ScannedAdapter;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.swagger.client.model.TicketScannedModel;

/**
 * Created by NemanjaM on 17.6.2017.
 */

public class TicketScanned extends Fragment {

    private List<TicketScannedModel> ticketsScanned;
    private ListView ticketsScannedDisplay;
    private TextView noTicketsScannedDisplay;

    public TicketScanned() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setTitle(R.string.ticket_scanned_title);

        fillData();

        return inflater.inflate(R.layout.fragment_ticket_scanned, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        AppCompatActivity activity = (AppCompatActivity) getActivity();

        this.noTicketsScannedDisplay = (TextView) activity.findViewById(R.id.emptyScannedLabel);
        this.ticketsScannedDisplay = (ListView) activity.findViewById(R.id.scannedTicketsList);

        if (ticketsScanned.size() > 0) {
            this.ticketsScannedDisplay.setVisibility(View.VISIBLE);
            this.noTicketsScannedDisplay.setVisibility(View.GONE);
            this.ticketsScannedDisplay.setAdapter(new ScannedAdapter(activity, ticketsScanned));
        } else {
            this.ticketsScannedDisplay.setVisibility(View.GONE);
            this.noTicketsScannedDisplay.setVisibility(View.VISIBLE);
        }
    }

    private void fillData() {

        ticketsScanned = new ArrayList<>();

        //List<TicketScannedModel> ticketsScanned = new ArrayList<>();
        final Dao<TicketScannedModel, Integer> scannedDAO = ((MainActivity)getActivity()).getSession().getHelper().getScannedDAO();

        try {
            ticketsScanned = scannedDAO.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Collections.sort(ticketsScanned, new CustomComparator());
    }

    private class CustomComparator implements Comparator<TicketScannedModel> {
        @Override
        public int compare(TicketScannedModel o1, TicketScannedModel o2) {
            return o1. getScannedTime().compareTo(o2.getScannedTime());
        }
    }
}