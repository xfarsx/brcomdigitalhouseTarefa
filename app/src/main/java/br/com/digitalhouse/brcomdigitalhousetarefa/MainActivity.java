package br.com.digitalhouse.brcomdigitalhousetarefa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText dNome;
    private EditText dEmail;
    private EditText dEndereco;
    private EditText dProfissao;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dNome = (EditText) findViewById(R.id.dNome);
        dEmail = (EditText) findViewById(R.id.dEmail);
        dEndereco = (EditText) findViewById(R.id.dEndereco);
        dProfissao = (EditText) findViewById(R.id.dProfissao);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(dNome.getText().toString().equals("") || dEmail.getText().toString().equals("") || dEndereco.getText().toString().equals("")
                || dProfissao.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Favor inserir os dados",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (dNome.getText().toString().length() < 2){
                    Toast.makeText(MainActivity.this,"Nome muito curto!", Toast.LENGTH_SHORT).show();
                    dNome.requestFocus();
                    return;
                }
                if (!dEmail.getText().toString().contains("@") || !dEmail.getText().toString().contains(".com"))
                {
                    Toast.makeText(MainActivity.this,"Favor inserir um email válido.",Toast.LENGTH_SHORT).show();
                    dEmail.requestFocus();
                    return;
                }
                if (dEndereco.getText().toString().length() <= 7)
                {
                    Toast.makeText(MainActivity.this,"Endereço parece inválido!",Toast.LENGTH_SHORT).show();
                    dEndereco.requestFocus();
                    return;
                }
                if (dProfissao.getText().toString().length() < 5)
                {
                    Toast.makeText(MainActivity.this,"Favor inserir uma profissão válida!",Toast.LENGTH_SHORT).show();
                    dProfissao.requestFocus();
                    return;
                }

                Toast.makeText(MainActivity.this,"Dados Enviados!",Toast.LENGTH_SHORT).show();

            }
        });
            
         
        }
    }

