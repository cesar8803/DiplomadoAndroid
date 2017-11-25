package mx.mobilestudio.promohunters.listeners;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import mx.mobilestudio.promohunters.RegisterActivity;
import mx.mobilestudio.promohunters.interfaces.RegisterEventHandler;

/**
 * Created by cesar on 10/28/17.
 */

public class RegisterCompleteListener implements OnCompleteListener<AuthResult> {
    private Context context;

    private  RegisterEventHandler registerEventHandler;


    public RegisterCompleteListener(Context context, RegisterEventHandler registerEventHandler){
        this.context= context;
        this.registerEventHandler = registerEventHandler;
    }


    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {

        if(task.isSuccessful()){
            registerEventHandler.onRegistryComplete(task.getResult().getUser());

        }else{

            registerEventHandler.onRegistryFailed(task);

        }



    }
}
