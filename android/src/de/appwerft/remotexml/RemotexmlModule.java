package de.appwerft.remotexml;

import java.io.IOException;
import java.net.MalformedURLException;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollFunction;
import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.TiC;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import android.os.AsyncTask;

import com.alibaba.fastjson.JSONObject;

@Kroll.module(name = "Remotexml", id = "de.appwerft.remotexml")
public class RemotexmlModule extends KrollModule {

	// Standard Debugging variables
	private static final String LCAT = "RXml";
	public KrollFunction mCallback;

	// You can define constants with @Kroll.constant, for example:
	// @Kroll.constant public static final String EXTERNAL_NAME = value;

	public RemotexmlModule() {
		super();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app) {
		Log.d(LCAT, "inside onAppCreate");
		// put module init code that needs to run when the application is
		// created
	}

	// Methods
	@Kroll.method
	public void createRemoteXMLClient(final KrollDict options,
			final @Kroll.argument(optional = true) KrollFunction mCallback) {

		AsyncTask<Void, Void, Void> doRequest = new AsyncTask<Void, Void, Void>() {
			@Override
			protected Void doInBackground(Void[] dummy) {
				int timeout = 10000;
				String url = null;
				String useragent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:46.0) Gecko/20100101 Firefox/46.0";
				if (options.containsKey(TiC.PROPERTY_TIMEOUT)) {
					timeout = options.getInt(TiC.PROPERTY_TIMEOUT);
				}
				if (options.containsKey(TiC.PROPERTY_URL)) {
					url = options.getString(TiC.PROPERTY_URL);
				}
				if (options.containsKey("useragent")) {
					useragent = options.getString("useragent");
				}
				KrollDict data = new KrollDict();
				try {

					Document xmlDoc = Jsoup.connect(url).userAgent(useragent)
							.timeout(timeout).ignoreContentType(true).get();
					String xmlString = xmlDoc.toString();
					Log.d(LCAT, xmlString);

					JSONObject o = com.alibaba.fastjson.JSON
							.parseObject(xmlString);
					data.put("json", o);
					/*
					 * data.put("success", true);
					 * mCallback.call(getKrollObject(), data);
					 */
				} catch (MalformedURLException e) {
					data.put("error", "MalformedURLException");
					mCallback.call(getKrollObject(), data);
					e.printStackTrace();
				} catch (IOException e) {
					data.put("error", "IOException");
					mCallback.call(getKrollObject(), data);
					e.printStackTrace();
				}
				return null;
			}

		};
		doRequest.execute();

	}

}
