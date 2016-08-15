package com.brauliomendez.realm.app;

import android.app.Application;

import com.brauliomendez.realm.realm.module.RealmAppModule;

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
                .setModules(new RealmAppModule())
                .build();
        Realm.setDefaultConfiguration(mRealmConfiguration);
    }

    public static RealmApp getInstance(){
        return mInstance;
    }
}
