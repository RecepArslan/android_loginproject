package com.example.proje_account;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.content.pm.LauncherApps;
import android.provider.FontRequest;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    EditText yeniAd, yeniSifre;
    Button btn;
    String yeniIsim, yeniSifrem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        tanımla();
        tıklanma();


    }

    void tanımla() {
        yeniAd = findViewById(R.id.kullanıcıAdi);
        yeniSifre = findViewById(R.id.password);
        btn = findViewById(R.id.buton);

    }

    void degerler() {
        yeniIsim = yeniAd.getText().toString();
        yeniSifrem = yeniSifre.getText().toString();

    }

    boolean kontrol() {
        boolean buyukharf = false;
        boolean noktalama = false;
        if (yeniAd.length() >= 5)
            if (yeniSifrem.length() >= 6)
                for (int i = 0; i < yeniSifrem.length(); i++) {
                    if ((int) yeniSifrem.charAt(i) >= 65 && (int) yeniSifrem.charAt(i) <= 90)
                        buyukharf = true;
                    else if ((int) yeniSifrem.charAt(i) >= 33 && (int) yeniSifrem.charAt(i) <= 47)
                        noktalama = true;
                }
        if (buyukharf) {
            if (noktalama) return true;
            else return false;
        }
        else {
            return false;
        }
    }

    void tıklanma() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                degerler();
                if (kontrol()) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                   intent.putExtra(Utility.yeniAd, yeniIsim);
                   intent.putExtra(Utility.yeniSifre, yeniSifrem);
                   Log.i("deneme",yeniSifrem+" "+ yeniIsim);
                    Log.i("deneme2",Utility.yeniAd+" "+Utility.yeniSifre);
                    startActivity(intent);
                } else
                    Toast.makeText(getApplicationContext(),R.string.activity2_toastmessageyenihataligiris , Toast.LENGTH_LONG).show();
            }
        });
    }
}