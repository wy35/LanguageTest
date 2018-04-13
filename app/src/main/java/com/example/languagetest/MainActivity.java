package com.example.languagetest;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Locale locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            locale = getResources().getConfiguration().getLocales().get(0);
        } else {
            locale = getResources().getConfiguration().locale;
        }
        String text;
        if (locale.getLanguage().equalsIgnoreCase("zh")) {
            text = getString(R.string.language).equals("语言") ? "简体中文" : "繁体中文";
            Log.e("aaaa", text);
        } else {
            text = "非中文";
            Log.e("aaaa", text);
        }
        TextView textView = findViewById(R.id.text);
        textView.setText(text);
    }

    public void click(View view) {
        Intent intent = new Intent();
        ComponentName cm = new ComponentName("com.android.settings",
                "com.android.settings.LanguageSettings");
        intent.setComponent(cm);
        intent.setAction("android.intent.action.VIEW");
        startActivity(intent);

    }
}
