package com.example.fc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Fragment1.Fragment1Listener, Fragment2.Fragment2Listener {

    public int flag = 0;
    private Fragment1 fr1;
    private Fragment2 fr2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fr1 = new Fragment1();
        fr2 = new Fragment2();
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout1,new Fragment1()).commit();

        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout2,new Fragment2()).commit();

    }
    public void showDialog(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("confirm");
        builder.setMessage("Confirm sending");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               // Toast.makeText(MainActivity.this,"OK");
                flag = 1;
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                flag = 0;
            }
        });
        builder.show();

    }
  //  if(flag==1)

        @Override
        public void onInputsend (CharSequence input){
        showDialog();
        if(flag==1){
        fr2.update2(input);}
    }

        @Override
        public void onSendInput2 (CharSequence input2){
        if(flag==1) {
            fr1.update(input2);
        }
    }

        @Override
        public void onPointerCaptureChanged ( boolean hasCapture){
        super.onPointerCaptureChanged(hasCapture);
    }

}