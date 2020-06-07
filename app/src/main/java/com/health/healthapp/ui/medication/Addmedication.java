package com.health.healthapp.ui.medication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.health.healthapp.R;
import com.health.healthapp.ui.Reminder.Add;

public class Addmedication extends AppCompatActivity {

Button btnnext;
    String[] listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmedication);

      btnnext=findViewById(R.id.btn_next);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Addmedication.this, Add.class);
                startActivity(intent);

            }
        });

        //alert radio button
        listItems = getResources().getStringArray(R.array.unit_item);
        TextView txtunit = findViewById(R.id.txt_unit);
       final TextView txtresult = findViewById(R.id.txt_result);

        txtunit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Addmedication.this);
                mBuilder.setTitle("Choose an item");
                mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        txtresult.setText(listItems[i]);
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
