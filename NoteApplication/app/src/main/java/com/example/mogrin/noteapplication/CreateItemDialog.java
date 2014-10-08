package com.example.mogrin.noteapplication;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.app.Activity;

public class CreateItemDialog extends DialogFragment implements OnClickListener {

    Button btnYes, btnNo;
    EditText etxt;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle("Создание контакта");
        View v = inflater.inflate(R.layout.dialog, null);

        etxt = (EditText) v.findViewById(R.id.editText);
        btnYes = (Button) v.findViewById(R.id.btnYes);
        btnNo = (Button) v.findViewById(R.id.btnNo);

        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);
        return v;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnYes:
                String person = etxt.getText().toString();
                ((MainActivity)getActivity()).addItem(person);
            case R.id.btnNo:
                break;
        }
        dismiss();
    }

    public void onDismiss(DialogInterface dialog) {
        etxt.setText("");
        super.onDismiss(dialog);
    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
    }
}