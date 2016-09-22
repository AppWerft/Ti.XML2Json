#Ti.RemotexML


This is an Android Titanium module for retreiving remote XMLs via GET

##Usage

```javascript
var XMLClient = require("de.appwerft.remotexml");
XMLClient.createClient({
    url : "http://www.deutschlandfunk.de/podcast-studiozeit-aus-kultur-und-sozialwissenschaften.1149.de.podcast.xml",
    onload : function(e) {
    if ( typeof e.data == "String")
        console.log(JSON.parse(e.data));
    else if ( typeof e.data == "Object")
    console.log(e.data);
    else
    console.log(e);
    }
});