package mx.mobilestudio.promohunters.interfaces;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by cesar on 10/28/17.
 */

public interface RegisterEventHandler {
    public void onRegistryComplete(FirebaseUser firebaseUser);

    public void onRegistryFailed(Task task);

}
