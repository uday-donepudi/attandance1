package com.example.p2k24;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DountChartFragment extends Fragment {

    public DountChartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donut_chart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get reference to the TableLayout
        TableLayout tableLayout = view.findViewById(R.id.tableLayout);

        // Add rows dynamically
        for (int i = 0; i < 5; i++) {
            // Create a new row
            TableRow row = new TableRow(requireContext());

            // Create TextViews for each cell
            TextView cell1 = new TextView(requireContext());
            cell1.setText("Data " + (i + 1));
            cell1.setPadding(10, 10, 10, 10);

            TextView cell2 = new TextView(requireContext());
            cell2.setText("Data " + (i + 1));
            cell2.setPadding(10, 10, 10, 10);

            TextView cell3 = new TextView(requireContext());
            cell3.setText("Data " + (i + 1));
            cell3.setPadding(10, 10, 10, 10);

            // Add TextViews to the row
            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);

            // Add the row to the TableLayout
            tableLayout.addView(row);
        }
    }
}
