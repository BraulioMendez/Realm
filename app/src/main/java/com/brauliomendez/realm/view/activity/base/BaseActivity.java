package com.brauliomendez.realm.view.activity.base;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * @author Braulio Méndez Jiménez
 * @since 14/08/16
 */
public abstract class BaseActivity extends AppCompatActivity {

    abstract protected void initComponents();

    public void showMessage(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}
