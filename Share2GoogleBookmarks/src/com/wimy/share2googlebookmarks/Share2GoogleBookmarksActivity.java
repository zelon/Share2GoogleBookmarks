package com.wimy.share2googlebookmarks;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Share2GoogleBookmarksActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
		Bundle bundle = getIntent().getExtras();

		if ( bundle != null )
		{
			String url = bundle.getString(Intent.EXTRA_TEXT);
			String subject = bundle.getString(Intent.EXTRA_SUBJECT);

			if ( url == null && subject == null )
			{
				Toast.makeText(this, "url and subject are null", Toast.LENGTH_LONG).show();
				finish();
				return;
			}
			
			if ( url == null ) url = "unknown url";
			if ( subject == null ) subject = "unknown subject";
			
			String newUrl = String.format("https://www.google.com/bookmarks/mark?op=edit&bkmk=%s&title=%s", url, subject);

			Log.i("gm", "Load " + newUrl);
				
			openInBrowser(newUrl);
				
			finish();
		}
		
    }
    
    private void openInBrowser(String url) {
    	Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
    	startActivity(browserIntent);
    }
}