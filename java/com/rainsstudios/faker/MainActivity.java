package com.rainsstudios.faker;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.internal.view.SupportMenu;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private AdView ad;
    AssetManager assets;
    Button button;
    EditText edit;
    Snackbar empty;
    /* renamed from: i */
    int f17i;
    Intent intent;
    InputStream is;
    String line;
    TextView result;
    Snackbar snack;
    ArrayList<String> testlist = new ArrayList();
    String url;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.intent = getIntent();
        String url = this.intent.getStringExtra("android.intent.extra.TEXT");
        setContentView((int) C0500R.layout.activity_main);
        this.ad = (AdView) findViewById(C0500R.id.adView);
        this.ad.loadAd(new Builder().build());
        this.result = (TextView) findViewById(C0500R.id.resultTextView);
        this.edit = (EditText) findViewById(C0500R.id.editText);
        this.button = (Button) findViewById(C0500R.id.checkButton);
        this.assets = getAssets();
        if (url != null) {
            this.edit.setText(url);
        }
        this.snack = Snackbar.make(findViewById(16908290), (CharSequence) "Unable to locate Database!", 0);
        this.empty = Snackbar.make(findViewById(16908290), (CharSequence) "Entry is empty!", 0);
        try {
            this.is = this.assets.open("fake news list.txt");
        } catch (IOException e) {
        }
        BufferedReader r = new BufferedReader(new InputStreamReader(this.is));
        while (true) {
            try {
                String readLine = r.readLine();
                this.line = readLine;
                if (readLine == null) {
                    return;
                }
                if (this.line.length() > 0) {
                    this.testlist.add(this.line);
                }
            } catch (IOException e2) {
                this.snack.show();
                return;
            }
        }
    }

    public void checkFake(View v) {
        if (this.edit.getText().toString().trim().length() != 0) {
            this.f17i = 0;
            while (this.f17i < this.testlist.size()) {
                if (this.edit.getText().toString().contains((CharSequence) this.testlist.get(this.f17i))) {
                    this.result.setText("Fake News!");
                    this.result.setTextColor(SupportMenu.CATEGORY_MASK);
                    return;
                } else if (this.edit.getText().toString().contains((CharSequence) this.testlist.get(this.f17i))) {
                    this.result.setText("This appears to be valid");
                    this.result.setTextColor(-16711936);
                    this.f17i++;
                } else {
                    this.result.setText("This appears to be valid");
                    this.result.setTextColor(-16711936);
                    this.f17i++;
                }
            }
            return;
        }
        this.empty.show();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onOptionsItemSelected(android.view.MenuItem r5) {
        /*
        r4 = this;
        r3 = 1;
        r2 = r5.getItemId();
        switch(r2) {
            case 2131558572: goto L_0x000d;
            case 2131558573: goto L_0x002a;
            case 2131558574: goto L_0x0017;
            default: goto L_0x0008;
        };
    L_0x0008:
        r2 = super.onOptionsItemSelected(r5);
        return r2;
    L_0x000d:
        r1 = new android.content.Intent;
        r2 = com.rainsstudios.faker.Main2Activity.class;
        r1.<init>(r4, r2);
        r4.startActivity(r1);
    L_0x0017:
        r0 = new android.content.Intent;
        r2 = "android.intent.action.VIEW";
        r0.<init>(r2);
        r2 = "https://play.google.com/store/apps/details?id=com.rainsstudios.faker";
        r2 = android.net.Uri.parse(r2);
        r0.setData(r2);
        r4.startActivity(r0);
    L_0x002a:
        r4.moveTaskToBack(r3);
        r2 = android.os.Process.myPid();
        android.os.Process.killProcess(r2);
        java.lang.System.exit(r3);
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rainsstudios.faker.MainActivity.onOptionsItemSelected(android.view.MenuItem):boolean");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0500R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
