API
====== 
### [Incident](https://github.com/ilyukou/beldtp-api/tree/master/docs/entity/INCIDENT.md)
#### incident/{id}
Required param
* id -  unique identifier of Incident.

Return [incident](https://github.com/ilyukou/beldtp-api/tree/master/docs/entity/INCIDENT.md) or 404 HTTP Error

#### incident/
get all incident id

#### incident/getByTime
Required param 
* from - start of the segment for which you need to get current time in milliseconds since January 1, 1970 ( UTC+3 )
* to  - the end of the segment for which you need to get current time in milliseconds since January 1, 1970 ( UTC+3 )

if from > to return Http error : 400 Bad Request

Example : http://ip/incident/getByTime?from=1313894313305&to=1586972489805
Return all incident id which happened from Sun Aug 21 2011 05:38 to Wed Apr 15 2020 20:41


#### incident/getByLocation
Required param
*  longitude - coordinate of the center of the area
*  latitude - coordinate of the center of the area
*  radius - the distance from the center of coordinates where the objects will fall. The resulting objects will be returned as a List of IDs

For currently version request area for searching incident isn't circle, it is square. 

max longitude = longitude + radius; min longitude - radius

max latitude = latitude + radius; min latitude - radius

### [AttachmentFile](https://github.com/ilyukou/beldtp-api/tree/master/docs/entity/MEDIA.md)
#### attachmentFile/{id}
Required param
* id -  unique identifier of Media.

Return [AttachmentFile](https://github.com/ilyukou/beldtp-api/tree/master/docs/entity/MEDIA.md) or 404 HTTP Error

#### attachmentFile/file/{id}
Required param 
* id - unique identifier of [AttachmentFile](https://github.com/ilyukou/beldtp-api/tree/master/docs/entity/MEDIA.md)

Example : http://ip/attachmentFile/file/1

Return a file 

#### getAllMarker
Return incident id and location
return array of object {"id":34,"longitude":25.0203,"latitude":53.7476}