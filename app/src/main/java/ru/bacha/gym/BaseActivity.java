package ru.bacha.gym;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    public GymApp getGymApp() {
        return ((GymApp) getApplication());
    }

}
