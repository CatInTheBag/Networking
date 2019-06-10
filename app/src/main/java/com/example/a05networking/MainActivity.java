package com.example.a05networking;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.a05networking.databinding.ActivityMainBinding;

import java.net.URL;

public class MainActivity extends AppCompatActivity
{

   private ActivityMainBinding binding;

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

      createWebView();
   }

   private void createWebView()
   {
      binding.webViewId.setWebViewClient(new WebViewClient()
      {
         @Override
         public boolean shouldOverrideUrlLoading(WebView view, String url)
         {
            view.loadUrl(url);
            return false;
         }
      });

      binding.webViewId.loadUrl("https://www.dnes.bg");

   }
}
