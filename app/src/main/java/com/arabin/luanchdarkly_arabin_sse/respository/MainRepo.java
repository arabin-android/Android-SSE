package com.arabin.luanchdarkly_arabin_sse.respository;

import com.arabin.retrofit.api.ScoresSSEApiHelper;
import com.arabin.retrofit.httphelper.IPassDataInterface;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;


/**
 * @author Arabin
 * Main repository to start/stop SSE
 * */
public class MainRepo {

    private final ScoresSSEApiHelper scoresSSEApiHelper;

    @Inject
    public MainRepo(@NotNull ScoresSSEApiHelper scoresSSEApiHelper){
        this.scoresSSEApiHelper = scoresSSEApiHelper;
    }

    public void startServerEvent(IPassDataInterface iPassDataInterface){
        scoresSSEApiHelper.onStartEvents(iPassDataInterface);
    }

    public void stopServerEvent(){
        scoresSSEApiHelper.onStopEvents();
    }

    /* Room Db Related operation
        public void startServerEvent(){
        apiHelperInterface.onStartEvents(dataDao);
    }
        public Flowable<List<MainData>> getAllUserWithExamScore(){
        return dataDao.getAllUserWithExamScore();
    }
        private final MainDataDao dataDao;

    * */

}
