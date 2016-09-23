package com.echo.hotpatch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.android.tools.fd.runtime.IncrementalChange;
import com.android.tools.fd.runtime.IncrementalClassLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static volatile transient IncrementalChange $change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> dexes = new ArrayList<>();
        String path = getFilesDir().getAbsolutePath() + File.separator + "patch" + File.separator;
        dexes.add(path + "patch.dex");
        IncrementalClassLoader.inject(getClassLoader(), null, getCacheDir().getAbsolutePath(), dexes);
    }

    public void onTest(View view) {
        IncrementalChange change = $change;
        if (change != null) {
            change.access$dispatch("onTest.(Landroid/view/View;)V", new Object[]{this, view});
            return;
        }
        Toast.makeText(this, "hello not patched", Toast.LENGTH_SHORT).show();
    }

    public void onPatch(View view) {
        Patcher.patch();
        Toast.makeText(this, "patch finished", Toast.LENGTH_SHORT).show();
    }
}
