package org.palja;

import android.app.Activity;
import android.content.Intent; // ����Ʈ ��� ���� import�մϴ�.
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Palja extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
                Button launch = (Button)findViewById(R.id.launchActivity);
        launch.setOnClickListener(new Button.OnClickListener(){
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(Palja.this, Apt.class); // �ι�° ��Ƽ��Ƽ�� �����ϱ� ���� ����Ʈ
		startActivity(intent); // �ι�° ��Ƽ��Ƽ�� �����մϴ�.
			} 
       	        });
                Button launch1 = (Button)findViewById(R.id.button1);
        launch1.setOnClickListener(new Button.OnClickListener(){
    public void onClick(View v) {
	    // TODO Auto-generated method stub
	    Intent intent = new Intent(Palja.this, Map.class); // ����° ��Ƽ��Ƽ�� �����ϱ� ���� ����Ʈ
	    startActivity(intent); // ����° ��Ƽ��Ƽ�� �����մϴ�.
		} 
   	        });
        Button launch2 = (Button)findViewById(R.id.button2);
        launch2.setOnClickListener(new Button.OnClickListener(){
    public void onClick(View v) {
	    // TODO Auto-generated method stub
	    Intent intent = new Intent(Palja.this, Apt.class); // ����° ��Ƽ��Ƽ�� �����ϱ� ���� ����Ʈ
	    startActivity(intent); // ����° ��Ƽ��Ƽ�� �����մϴ�.
	} 
	        });
    }
}