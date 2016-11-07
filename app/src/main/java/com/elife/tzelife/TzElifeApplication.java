package com.elife.tzelife;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * https://github.com/square/leakcanary
 * <p/>
 * https://www.liaohuqiu.net/cn/posts/leak-canary-read-me/
 * HAHA heap文件分析
 * https://github.com/square/haha
 * <p/>
 * Created by tzhang on 2016/10/24.
 */
public class TzElifeApplication extends Application {

    // 使用 RefWatcher 监控那些本该被回收的对象  refWatcher.watch(schrodingerCat);
    private RefWatcher refWatcher;

    public static RefWatcher getRefWatcher(Context context) {
        TzElifeApplication application = (TzElifeApplication) context.getApplicationContext();
        return application.refWatcher;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }

        //LeakCanary.install() 会返回一个预定义的 RefWatcher，同时也会启用一个 ActivityRefWatcher，用于自动监控调用 Activity.onDestroy() 之后泄露的 activity
        refWatcher = LeakCanary.install(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    // 发布版使用
    protected RefWatcher installLeakCanary() {
        return RefWatcher.DISABLED;
    }
}
