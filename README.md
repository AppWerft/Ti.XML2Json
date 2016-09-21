#Ti.RemotexML


This is an Android Titanium module for retreiving remote XMLs via GET

##Usage

```javascript
var XMLClient = require("de.appwerft.remotexml");
XMLClient.createClient({
    url: URL,
    onLoad : function(e) {
        console.log(e);
    }
});