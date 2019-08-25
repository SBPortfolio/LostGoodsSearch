package com.example.lostgoodssearch.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lostgoodssearch.GoodsDetailActivity;
import com.example.lostgoodssearch.R;
import com.example.lostgoodssearch.model.LostGoodsItems;
import com.example.lostgoodssearch.model.Utils;

import java.util.List;

public class LostGoodsAdapter extends BaseAdapter {
    private Context context;
    private List<LostGoodsItems> list;
    private String atcId = "";

    public LostGoodsAdapter(Context context, List<LostGoodsItems> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        //view 홀더
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_lost_goods_layout, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder)convertView.getTag();
        }

        LostGoodsItems vo = list.get(position);
        atcId = vo.getAtcId();
        String IstPlace = vo.getLstPlace();
        String lstPrdtNm = vo.getPrdtClNm();
        String lstSbjt = vo.getLstSbjt();
        String lstYmd = vo.getLstYmd();
        String prdtClNm = vo.getPrdtClNm();
        int rnum = vo.getRnum();

        vh.tv_atcId.setText(atcId);
        vh.tv_lstPlace.setText(IstPlace);
        vh.tv_lstPrdtNm.setText(lstPrdtNm);
        vh.tv_lstSbjt.setText(lstSbjt);
        vh.tv_lstYmd.setText(lstYmd);
        vh.tv_prdtClNm.setText(prdtClNm);
        //int -> String으로 바꿔주기
        vh.tv_rnum.setText(Integer.toString(rnum));

        vh.ll_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GoodsDetailActivity.class);
                intent.putExtra(Utils.ATC_ID, atcId);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    class ViewHolder {
        LinearLayout ll_container;
        TextView tv_atcId, tv_lstPlace,tv_lstPrdtNm,tv_lstSbjt,tv_lstYmd,tv_prdtClNm,tv_rnum;

        ViewHolder(View v){
            ll_container = v.findViewById(R.id.ll_container);

            tv_atcId = v.findViewById(R.id.tv_atcId);
            tv_lstPlace = v.findViewById(R.id.tv_lstPlace);
            tv_lstPrdtNm = v.findViewById(R.id.tv_lstPrdtNm);
            tv_lstSbjt = v.findViewById(R.id.tv_lstSbjt);
            tv_lstYmd = v.findViewById(R.id.tv_lstYmd);
            tv_prdtClNm = v.findViewById(R.id.tv_prdtClNm);
            tv_rnum = v.findViewById(R.id.tv_rnum);
        }
    }
}
