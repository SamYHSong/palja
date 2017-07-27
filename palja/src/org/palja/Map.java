package org.palja;

import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;

public class Map extends MapActivity {
 MapView mapView;
 MapController controller;
 MyLocInfo myLoc;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
        mapView=(MapView)findViewById(R.id.mapView);
        controller=mapView.getController();
        double lati=37.49386;
        double logi=127.143617;
        GeoPoint gp=new GeoPoint((int)(lati*1000000),
          (int)(logi*1000000));
        controller.setZoom(15);
        controller.setCenter(gp);
        mapView.setBuiltInZoomControls(true);
        
        myLoc=new MyLocInfo(this, mapView);
        
        /////오버레이 (위치찾고 표시해주는 겹치게 되는역할)//////
        List<Overlay> list=mapView.getOverlays();
        list.add(myLoc);
        /////////////////////////////////////////////
                
        //처음 위치가 조사될때 실행할 Runnable객체 등록
        myLoc.runOnFirstFix(new Runnable() {   
   @Override
   public void run() {
    GeoPoint pt=myLoc.getMyLocation();
    //맵뷰를 현재 위치로 이동
    controller.animateTo(pt);
   }
  });
    }
    //액티비티가 화면에 보여질대 MyLocation기능을 켠다.
    @Override
    protected void onResume() {
     super.onResume();
     myLoc.enableMyLocation();//내위치찾는기능켜기
     myLoc.enableCompass();//나침판기능켜기-애뮬레이터에서는 안보여요.
    }
    //액티비티가 화면에 사라질때(종료되기 직전)MyLocation기능을 끈다.
    @Override
    protected void onPause() {
     super.onPause();
     myLoc.disableMyLocation();//위치찾기기능 끄기
     myLoc.disableCompass();//나침판기능끄기
    }
  
 @Override
 protected boolean isRouteDisplayed() {
  return false;
 }
 //내 위치를 찾아 표시해주는 클래스(MyLocationOverlay를 상속받아 만듬)
 class MyLocInfo extends MyLocationOverlay{
  public MyLocInfo(Context context, MapView mapView){
   super(context, mapView);
  }
  //탭했을때 자동으로 호출
  @Override
  protected boolean dispatchTap() {
   Toast.makeText(Map.this, 
     "현재나의위치", 0).show();
   return true;
  }
 }
}