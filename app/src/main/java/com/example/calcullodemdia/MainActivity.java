package com.example.calcullodemdia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nota1, nota2, nota3, nota4, txtFalta;
    private Button btnCalcular;
    private TextView txtResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //é i medo construtor do AppCompatActivity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nota1 = findViewById(R.id.nota1);
        nota2 = findViewById(R.id.nota2);
        nota3 = findViewById(R.id.nota3);
        nota4 = findViewById(R.id.nota4);
        txtFalta =  findViewById(R.id.txtFalta);
        btnCalcular =  findViewById(R.id.btnCalcular);
        txtResultado =  findViewById(R.id.txtResultado);

    btnCalcular.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            boolean retorno= validarCampos();

            if (retorno){
//                CONVERTER PARA INTEIRO O TEXTO QUE FOI PEGO
                int nota_1 = Integer.parseInt(nota1.getText().toString());
                int nota_2 = Integer.parseInt((nota2.getText().toString()));
                int nota_3 = Integer.parseInt(nota3.getText().toString());
                int nota_4 =  Integer.parseInt(nota4.getText().toString());
                int numeroFalta = Integer.parseInt(txtFalta.getText().toString());
                double media = (nota_1+nota_2+nota_3+nota_4)/4;

                if (media>=5 && numeroFalta<=20){
                    txtResultado.setText("Aluno foi APROVADO!!!\n" + "Média Final: " + media);
                    txtResultado.setTextColor(getColor(R.color.green));
                    txtResultado.setBackgroundColor(getColor(R.color.fundoGreen));
                }else if (numeroFalta >20) {
                    txtResultado.setText("Aluno foi reprovado por faltas\n" + "Média Final: " +media);
                    txtResultado.setTextColor(getColor(R.color.red));
                    txtResultado.setBackgroundColor(getColor(R.color.fundRed));
                } else if (media<5) {
                    txtResultado.setText("Aluno foi Reprovado por Nota\nMédia Final: "+ media);
                    txtResultado.setTextColor(getColor(R.color.red));
                    txtResultado.setBackgroundColor(getColor(R.color.fundRed));
                }

            }else {
                Toast.makeText(MainActivity.this, "Preencha toodos os campos", Toast.LENGTH_SHORT).show();

            }

        }
//
        private boolean validarCampos() {
            boolean camposValidados = true;

            if(nota1.getText().toString().isEmpty()){
                camposValidados=false;
                nota1.setText("*");
                nota1.setTextColor(getColor(R.color.red));
            }
            if(nota2.getText().toString().isEmpty()){
                camposValidados=false;
                nota2.setText("*");
                nota2.setTextColor(getColor((R.color.red)));
            }
            if(nota3.getText().toString().isEmpty()){
                camposValidados=false;
                nota3.setText("*");
                nota3.setTextColor(getColor((R.color.red)));
            }
            if(nota4.getText().toString().isEmpty()){
                camposValidados=false;
                nota4.setText("*");
                nota4.setTextColor(getColor((R.color.red)));
            }
            if(txtFalta.getText().toString().isEmpty()){
                camposValidados=false;
                txtFalta.setText("*");
                txtFalta.setTextColor(getColor((R.color.red)));
            }


            return camposValidados;
        }
    });

    }
}