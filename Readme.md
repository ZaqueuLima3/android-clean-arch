# Android Clean Architecture

**(Yes, this is an over-engineering project, don't apply if you don't have to)**

## Architecture

In this sample, I tried to follow the [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) principles with low coupling.

The main idea is that the application does not depend on any external library, and the layers don't depend on each other.

This application is divided into five layers.

<img src="https://user-images.githubusercontent.com/31195408/127798523-f08ea66d-ee08-4efa-9bff-e9a2ef1538e9.png" width="300">

- **Main:** The **main** layer is the only one that knows all of the others, this is the one responsible for the dependencies injection declarations (with Koin in my case), for the FragmentFactory, MainActivity (once the app is based on a single activity, the only one goes into the main layer, otherwise, you can put the activities in the presentation layer), and the Application.
- **Presentation:** The **presentation** layer knows itself and the domain layer, this is the one responsible for the UI related classes like Fragments, Adapters, ViewHolder, and ViewModels.
- **Domain:** The **domain** layer is the only one that knows just itself, it is where you declare all of your use cases and all repository contracts.
- **Data:** The **data** layer knows itself and the domain layer, this is the one responsible for implements the domain repositories contracts, declare contracts for external libraries adapters like a **retrofit** service, and handle the app data.
- **Infra:** The **infra** layer is the one that knows the external libraries that you are using, this is the one responsible for implements your external libraries adapters.

The architecture diagram:

![image](https://user-images.githubusercontent.com/31195408/127798568-839d0496-3a3a-4ed3-b873-1e7ff9028223.png)

## App Screenshots

### List of Recipes

<img src="https://user-images.githubusercontent.com/31195408/127798599-5320fd16-96c8-48bc-b054-2e4ce46df7d4.png" width="400">

## Libraries

- Appcompat
- ConstraintLayout
- Material Design
- Swiperefreshlayout
- Retrofit
- Gson
- Room
- Koin
- Glide
- Picasso (I'm using Glide and Picasso for illustrative purposes only, to show the convenience of switching a library when using adapters)

## Contribute

This project is just a demo, few free to clone or fork the project and send your feedback, pull requests...
