package com.example.lostgoodssearch.retrofit;

import com.example.lostgoodssearch.model.GoodsDetailResponse;
import com.example.lostgoodssearch.model.LocationResponse;
import com.example.lostgoodssearch.model.LostGoodsResponse;
import com.example.lostgoodssearch.model.Utils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("LostGoodsInfoInqireService/getLostGoodsInfoAccToClAreaPd")
    Call<LostGoodsResponse> getLostGoodsList(
            @Query("serviceKey") String serviceKey,
            @Query("start_ymd") String start_ymd,
            @Query("end_ymd") String end_ymd,
            @Query("PRDT_CL_CD_01") String prdt_cl_cd_01,
            @Query("PRDT_CL_CD_02") String Prdt_cl_cd_02,
            @Query("LST_LCT_CD") String lst_lct_cd,
            @Query("pageNo") int pageNo,
            @Query("numOfRows") int numOfRows);

    @GET("CmmnCdService/getCmmnCd")
    Call<LocationResponse> getLocationList(@Query("serviceKey")String serviceKey, @Query(Utils.GRP_NM) String grp_nm);

    @GET("LostGoodsInfoInqireService/getLostGoodsDetailInfo")
    Call<GoodsDetailResponse> getGoodsDetail(@Query("serviceKey")String serviceKey, @Query(Utils.ATC_ID) String act_id);
}
