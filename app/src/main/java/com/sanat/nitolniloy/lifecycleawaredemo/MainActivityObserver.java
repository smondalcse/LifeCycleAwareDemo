package com.sanat.nitolniloy.lifecycleawaredemo;

import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MainActivityObserver implements LifecycleObserver {

    private String TAG = this.getClass().getSimpleName();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreateEvent(){    // This is a usre define version
        Log.i(TAG, "Observer ON_CREATE");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStartEvent(){    // This is a usre define version
        Log.i(TAG, "Observer ON_START");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPauseEvent(){    // This is a usre define version
        Log.i(TAG, "Observer ON_PAUSE");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResumeEvent(){    // This is a usre define version
        Log.i(TAG, "Observer ON_RESUME");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroyEvent(){    // This is a usre define version
        Log.i(TAG, "Observer ON_DESTROY");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStopEvent(){    // This is a usre define version
        Log.i(TAG, "Observer ON_STOP");
    }
}
