package com.example.a05networking;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.a05networking.databinding.ActivityMainBinding;

import java.net.URL;

public class MainActivity extends AppCompatActivity
{

   private ActivityMainBinding binding;
   private WebView webView;
   private ProgressBar progess;
   private EditText webLink;
   private Button goButton;
   private String url;

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
      initViews();
      onClick();

   }

   private void onClick() {
      goButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            url = webLink.getText().toString();
            createWebView();
         }
      });
   }

   private void initViews() {
      webView = binding.webViewId;
      progess = binding.progressBarId;
      webLink = binding.editTextWebSite;
      goButton = binding.buttonGo;
   }

   private void createWebView()
   {
      webView.setWebViewClient(new WebViewClient()
      {
         @Override
         public boolean shouldOverrideUrlLoading(WebView view, String url)
         {
            loadWebPage(url);
            return false;
         }

         @Override
         public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            hideProgress();
         }


      });


      loadWebPage("https://"+url);


   }

   private void hideProgress() {
      progess.setVisibility(View.GONE);
   }

   private void loadWebPage(String url) {
      progess.setVisibility(View.VISIBLE);
      webView.loadUrl(url);
   }


   @Override
   public void onBackPressed() {
      if(webView.canGoBack()){
         webView.goBack();
      } else {
         super.onBackPressed();
      }
   }
}
