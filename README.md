CodeLearnIntern

Software Used : Eclipse.

About plugin:

Plugin which helps to display the information about flights and its timings of source and destination.
For time being, i am fetching the data of only some places.
places are :
Bangalore,Chennai,Delhi,Mumbai,Goa,cochin,hyderabad,ahmedabad.

I have used makemytrip website to fetch the details.

If any other place is given as an input plugin will display "invalid".


Test cases :

I have used junit to test, i have written 7 testcodes which have run successfully.
Image :test.png;

TestCodes:

File: ViewPart13Test.java.


Installation Procedure :

1.Once you download the zip file from github extact it.
2.After extracting you find a folder named export.
3.Now, open Eclipse Ide.
4.goto Help->Install New Software
5.now in workwith row click Add button
6.on the popup window in Name type "Local site" and in location type "file:Location of export folder" press ok (ref:add.png) .
7.uncheck group items by category.
8.now you will find Codelearn in the above table check that and click next ->next -> accept the terms click finish ->ok.
9.now eclipse will restart.

TO Check the Plugin.

1.goto Window ->show view -> other.
2.now expand other folder in the popup window.
3.select CodeLearnInternship.view13 , click ok.


As it's a view plugin you will find the pluginview next to other standard views ex:console,error etc.

I have attached a sample.png image describes how the plugin works.

sample.png,  mumbai to bangalore flights.

to verify the results you can always use the following link.
http://www.makemytrip.com/flights/mumbai-bangalore-cheap-airtickets.html

here replace mumbai and bangalore with required source and destinations.
note:plugin works for only some mentioned places as above.


i have even added the plugin project.


