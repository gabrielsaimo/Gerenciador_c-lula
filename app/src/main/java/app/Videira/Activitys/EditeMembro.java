package app.Videira.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.Key;
import java.util.UUID;

import app.Videira.BancoFireBase.MembroDao;
import app.Videira.R;

public class EditeMembro extends AppCompatActivity {

     EditText editEmail,editNome,editEndereco,editTelefone,editIdade,editeBatizado;
     CheckBox checkBoxSim,checkBoxNao;
     DatabaseReference reference;
     MembroDao membroDao;
    private Button btdeleta,btAtualiza;
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    public Button voltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edite_membro);
        inicilaizalarFirebase();
        editNome = findViewById(R.id.editNome);
        editEndereco = findViewById(R.id.editEndereco);
        editTelefone = findViewById(R.id.editTelefone);
        editEmail = findViewById(R.id.editText);
        btdeleta = findViewById(R.id.btdeletar);
        editIdade = findViewById(R.id.editIdade);
        editeBatizado = findViewById(R.id.editBatizado);
        btAtualiza = findViewById(R.id.btAtualizar);
        checkBoxSim= findViewById(R.id.checkBoxSim);
        checkBoxNao = findViewById(R.id.checkBoxNao);

        editNome.setText(getIntent().getStringExtra("nome"));
        editEndereco.setText(getIntent().getStringExtra("endereco"));
        editTelefone.setText(getIntent().getStringExtra("telefone"));
        editEmail.setText(getIntent().getStringExtra("email"));
        editIdade.setText(getIntent().getStringExtra("idade"));
        editeBatizado.setText(getIntent().getStringExtra("batizado"));
        eventoClicks();
    }

    //MOSTRA MSG
    private void alert(String msg) {
        final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        Toast.makeText(EditeMembro.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(EditeMembro.this, Login.class);
        startActivity(i);
        finish();
    }
    private void eventoClicks() {
        btAtualiza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MembroDao m = new MembroDao();

                    m.setID(m.getID());
                    m.setNome(editNome.getText().toString().trim());
                    m.setEmail(editEmail.getText().toString().trim());
                    m.setTelefone(editTelefone.getText().toString().trim());
                    m.setIdade(editIdade.getText().toString().trim());
                    m.setEndereco(editEndereco.getText().toString().trim());
                    m.setBatizado(editeBatizado.getText().toString());
                    reference.child("Membro").child(m.getID()).setValue(m);
            }
        });

        btdeleta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                if (id == R.id.btdeletar) {
                    MembroDao m = new MembroDao();
                    m.setID(m.getID());
                    reference.child("Membro").removeValue();
                }
            }
        });
    }
    public void btdeletar(View view) {


    } private void inicilaizalarFirebase() {
        FirebaseApp.initializeApp(EditeMembro.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        //  firebaseDatabase.setPersistenceEnabled(true);
        reference = FirebaseDatabase.getInstance().getReference("Membro");
    }
























}