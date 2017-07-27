package org.palja;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Apt extends Activity {
WebView mWebView;
 
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
                
        mWebView = (WebView) findViewById(R.id.webview); 
        mWebView.getSettings().setJavaScriptEnabled(true);  // ���信�� �ڹٽ�ũ��Ʈ���డ��
        mWebView.loadUrl("rjaend1.dothome.co.kr");  // Ȩ������ ����
        mWebView.setWebViewClient(new HelloWebViewClient());  // WebViewClient ����          
       
    }
    
    @Override 
    public boolean onKeyDown(int keyCode, KeyEvent event) { 
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) { 
            mWebView.goBack(); 
            return true; 
        } 
        return super.onKeyDown(keyCode, event); 

    }
    
    private class HelloWebViewClient extends WebViewClient { 
        @Override 
        public boolean shouldOverrideUrlLoading(WebView view, String url) { 
            view.loadUrl(url); 
            return true; 
        } 
    }
    
}