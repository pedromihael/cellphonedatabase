package com.pedromihael.cellphonedatabase;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.List;

public class NewCellphoneDialog extends AppCompatDialogFragment {

    private EditText mEditTextModel;
    private EditText mEditTextBrand;
    private Button mCancelButton;
    private Button mConfirmButton;
    private DialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.new_cellphone_dialog, null);

        builder.setView(view);

        mCancelButton = view.findViewById(R.id.cancel_button);
        mConfirmButton = view.findViewById(R.id.confirm_button);

        mCancelButton.setOnClickListener((v) -> this.dismiss());
        mConfirmButton.setOnClickListener((v) -> {
            Cellphone cellphone = null;
            String brand = mEditTextBrand.getText().toString();
            String model = mEditTextModel.getText().toString();
            CellPhoneOpenHelper helper = new CellPhoneOpenHelper(getContext());

            if (hasNotNullAssurance(model, brand)) {
                if (isBrand(model, brand)) {
                    cellphone = new Cellphone(brand);
                } else if (isDevice(model)) {
                    cellphone = new Cellphone(model, brand);
                }

                listener.persistNewCellphoneData(cellphone, helper);
                this.dismiss();

            } else {
                Toast.makeText(view.getContext(),
            "Para cadastrar um dispositivo, insira todos os campos. Para cadastrar uma marca, insira apenas a marca",
                Toast.LENGTH_SHORT).show();
            }

        });

        mEditTextBrand = view.findViewById(R.id.edit_brand);
        mEditTextModel = view.findViewById(R.id.edit_model);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (DialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement DialogListener");
        }

    }

    private boolean isModelEmpty(String model) {
        if (model.isEmpty() || model.equals(null)) {
            return true;
        }

        return false;
    }

    private boolean isBrandEmpty(String brand) {
        if (brand.isEmpty() || brand.equals(null)) {
            return true;
        }

        return false;
    }

    private boolean hasNotNullAssurance(String model, String brand) {
        if (isBrandEmpty(brand) && isModelEmpty(model)) {
            return false;
        }

        if (isBrandEmpty(brand) && !isModelEmpty(model)) {
            return false;
        }

        if (!isBrandEmpty(brand) && isModelEmpty(model)) {
            return true;
        }

        return true;
    }

    private boolean isDevice(String model) {
        if (!isModelEmpty(model)) {
            return true;
        }

        return false;
    }

    private boolean isBrand(String model, String brand) {
        if (!isBrandEmpty(brand) && isModelEmpty(model)) {
            return true;
        }

        return false;
    }

    public interface DialogListener {
        void persistNewCellphoneData(Cellphone cellphone, CellPhoneOpenHelper helper);
    }
}

