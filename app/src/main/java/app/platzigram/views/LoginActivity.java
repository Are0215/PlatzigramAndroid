package app.platzigram.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import app.platzigram.R;
import app.platzigram.views.CreateAccountActivity;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_login);
    }

    public void createAccount(View v){
        Intent it = new Intent(this, CreateAccountActivity.class);
        startActivity(it);

    }

    public void login(View view) {
        Intent it = new Intent(this, ContainerActivity.class);
        startActivity(it);
    }
}
