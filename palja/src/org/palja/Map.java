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
        
        /////�������� (��ġã�� ǥ�����ִ� ��ġ�� �Ǵ¿���)//////
        List<Overlay> list=mapView.getOverlays();
        list.add(myLoc);
        /////////////////////////////////////////////
                
        //ó�� ��ġ�� ����ɶ� ������ Runnable��ü ���
        myLoc.runOnFirstFix(new Runnable() {   
   @Override
   public void run() {
    GeoPoint pt=myLoc.getMyLocation();
    //�ʺ並 ���� ��ġ�� �̵�
    controller.animateTo(pt);
   }
  });
    }
    //��Ƽ��Ƽ�� ȭ�鿡 �������� MyLocation����� �Ҵ�.
    @Override
    protected void onResume() {
     super.onResume();
     myLoc.enableMyLocation();//����ġã�±���ѱ�
     myLoc.enableCompass();//��ħ�Ǳ���ѱ�-�ֹķ����Ϳ����� �Ⱥ�����.
    }
    //��Ƽ��Ƽ�� ȭ�鿡 �������(����Ǳ� ����)MyLocation����� ����.
    @Override
    protected void onPause() {
     super.onPause();
     myLoc.disableMyLocation();//��ġã���� ����
     myLoc.disableCompass();//��ħ�Ǳ�ɲ���
    }
  
 @Override
 protected boolean isRouteDisplayed() {
  return false;
 }
 //�� ��ġ�� ã�� ǥ�����ִ� Ŭ����(MyLocationOverlay�� ��ӹ޾� ����)
 class MyLocInfo extends MyLocationOverlay{
  public MyLocInfo(Context context, MapView mapView){
   super(context, mapView);
  }
  //�������� �ڵ����� ȣ��
  @Override
  protected boolean dispatchTap() {
   Toast.makeText(Map.this, 
     "���糪����ġ", 0).show();
   return true;
  }
 }
}