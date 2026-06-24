package com.example.boxuegu.activity.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;       // 数据库版本号
    public static final String DB_NAME = "bxg.db"; // 数据库名称

    // 表名常量
    public static final String U_USERINFO = "userinfo";          // 用户信息表
    public static final String U_VIDEO_PLAY_LIST = "videoplaylist"; // 视频播放记录表

    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // 1. 创建用户信息表
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + U_USERINFO + "("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "userName VARCHAR, "   // 用户名
                + "nickName VARCHAR, "   // 昵称
                + "sex VARCHAR, "        // 性别
                + "signature VARCHAR"    // 签名
                + ")");

        // 2. 创建视频播放记录表
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + U_VIDEO_PLAY_LIST + "("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "userName VARCHAR, "      // 用户名
                + "chapterId INT, "         // 章节ID
                + "videoId INT, "           // 视频ID
                + "videoPath VARCHAR, "     // 视频地址
                + "chapterName VARCHAR, "   // 章节名称
                + "videoName VARCHAR, "     // 视频名称
                + "videoIcon VARCHAR "      // 视频图标
                + ")");
    }

    // 当数据库版本号增加时，会调用此方法
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // 删除旧表
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + U_USERINFO);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + U_VIDEO_PLAY_LIST);
        // 重新创建新表
        onCreate(sqLiteDatabase);
    }
}