package notas.taller1cdlr;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText nota1;
    private EditText nota2;
    private EditText nota3;
    private TextView mostar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        nota1 = (EditText) findViewById(R.id.editText);
        nota2 = (EditText) findViewById(R.id.editText2);
        nota3 = (EditText) findViewById(R.id.editText3);
        mostar = (TextView) findViewById(R.id.textView5);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = getApplicationContext();

                if (nota1.getText().toString().isEmpty() == true || nota2.getText().toString().isEmpty() == true || nota3.getText().toString().isEmpty() == true || Float.valueOf(nota1.getText().toString()) > 5 || Float.valueOf(nota2.getText().toString()) > 5 || Float.valueOf(nota3.getText().toString()) > 5) {
                    Toast.makeText(context, "Ingrese correctamente los campos", Toast.LENGTH_LONG).show();
                } else {
                    float total = (Float.parseFloat(nota1.getText().toString()) + Float.parseFloat(nota2.getText().toString()) + Float.parseFloat(nota3.getText().toString())) / 4;

                    float need = (float) ((3.5 - total) * 4);
                    String text;
                    if (need <= 0) {
                        text = "No necesitas nota la llevas en " + String.valueOf(total);
                    } else {
                        text = "Necesitas: " + String.valueOf(need);

                    }
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    mostar.setText(text);
                }

            }

        });
    }
}
