package com.example.tugaskalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    Button clear, hapus, bagi, kali, kurang, tambah, samadengan;
    TextView input, output;

    String proses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clear = findViewById(R.id.clear);
        hapus = findViewById(R.id.hapus);
        bagi = findViewById(R.id.bagi);
        tambah = findViewById(R.id.tambah);
        kurang = findViewById(R.id.kurang);
        kali = findViewById(R.id.kali);
        input = findViewById(R.id.input);
        output = findViewById(R.id.output);

    }

    public void bagi(View view) {
        proses = input.getText().toString();
        input.setText(proses + "/");
    }
    public void tujuh(View view) {
        proses = input.getText().toString();
        input.setText(proses + "7");
    }
    public void delapan(View view) {
        proses = input.getText().toString();
        input.setText(proses + "8");
    }
    public void sembilan(View view) {
        proses = input.getText().toString();
        input.setText(proses + "9");
    }
    public void kali(View view) {
        proses = input.getText().toString();
        input.setText(proses + "x");
    }
    public void empat(View view) {
        proses = input.getText().toString();
        input.setText(proses + "4");
    }
    public void lima(View view) {
        proses = input.getText().toString();

        input.setText(proses + "5");
    }
    public void enam(View view) {
        proses = input.getText().toString();
        input.setText(proses + "6");
    }
    public void kurang(View view) {
        proses = input.getText().toString();
        input.setText(proses + "-");
    }
    public void satu(View view) {
        proses = input.getText().toString();
        input.setText(proses + "1");
    }
    public void dua(View view) {
        proses = input.getText().toString();
        input.setText(proses + "2");
    }
    public void tiga(View view) {
        proses = input.getText().toString();
        input.setText(proses + "3");
    }
    public void tambah(View view) {
        proses = input.getText().toString();
        input.setText(proses + "+");
    }
    public void nol(View view) {
        proses = input.getText().toString();
        input.setText(proses + "0");
    }

    public void hapus(View view) {
        String word = input.getText().toString();
        int length = word.length();
        if (length > 0) {
            input.setText(word.substring(0, length-1));
        }
    }

    public void ac(View view) {

        input.setText("");
        output.setText("");
    }

    public void samadengan(View view) {
        proses = input.getText().toString();

        proses = proses.replaceAll("x", "*");
        proses = proses.replaceAll("/", "/");

        Context rhino = Context.enter();

        rhino.setOptimizationLevel(-1);

        String finalResult = "";

        try {
            Scriptable scriptable = rhino.initSafeStandardObjects();
            finalResult = rhino.evaluateString(scriptable, proses, "javascript", 1, null).toString();
        } catch (Exception e) {
            finalResult = "0";
        }

        output.setText(finalResult);
    }
}