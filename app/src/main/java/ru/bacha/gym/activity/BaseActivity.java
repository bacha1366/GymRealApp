package ru.bacha.gym.activity;

import androidx.appcompat.app.AppCompatActivity;

import ru.bacha.gym.GymApp;

public abstract class BaseActivity extends AppCompatActivity {
    public GymApp getGymApp() {
        return ((GymApp) getApplication());
    }

}
