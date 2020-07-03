package app.Videira.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import app.Videira.R;

public class Tela_Principal extends AppCompatActivity {

    String url;
    private ProgressBar progressBar;
    private Button btnComent,button22,button2;
    public Button button21;
    public Button irAteLocal;
    private TextView Datat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__principal);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        inicializarComponentes();
        startt();
        eventoClicks1();
    }
    private void eventoClicks1() {
       btnComent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tela_Principal.this, ListaMenbros.class);
                startActivity(i);
            }
        });
        irAteLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tela_Principal.this, Membros.class);
                startActivity(i);

            }
        });
       button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
/*        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    Intent i = new Intent(Tela_Principal.this, IdeiasCelula.class);
              //  startActivity(i);
            }
        });
*/
    }
    void inicializarComponentes(){
        btnComent =(findViewById(R.id.button20));
        button22 = (findViewById(R.id.button22));
        button21 = (findViewById(R.id.button21));
        irAteLocal = (findViewById(R.id.button2));

    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(Tela_Principal.this, Login.class);
        startActivity(i);
        finish();
        
    }
    private void startt(){
        this.progressBar = findViewById(R.id.progressBar);
    }
}