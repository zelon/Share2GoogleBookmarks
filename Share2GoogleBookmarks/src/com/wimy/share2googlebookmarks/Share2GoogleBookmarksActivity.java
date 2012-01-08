package com.wimy.share2googlebookmarks;

import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class Share2GoogleBookmarksActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
		Bundle bundle = getIntent().getExtras();

		if ( bundle != null )
		{
			Set<String> keyset = bundle.keySet();
			
			for ( String s : keyset )
			{
				Log.i("gm", bundle.get(s).toString());
			}
			
			String url = bundle.getString(Intent.EXTRA_TEXT);
			String subject = bundle.getString(Intent.EXTRA_SUBJECT);

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