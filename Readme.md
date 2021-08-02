# Android Clean Architecture

**(Yes, this is an over-engineering project, don't apply if you don't have to)**

## Architecture

---

In this sample, I tried to follow the [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) principles with low coupling.

The main idea is that the application does not depend on any external library, and the layers don't depend on each other.

This application is divided into five main layers.

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/93b3436f-d20d-4434-8dc9-cfa56550c935/Screen_Shot_2021-08-01_at_23.02.14.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/93b3436f-d20d-4434-8dc9-cfa56550c935/Screen_Shot_2021-08-01_at_23.02.14.png)

- **Main:** The **main** layer is the only one that knows all of the others, this is the one responsible for the dependencies injection declarations (with Koin in my case), for the FragmentFactory, MainActivity (once the app is based on a single activity, the only one goes into the main layer, otherwise, you can put the activities in the presentation layer), and the Application.
- **Presentation:** The **presentation** layer knows itself and the domain layer, this is the one responsible for the UI related classes like Fragments, Adapters, ViewHolder, and ViewModels.
- **Domain:** The **domain** layer is the only one that knows just itself, it is where you declare all of your use cases and all repository contracts.
- **Data:** The **data** layer knows itself and the domain layer, this is the one responsible for implements the domain repositories contracts, declare contracts for external libraries adapters like a **retrofit** service, and handle the app data.
- **Infra:** The **infra** layer is the one that knows the external libraries that you are using, this is the one responsible for implements your external libraries adapters.

The feature architecture diagram:

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5e2ff388-e039-46be-a38b-28b1f0cff58e/Screen_Shot_2021-08-01_at_22.43.06.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5e2ff388-e039-46be-a38b-28b1f0cff58e/Screen_Shot_2021-08-01_at_22.43.06.png)

## App Screenshots

---

### List of Recipes

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0b9b7deb-66d0-4d42-a601-870f9b86b6ad/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0b9b7deb-66d0-4d42-a601-870f9b86b6ad/Untitled.png)

## Libraries

---

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

---

This project is just a demo, few free to clone or fork the project and send your feedback, pull requests...
