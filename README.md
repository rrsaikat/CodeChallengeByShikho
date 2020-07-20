<h1 align="center">CodeChallengeByShikho</h1>
<p align="center">
  <a href="https://android-arsenal.com/api?level=16"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
    <a href="https://github.com/rrsaikat"><img alt="API" src="https://badges.frapsoft.com/os/v1/open-source.png?v=103"/></a>
   <a href=""><img alt="Github Downloads (total)" src="https://img.shields.io/github/downloads/rrsaikat/CodeChallengeByShikho/total.svg"/></a>
  <a href="https://github.com/rrsaikat/CodeChallengeByShikho/raw/master/app/release/CodeChallengeByShikho-1.0.15.apk"><img alt="Download" src="https://img.shields.io/badge/DownloadApk-v1.0.15-green.svg"/></a>
  <a href="https://github.com/rrsaikat/AutoCallScheduler/graphs/traffic"><img alt="Total Clones" src="https://img.shields.io/badge/Clones-9-orange"/></a>
    <a href="https://github.com/rrsaikat/AutoCallScheduler/graphs/traffic"><img alt="Total Views" src="https://img.shields.io/badge/Views-101-brightgreen"/></a>
    <a href="https://twitter.com/RsaikatR"><img alt="Twitter follow" src="https://img.shields.io/twitter/follow/RsaikatR.svg?style=social"/></a>

<p align="center">  
A simple Android Application which uses GraphQL API (https://graphqlzero.almansi.me/api) to perform CRUD operations on dummy data. The application is written entirely in Kotlin.
Android Jetpack is used as an Architecture glue including but not limited to ViewModel, LiveData, Lifecycles, Navigation, Room and Data Binding. The application does network HTTP requests via GraphQL, APolloClient, OkHttp and GSON. Loaded data is saved to SQL based database Room, which serves as data warehouse and support offline mode. Kotlin Coroutines manage background threads with simplified code and reducing needs for callbacks. Combination of Coroutines and Kotlin build in functions (transformation, collections) are preferred over RxJava 2. Work manager does synchronisation job being compatible with Doze Mode and using battery efficiently. Navigation component manages in-app navigation.Dagger 2 is used for dependency injection. Glide is used for lazy image loading.
</p>

 <p align="center"> 
    <img src="https://github.com/rrsaikat/CodeChallengeByShikho/blob/master/shikho.png" alt="app preview">
 </p>


### App Architechture

<p align="center"> 
    <img src="https://github.com/rrsaikat/CodeChallengeByShikho/blob/master/Architechture%20Diagram.png" alt="architechture pattern">
 </p>


#### Statistics
Features | Status | Discussion
--- | --- | ---
Get a Post, Get a User, Get User's Posts, Get All Posts  Query | done | -
Load & Display the photo album from “Get a Photo’s Album” Query | done | -
Create a Post, Update a Post, Delete a Post | Not Done | Having issues from server side
Language: 100% Kotlin | Done | -
Github/Gitlab with all development branches & commit history timeline | done | -
Followed Recommended App Architecture | done | MVVM
Android Architecture Components from Android Jetpack | Done | LiveData, Viewmodel, Coroutines, Dagger2, Navigation, Data Binding, WorkManager, Room, Android Ktx
GraphQL Client | Done | Apollo


# License
      Copyright (c) 2020. RRsaikat

      Licensed under the Apache License, Version 2.0 (the "License");
      you may not use this file except in compliance with the License.
      You may obtain a copy of the License at

            http://www.apache.org/licenses/LICENSE-2.0

      Unless required by applicable law or agreed to in writing,
      software distributed under the License is distributed on an "AS IS" BASIS,
      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
      See the License for the specific language governing permissions and
      limitations under the License.
