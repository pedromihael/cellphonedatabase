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
            String brand = mEditTextBrand.getText().toString();
            String model = mEditTextModel.getText().toString();
            // listener.persistNewCellphoneData(model, brand);

            // TODO: metodo de teste de cadastro
            /*
            * verificar se campo model ta preenchido
            * * se tiver, verifica se marca ta preenchido
            * * se ambos estiverem, ao clicar em confirmar, faz busca no que ja existe
            * * pra ver se ja existe
            *
            * * se
            *
            * */

            this.dismiss();

            Toast.makeText(view.getContext(),"Cadastrado com sucesso!",Toast.LENGTH_SHORT).show();
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
    public interface DialogListener {
        void persistNewCellphoneData(String model, String brand);
        // implementada na Main - Deve ser substituida pelo ciclo de salvar no banco
    }
}

