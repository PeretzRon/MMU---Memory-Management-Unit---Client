package com.hit.client;

import com.hit.view.CacheUnitView;

import java.beans.PropertyChangeEvent;

public class CacheUnitClientObserver implements java.beans.PropertyChangeListener {

    private CacheUnitClient cacheUnitClient;
    private CacheUnitView cacheUnitView;

    public CacheUnitClientObserver() {
        cacheUnitClient = new CacheUnitClient();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        cacheUnitView = (CacheUnitView) evt.getSource();
        String result = cacheUnitClient.send((String) evt.getNewValue());
        if (result.contains("true")) {
            result = result.replace("true", "");
            result = "Request Succeeded ! ! !\n\n" + result;
        } else if (result.contains("false")) {
            result = result.replace("false", "");
            result = "Request Failed ! ! !\n\n" + result;
        }

        cacheUnitView.updateUIData(result);
    }

}
