package com.pedromihael.cellphonedatabase;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

public class NewCellphoneDialog extends AppCompatDialogFragment {

    private EditText mEditTextModel;
    private EditText mEditTextBrand;
    private EditText mEditTextModelYear;
    private DialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.new_cellphone_dialog, null);

        builder.setView(view)
                .setTitle(R.string.dialog_title)
                .setNegativeButton(R.string.dialog_negative_button, (dialogInterface, i) -> { })
                .setPositiveButton(R.string.dialog_positive_button, (dialogInterface, i) -> {
                    String brand = mEditTextBrand.getText().toString();
                    String model = mEditTextModel.getText().toString();
                    String modelYear = mEditTextModelYear.getText().toString();
                   // listener.persistNewCellphoneData(model, brand, modelYear);
                });

        mEditTextBrand = view.findViewById(R.id.edit_brand);
        mEditTextModel = view.findViewById(R.id.edit_model);
        mEditTextModelYear = view.findViewById(R.id.edit_modelyear);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (DialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement ExampleDialogListener");
        }
    }
    public interface DialogListener {
        void persistNewCellphoneData(String model, String brand, String modelYear);
        // implementada na Main - Deve ser substituida pelo ciclo de salvar no banco
    }
}

