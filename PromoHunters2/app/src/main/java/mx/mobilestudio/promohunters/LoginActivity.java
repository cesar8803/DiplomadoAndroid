package mx.mobilestudio.promohunters;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, OnCompleteListener {


    private TextView email;
    private TextView password;
    private Button login;
    private Button create_acccount;
    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;  // Crear usuarios y Autentificarlos
    private DatabaseReference databaseReference;  // Mddificar nuestra base de datos Real Time


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (TextView) findViewById(R.id.email);
        password = (TextView) findViewById(R.id.password);
        login = (Button) findViewById(R.id.boton_login);
        create_acccount = (Button) findViewById(R.id.boton_crear_cuenta);


        firebaseAuth = FirebaseAuth.getInstance();


        login.setOnClickListener(this);
        create_acccount.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boton_login:
                singIn(email.getText().toString(), password.getText().toString());

                break;
            case R.id.boton_crear_cuenta:

                Intent intent = new Intent(this,RegisterActivity.class);

                startActivity(intent);
                break;
        }
    }




    public void singIn(String email, String password){

    if (email.length()>0   && password.length() > 0){
        showProgressDialog();
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this,this);
    }else{
        Toast.makeText(this, "Usuario o Password invalido", Toast.LENGTH_LONG).show();
    }
;
    }


    @Override
    public void onComplete(@NonNull Task task) {


        Log.d(this.getClass().getName()  ,"Login onComplete" +task.isSuccessful());

        hideProgressDialog();

        if(!task.isSuccessful()){

            Log.d(this.getClass().getName()  + this.getClass().getEnclosingMethod().getName()  ,"signInWithEmailAndPassword failed" +task.getException());
            Toast.makeText(LoginActivity.this, "Log in Incorrecto",
                    Toast.LENGTH_SHORT).show();
        }else{
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
        }


    }




    public void showProgressDialog(){
        if(progressDialog== null){
            progressDialog = new ProgressDialog(this);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Cargando....");

        }
        progressDialog.show();
    }


    public void hideProgressDialog(){
        if(progressDialog != null  && progressDialog.isShowing() ){
            progressDialog.dismiss();
        }

    }




}
