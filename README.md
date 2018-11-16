# ViaplaySections
As requested I implemented a simple app that shows the sections to the user. 
The sections are listed in a recyclerView and with navigating to a particular section, user can see the title and description of this section.

I used Android Room Persistence Library for database. I have used SQLite and Realm databases before but it is my first time using Room library. I wanted to give it a try.
The solution that I implemented for online-offline working is storing data(saving or updating) every time when user requests it from the API. 

If there is an internet connection when the app is launched, the sections are saved to database. If it was saved earlier, it is updated. 
Also if user navigates to detail of the section, this section detail is saved to database or updated if it exists.
If there is no internet connection data is loaded from the database.

I implemented a simple MVP architecture for the application. 

I used Retrofit for the networking operations, Gson for parsing json and Butterknife for view binding.
