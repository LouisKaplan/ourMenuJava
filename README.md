# ourMenu
 
### Problem Statement:
Collecting a food order can be a hassle, especially at a convention or a competition. I frequently attend Magic: The Gathering competitions with more than 1200 people in attendance, and making a food run for half a dozen friends who might be scattered around the room is difficult.
 
Forcing someone to stop what they're doing to give you their order can be disruptive and time consuming. Instead, ourMenu users can store their favorite (or a default that they'll always be happy with) order for a variety of restaurants. Later, the food-runner can simply pull up a list of diners and a list of restaurants, choose options from each list, and display an order for each person for the selected restaurant.
 
I eventually realized that I could add many other functions by collecting just a LITTLE more data. For example:
 
* By asking users to give each restaurant a score from 1-10, we can select a list of users and find the restaurant that they collectively score the highest.
 
* By aggregating people's pizza preferences, we can come up with a set of ingredients that all present diners enjoy.
 
In addition, I wanted to make sure I had easy ways to add restaurants and their menu items, a very simple interface for users to update their personal orders, and a way for admins to update existing restaurants.
 
All of this is the core functionality. There are many other things that can be implemented in the future - comments about allergies, food that the users NEVER want, dietary restrictions, etc.
 
 
### Technologies:
* Java
* HTML
* CSS
* Maven
* MySql
* jQuery
* jQuery UI
* Bootstrap
* Hibernate
* Jackson
* Google Geocoder API
* Google Maps API
 
### Independent Research:
* jQuery
* jQuery UI
* Bootstrap

### FINAL NOTE:
Things I didn't get done: 
* Authentication still doesn't work on AWS. It works 100% fine locally. I looked at every suggestion in Slack and it's still not working. I'm just out of time. 
* Code comments are nowhere near done. 
* Finally, validation of fields is not done. This means that leaving some fields blank, or entering weird data causes problems - I know how to fix this, but ran out of time. If you want to see intended functionality, I reccomend selecting as many people as possible in each situation, as the live database doesn't have a ton of data in it.

All of this got left behind because of time constraints. Everything else is at least somewhere in the ballpark of where I wanted to be. Unfortunately, without authorization, the personal menu and update a restaurant pages are not visible on the live site.

### MAJOR CHANGES SINCE PRESENTATION:
* Added restaurant ratings for users (not visible without login - screenshot here: http://imgur.com/a/mB5Os )
* Added styling to website (also not visible on AWS for some reason, no time to fix - see on above screenshot)
* Implemented google maps API and added function to Restaurant Selector. User now enters in city and state while searching for a restaurant, and the results page shows a location for the restaurant that the group prefers: http://imgur.com/pdbLMrB and http://imgur.com/8AnANDa
* Edit Restaurant page has been added. This allows users to add or remove menu items for specific restaurants: http://imgur.com/UHw1Aom
* Fixed MANY bugs
* Implemented a logout function and page
* Auploaded to AWS. Everything seems to work there except authentication. I've messed with it a bunch and read all the answers in the slack channel, but it's not working and it's almost 2am - I'm done :)

Thanks for looking at all this!
