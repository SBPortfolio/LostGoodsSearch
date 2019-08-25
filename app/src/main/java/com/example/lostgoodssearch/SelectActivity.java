package com.example.lostgoodssearch;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.lostgoodssearch.model.LocationItems;
import com.example.lostgoodssearch.model.LocationResponse;
import com.example.lostgoodssearch.model.Utils;
import com.example.lostgoodssearch.retrofit.RetrofitClient;
import com.example.lostgoodssearch.retrofit.RetrofitService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectActivity extends AppCompatActivity {
    Spinner spinnerLocation;
    String loadsearchkeyID;
    EditText startDate;
    EditText endDate;
    Calendar myCalendar = Calendar.getInstance();
    String myFormat = "yyyyMMdd";
    SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
    String cmmCd;
    String start_ymd = "20190816";
    String end_ymd = "20190816";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        spinnerLocation = (Spinner) findViewById(R.id.spinnerLocation);
        startDate = (EditText) findViewById(R.id.startDate);
        endDate = (EditText) findViewById(R.id.endDate);

        RetrofitService retrofitService = RetrofitClient.getRetroService();
        Call<LocationResponse> call = retrofitService.getLocationList(Utils.SERVICE_KEY, Utils.CD_VALUE);
        call.enqueue(new Callback<LocationResponse>() {
            @Override
            public void onResponse(Call<LocationResponse> call, Response<LocationResponse> response) {
                Log.d("callback", "success");
                List<LocationItems> items = response.body().getBody().getItems();
                List<LocationItems> locationItemsList = new ArrayList<>();
                for (LocationItems vo : items) {
                    String cd = vo.getCommCd();
                    if (cd.length() >= 6 && cd.substring((cd.length() - 3), cd.length()).equals("000")) {
                        locationItemsList.add(vo);
                    }
                }
                ArrayAdapter<LocationItems> arrayAdapter = new ArrayAdapter<LocationItems>(SelectActivity.this, R.layout.support_simple_spinner_dropdown_item, locationItemsList);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerLocation.setAdapter(arrayAdapter);
                spinnerLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        LocationItems locationItems = (LocationItems) parent.getItemAtPosition(position);
                        loadsearchkeyID = (String) locationItems.getCdNm();
                        cmmCd = locationItems.getCommCd();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

            @Override
            public void onFailure(Call<LocationResponse> call, Throwable t) {
                Log.d("callback", "fail : " + t.toString());
            }
        });



        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(startDate.getWindowToken(), 0);
                startDate.setText(sdf.format(myCalendar.getTime()));
                start_ymd = sdf.format(myCalendar.getTime());
            }

        };

        final DatePickerDialog.OnDateSetListener endDialog = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(endDate.getWindowToken(), 0);
                endDate.setText(sdf.format(myCalendar.getTime()));
                end_ymd = sdf.format(myCalendar.getTime());
            }

        };

        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(SelectActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(SelectActivity.this, endDialog, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    public void searchClk(View view) {
        Intent intent = new Intent(SelectActivity.this, LostGoodsActivity.class);
        intent.putExtra("cd", cmmCd);
        intent.putExtra("startDay", start_ymd);
        intent.putExtra("endDay", end_ymd);
        startActivity(intent);
    }
}
