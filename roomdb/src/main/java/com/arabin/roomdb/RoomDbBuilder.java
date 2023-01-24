package com.arabin.roomdb;

import android.app.Application;

import androidx.room.Room;

import com.arabin.roomdb.dao.MainDataDao;
import com.arabin.roomdb.db.DataDB;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RoomDbBuilder {

    @Provides
    @Singleton
    public static DataDB provideDataDB(Application application){
        return Room.databaseBuilder(application, DataDB.class, "main_database.db")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    public static MainDataDao provideDataDao(DataDB dataDB){return dataDB.getDataDao();}

}
