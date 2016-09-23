#Ti.RemotexML


This is an Android Titanium module for retreiving remote XMLs via GET

##Usage

With remote XML:
```javascript
var XMLClient = require("de.appwerft.remotexml");
XMLClient.createClient({
    url : "http://www.deutschlandfunk.de/podcast-studiozeit-aus-kultur-und-sozialwissenschaften.1149.de.podcast.xml",
    onload : function(e) {
        console.log(e.data);
        console.log(e.data);
    }
});
```
With  XML string:
```javascript
var xml = '<?xml version="1.0" encoding="UTF-8"?>
<CATALOG>
<CD>
<TITLE>Empire Burlesque</TITLE>
<ARTIST>Bob Dylan</ARTIST>
<COUNTRY>USA</COUNTRY>
<COMPANY>Columbia</COMPANY>
<PRICE>10.90</PRICE>
<YEAR>1985</YEAR>
</CD>
<CD>
<TITLE>Hide your heart</TITLE>
<ARTIST>Bonnie Tyler</ARTIST>
<COUNTRY>UK</COUNTRY>
<COMPANY>CBS Records</COMPANY>
<PRICE>9.90</PRICE>
<YEAR>1988</YEAR>
</CD>
<CD>
<TITLE>Greatest Hits</TITLE>
<ARTIST>Dolly Parton</ARTIST>
<COUNTRY>USA</COUNTRY>
<COMPANY>RCA</COMPANY>
<PRICE>9.90</PRICE>
<YEAR>1982</YEAR>
</CD>
<CD>
<TITLE>The very best of</TITLE>
<ARTIST>Cat Stevens</ARTIST>
<COUNTRY>UK</COUNTRY>
<COMPANY>Island</COMPANY>
<PRICE>8.90</PRICE>
<YEAR>1990</YEAR>
</CD>
</CATALOG>';

var XMLClient = require("de.appwerft.remotexml");
XMLClient.createClient({
    xml : xml,
    onload : function(e) {
        console.log(e.data);
        console.log(e.data);
    }
});
```