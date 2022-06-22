# CO225_Project
## Baby Development Tracking Application
#### Group Members
  + E/18/022 AMARASINGHE D. I.
  + E/18/327 SENEVIRATHNA M. D. C. D.
  + E/18/349 THALISHA W. G. A. P.

# Baby Development Tracking Application (Android)
## Project Description
The aim is to build a mobile application to track and help to manage the development of
babies (0 to 5 Years).  

Users (parents or guardians) register their babies in the application with babies’ details.
(Name, birth date, Gender, current weight, current height). Registered users should
enter the already received vaccination process of their babies. With time, users enter
their babies’ vaccinations, weight and height details.

The system should be fed with a standard vaccine schedule (government and private).
System includes standard weight and height ranges according to age. When users
enter the details, the application compares those information with these standard
information. Based on that comparison, users will get notifications such as when the
next vaccination date is nearby, when weight or height are not within the standard rate.

## Technology Stack

### Android Studio
Android Studio is the official integrated development environment (IDE) for Google's Android operating system. Android Studio offers: UI builder, Flexible Gradle-based build system, Build variants and multiple apk file generation, Rich layout editor with support for drag and drop theme editing and more.

<img src="https://techcrunch.com/wp-content/uploads/2017/02/android-studio-logo.png" width="200">

### Programing Language: Java
### Local database: SQLite
SQLite is a SQL database that stores data to a text file on a device. Android comes in with built in SQLite database implementation. SQLite does not have a separate server process. SQLite reads and writes directly to ordinary disk files. 

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/38/SQLite370.svg/1200px-SQLite370.svg.png" width="200">

### Data access layer: Room
The Room persistence library provides an abstraction layer over SQLite to allow for database access in SQLite database. Room is an Object Relational Mapping library which maps our database objects to Java objects. It has 3 components,
+ @Entity - which represents tables in the database.
+ @Dao(Data Access Object) - Write & map database queries to program objects.
+ @Database - which contains database holder and servers as the main access point.

<img src="https://user-images.githubusercontent.com/73495458/155275219-95cfee64-fcdf-4e5b-ae73-52f6f9cce7c9.png" width="650">

## Database
When an user register a baby to the application, necessary data is stored in the database. There are 3 tables that store baby's data.   
user_data table:    
| Guardian's Name | Baby's Name | Date_of_Birth | Gender | BirthWeight | BirthHeight |
|-----------------|-------------|---------------|--------|-------------|-------------|      

weight_height_data table:  
| Age | weight | height |
|-----|--------|--------|    
 
vaccination table:   
| Age | vaccine | date_Of_Vaccination |
|-----|---------|-------------------|    
     
There will be 5 more fixed data tables with standard data.
boy_weight:   
| Age | max_normal_weight | min_normal_weight |
|-----|-------------------|-------------------|    

boy_height:    
| Age | max_normal_height | min_normal_height |
|-----|-------------------|-------------------|     
   
girl_weight:   
| Age | max_normal_weight | min_normal_weight |
|-----|-------------------|-------------------|    

girl_height:    
| Age | max_normal_height | min_normal_height |
|-----|-------------------|-------------------|    

vaccine:   
| Age | vaccine |
|-----|---------|
    

## Future Extendibility

+ Add baby feeding guidelines.    
+ Baby’s hearing, talking, watching responses tracking method.     
+ Charts for better data understanding.     
	+ e.g.: age vs height, weight charts     
	+ weight vs height chart     
+ Emergency contact details.    

## UI
#### Home page
<img src="https://user-images.githubusercontent.com/73495458/169451539-da0d1795-df91-4b2c-be2a-50a3b7ef34ee.jpg" width="200">

#### Vaccination details page
<img src="https://user-images.githubusercontent.com/73495458/169451892-833e74a1-136c-472b-872c-26f6c75eed8f.jpg" width="200">      <img src="https://user-images.githubusercontent.com/73495458/169451986-d16fb66b-148c-459c-a8ed-96e71098a674.jpg" width="200">


#### Weight Height Entering page
<img src="https://user-images.githubusercontent.com/73495458/169452165-a4b3e005-0699-4ff3-bc62-7aa6d66e7aa5.jpg" width="200">


