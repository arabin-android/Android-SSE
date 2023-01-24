package com.arabin.retrofit.api;

import com.arabin.retrofit.httphelper.EventSource;
import com.arabin.retrofit.httphelper.IPassDataInterface;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.sse.EventSources;


public class ScoresSSEApiHelper {

    private final Request request;
    private final OkHttpClient client;
    private okhttp3.sse.EventSource eventSource;

    @Inject
    public ScoresSSEApiHelper(@NotNull Request request, @NotNull OkHttpClient client){
        synchronized (this){
            this.request = request;
            this.client = client;
        }
    }

    public void onStopEvents() {
        if (eventSource != null)
            eventSource.cancel();
    }

    public void onStartEvents(IPassDataInterface iPassDataInterface) {
        Executor executor = Executors.newSingleThreadExecutor();
        EventSource eventSourceHelper = new EventSource(iPassDataInterface);
        executor.execute(() -> {
            eventSource = EventSources.createFactory(client)
                    .newEventSource(request, eventSourceHelper);
        });
    }

    /* Room Db Related operation
        public void onStartEvents(MainDataDao dataDao){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        EventSourceHelper eventSourceHelper = new EventSourceHelper(dataDao);
        executorService.execute(() -> {
            eventSource = EventSources.createFactory(client)
                    .newEventSource(request, eventSourceHelper);
        });
    }
    * */


}
