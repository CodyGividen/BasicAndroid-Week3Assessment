package com.example.rodneytressler.week3assessmentkey;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Cody Gividen on 12/14/17.
 */

public class AccountFragment extends Fragment {
    private ActivityCallback activityCallback;

    @BindView(R.id.name_input)
    protected EditText nameInput;

    @BindView(R.id.class_input)
    protected EditText classInput;





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_creation, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public static AccountFragment newInstance() {

        Bundle args = new Bundle();

        AccountFragment fragment = new AccountFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @OnClick(R.id.button_finish)
    protected void finishClicked(){
        if(nameInput.getText().toString().isEmpty() || classInput.getText().toString().isEmpty()) {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
            builder.setTitle("Missing Information")
                    .setMessage("All Items are required!")
                    .setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();


        }else{
            if(classInput.getText().toString().equalsIgnoreCase("mage")
                    || classInput.getText().toString().equalsIgnoreCase("warrior")
                    || classInput.getText().toString().equalsIgnoreCase("archer")) {
                activityCallback.accountInformation(nameInput.getText().toString(),
                        classInput.getText().toString());
            }else{
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
                builder.setTitle("Wrong Class")
                        .setMessage("Please put in a real class!! (mage, warrior, or archer)!")
                        .setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

            }
        }
            activityCallback.accountInformation(nameInput.getText().toString(),
                    classInput.getText().toString());
        }




    public void attachParent(ActivityCallback activityCallback) {
        this.activityCallback = activityCallback;
    }
    public interface ActivityCallback {
        void accountInformation(String heroName, String heroClass);
    }
}
