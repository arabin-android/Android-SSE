package com.arabin.luanchdarkly_arabin_sse.viewmodel;

public class SingleEventObserver<T> {

    private T content;

    private boolean hasBeenHandled = false;

    public SingleEventObserver(T content){
        this.content = content;
    }

    public T getContentIfNotHandled(){
        if(hasBeenHandled) return null;
        else{
            hasBeenHandled = true;
            return content;
        }
    }

}
