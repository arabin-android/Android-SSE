package com.arabin.luanchdarkly_arabin_sse.viewmodel;

import android.util.ArrayMap;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.arabin.luanchdarkly_arabin_sse.respository.MainRepo;
import com.arabin.retrofit.httphelper.IPassDataInterface;
import com.arabin.roomdb.model.MainData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel implements IPassDataInterface {

    private final MainRepo mainRepo;
    private List<MainData>listOfData;
    private ArrayMap<String, MainData>studentsList;

    private final MutableLiveData<SingleEventObserver<List<MainData>>>
            listOfAllItems = new MutableLiveData<>();
    public LiveData<SingleEventObserver<List<MainData>>>getListOfAllData(){
        return listOfAllItems;
    }

    private final MutableLiveData<SingleEventObserver<ArrayMap<String, MainData>>>
            mapOfExams = new MutableLiveData<>();
    public LiveData<SingleEventObserver<ArrayMap<String, MainData>>> getMapOfExams(){
        return mapOfExams;
    }

    @Inject
    public MainViewModel(MainRepo mainRepo) {
        this.mainRepo = mainRepo;
    }

    public void startServerEvent() {
        mainRepo.startServerEvent(this);
    }

    public void stopServerEvent() {
        mainRepo.stopServerEvent();
    }

    public List<MainData>getListOfData(){
        return listOfData;
    }

    @Override
    public void onLoadData(MainData aData) {
        if (listOfData == null ) {
            listOfData = new ArrayList<>();
        }
        if (studentsList == null)
            studentsList = new ArrayMap<>();

        if (aData.getExam() != null)
            listOfData.add(0,aData);

        if (aData.getExam() != null && aData.getScore() != null)
            studentsList.put(aData.getStudentId(), aData);

        listOfAllItems.postValue(new SingleEventObserver<>(listOfData));
        mapOfExams.postValue(new SingleEventObserver<>(studentsList));
    }

}
