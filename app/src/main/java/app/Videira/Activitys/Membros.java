package app.Videira.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import app.Videira.BancoFireBase.MembroDao;
import app.Videira.R;

public class Membros extends AppCompatActivity {

   private   EditText editNome,editEmail,editTelefone,editIdade,editEndereco,editeBatizado;
    CheckBox checkBoxSim,checkBoxNao;
   private Button btCadastra;
   private FirebaseAuth auth;
   private FirebaseDatabase firebaseDatabase;
   private DatabaseReference m;
   private MembroDao membro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_d_t__menbro);


        auth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        m = firebaseDatabase.getReference("Membro");
        membro = new MembroDao();
        FirebaseApp.initializeApp(Membros.this);
        editNome = findViewById(R.id.editNome);
        editEndereco = findViewById(R.id.editEndereco);
        editTelefone = findViewById(R.id.editTelefone);
        editEmail = findViewById(R.id.editText);
        editIdade = findViewById(R.id.editIdade);
        editeBatizado = findViewById(R.id.editBatizado);
        checkBoxSim= findViewById(R.id.checkBoxSim);
        checkBoxNao = findViewById(R.id.checkBoxNao);
        btCadastra =(Button) findViewById(R.id.btCadastra);


btCadastra.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        checkbox();
        SalvarNoFirebase(editNome.getText().toString(),editEmail.getText().toString(),editEndereco.getText().toString(),editTelefone.getText().toString(),editIdade.getText().toString(),editeBatizado.getText().toString());
    }
});
    }public void checkbox(){
        String Texto = "";
        if(checkBoxSim.isChecked()){
            Texto = "SIM";
        }if(checkBoxNao.isChecked()){
            Texto = "Não";
        }
        editeBatizado.setText(Texto);
    }

    private void SalvarNoFirebase(String nome,String email,String endereco,String telefone,String indade,String batizado) {

    String Key = m.child("Membro").push().getKey();
    membro.setID(UUID.randomUUID().toString());
    membro.setNome(nome);
    membro.setEmail(email);
    membro.setEndereco(endereco);
    membro.setTelefone(telefone);
    membro.setIdade(indade);
    membro.setBatizado(batizado);
    m.child(Key).setValue(membro);
    alert("Cadastrado !");
        onBackPressed();
    }


    private  void alert (String msg){
        final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        Toast.makeText(Membros.this,msg,Toast.LENGTH_SHORT).show();

    }

}