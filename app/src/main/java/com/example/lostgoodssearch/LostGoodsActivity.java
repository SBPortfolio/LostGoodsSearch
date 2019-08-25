package com.example.lostgoodssearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.lostgoodssearch.adapter.LostGoodsAdapter;
import com.example.lostgoodssearch.model.LostGoodsItems;
import com.example.lostgoodssearch.model.LostGoodsResponse;
import com.example.lostgoodssearch.model.Utils;
import com.example.lostgoodssearch.retrofit.RetrofitClient;
import com.example.lostgoodssearch.retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LostGoodsActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_goods);

        Intent intent = getIntent();
        String start_ymd = intent.getStringExtra("start_ymd");
        String end_ymd = intent.getStringExtra("end_ymd");
        String PRDT_CL_CD_01 = "PRA000";
        String PRDT_CL_CD_02 = "PRA300";
        String LST_LCT_CD = intent.getStringExtra("LST_LCT_CD");
        listView = (ListView)findViewById(R.id.lostGoodsListView);

        RetrofitService rs = RetrofitClient.getRetroService();
        Call<LostGoodsResponse> call = rs.getLostGoodsList(Utils.SERVICE_KEY, start_ymd, end_ymd, PRDT_CL_CD_01, PRDT_CL_CD_02, LST_LCT_CD, 1, 10);
        call.enqueue(new Callback<LostGoodsResponse>() {
            @Override
            public void onResponse(Call<LostGoodsResponse> call, Response<LostGoodsResponse> response) {
                Log.d("callback", "success");
                if(response.isSuccessful()){
                    List<LostGoodsItems> list = response.body().getBody().getItems();
                    LostGoodsAdapter lostGoodsAdapter = new LostGoodsAdapter(LostGoodsActivity.this, list);
                    listView.setAdapter(lostGoodsAdapter);
                }
            }

            @Override
            public void onFailure(Call<LostGoodsResponse> call, Throwable t) {
                Log.d("callback", "fail : " + t.toString());
            }
        });
    }
}
