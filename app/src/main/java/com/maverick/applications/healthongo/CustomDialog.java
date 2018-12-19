package com.maverick.applications.healthongo;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by chinmay on 17/12/18.
 */

public class CustomDialog extends DialogFragment {

    public interface CustomDialogListener {
        void getValues(String name,String email);
    }

    CustomDialogListener mListener = null;

    public void addListener(CustomDialogListener listener) {
        mListener = listener;
    }

    Button mAddButton;
    EditText mNameEditText,mEmailEditText;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.custom_dialog,container,false);
        mNameEditText = v.findViewById(R.id.name_input);
        mEmailEditText = v.findViewById(R.id.email_input);
        mAddButton = v.findViewById(R.id.add_family);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable emailEditable = mEmailEditText.getText();
                Editable nameEditable = mNameEditText.getText();
                if(nameEditable != null) {
                    String name = nameEditable.toString();
                    if(!name.isEmpty()) {
                        if (emailEditable != null) {
                            String email = emailEditable.toString();
                            if(!email.isEmpty()) {
                                if (mListener != null) {
                                    mListener.getValues(name,email);
                                    dismiss();
                                }
                            } else {
                                Toast.makeText(v.getContext(), "Email Empty!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }else {
                        Toast.makeText(v.getContext(), "Name Empty!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return v;
    }

    @Override
    public void onResume() {
        WindowManager.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.CENTER;
        getDialog().getWindow().setAttributes(params);
        super.onResume();
    }
}
