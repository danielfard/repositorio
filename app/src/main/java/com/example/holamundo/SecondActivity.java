package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    EditText n1,n2;
    Button suma,resta,multiplicar,dividir,mcm,mcd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        n1=findViewById(R.id.edtnum1);
        n2=findViewById(R.id.edtnum2);

        suma=findViewById(R.id.btnsumar);
        resta=findViewById(R.id.btnrestar);
        multiplicar=findViewById(R.id.btnmultiplicar);
        dividir=findViewById(R.id.btndividir);
        mcm=findViewById(R.id.btnMCM);
        mcd=findViewById(R.id.btnMCD);


        suma.setOnClickListener(this);
        resta.setOnClickListener(this);
        multiplicar.setOnClickListener(this);
        dividir.setOnClickListener(this);
        mcm.setOnClickListener(this);
        mcd.setOnClickListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem item){
        switch(item.getItemId()){
            case R.id.m1:
                Toast.makeText(this, "menu 1", Toast.LENGTH_SHORT).show();
            break;
            case R.id.m2:
                Toast.makeText(this, "menu 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m3:
                Toast.makeText(this, "menu 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m4:
                Toast.makeText(this, "menu 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m5:
                Toast.makeText(this, "menu 3", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void onClick(View v){
        if(TextUtils.isEmpty(n1.getText().toString()) || TextUtils.isEmpty(n2.getText().toString())){
            Toast.makeText(getApplicationContext(), "Datos Vacios", Toast.LENGTH_SHORT).show();
        }else{
            double num1 = Integer.parseInt(n1.getText().toString());
            double num2 = Integer.parseInt(n2.getText().toString());
            switch (v.getId()){
                case R.id.btnsumar:
                    Toast.makeText(this,"Suma= "+(num1+num2),Toast.LENGTH_LONG).show();
                    break;
                case R.id.btnrestar:

                    Toast.makeText(this,"Resta= "+(num1-num2),Toast.LENGTH_LONG).show();
                    break;

                case R.id.btnmultiplicar:
                    Toast.makeText(this,"Multiplicar= "+(num1*num2),Toast.LENGTH_LONG).show();
                    break;

                case R.id.btndividir:
                    if(num2!=0){
                        Toast.makeText(this,"Multiplicar= "+(num1/num2),Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(this,"Division entre 0 Error ",Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.btnMCM:
                    int mcm=1;
                    int i=2;
                    while(i <= num1 || i <= num2)
                    {
                        if(num1%i==0 || num2%i==0)
                        {
                            mcm=mcm*i;
                            if(num1%i==0) num1=num1/i;
                            if(num2%i==0) num2=num2/i;
                        }
                        else
                            i=i+1;
                    }
                    Toast.makeText(this,"El MCM es =" +mcm,Toast.LENGTH_LONG).show();

                    break;
                case R.id.btnMCD:
                    while(num1 != num2)
                        if(num1>num2)
                            num1= num1-num2;
                        else
                            num2= num2 -num1;

                    Toast.makeText(this,"El MCD es: " +num1,Toast.LENGTH_LONG).show();

                    break;
            }


        }
    }
}
