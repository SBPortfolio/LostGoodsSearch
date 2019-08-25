package com.example.lostgoodssearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lostgoodssearch.model.GoodsDetailItems;
import com.example.lostgoodssearch.model.GoodsDetailResponse;
import com.example.lostgoodssearch.model.Utils;
import com.example.lostgoodssearch.retrofit.RetrofitClient;
import com.example.lostgoodssearch.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GoodsDetailActivity extends AppCompatActivity {
    private ImageView iv_pic;
    private TextView atcId;
    private TextView lstHor;
    private TextView lstLctNm;
    private TextView lstPlace;
    private TextView lstPlaceSeNm;
    private TextView lstPrdtNm;
    private TextView lstSbjt;
    private TextView lstSteNm;
    private TextView lstYmd;
    private TextView orgId;
    private TextView orgNm;
    private TextView prdtClNm;
    private TextView tel;
    private TextView uniq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);

        iv_pic = findViewById(R.id.iv_pic);
        atcId = findViewById(R.id.atcId);
        lstHor = findViewById(R.id.lstHor);
        lstLctNm = findViewById(R.id.lstLctNm);
        lstPlace = findViewById(R.id.lstPlace);
        lstPlaceSeNm = findViewById(R.id.lstPlaceSeNm);
        lstPrdtNm = findViewById(R.id.lstPrdtNm);
        lstSbjt = findViewById(R.id.lstSbjt);
        lstSteNm = findViewById(R.id.lstSteNm);
        lstYmd = findViewById(R.id.lstYmd);
        orgId = findViewById(R.id.orgId);
        orgNm = findViewById(R.id.orgNm);
        prdtClNm = findViewById(R.id.prdtClNm);
        tel = findViewById(R.id.tel);
        uniq = findViewById(R.id.uniq);


        Intent intent = getIntent();
        String atc_id = intent.getStringExtra(Utils.ATC_ID);
        Log.d("atc_id", "atc_id : " + atc_id);

        RetrofitService rs = RetrofitClient.getRetroService();
        Call<GoodsDetailResponse> call = rs.getGoodsDetail(Utils.SERVICE_KEY, atc_id);
        call.enqueue(new Callback<GoodsDetailResponse>() {
            @Override
            public void onResponse(Call<GoodsDetailResponse> call, Response<GoodsDetailResponse> response) {
                if(response.isSuccessful()){
                    GoodsDetailItems items = response.body().getBody().getItems();
                    String imageURL = items.getLstFilePathImg();
                    Glide.with(GoodsDetailActivity.this).load(imageURL).into(iv_pic);

                    atcId.setText(items.getAtcId());
                    lstHor.setText(items.getLstHor());
                    lstLctNm.setText(items.getLstLctNm());
                    lstPlace.setText(items.getLstPlace());
                    lstPlaceSeNm.setText(items.getLstPlaceSeNm());
                    lstPrdtNm.setText(items.getLstPrdtNm());
                    lstSbjt.setText(items.getLstSbjt());
                    lstSteNm.setText(items.getLstSteNm());
                    lstYmd.setText(items.getLstYmd());
                    orgId.setText(items.getOrgId());
                    orgNm.setText(items.getOrgNm());
                    prdtClNm.setText(items.getPrdtClNm());
                    tel.setText(items.getTel());
                    uniq.setText(items.getUniq());
                }
            }

            @Override
            public void onFailure(Call<GoodsDetailResponse> call, Throwable t) {
                Log.d("callback", "fail : " + t.toString());
            }
        });
    }
}
