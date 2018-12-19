package com.maverick.applications.healthongo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class SettingsFragment extends Fragment implements CustomDialog.CustomDialogListener {

    public SettingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    ImageButton mAddButton;
    LinearLayout mList;
    android.app.FragmentManager fragmentManager;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentManager = getActivity().getFragmentManager();
        ActionBar actionBar = ((HomeApp)getActivity()).getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setCustomView(R.layout.layout_title_bar_side);
            TextView title = getActivity().findViewById(R.id.actionbar_title);
            title.setText(R.string.title_settings);
        }
        mList = view.findViewById(R.id.family_list);
        mAddButton = view.findViewById(R.id.add_button);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog dialog = new CustomDialog();
                dialog.addListener(SettingsFragment.this);
                dialog.show(fragmentManager,"customdialog");
            }
        });

    }

    private void addFamilyDetails(String name, String email) {
        View v = LayoutInflater.from(mList.getContext()).inflate(R.layout.layout_family,mList,false);
        TextView nameText = v.findViewById(R.id.family_name);
        TextView emailText = v.findViewById(R.id.family_email);
        nameText.setText(name);
        emailText.setText(email);
        mList.addView(v);
    }

    @Override
    public void getValues(String name, String email) {
        addFamilyDetails(name,email);
    }
}
