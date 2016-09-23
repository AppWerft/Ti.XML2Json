package de.appwerft.remotexml;

import org.appcelerator.kroll.common.Log;
import org.json.JSONException;

public class JSON {
	final static String LCAT = "importJSON  🌀🌀️";

	public static Object fromJSON(Object value) {
		Log.d(LCAT, "start toKrollDict >>>>>>>>>>>>>>>> ");
		try {
			if (value instanceof org.json.jsonjava.JSONObject) {
				Log.d(LCAT, "was org.json.jsonjava.JSONObject");
				org.json.jsonjava.JSONObject foo = (org.json.jsonjava.JSONObject) value;
				org.json.JSONObject bar = new org.json.JSONObject();
				for (String key : foo.keySet()) {
					Log.d(LCAT, "key=" + key);
					Object val = foo.get(key);
					Log.d(LCAT, val.toString());
					bar.put(key, val);
				}
				return bar;
			} else if (value instanceof org.json.jsonjava.JSONArray) {
				Log.d(LCAT, "was org.json.jsonjava.Array");
				org.json.jsonjava.JSONArray foo = (org.json.jsonjava.JSONArray) value;
				org.json.JSONArray bar = new org.json.JSONArray(foo.length());
				for (int i = 0; i < bar.length(); i++) {
					bar.put(i, fromJSON(foo.get(i)));
				}
				return bar;
			} else if (value == org.json.jsonjava.JSONObject.NULL) {
				return null;
			} else
				Log.d(LCAT, "no type matching");
		} catch (JSONException e) {
			Log.e(LCAT, e.getMessage());
		}
		return value;
	}
}
