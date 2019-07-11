package amrita.design.com.amritanavigator;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Final extends Activity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        tv = findViewById(R.id.textView2);
        tv.setMovementMethod(new ScrollingMovementMethod());
    }
}
