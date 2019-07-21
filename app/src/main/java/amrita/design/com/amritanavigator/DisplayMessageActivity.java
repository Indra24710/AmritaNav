package amrita.design.com.amritanavigator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DisplayMessageActivity extends AppCompatActivity {
    DrawView drawView;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getIntent().getExtras();
        int intValue=bundle.getInt("intVariableName",0);
        int intValue1=bundle.getInt("intVariableName1",0);
        int prio=bundle.getInt("intVariableName2",0);
        ShortestPath sp=new ShortestPath();
        float path[]=sp.main1(intValue,intValue1,prio);



        drawView = new DrawView(this,path);

        setContentView(drawView);

    }


}
