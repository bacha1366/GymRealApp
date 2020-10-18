package ru.bacha.gym;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

        import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExercisesManager exercisesManager = new ExercisesManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listexercises = findViewById(R.id.IDlist);
        final ArrayAdapter<ExeClass> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, exercisesManager.getMyExercises());
        listexercises.setAdapter(adapter);
        listexercises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                startActivity(createExerciseIntent(MainActivity.this, adapter.getItem(position)));
            }
        });

    }

    public static Intent createExerciseIntent(Context context, ExeClass exercise) {
        Intent intent = new Intent(context, ExeActivity.class);
        intent.putExtra(EXERCISE_KEY, exercise);
        return intent;
    }

    private static String EXERCISE_KEY = "exercise_key";
}
