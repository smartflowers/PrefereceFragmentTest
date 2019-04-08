package com.example.preferecefragmenttest;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class PreferencerFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}

