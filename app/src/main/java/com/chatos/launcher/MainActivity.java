package com.chatos.launcher;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.view.View;
import android.widget.*;
import java.util.*;
public class MainActivity extends Activity {
 LinearLayout layout;
 @Override public void onCreate(Bundle b){super.onCreate(b);showApps();}
 void showApps(){
 ScrollView scroll=new ScrollView(this);
 layout=new LinearLayout(this);layout.setOrientation(1);layout.setPadding(24,24,24,24);layout.setBackgroundColor(Color.rgb(17,22,32));
 TextView title=new TextView(this);title.setText("ChatOS 0.1  •  Apps");title.setTextSize(25);title.setTextColor(Color.WHITE);layout.addView(title);
 Intent intent=new Intent(Intent.ACTION_MAIN);intent.addCategory(Intent.CATEGORY_LAUNCHER);
 List<ResolveInfo> apps=getPackageManager().queryIntentActivities(intent,0);
 Collections.sort(apps,new ResolveInfo.DisplayNameComparator(getPackageManager()));
 for(final ResolveInfo app:apps){
 Button button=new Button(this);button.setAllCaps(false);button.setText(app.loadLabel(getPackageManager()));
 button.setOnClickListener(new View.OnClickListener(){public void onClick(View v){
 Intent launch=getPackageManager().getLaunchIntentForPackage(app.activityInfo.packageName);
 if(launch!=null)startActivity(launch);
 }});layout.addView(button);
 }
 scroll.addView(layout);setContentView(scroll);
 }
}
