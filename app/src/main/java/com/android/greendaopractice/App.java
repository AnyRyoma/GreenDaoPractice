package com.android.greendaopractice;

import android.app.Application;

import com.android.greendaopractice.greendao.DaoMaster;
import com.android.greendaopractice.greendao.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Shawn Chen on 2017/1/1.
 */
public class App extends Application {

    // 使用加密数据库 标志
    public static final boolean ENCRYPTED = true;

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        // 获取DevOpenhelper对象  数据库名：加密情况为 notes-db-encrypted
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,
                ENCRYPTED ? "notes-db-encrypted" : "notes-db", null);
        // 获取数据库
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        // 获取DaoSession 对象
        daoSession = new DaoMaster(db).newSession();
    }

    /**
     * 获取 DaoSession
     * @return
     */
    public DaoSession getDaoSession() {
        return daoSession;
    }
}
