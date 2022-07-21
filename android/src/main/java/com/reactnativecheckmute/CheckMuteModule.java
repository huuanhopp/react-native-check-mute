package com.reactnativecheckmute;

import static android.content.Context.AUDIO_SERVICE;

import android.media.AudioManager;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = CheckMuteModule.NAME)
public class CheckMuteModule extends ReactContextBaseJavaModule {
    public static final String NAME = "CheckMute";

    public CheckMuteModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @ReactMethod
    public void isMute(final Promise promise) {
        AudioManager am = (AudioManager) getReactApplicationContext().getSystemService(AUDIO_SERVICE);
        int volume_level= am.getStreamVolume(AudioManager.STREAM_MUSIC);
        promise.resolve(volume_level == 0);
    }

    @ReactMethod
    public void getCurrentVolume(final Promise promise) {
        AudioManager am = (AudioManager) getReactApplicationContext().getSystemService(AUDIO_SERVICE);
        promise.resolve((am.getStreamVolume(AudioManager.STREAM_MUSIC)/am.getStreamMaxVolume(AudioManager.STREAM_MUSIC))*100);
    }

}
