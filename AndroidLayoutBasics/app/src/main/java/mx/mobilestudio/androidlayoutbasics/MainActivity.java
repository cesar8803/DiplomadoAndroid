package mx.mobilestudio.androidlayoutbasics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //test comment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onResume(){
        super.onResume();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
