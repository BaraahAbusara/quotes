# quotes
In this project I will be implementing a random quote picker for you to enjoy. 

## About
My project reads the data from a file that contains json data about movie quotes using the bufferedReader then parse it to an array of objects (Quote).
After that my code picks a random index between 0 and length of the array and return the Quote object with that index. 

## testing 
To test my project you have to cd inside quoteApp directory and run `./gradlew test` . 

## Cloning 
To work on my project after cloning it make sure you have Gson library, if not add this to your dependencies in the build.gradle file :  
`    // https://mvnrepository.com/artifact/com.google.code.gson/gson
implementation 'com.google.code.gson:gson:2.9.0'
`
