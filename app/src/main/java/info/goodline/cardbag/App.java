package info.goodline.cardbag;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import io.realm.Realm;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
    @Override
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
