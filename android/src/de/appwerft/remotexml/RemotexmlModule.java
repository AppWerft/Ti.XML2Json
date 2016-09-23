package de.appwerft.remotexml;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.jsonjava.XML;

@Kroll.module(name = "Remotexml", id = "de.appwerft.remotexml")
public class RemotexmlModule extends KrollModule {

	public RemotexmlModule() {
		super();
	}

	@Kroll.method
	public KrollDict parseXML(String xml) throws JSONException {
		JSONObject json = de.appwerft.remotexml.JSON
				.toJSON(org.json.jsonjava.XML.toJSONObject(xml));
		return new KrollDict(json);
	}
}
