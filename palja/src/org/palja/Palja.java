package org.palja;

import android.app.Activity;
import android.content.Intent; // 인텐트 사용 위해 import합니다.
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
		Intent intent = new Intent(Palja.this, Apt.class); // 두번째 액티비티를 실행하기 위한 인텐트
		startActivity(intent); // 두번째 액티비티를 실행합니다.
			} 
       	        });
                Button launch1 = (Button)findViewById(R.id.button1);
        launch1.setOnClickListener(new Button.OnClickListener(){
    public void onClick(View v) {
	    // TODO Auto-generated method stub
	    Intent intent = new Intent(Palja.this, Map.class); // 세번째 액티비티를 실행하기 위한 인텐트
	    startActivity(intent); // 세번째 액티비티를 실행합니다.
		} 
   	        });
        Button launch2 = (Button)findViewById(R.id.button2);
        launch2.setOnClickListener(new Button.OnClickListener(){
    public void onClick(View v) {
	    // TODO Auto-generated method stub
	    Intent intent = new Intent(Palja.this, Apt.class); // 세번째 액티비티를 실행하기 위한 인텐트
	    startActivity(intent); // 세번째 액티비티를 실행합니다.
	} 
	        });
    }
}