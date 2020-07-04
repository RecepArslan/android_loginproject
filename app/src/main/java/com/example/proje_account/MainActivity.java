package com.example.proje_account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String kullaniciAd, sifre;
    EditText Username, Password;
    Button btn;
    ImageView image;
    String defaultad;
    String defauldsifre;
    Bundle temp;
    boolean sayac = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defaultad="admin";
        defauldsifre="admin123.";
        al();
        tanımla();
        butontıkla();
        fototTikla();


    }


    void tanımla() {
        Username = findViewById(R.id.kullanıcıAdi);
        Password = findViewById(R.id.password);
        btn = findViewById(R.id.buton);
        image = findViewById(R.id.Kilit);

    }

    void degerler() {
        kullaniciAd = Username.getText().toString();
        sifre = Password.getText().toString();

    }

    void butontıkla() {


       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               degerler();
               Log.i("calisma", sifre + " " + defauldsifre + " " + defaultad + " " + kullaniciAd);
               if (kontrol()) {
                   Intent intent = new Intent(getApplicationContext(), Activity2.class);
                   startActivity(intent);

               } else
                   Toast.makeText(getApplicationContext(),R.string.activity_main_toastmessagehataligiris, Toast.LENGTH_LONG).show();
           }
       });

    }

    boolean kontrol() {

        if ((defaultad.equals(kullaniciAd) && defauldsifre.equals(sifre))) return true;
        else return false;

    }

    void al() {
        temp = getIntent().getExtras();
        if (temp != null) {
            if (temp.getString(Utility.yeniAd) != null && temp.getString(Utility.yeniSifre) != null) {
                {
                    defauldsifre = temp.getString(Utility.yeniSifre);
                    defaultad = temp.getString(Utility.yeniAd);
                    Log.i("deneme", "buradayım");


                }

            }

        }

    }

    void fototTikla() {
        image.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (sayac) {
                    Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    sayac = false;
                } else {
                    Password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    sayac = true;
                }


            }
        });


    }
}