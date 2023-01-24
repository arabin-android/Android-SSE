package com.arabin.retrofit.httphelper;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.arabin.roomdb.model.MainData;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import okhttp3.Response;
import okhttp3.sse.EventSourceListener;

public class
EventSource extends EventSourceListener {

    private final IPassDataInterface iPassDataInterface;

    public EventSource(IPassDataInterface iPassDataInterface){
        this.iPassDataInterface = iPassDataInterface;
    }

    @Override
    public void onOpen(@NonNull okhttp3.sse.EventSource eventSource, @NonNull Response response) {
        super.onOpen(eventSource, response);
        Log.d("EventSourceHelper", "Connection opened");
    }


    @Override
    public void onClosed(@NonNull okhttp3.sse.EventSource eventSource) {
        super.onClosed(eventSource);
        Log.d("EventSourceHelper", "Connection closed");
    }

    @Override
    public void onEvent(@NonNull okhttp3.sse.EventSource eventSource, @Nullable String id,
                        @Nullable String type, @NonNull String data) {
        super.onEvent(eventSource, id, type, data);
        Log.d("EventSourceHelper", "Event data: -->"+data);
        JsonObject convertedJson = new Gson().fromJson(data, JsonObject.class);
        MainData convertedData = new MainData(convertedJson.get("exam").getAsString(),
                convertedJson.get("studentId").getAsString(),
                convertedJson.get("score").getAsString());
        iPassDataInterface.onLoadData(convertedData);
    }


    @Override
    public void onFailure(@NonNull okhttp3.sse.EventSource eventSource,
                          @Nullable Throwable t, @Nullable Response response) {
        super.onFailure(eventSource, t, response);
        if (response != null) {
            Log.d("EventSourceHelper", "Failure response: -->"+response.body());
        }
    }


    /*
     * RoomDb related operations**/
    /*
    private MainDataDao dataDao;
    public EventSourceHelper(MainDataDao dataDao){
        this.dataDao = dataDao;
    }
     List<MainData>items = new ArrayList<>();
        items.add(convertedData);
      System.out.println("All inserted-->"+dataDao.insertAll(items));
    //        dataDao.deleteAll();
    */


}
