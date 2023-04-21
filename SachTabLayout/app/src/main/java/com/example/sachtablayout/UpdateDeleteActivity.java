package com.example.sachtablayout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.sachtablayout.dal.SQLiteHelper;
import com.example.sachtablayout.model.Item;

import java.util.Calendar;

public class UpdateDeleteActivity extends AppCompatActivity implements View.OnClickListener{

    public Spinner sp;
    private EditText eTitle, ePrice, eDate, eAuthor;
    private Button btUpdate, btBack, btRemove;
    private Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);
        initView();
        btBack.setOnClickListener(this);
        btUpdate.setOnClickListener(this);
        btRemove.setOnClickListener(this);
        eDate.setOnClickListener(this);
        Intent intent= getIntent();
        item= (Item) intent.getSerializableExtra("item");
        eTitle.setText(item.getTitle());
        eAuthor.setText(item.getAuthor());
        ePrice.setText(item.getPrice());
        eDate.setText(item.getDate());
        int p=0;
        for(int i=0;i<sp.getCount();i++){
            if(sp.getItemAtPosition(i).toString().equalsIgnoreCase(item.getCategory())){
                p=i;
                break;

            }
        }
        sp.setSelection(p);

    }
    private void initView() {
        sp= findViewById(R.id.spCategory);
        eTitle= findViewById(R.id.tvTitle);
        eAuthor= findViewById(R.id.tvAuthor);
        ePrice= findViewById(R.id.tvPrice);
        eDate= findViewById(R.id.tvDate);
        btUpdate= findViewById(R.id.btUpdate);
        btBack= findViewById(R.id.btBack);
        btRemove= findViewById(R.id.btRemove);
        sp.setAdapter(new ArrayAdapter<String>(this,
                R.layout.item_spinner, getResources().getStringArray(R.array.NXB)));
    }

    @Override
    public void onClick(View view) {
        SQLiteHelper db = new SQLiteHelper(this);
        if(view==eDate){
            final Calendar c= Calendar.getInstance();
            int year= c.get(Calendar.YEAR);
            int month= c.get(Calendar.MONTH);
            int day= c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog= new DatePickerDialog(UpdateDeleteActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                    String date="";
                    if(m>8){
                        date= d+"/"+(m+1)+"/"+y;
                    }else {
                        date= d+"/0"+(m+1)+"/"+y;
                    }
                    eDate.setText(date);

                }
            }, year, month, day);
            dialog.show();
        }
        if(view==btBack){
            finish();
        }
        if(view==btUpdate){
            String t= eTitle.getText().toString();
            String a= eAuthor.getText().toString();
            int p= Integer.parseInt((ePrice.getText().toString()));
            String c= sp.getSelectedItem().toString();
            String d= eDate.getText().toString();
            if(!t.isEmpty() && p!=0){
                int id= item.getId();
                Item i =new Item(id,t,a,c,p,d);
                db= new SQLiteHelper(this );
                db.update(i);
                finish();
            }
        }
        if(view==btRemove){
            int id= item.getId();
            AlertDialog.Builder builder= new AlertDialog.Builder(view.getContext());
            builder.setTitle("Thong bao xoa");
            builder.setMessage("Ban co cha muon xoa "+item.getTitle()+" khong?");
            builder.setIcon(R.drawable.remove);
            builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    SQLiteHelper bb = new SQLiteHelper(getApplicationContext());
                    bb.delete(id);
                    finish();
                }
            });
            builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog dialog= builder.create();
            dialog.show();
        }
    }
}