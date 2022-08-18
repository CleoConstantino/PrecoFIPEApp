package com.github.precofipeapp.util;

import android.app.Activity;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.github.precofipeapp.activities.LoginActivity;

public class DialogUtil {

    public static void showError(final Activity activity, final String titulo, final String mensagem) {

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(titulo);
        builder.setMessage(mensagem);
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();

    }
}
