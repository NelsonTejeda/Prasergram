package com.example.prasergram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("Q5MT7Ms33PRL5tt7sJTUAMlAOPxejlqoVpGr42sl")
                .clientKey("XP81joC9qthQz56A6xslswlYjuJgtqlGtghq32SN")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
