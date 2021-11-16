package com.example.calculadora;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.xml.xpath.XPathExpression;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button igual, deletar, limpar, zero, um, dois, tres, quatro, cinco, seis, sete, oito, nove, virgula, subtrair, dividir, multiplicar, somar;
    private TextView formula, resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Iniciar();
        getSupportActionBar().hide();

        zero.setOnClickListener(this);
        um.setOnClickListener(this);
        dois.setOnClickListener(this);
        tres.setOnClickListener(this);
        quatro.setOnClickListener(this);
        cinco.setOnClickListener(this);
        seis.setOnClickListener(this);
        sete.setOnClickListener(this);
        oito.setOnClickListener(this);
        nove.setOnClickListener(this);
        virgula.setOnClickListener(this);
        somar.setOnClickListener(this);
        subtrair.setOnClickListener(this);
        dividir.setOnClickListener(this);
        multiplicar.setOnClickListener(this);
        deletar.setOnClickListener(this);

        limpar.setOnClickListener( new View.OnClickListener(){
                public void onClick(View v){
                    formula.setText("");
                    resultado.setText("");
        }

        });

        deletar.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                TextView txtformula = findViewById(R.id.formula);
                String string = txtformula.getText().toString();

                if (!string.isEmpty()){
                    byte var0=0;
                    int var1 = string.length()-1;
                    String txtExpressao = string.substring(var0,var1);
                    txtformula.setText(txtExpressao);
                }
                resultado.setText("");
            }
        })
        ;
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Expression expressao = new ExpressionBuilder(formula.getText().toString()).build();
                    double result = expressao.evaluate();
                    long longResult = (long) result;

                    if (result == (double) longResult) {
                        resultado.setText((CharSequence) String.valueOf(longResult));
                    } else {
                        resultado.setText((CharSequence) String.valueOf(result));
                    }
            }
        });

    }

    private void Iniciar(){
        zero = findViewById(R.id.zero);
        um = findViewById(R.id.um);
        dois = findViewById(R.id.dois);
        tres = findViewById(R.id.tres);
        quatro = findViewById(R.id.quatro);
        cinco = findViewById(R.id.cinco);
        seis = findViewById(R.id.seis);
        sete = findViewById(R.id.sete);
        oito = findViewById(R.id.oito);
        nove = findViewById(R.id.nove);
        virgula = findViewById(R.id.virgula);
        somar = findViewById(R.id.somar);
        subtrair = findViewById(R.id.subtrair);
        multiplicar = findViewById(R.id.multiplicar);
        dividir = findViewById(R.id.dividir);
        resultado = findViewById(R.id.resultado);
        limpar = findViewById(R.id.limpar);
        igual = findViewById(R.id.igual);
        deletar = findViewById(R.id.deletar);
        formula = findViewById(R.id.formula);
    }

    public void AcrescentarUmaExpressão(String string, boolean limparDados) {
        if (limparDados){
            if (!resultado.getText().equals(" ")){ formula.setText(" ");}
            resultado.setText(" ");
            formula.append(string);
        }else{
            if (!resultado.getText().equals(" ")){ formula.setText(" ");}
            formula.append(resultado.getText());
            formula.append(string);
            resultado.setText(" ");
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.zero:
                AcrescentarUmaExpressão( "0", true);
            break;

            case R.id.um:
                AcrescentarUmaExpressão( "1", true);
                break;

            case R.id.dois:
                AcrescentarUmaExpressão( "2", true);
                break;

            case R.id.tres:
                AcrescentarUmaExpressão( "3", true);
                break;
            case R.id.quatro:
                AcrescentarUmaExpressão( "4", true);
                break;
            case R.id.cinco:
                AcrescentarUmaExpressão( "5", true);
                break;
            case R.id.seis:
                AcrescentarUmaExpressão( "6", true);
                break;
            case R.id.sete:
                AcrescentarUmaExpressão( "7", true);
                break;
            case R.id.oito:
                AcrescentarUmaExpressão( "8", true);
                break;
            case R.id.nove:
                AcrescentarUmaExpressão( "9", true);
                break;
            case R.id.virgula:
                AcrescentarUmaExpressão( ".", true);
                break;
            case R.id.somar:
                AcrescentarUmaExpressão( "+", false);
                break;
            case R.id.subtrair:
                AcrescentarUmaExpressão( "-", false);
                break;
            case R.id.multiplicar:
                AcrescentarUmaExpressão( "*", false);
                break;
            case R.id.dividir:
                AcrescentarUmaExpressão( "/", false);
                break;
        }
    }
}