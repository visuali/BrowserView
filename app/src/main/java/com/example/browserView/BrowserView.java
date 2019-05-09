package com.example.browserView;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class BrowserView extends AppCompatActivity {
    private EditText urlText;
    private Button goButton;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Load the view from its definition in the layout resource
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.web_view);

        // Get a handle to our two UI controls
        urlText = (EditText) findViewById(R.id.url_field);
        urlText.setText("https://www.android.com");
        goButton = (Button) findViewById(R.id.go_button);

        // Setup event handlers to tell Android to open the browser:
        // 1. when the user selects the Go button,
        // either by touching it or by navigating to it and pressing the center D-pad button.
        goButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                openBrowser();
            }
        });
        // 2. when the user types the enter key into the edit field
        urlText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                //
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    openBrowser();
                    return true;
                }
                return false;
            }
        });
    }
    private void openBrowser() {
//        Uri uri = Uri.parse(urlText.getText().toString());
//        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//        startActivity(intent);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(urlText.getText().toString());
    }
}
