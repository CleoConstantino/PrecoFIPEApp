package com.github.precofipeapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.precofipeapp.MainActivity;
import com.github.precofipeapp.R;
import com.github.precofipeapp.database.dao.UsuarioDAO;
import com.github.precofipeapp.util.DialogUtil;
import com.github.precofipeapp.util.KeyUtil;


public class LoginActivity extends AppCompatActivity {

    private TextView editEmail;
    private TextView editSenha;
    private Button btnEntrar, btnRegistrar;
    private Switch switchLembrarSenha;

    private UsuarioDAO dao;

    private static final int REQUISICAO_REGISTRO = 10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        switchLembrarSenha = findViewById(R.id.switchLembrarSenha);
        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);

        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivityForResult(it, REQUISICAO_REGISTRO);

            }
        });

        btnEntrar = findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String conteudoEmail = editEmail.getText().toString();
                String conteudoSenha = editSenha.getText().toString();

                if (conteudoEmail.isEmpty()) {
                    editEmail.setError("Campo e-mail ?? obrigat??rio!");
                }
                else if (conteudoSenha.isEmpty()) {
                    editSenha.setError("Campo senha ?? obrigat??rio!");
                } else {

                    dao = new UsuarioDAO(LoginActivity.this);
                    boolean isUsuarioEncontrado = dao.Select(conteudoEmail, conteudoSenha);

                    if (isUsuarioEncontrado) {

                        if (switchLembrarSenha.isChecked()) {
                            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString(KeyUtil.KEY_USUARIO, conteudoEmail).putString(KeyUtil.KEY_SENHA, conteudoSenha).apply();
                        }

                        Intent it = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(it);
                    }
                    else {
                        DialogUtil.showError(LoginActivity.this, "Erro", "Usu??rio inexistente!");
                    }
                }
            }
        });

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
        editEmail.setText(preferences.getString(KeyUtil.KEY_USUARIO, ""));
        editSenha.setText(preferences.getString(KeyUtil.KEY_SENHA, ""));

        if (!editEmail.getText().toString().isEmpty()) {
            switchLembrarSenha.setChecked(true);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Se for igual ao registro...
        if (requestCode == REQUISICAO_REGISTRO) {

            //Clicou no bot??o salvar...
            if(resultCode == 1) {
                final String resultadoEmailUsuario = data.getStringExtra(KeyUtil.KEY_REGISTRO_EMAIL_USUARIO);
                editEmail.setText(resultadoEmailUsuario);

                final String resultadoSenhaUsuario = data.getStringExtra(KeyUtil.KEY_REGISTRO_SENHA_USUARIO);
                editSenha.setText(resultadoSenhaUsuario);
            }
            //Clicou no bot??o cancelar...
            else if (resultCode == 9){
                Toast.makeText(LoginActivity.this, "Cancelou  registro de usu??rio!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
