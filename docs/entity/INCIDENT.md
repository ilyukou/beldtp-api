### Incident
* ##### Type name - description
* Long id - unique identifier
* String text - description about incident
* Set<Long> media - set of media id
###### Time UTC+3 ( Minsk )
* Long millis - time in millis 
* Byte day - first day of month have value 1
* Byte month - range 0-11
* Byte hour - range 0-23
* Byte minute - range 0-59
* Integer year
###### Location
* Float longitude - see [Telegram Api](https://core.telegram.org/bots/api#sendlocation)
* Float latitude - see [Telegram Api](https://core.telegram.org/bots/api#sendlocation)
* String city - this and all below parameters get from [geocoder](https://opencagedata.com/)
* String cityDistrict
* String country
* String countryCode
* String county
* String postcode
* String road
* String houseNumber
* String state