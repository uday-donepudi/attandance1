package com.example.p2k24;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class DetailListAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private List<String> mDataList;

    public DetailListAdapter(Context context, List<String> dataList) {
        super(context, 0, dataList);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        // Get the data item for this position
        String item = mDataList.get(position);

        // Find and set the TextView with the item name
        TextView textView1 = convertView.findViewById(R.id.textView1);
        TextView textView2 = convertView.findViewById(R.id.textView2);
        TextView textView3 = convertView.findViewById(R.id.textView3);
        if (item != null) {
            String[] parts = item.split(","); // Assuming your data is comma-separated
            if (parts.length >= 3) {
                textView1.setText(parts[0]);
                textView2.setText(parts[1]);
                textView3.setText(parts[2]);
            }
        }
        return convertView;
    }
}
