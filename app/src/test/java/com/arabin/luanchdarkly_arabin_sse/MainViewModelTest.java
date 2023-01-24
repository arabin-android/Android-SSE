package com.arabin.luanchdarkly_arabin_sse;

import static org.mockito.Mockito.mock;

import com.arabin.luanchdarkly_arabin_sse.respository.MainRepo;
import com.arabin.luanchdarkly_arabin_sse.viewmodel.MainViewModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainViewModelTest extends Assert {

    private MainViewModel viewModel;

    @Before
    public void setup(){
        MainRepo mainRepo = mock(MainRepo.class);
        viewModel = new MainViewModel(mainRepo);
    }

    @Test
    public void testOnStartServerEvent(){
        viewModel.startServerEvent();
    }

    @Test
    public void testOnStopServerEvent(){
        viewModel.stopServerEvent();
    }

}
