package com.arabin.roomdb.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.arabin.roomdb.dao.MainDataDao;
import com.arabin.roomdb.model.MainData;

@Database(entities = {MainData.class}, version = 2, exportSchema = false)
public abstract class DataDB extends RoomDatabase {
    public abstract MainDataDao getDataDao();
}
