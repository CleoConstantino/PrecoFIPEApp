package com.github.precofipeapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.github.precofipeapp.MainActivity;
import com.github.precofipeapp.R;

public class SplashAlternativaActivity extends AppCompatActivity {

    private LottieAnimationView animacaoVeiculo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_alternativa);

        animacaoVeiculo = findViewById(R.id.animacaoVeiculo);

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent it = new Intent(SplashAlternativaActivity.this, LoginActivity.class);
                it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(it);
            }
        }, 9000);

    }
}
