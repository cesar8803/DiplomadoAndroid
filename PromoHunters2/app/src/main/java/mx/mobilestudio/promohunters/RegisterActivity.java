package mx.mobilestudio.promohunters;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

import mx.mobilestudio.promohunters.Model.User;
import mx.mobilestudio.promohunters.interfaces.RegisterEventHandler;
import mx.mobilestudio.promohunters.listeners.RegisterCompleteListener;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, RegisterEventHandler {


    private Button botonCrearCuenta;
    private TextView textviewmail;
    private TextView textViewPassword;


    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference myDataBaseReference;
    private RegisterCompleteListener onRegisterComplete;


    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textviewmail = (TextView) findViewById(R.id.email_registro);
        textViewPassword = (TextView) findViewById(R.id.password_registro);
        botonCrearCuenta = (Button) findViewById(R.id.boton_crear_cuenta_registro);


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        myDataBaseReference = firebaseDatabase.getReference();



        onRegisterComplete = new RegisterCompleteListener(this,this);






        botonCrearCuenta.setOnClickListener(this);

    }


    public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );
    private boolean checkEmail(String email) {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
    }



    @Override
    public void onClick(View v) {

        if(textviewmail.getText().toString().isEmpty()  || !checkEmail(textviewmail.getText().toString())   ){

            Toast.makeText(this,"Es necesario capturar el campo email, en un formato valido", Toast.LENGTH_LONG).show();

            return;
        }

        if(textViewPassword.getText().toString().isEmpty()  ||  textViewPassword.getText().toString().length() < 6  ){


            Toast.makeText(this,"Es necesario capturar el password, minimo 6 caracteres", Toast.LENGTH_LONG).show();


            return;

        }


        singUp(textviewmail.getText().toString(), textViewPassword.getText().toString());


    }




    public void singUp(String mail, String password){
            showProgressDialog();

            firebaseAuth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(this,onRegisterComplete);



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

    @Override
    public void onRegistryComplete(FirebaseUser firebaseUser) {

                String userName = null;

                if(firebaseUser.getEmail().contains("@")){
                    userName =  firebaseUser.getEmail().split("@")[0];
                }

                User user  = new User(userName,firebaseUser.getEmail());


                 myDataBaseReference.child("users").child(firebaseUser.getUid()).setValue(user);
                hideProgressDialog();


                 Intent i = new Intent(this, MainActivity.class);

                 startActivity(i);


    }

    @Override
    public void onRegistryFailed(Task task ) {

        Toast.makeText(this,"Ocurrio un error en el registro."+task.getException(), Toast.LENGTH_LONG).show();

        hideProgressDialog();

    }


}
