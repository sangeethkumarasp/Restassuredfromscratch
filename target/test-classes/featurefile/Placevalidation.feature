Feature:Place validation feature
This feature is to cover the place validation 

Scenario Outline: add place api validation
Given user with addplace payload with "<name>" "<language>" "<address>"
When user calls "addplaceapi" with "post" http request
Then api call got sucess with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify place_Id created maps to "<name>" using "getPlaceAPI"


Examples:
|name     |language    |address   |
|AAHOUSE  |English     |World cross center|
