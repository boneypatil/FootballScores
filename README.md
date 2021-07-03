# Scores


[![Kotlin](https://img.shields.io/badge/Kotlin-1.3.61-blue.svg)](https://kotlinlang.org)
[![Dagger2](https://img.shields.io/badge/Dagger%202-2.26-red.svg)](https://github.com/google/dagger)
[![Material design](https://img.shields.io/badge/Material%20Design-1.2.0--alpha%205-%237464f2.svg)](https://material.io)
[![The API Generator ](https://run.mocky.io/)

### Application which retrieves data from Webserver (via Retrofit). We are using MVVM architecture pattern and Dagger 2 example.
 # Overview:

* ### __Model__
   Model is implemented as Repository pattern.
* ### __View__
     View is realised as 2 fragments. First one contains RecyclerView, second one depends on clicks on recycler-items and finally displays detailed data fetched from the Model. 
    <br/><br/>

    <div align = "center">
     <img src = "https://github.com/boneypatil/FootballScores/blob/develop/app/src/main/res/drawable/screen1.jpeg?raw=true" width="330">
     <img src = "https://github.com/boneypatil/FootballScores/blob/develop/app/src/main/res/drawable/screen2.jpeg?raw=true" width="330">
    </div>

*  ### __ViewModel__
   ViewModel is responsible for transferring data between view and model.
* ### __Dagger 2__
    – Implementation of dependency injection for communication between app modules<br/>
    – AndroidInjector applying for injecting into View components<br/>
    – Unit-testing simplifying
    <br/><br/>


# Applied technologies and libraries:


* ### __Model__

	* ### __Network__<br/>
	     __Retrofit 2__ <br/>
		– getting data from server into pojo-classes
     
	     __okHTTP__ <br/>
	        – caching data from the server to display the movie offline
		
	     __Gson__ <br/>
		– converting  json to object
       
   * __Coroutines__ <br/>
      – managing asynchronous network queries<br/>
      – using instead of callbacks<br/>
      – providing light asynchronous operations, combining 2 api responce demonstration 

* ### __ViewModel__
   * __LiveData__ <br/>
      – observer-pattern implementation for View interaction
         
* ### __View__
   * __Fragments__ <br/>
     – interactive displaying and click reflecting and pull to refresh functionality 
          
  *  __Data Binding__ <br/>
    – replace basic operations with UI (e.g. findViewById() ) to the XML

## All libraries: <br/>

* Android X
* Material Librarie 
* Android Jetpack
* Dagger 2
* Kotlin Coroutines
* Retrofit 2
* OkHTTP 3
* Gson
* Glide

