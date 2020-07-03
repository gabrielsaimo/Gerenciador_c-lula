package app.Videira.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import java.util.ArrayList;
import java.util.List;
import app.Videira.BancoFireBase.MembroDao;
import app.Videira.R;

public class ListaMenbros extends AppCompatActivity {
    ListView listView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseListAdapter firebaseListAdapter;
    private List<String> membro = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_menbros);
        listView = findViewById(R.id.Lista);
        Query query = FirebaseDatabase.getInstance().getReference().child("Membro");
        FirebaseListOptions<MembroDao> options = new FirebaseListOptions.Builder<MembroDao>().setLayout(R.layout.item).setQuery(query,MembroDao.class).build();
        firebaseListAdapter = new FirebaseListAdapter(options) {
           @Override
           protected void populateView(@NonNull View v, @NonNull Object model, int position) {
               TextView nome = v.findViewById(R.id.textNome);
               TextView email = v.findViewById(R.id.textEmail);
               TextView telefone = v.findViewById(R.id.textnumero);
               TextView endereco= v.findViewById(R.id.textEndereco);
               TextView idade= v.findViewById(R.id.textData);
               TextView batizado = v.findViewById(R.id.textBatizado);

               MembroDao m = (MembroDao) model;
               nome.setText(m.getNome().toString());
               email.setText(m.getEmail().toString());
               telefone.setText(m.getTelefone().toString());
               endereco.setText(m.getEndereco().toString());
               idade.setText(m.getIdade().toString());
               batizado.setText(m.getBatizado());
           }
       };
    /*    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

               // MapsActivity.InfoSalvas.putString("key",  arrayList.get(idInt).getIdPt());
                finish();
                Intent i = new Intent(ListaMenbros.this, EditeMembro.class);
                MembroDao m =(MembroDao) adapterView.getItemAtPosition(position);
                i.putExtra("id",m.getID());
                i.putExtra("nome",m.getNome());
                i.putExtra("email",m.getEmail());
                i.putExtra("telefone",m.getTelefone());
                i.putExtra("idade",m.getIdade());
                i.putExtra("endereco",m.getEndereco());
                i.putExtra("batizado",m.getBatizado());
                startActivity(i);
            }
        });*/
        listView.setAdapter(firebaseListAdapter);

    }

    protected void  onStart(){
        super.onStart();
        firebaseListAdapter.startListening();
    }
    protected void onStop(){
        super.onStop();
        firebaseListAdapter.stopListening();
    }

    private void inicilaizalarFirebase() {
        FirebaseApp.initializeApp(ListaMenbros.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
      //  firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference("Membro");
    }


}