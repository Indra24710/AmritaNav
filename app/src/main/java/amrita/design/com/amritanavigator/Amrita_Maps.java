package amrita.design.com.amritanavigator;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class Amrita_Maps extends AppCompatActivity implements OnItemClickListener, OnItemSelectedListener {
    String Choice,address,address1;
    String Dest;
    String Source;
    TextView bustext,walktext,cycletext,message;
    ListView list;
LinearLayout linearLayout;
InputMethodManager imm;
    private ArrayAdapter<String> adapter;
   // private ArrayAdapter<String> adapter1;
    public ImageButton btn,walk,cycle,bus,clear,swap;
   // public Spinner btn1;
   int cho = 0;
    public String item[]={
            "Main Gate","ATM 1/Post Office", "ATM 2",
            "Academic Block-1", "Academic Block-2", "Academic Block-3", "Amriteshwari Hall/Sudhamani Hall",
            "Main Canteen", "MBA Canteen", "IT Canteen",
            "Yagnavyalkya Bhavanam","Yagnavyalkya Bhavanam Annexe","Vyasamaharishi Bhavanam",
            "Nachikethas Bhavanam","Gargi Bhavanam","Mytreyi Bhavanam",
            "Gautama Bhavanam","Vashista Bhavanam","Agasthiya Bhavanam",
            "Guest House","CIR Block","Amrita School of Business","Central Library",
            "Swimming Pool","Main Ground","D-Ground","Gym","General Stores",
            "Temple","Saraswathi Statue","Mechanical Workshops","Car Parking","Dean Office","ICTS","Clinic",
            "Aerospace Department","Chemical and Material Science Department","Civil Department",
            "Computer Science Department","Electronics And Communication Department","Electrical And Electronics Department",
            "Mechanical Department","Mathematics Department","Science Department","English Department","Communication Department",
            "Social Work Department","Provision Stores","Cloth Shop","Travel Desk","Mobile Recharge","Hair Dressing-Boys",
            "Beauty Parlour-Boys/Girls","Amrita Darshanam Centre","Student Welfare Department","AB-1","AB-2","AB-3",
            "Hospital","Boys Hostel YB Annexe(1st year)","Girls Hostel(1st year)","Cyber Security","Center of Excellence in Networking(CEN)",
            "Accounts","Admissions","Boys Hostel(2nd year)","Boys Hostel(3rd year)","Boys Hostel(4th year)","Post Office",
            "Bank","Boys Hostel YB(1st year)","New Auditorium","Pandal"

    };
  //  String[] modee = new String[]{"Walk", "Cycle"};
    int p = 1000;
    AutoCompleteTextView textView = null;
    AutoCompleteTextView textView1 = null;
   // Spinner textview2 = null;
    int u = 1000;
public int addr=1;
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public Amrita_Maps() {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opt, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        startActivity(new Intent(this, Final.class));
        if (menuItem.getItemId() != R.menu.opt) {
            return super.onOptionsItemSelected(menuItem);
        }
        startActivity(new Intent(this, Final.class));
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home);
        this.textView = (AutoCompleteTextView) findViewById(R.id.source);
        this.textView1 = (AutoCompleteTextView) findViewById(R.id.destination);
        // this.textview2 = (Spinner) findViewById(R.id.mode);
        linearLayout = findViewById(R.id.fragment);
        btn = findViewById(R.id.go);
        this.clear = findViewById(R.id.clear);
        this.swap = findViewById(R.id.swap);
        this.bus = findViewById(R.id.bus);
        this.walk = findViewById(R.id.walk);
        this.cycle = findViewById(R.id.cycle);
        list = findViewById(R.id.list);
        this.adapter = new ArrayAdapter(this, 17367050, this.item);
        //     this.adapter1 = new ArrayAdapter(this, 17367050, this.modee);
        //  this.textview2.setAdapter(this.adapter1);
        this.textView.setThreshold(1);
        this.textView1.setThreshold(1);
        this.textView.setAdapter(this.adapter);
        this.textView.setOnItemSelectedListener(this);
        this.textView.setOnItemClickListener(this);
        this.textView1.setAdapter(this.adapter);
        this.textView1.setOnItemSelectedListener(this);
        this.textView1.setOnItemClickListener(this);
        this.bustext = findViewById(R.id.bustext);
        this.walktext = findViewById(R.id.walktext);
        this.cycletext = findViewById(R.id.cycletext);
        this.message = findViewById(R.id.message);

        linearLayout.removeAllViews();
        final InputMethodManager input=(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        input.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,0);
        ShortestPath sp = new ShortestPath();
        Log.i("ucpc",Integer.toString(u));
        Log.i("pc",Integer.toString(p));
        Log.i("commute",Integer.toString(cho));
        float path[] = sp.main1(8,8,0);
        DrawView drawView = new DrawView(Amrita_Maps.this, path);
        linearLayout.addView(drawView);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                textView1.setText("");
                setText(0);
                linearLayout.removeAllViews();
                ShortestPath sp = new ShortestPath();
                Log.i("ucpc",Integer.toString(u));
                Log.i("pc",Integer.toString(p));
                Log.i("commute",Integer.toString(cho));
                float path[] = sp.main1(8,8,0);
                DrawView drawView = new DrawView(Amrita_Maps.this, path);
                linearLayout.addView(drawView);
                input.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,0);

            }
        });

        swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = textView.getText().toString();
                textView.setText(textView1.getText().toString());
                textView1.setText(temp);
                input.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY,0);

            }
        });
        walktext.setVisibility(View.VISIBLE);
        cycletext.setVisibility(View.INVISIBLE);
        bustext.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                addr = maps(textView.getText().toString(), textView1.getText().toString(), 0);
                walktext.setVisibility(View.VISIBLE);
                cycletext.setVisibility(View.INVISIBLE);
                bustext.setVisibility(View.INVISIBLE);
                setText(addr);
                input.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY,0);

            }
        });

        walk.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                addr = maps(textView.getText().toString(), textView1.getText().toString(), 0);
                walktext.setVisibility(View.VISIBLE);
                cycletext.setVisibility(View.INVISIBLE);
                bustext.setVisibility(View.INVISIBLE);
                setText(addr);
            }
        });

        cycle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                addr = maps(textView.getText().toString(), textView1.getText().toString(), 1);
                cycletext.setVisibility(View.VISIBLE);
                walktext.setVisibility(View.INVISIBLE);
                bustext.setVisibility(View.INVISIBLE);
                setText(addr);
            }
        });


        bus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setText(0);
                bustext.setVisibility(View.VISIBLE);
                cycletext.setVisibility(View.INVISIBLE);
                walktext.setVisibility(View.INVISIBLE);

                linearLayout.removeAllViews();



                if(textView.getText().toString().equals("Academic Block-1")){


                    String times[]=new String []{"9.20 AM","10.10 AM","11.10 AM","12.00 Noon","1.00 PM","1.50PM","2.40PM","3.30PM"};
                    final ArrayList<String> time=new ArrayList<String>();
                    for(int i=0;i<8;i++){
                        time.add(times[i]);
                    }
                    ArrayAdapter listadapter=new ArrayAdapter<>(Amrita_Maps.this,android.R.layout.simple_list_item_1,time);
                    list.setAdapter(listadapter);
                    linearLayout.addView(list);
                }else if(textView.getText().toString().equals("Academic Block-3")){


                    String times[]=new String[] {"9:40 AM","10.30 AM","11.20 AM","12.20 PM","1.10 PM","2.10 PM","3.00 PM","3.50 PM"};

                    final ArrayList<String> time=new ArrayList<String>();
                    for(int i=0;i<8;i++){
                        time.add(times[i]);
                    }
                    ArrayAdapter listadapter=new ArrayAdapter<>(Amrita_Maps.this,android.R.layout.simple_list_item_1,time);
                    list.setAdapter(listadapter);
                    linearLayout.addView(list);
                }else {
                    linearLayout.removeAllViews();
                    TextView t=new TextView(Amrita_Maps.this);
                    t.setText("Buses start only from Academic Block 1 and Academic Block 3. The stops are School of Business and Library(2 stops)");
                    t.setId(1);
                    t.setTextColor(Color.parseColor("#000000"));
                    t.setTypeface(Typeface.create("sans-serif-condensed",Typeface.BOLD));
                    linearLayout.addView(t);
                }
            }
        });

    }



   public  int  maps(String Source,String Dest,int cho){
        Amrita_Maps amrita_Maps = Amrita_Maps.this;
        amrita_Maps.u = 1000;
        amrita_Maps.p = 1000;
        amrita_Maps.cho = cho;
        amrita_Maps.Source = Source;
        amrita_Maps = Amrita_Maps.this;
        amrita_Maps.Dest = Dest;
        addr=0;
        //  amrita_Maps = Amrita_Maps.this;
        //   amrita_Maps.Choice = amrita_Maps.textview2.getSelectedItem().toString();


       if (Objects.equals(Amrita_Maps.this.Source, "Mechanical Workshops")) {
           Amrita_Maps.this.u = 23;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Mechanical Workshops")) {
                    Amrita_Maps.this.p = 23;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Saraswathi Statue")) {
           Amrita_Maps.this.u = 8;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Saraswathi Statue")) {
           Amrita_Maps.this.p = 8;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Temple")) {
           Amrita_Maps.this.u = 30;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Temple")) {
           Amrita_Maps.this.p = 30;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Main Gate")) {
           Amrita_Maps.this.u = 1;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Main Gate")) {
           Amrita_Maps.this.p = 1;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "ATM 1")) {
           Amrita_Maps.this.u = 2;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "ATM 1")) {
           Amrita_Maps.this.p = 2;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Post Office")) {
           Amrita_Maps.this.u = 2;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Post office")) {
           Amrita_Maps.this.p = 2;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Bank")) {
           Amrita_Maps.this.u = 2;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Bank")) {
           Amrita_Maps.this.p = 2;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "ATM 2")) {
           Amrita_Maps.this.u = 58;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "ATM 2")) {
           Amrita_Maps.this.p = 58;
       }

       if (Objects.equals(Amrita_Maps.this.Source, "Academic Block-1")) {
           Amrita_Maps.this.u = 8;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Academic Block-1")) {
           Amrita_Maps.this.p = 8;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "AB-1")) {
           Amrita_Maps.this.u = 8;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "AB-1")) {
           Amrita_Maps.this.p = 8;
       }

       if (Objects.equals(Amrita_Maps.this.Source, "Student Welfare Department"))

           Amrita_Maps.this.u = 8;
       if (Objects.equals(Amrita_Maps.this.Dest, "Student Welfare Department")) {
           Amrita_Maps.this.addr = 15;
           Amrita_Maps.this.p = 8;
       }

       if (Objects.equals(Amrita_Maps.this.Source,"Cyber Security"))
           Amrita_Maps.this.u = 57;
       if (Objects.equals(Amrita_Maps.this.Dest, "Cyber Security")) {
           Amrita_Maps.this.p = 57;

           Amrita_Maps.this.addr = 0;
       }
       if (Objects.equals(Amrita_Maps.this.Source,"Center of Excellence in Networking(CEN)"))
           Amrita_Maps.this.u = 57;
       if (Objects.equals(Amrita_Maps.this.Dest, "Center of Excellence in Networking(CEN)")) {
           Amrita_Maps.this.p = 57;

           Amrita_Maps.this.addr = 0;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Dean Office")) {

           Amrita_Maps.this.u = 8;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Dean Office")) {
           Amrita_Maps.this.p = 8;
           Amrita_Maps.this.addr = 7;
       }


       if (Objects.equals(Amrita_Maps.this.Source, "Admissions")) {

           Amrita_Maps.this.u = 8;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Admissions")) {
           Amrita_Maps.this.p = 8;
           Amrita_Maps.this.addr = 16;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Accounts")) {

           Amrita_Maps.this.u = 8;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Accounts")) {
           Amrita_Maps.this.p = 8;
           Amrita_Maps.this.addr = 17;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "ICTS"))
           Amrita_Maps.this.u = 8;
       if (Objects.equals(Amrita_Maps.this.Dest, "ICTS")) {
           Amrita_Maps.this.p = 8;

           Amrita_Maps.this.addr = 8;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "AB-2")) {
           Amrita_Maps.this.u = 57;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "AB-2")) {
           Amrita_Maps.this.p = 57;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Academic Block-2")) {
           Amrita_Maps.this.u = 57;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Academic Block-2")) {
           Amrita_Maps.this.p = 57;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "AB-3")) {
           Amrita_Maps.this.u = 76;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "AB-3")) {
           Amrita_Maps.this.p = 76;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Academic Block-3")) {
           Amrita_Maps.this.u = 76;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Academic Block-3")) {
           Amrita_Maps.this.p = 76;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Amriteshwari Hall/Sudhamani Hall")) {
           Amrita_Maps.this.u = 9;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Amriteshwari Hall/Sudhamani Hall")) {
           Amrita_Maps.this.p = 9;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Main Canteen")) {
           Amrita_Maps.this.u = 7;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Main Canteen")) {
           Amrita_Maps.this.p = 7;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "MBA Canteen")) {
           Amrita_Maps.this.u = 35;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "MBA Canteen")) {
           Amrita_Maps.this.p = 35;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "IT Canteen")) {
           Amrita_Maps.this.u = 73;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "IT Canteen")) {
           Amrita_Maps.this.p = 73;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Yagnavyalkya Bhavanam")) {
           Amrita_Maps.this.u = 14;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Yagnavyalkya Bhavanam")) {
           Amrita_Maps.this.p = 14;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "YB Annexe")) {
           Amrita_Maps.this.u = 18;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "YB Annexe")) {
           Amrita_Maps.this.p = 18;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Vyasamaharishi Bhavanam")) {
           Amrita_Maps.this.u = 13;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Vyasamaharishi Bhavanam")) {
           Amrita_Maps.this.p = 13;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Nachikethas Bhavanam")) {
           Amrita_Maps.this.u = 14;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Nachikethas Bhavanam")) {
           Amrita_Maps.this.p = 14;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Gargi Bhavanam")) {
           Amrita_Maps.this.u = 49;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Gargi Bhavanam")) {
           Amrita_Maps.this.p = 49;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Mytreyi Bhavanam")) {
           Amrita_Maps.this.u = 27;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Mytreyi Bhavanam")) {
           Amrita_Maps.this.p = 27;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Gautama Bhavanam")) {
           Amrita_Maps.this.u = 66;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Gautama Bhavanam")) {
           Amrita_Maps.this.p = 66;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Vashista Bhavanam")) {
           Amrita_Maps.this.u = 67;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Vashista Bhavanam")) {
           Amrita_Maps.this.p = 67;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Agasthiya Bhavanam")) {
           Amrita_Maps.this.u = 67;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Agasthiya Bhavanam")) {
           Amrita_Maps.this.p = 67;
       }

       if (Objects.equals( Amrita_Maps.this.Source, "Boys Hostel YB(1st year)")) {
           Amrita_Maps.this.u = 14;

       }
       if (Objects.equals( Amrita_Maps.this.Dest, "Boys Hostel YB(1st year)")) {
           Amrita_Maps.this.p = 14;
           Amrita_Maps.this.addr = 0;
       }

       if (Objects.equals( Amrita_Maps.this.Source, "Boys Hostel YB Annexe(1st year)")) {
           Amrita_Maps.this.u = 18;

       }
       if (Objects.equals( Amrita_Maps.this.Dest, "Boys Hostel YB Annexe(1st year)")) {
           Amrita_Maps.this.p = 18;
           Amrita_Maps.this.addr = 0;
       }

       if (Objects.equals( Amrita_Maps.this.Source, "Boys Hostel(4th year)")) {
           Amrita_Maps.this.u = 14;

       }
       if (Objects.equals( Amrita_Maps.this.Dest, "Boys Hostel(4th year)")) {
           Amrita_Maps.this. p = 14;
           Amrita_Maps.this.addr = 0;
       }

       if (Objects.equals( Amrita_Maps.this.Source, "Girls Hostel(1st year)")) {
           Amrita_Maps.this.u = 27;

       }
       if (Objects.equals( Amrita_Maps.this.Dest, "Girls Hostel(1st year)")) {
           Amrita_Maps.this.p = 27;
           Amrita_Maps.this.addr = 0;
       }

       if (Objects.equals( Amrita_Maps.this.Source, "Boys Hostel(3rd year)")) {
           Amrita_Maps.this.u = 67;

       }
       if (Objects.equals( Amrita_Maps.this.Dest, "Boys Hostel(3rd year)")) {
           Amrita_Maps.this.p = 67;
           Amrita_Maps.this.addr = 0;
       }

       if (Objects.equals( Amrita_Maps.this.Source, "Boys Hostel(2nd year)")) {
           Amrita_Maps.this.u = 67;

       }
       if (Objects.equals( Amrita_Maps.this.Dest, "Boys Hostel(2nd year)")) {
           Amrita_Maps.this.p = 67;
           Amrita_Maps.this.addr = 0;
       }

       if (Objects.equals(Amrita_Maps.this.Source, "Guest House")) {
           Amrita_Maps.this.u = 55;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Guest House")) {
           Amrita_Maps.this.p = 55;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "CIR Block")) {
           Amrita_Maps.this.u = 38;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "CIR Block")) {
           Amrita_Maps.this.p = 38;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Amrita School of Business")) {
           Amrita_Maps.this.u = 40;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Amrita School of Business")) {
           Amrita_Maps.this.p = 40;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "New Auditorium")) {
           Amrita_Maps.this.u = 40;

       }
       if (Objects.equals(Amrita_Maps.this.Dest, "New Auditorium")) {
           Amrita_Maps.this.p = 40;
           Amrita_Maps.this.addr = 0;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Pandal")) {
           Amrita_Maps.this.u = 40;

       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Pandal")) {
           Amrita_Maps.this.p = 40;
           Amrita_Maps.this.addr = 0;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Library")) {
           Amrita_Maps.this.u = 71;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Library")) {
           Amrita_Maps.this.p = 71;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Swimming Pool")) {
           Amrita_Maps.this.u = 83;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Swimming Pool")) {
           Amrita_Maps.this.p = 83;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Main Ground")) {
           Amrita_Maps.this.u = 87;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Main Ground")) {
           Amrita_Maps.this.p = 87;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "D-Ground")) {
           Amrita_Maps.this.u = 32;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "D-Ground")) {
           Amrita_Maps.this.p = 32;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Gym")) {
           Amrita_Maps.this.u = 21;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Gym")) {
           Amrita_Maps.this.p = 21;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "General Stores")) {
           Amrita_Maps.this.u = 28;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "General Stores")) {
           Amrita_Maps.this.p = 28;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Clinic")) {
           Amrita_Maps.this.u = 28;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Clinic")) {
           Amrita_Maps.this.p = 28;
           Amrita_Maps.this.addr = 0;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Hospital")) {
           Amrita_Maps.this.u = 28;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Hospital")) {
           Amrita_Maps.this.p = 28;
           Amrita_Maps.this.addr = 0;
       }

       if (Objects.equals(Amrita_Maps.this.Source, "Provision Stores")) {
           Amrita_Maps.this.u = 28;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Provision Stores")) {
           Amrita_Maps.this.p = 28;
           Amrita_Maps.this.addr = 0;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Cloth Shop")) {
           Amrita_Maps.this.u = 28;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Cloth Shop")) {
           Amrita_Maps.this.p = 28;
           Amrita_Maps.this.addr = 0;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Travel Desk")) {
           Amrita_Maps.this.u = 28;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Travel Desk")) {
           Amrita_Maps.this.p = 28;
           Amrita_Maps.this.addr = 0;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Mobile Recharge")) {
           Amrita_Maps.this.u = 28;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Mobile Recharge")) {
           Amrita_Maps.this.p = 28;
           Amrita_Maps.this.addr = 0;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Hair Dressing-Boys")) {
           Amrita_Maps.this.u = 28;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Hair Dressing-Boys")) {
           Amrita_Maps.this.p = 28;
           Amrita_Maps.this.addr = 0;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Beauty Parlour-Boys/Girls")) {
           Amrita_Maps.this.u = 28;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Beauty Parlour-Boys/Girls")) {
           Amrita_Maps.this. p = 28;
           Amrita_Maps.this.addr = 0;
       }

       if (Objects.equals(Amrita_Maps.this.Source, "Amrita Darshanam Centre"))

           Amrita_Maps.this.u = 88;
       if (Objects.equals(Amrita_Maps.this.Dest, "Amrita Darshanam Centre")) {
           Amrita_Maps.this.addr = 0;
           Amrita_Maps.this.p = 88;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Aerospace Department"))

           Amrita_Maps.this.u = 8;
       if (Objects.equals(Amrita_Maps.this.Dest, "Aerospace Department")) {
           Amrita_Maps.this.addr = 1;
           Amrita_Maps.this.p = 8;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Civil Department"))
           Amrita_Maps.this.u = 8;
       if (Objects.equals(Dest, "Civil Department")) {
           Amrita_Maps.this.addr = 2;
           Amrita_Maps.this.p = 8;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Mechanical Department"))
           Amrita_Maps.this.u = 8;
       if (Objects.equals(Amrita_Maps.this.Dest, "Mechanical Department")) {
           Amrita_Maps.this.addr = 3;
           Amrita_Maps.this.p = 8;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Mathematics Department"))
           Amrita_Maps.this.u = 8;
       if (Objects.equals(Amrita_Maps.this.Dest, "Mathematics Department")) {
           Amrita_Maps.this.addr = 4;
           Amrita_Maps.this.p = 8;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Science Department"))
           Amrita_Maps.this.u = 8;
       if (Objects.equals(Amrita_Maps.this.Dest, "Science Department")) {
           Amrita_Maps.this.addr = 5;
           Amrita_Maps.this.p = 8;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "English Department"))
           u = 8;
       if (Objects.equals(Amrita_Maps.this.Dest, "English Department")) {
           Amrita_Maps.this.addr = 6;
           Amrita_Maps.this.p = 8;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Chemical and Material Science Department")) {
           Amrita_Maps.this.u = 57;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Chemical and Material Science Department")) {
           Amrita_Maps.this.addr = 9;
           Amrita_Maps.this.p = 57;
       }

       if (Objects.equals(Amrita_Maps.this.Source, "Electronics And Communication Department")) {
           Amrita_Maps.this.u = 57;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Electronics And Communication Department")) {
           Amrita_Maps.this.addr = 10;
           Amrita_Maps.this.p = 57;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Electrical And Electronics Department")) {
           Amrita_Maps.this.u = 57;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Electrical And Electronics Department")) {
           Amrita_Maps.this.addr = 11;
           Amrita_Maps.this.p = 57;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Social Work Department")) {
           Amrita_Maps.this.u = 57;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Social Work Department")) {
           Amrita_Maps.this.addr = 12;
           Amrita_Maps.this.p = 57;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Computer Science Department")) {

           Amrita_Maps.this.u = 76;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Computer Science Department")) {
           Amrita_Maps.this.addr = 13;
           Amrita_Maps.this.p = 76;
       }
       if (Objects.equals(Amrita_Maps.this.Source, "Communication Department")) {

           Amrita_Maps.this.u = 76;
       }
       if (Objects.equals(Amrita_Maps.this.Dest, "Communication Department")) {
           Amrita_Maps.this.addr = 14;
           Amrita_Maps.this.p = 76;
       }

       if (Objects.equals(Amrita_Maps.this.Source, "Student Welfare Department"))

           Amrita_Maps.this.u = 8;
       if (Objects.equals(Amrita_Maps.this.Dest, "Student Welfare Department")) {
           Amrita_Maps.this.addr = 15;
           Amrita_Maps.this.p = 8;
       }

       if (Objects.equals(Amrita_Maps.this.Source,"Cyber Security"))
           Amrita_Maps.this.u = 57;
       if (Objects.equals(Amrita_Maps.this.Dest, "Cyber Security")) {
           Amrita_Maps.this.p = 57;

           Amrita_Maps.this.addr = 0;
       }
       if (Objects.equals(Amrita_Maps.this.Source,"Center of Excellence in Networking(CEN)"))
           Amrita_Maps.this.u = 57;
       if (Objects.equals(Amrita_Maps.this.Dest, "Center of Excellence in Networking(CEN)")) {
           Amrita_Maps.this.p = 57;

           Amrita_Maps.this.addr = 0;
       }

       if((u!=1000)&&(p!=1000)){
                if (u == 73 || p== 73) {

                    if (cho == 1) {
                        Toast.makeText(amrita_Maps.getApplicationContext(), "IT canteen cannot be accessed with cycle.", 1).show();
                        Amrita_Maps.this.textView.getText();
                    }
                }

                if (u == 30 || p == 30) {
                    amrita_Maps = Amrita_Maps.this;
                    if (cho == 1) {
                        Toast.makeText(amrita_Maps.getApplicationContext(), "Temple cannot be accessed with cycle.", 1).show();
                        Amrita_Maps.this.textView.getText();
                    }
                }

                linearLayout.removeAllViews();
               ShortestPath sp = new ShortestPath();
           Log.i("ucpc",Integer.toString(u));
           Log.i("pc",Integer.toString(p));
           Log.i("commute",Integer.toString(cho));
                float path[] = sp.main1(u,p,cho);
                DrawView drawView = new DrawView(Amrita_Maps.this, path);
                linearLayout.addView(drawView);

                Amrita_Maps.this.textView.getText();
            }
        else{
        Toast.makeText(Amrita_Maps.this.getApplicationContext(), "Enter valid places.", 1).show();
        Amrita_Maps.this.textView.getText();
       }
       return this.addr;
    }


    public void setText(int addr){

        switch (addr) {
            case (0):
                address = " ";
                message.setText(address);
                break;
            case (1):
                address = "Aerospace Engineering Department(Academic Block-1/Third Floor)";
                message.setText(address);
                break;
            case (2):
                address = "Civil Engineering Department(Academic Block-1/Second Floor)";
                message.setText(address);
                break;
            case (3):
                address = "Mechanical Engineering Department(Academic Block-1/Second Floor)";
                message.setText(address);
                break;
            case (4):
                address = "Mathematics Department(Academic Block-1/Ground Floor)";
                message.setText(address);
                break;
            case (5):
                address = "Science Department(Academic Block-1/Third Floor)";
                message.setText(address);
                break;
            case (6):
                address = "English Department(Academic Block-1/Third Floor)";
                message.setText(address);
                break;
            case (7):
                address = "Deans office is in First Floor(Academic Block-1)";
                message.setText(address);
                //Log.i("addr", "Deans office");
                break;
            case (8):
                address = "ICTS office is in Second Floor(Academic Block-1)";
                message.setText(address);
                break;
            case (9):
                address = "Chemical and Material Science Department(Academic Block-2/Third Floor)";
                message.setText(address);
                break;
            case (10):
                address = "Electronics And Communication Department(Academic Block-2/Second Floor)";
                message.setText(address);
                break;
            case (11):
                address = "Electrical And Electronics Department(Academic Block-2/First Floor)";
                message.setText(address);
                break;
            case (12):
                address = "Social Work Department(Academic Block-2/Third Floor)";
                message.setText(address);
                break;
            case (13):
                address = "Computer Science Department(Academic Block-3/First Floor)";
                message.setText(address);
                break;
            case (14):
                address = "Communication Department(Academic Block-3/Third Floor)";
                message.setText(address);
                break;
            case (15):
                address = "Student Welfare Department is in Ground Floor(Academic Block-1)";
                message.setText(address);
                break;
            case (16):
                address = "Admissions office is in Academic Block-1(First Floor)";
                message.setText(address);
                break;
            case (17):
                address = "Accounts office is in Academic Block-1(First Floor)";
                message.setText(address);
                break;
            default:
                address1 = "default ";

                message.setText(address1);
                break;

        }
    }





    public void onNothingSelected(AdapterView<?> adapterView) {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }


    /* Access modifiers changed, original: protected */
    public void onResume() {
        super.onResume();
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        super.onDestroy();
    }
}
