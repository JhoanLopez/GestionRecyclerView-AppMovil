package com.jhoanlopez.gestiondecontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MultiAutoCompleteTextView;

public class PoliticaDePrivacidad extends AppCompatActivity {

    MultiAutoCompleteTextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_politica_de_privacidad);

        texto = findViewById(R.id.multiAutoCompleteTextView);

        texto.setText(
                "Compromiso de privacidad\n" +
                        "\n" +
                        "En esta Política de Privacidad se utiliza el término “Datos Personales” en relación con información como el nombre, apellidos, cargo, dirección de correo electrónico, dirección postal o número de teléfono, que pueda utilizarse para su identificación. Generalmente, solo procesaremos sus Datos Personales tal y como se describe en la presente Política de Privacidad. Sin embargo, nos reservamos el derecho a realizar procesamientos adicionales con el alcance autorizado o solicitado por la ley, o como apoyo a cualquier investigación criminal. Las siguientes secciones explican cómo y dónde recopilamos sus Datos Personales.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                "Seguridad y confidencialidad\n" +
                        "\n" +
                        "Con el fin de garantizar la seguridad y confidencialidad de los Datos Personales que recopilamos online, utilizamos redes de datos protegidas mediante cortafuegos estándar protegidos con contraseña. Durante el tratamiento de sus Datos Personales, tomamos medidas diseñadas adecuadamente para proteger dicha información ante posibles pérdidas, uso inadecuado, acceso no autorizado, revelación, alteración o destrucción. \n" +
                        "\n" +
                        "\n" +
                        "\n" +
                "Transferencia de datos al extranjero\n" +
                        "\n" +
                        "Colaboramos habitualmente con empresas que trabajan fuera de las fronteras de España. Por este motivo, podríamos transferir sus datos a una de las bases de datos de empresas fuera de su país de residencia, lo cual incluye la posibilidad de que se transfieran a países que no ofrecen un nivel adecuado de protección para sus Datos Personales en comparación con la seguridad proporcionada en su país.\n" +
                        "\n" +
                        "En el caso de que el nivel de protección de privacidad en un país concreto no cumpla las normas reconocidas internacionalmente, adoptaremos las medidas adecuadas para garantizar que la información transferida a las bases de datos de Reporting Estándar en dicho país cuenta con la adecuada protección, y que la cesión de datos a terceros en tal país no se lleva a cabo sin que Ud. la autorice previamente."
        );
    }
}