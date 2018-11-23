package info.goodline.cardbag;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import io.realm.Realm;

public class App extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
