package com.e.jihcpracticelesson5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView androidPhone, iOsPhone;
    RadioButton bank_radiobutton, kolmakol_radiobutton;
    CheckBox indraiverDostavka_checkbox, yandexDostavka_checkbox, zhekeDostavka_checkbox;
    Button zhiberuBtn;

    String tolemTuri, zhetkizuTuri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidPhone = findViewById(R.id.androidPhone);
        iOsPhone = findViewById(R.id.iOsPhone);

        bank_radiobutton = findViewById(R.id.bank_radiobutton);
        kolmakol_radiobutton = findViewById(R.id.kolmakol_radiobutton);

        indraiverDostavka_checkbox = findViewById(R.id.indraiverDostavka_checkbox);
        yandexDostavka_checkbox = findViewById(R.id.yandexDostavka_checkbox);
        zhekeDostavka_checkbox = findViewById(R.id.zhekeDostavka_checkbox);

        zhiberuBtn = findViewById(R.id.zhiberuBtn);

        registerForContextMenu(androidPhone);
        registerForContextMenu(iOsPhone);

        zhiberuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bank_radiobutton.isChecked()){
                    tolemTuri = "Банк карточкасы аркылы";
                }else if (kolmakol_radiobutton.isChecked()){
                    tolemTuri = "Қолма қол ақша аркылы";
                }

                if(indraiverDostavka_checkbox.isChecked()){
                    zhetkizuTuri = "Индрайвер такси аркылы";
                }
                if (yandexDostavka_checkbox.isChecked()){
                    zhetkizuTuri = "Яндекс такси аркылы";
                }
                if (zhekeDostavka_checkbox.isChecked()){
                    zhetkizuTuri = "Доставка емес, клиент өзі алып кетеді";
                }

                String result ="Android:" + androidPhone.getText()+"\n"+
                               "iOs:" + iOsPhone.getText()+"\n"+
                                "Төлем түрі:" + tolemTuri+"\n"+
                                "Жеткізу түрі:" + zhetkizuTuri;

                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        if(v == androidPhone) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.androidmenu, menu);
        }else if(v == iOsPhone){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.iosmenu, menu);
        }

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.oppo:
                androidPhone.setText("Oppo");
                break;
            case R.id.samsung:
                androidPhone.setText("Samsung");
                break;
            case R.id.huawei:
                androidPhone.setText("Huawei");
                break;
            case R.id.lg:
                androidPhone.setText("LG");
                break;

            case R.id.iPhone_12_promax:
                iOsPhone.setText("iPhone 12 Pro Max");
                break;
            case R.id.iPhone_12_mini:
                iOsPhone.setText("iPhone 12 mini");
                break;
            case R.id.iPhone_X:
                iOsPhone.setText("iPhone X");
                break;
            case R.id.iPhone_8plus:
                iOsPhone.setText("iPhone 8 plus");
                break;
            case R.id.iPhone_7:
                iOsPhone.setText("iPhone 7");
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings_menu:
                Toast.makeText(this, "Settings menu clicked", Toast.LENGTH_LONG).show();
                break;
            case R.id.exit_menu:
                Toast.makeText(this, "Exit menu clicked", Toast.LENGTH_LONG).show();
                break;
            case R.id.delete_menu:
                Toast.makeText(this, "Delete menu clicked", Toast.LENGTH_LONG).show();
                break;
            case R.id.update_menu:
                Toast.makeText(this, "Update menu clicked", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}