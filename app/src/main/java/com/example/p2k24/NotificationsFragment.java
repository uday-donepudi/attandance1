package com.example.p2k24;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private ListView messageListView;
    private ArrayAdapter<String> messageAdapter;
    private ArrayList<String> messageList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);

        // Initialize UI components
        messageListView = view.findViewById(R.id.messageListView);

        // Initialize message list and adapter
        messageList = new ArrayList<>();
        messageAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, messageList);
        messageListView.setAdapter(messageAdapter);

        return view;
    }
}
