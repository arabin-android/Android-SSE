package com.arabin.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.arabin.roomdb.model.MainData;

import java.util.List;


@Dao
public interface MainDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertAll(List<MainData>items);

    @Query("DELETE from data_table")
    void deleteAll();

/*    @Query("select * from data_table where exam > 0 and score > 0 order by id DESC")
    Flowable<List<MainData>> getAllUserWithExamScore();

    @Query("select * from data_table where studentId = :id")
    Observable<List<MainData>> getAllExamResults(String id);

    @Query("select * from data_table where exam > 0")
    Observable<List<MainData>>getAllExams();

    @Query("select * from data_table where exam = :examId")
    Observable<List<MainData>>getAllResultOnExamId(long examId);*/

}
