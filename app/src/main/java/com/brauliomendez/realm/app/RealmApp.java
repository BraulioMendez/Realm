package com.brauliomendez.realm.app;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * @author Braulio Méndez Jiménez
 * @since 14/08/16
 */
public class RealmApp extends Application {

    public static RealmApp mInstance;

    @Override public void onCreate() {
        super.onCreate();
        mInstance = this;
        setUpRealmConfiguration();
    }

    private void setUpRealmConfiguration(){
        RealmConfiguration mRealmConfiguration = new RealmConfiguration.Builder(getApplicationContext())
                .build();
        Realm.setDefaultConfiguration(mRealmConfiguration);
    }

    private static RealmApp getInstance(){
        return mInstance;
    }
}
