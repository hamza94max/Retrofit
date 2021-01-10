# RestAPi_recycle-cards <br/>

Simple app to display the cards of api <br/> <br/>

```
dependencies {  
    // Retrofit & OkHttp
    implementation 'com.squareup.retrofit2:retrofit:2.5.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
}
```
 <br/> <br/>
```
<uses-permission android:name="android.permission.INTERNET" />  
```


# HTTP Method
You already know that we use annotations on the Java interface methods to describe individual API endpoints and ultimately, the handling of requests. One of the first things you want to define is the HTTP request method like GET, POST, PUT, DELETE, and so on. Retrofit provides an annotation for each of the main standard request methods. You simply use the appropriate Retrofit annotations for each HTTP method: @GET, @POST, @PUT, @DELETE, @PATCH or @HEAD.

You always need to specify what kind of request method the endpoint expects from your app. If you never heard of HTTP request methods, read up on it on [wikipedia’s HTTP page](https://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol#Request_methods). You should be able to pull the expected HTTP request method from the API documentation.



[Fake api ](http://jsonplaceholder.typicode.com/)<br/>
[Retrofit Guide](https://square.github.io/retrofit/#:~:text=Retrofit%20Configuration,are%20turned%20into%20callable%20objects.)<br/><br/>
[Retrofit tutorial auth](https://futurestud.io/tutorials/android-basic-authentication-with-retrofit) 



