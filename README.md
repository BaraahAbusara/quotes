# quotes
In this project I will be implementing a random quote picker for you to enjoy. 
Guess what? In step 2 I made my project get random quotes for you from an API , not only that !
you will be able to enjoy the quotes both when you are online and offline! 

## About
My project reads the data from a file that contains json data about movie quotes using the bufferedReader then parse it to an array of objects (Quote).
After that my code picks a random index between 0 and length of the array and return the Quote object with that index.

In step 2 : my code reads a random quote from an API and parse it from Json format to an object then save it to my local data following these steps:
1. Read data we have locally.
2. Parse the data from JSON format to ArrayList of objects.
3. Add the quote to the ArrayList.
4. Return it to JSON format and  write it in the file.

And in case the connection to the internet failed my project will read a random quote from our local file.

## testing 
To test my project you have to cd inside quoteApp directory and run `./gradlew test` . 

## Cloning 
To work on my project after cloning it make sure you have Gson library, if not add this to your dependencies in the build.gradle file :  
`    // https://mvnrepository.com/artifact/com.google.code.gson/gson
implementation 'com.google.code.gson:gson:2.9.0'
`
