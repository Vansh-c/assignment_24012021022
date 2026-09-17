https://github.com/user-attachments/assets/7d355603-8717-4959-aeb3-f39b7b401a79

# 🎵 MusikHören

> **Experience Sound in Loop**

**MusikHören** is a simple Android music player application developed as
an Android/Mobile Application Development assignment. The app provides a
clean music-list interface where users can play, pause, switch between
songs, and enable/disable looping for individual tracks.

------------------------------------------------------------------------

## 📱 Project Overview

MusikHören displays a collection of songs in a `RecyclerView`. Each song
contains:

-   🎨 A music/poster image
-   🎵 Song title
-   ▶️ Play/Pause control
-   🔁 Loop/Replay control

The application also includes a splash screen with the app logo, title,
and tagline before opening the main music player screen.

------------------------------------------------------------------------

## ✨ Features

### 🎬 Splash Screen

-   Displays the MusikHören logo.
-   Shows the application name with a fade-in animation.
-   Displays the tagline **"Experience Sound in Loop"**.
-   Automatically opens the main screen after approximately 2 seconds.

### 🎧 Music Player

-   Shows available songs in a scrollable `RecyclerView`.
-   Displays an image and title for every track.
-   Plays audio files stored locally in the Android `res/raw` directory.

### ▶️ Play / Pause

-   Tap the play button to start a song.
-   Tap the same button again to pause it.
-   The button icon changes between play and pause states.
-   Starting another song automatically stops the previously selected
    song.

### 🔁 Loop / Replay

-   Each song has its own loop control.
-   Loop can be enabled or disabled for a selected track.
-   The selected song can continue playing repeatedly when loop mode is
    active.

### 🧹 MediaPlayer Management

-   Uses Android's `MediaPlayer` for local audio playback.
-   Releases the player when `MainActivity` is destroyed to avoid
    unnecessary resource usage.

------------------------------------------------------------------------

## 🛠️ Technologies Used

  Technology                Usage
  ------------------------- ----------------------------------
  **Kotlin**                Application programming language
  **Android Studio**        Development environment
  **Android SDK**           Android application development
  **RecyclerView**          Displaying the music list
  **MediaPlayer**           Playing local audio
  **ConstraintLayout**      Designing layouts
  **Material Components**   Floating action buttons
  **Gradle Kotlin DSL**     Project/build configuration

------------------------------------------------------------------------

## 📂 Project Structure

``` text
assignment_24012021022/
│
├── app/
│   └── src/
│       └── main/
│           ├── java/com/example/assignment_24012021022/
│           │   ├── MainActivity.kt
│           │   ├── MusicAdapter.kt
│           │   └── SplashActivity.kt
│           │
│           ├── res/
│           │   ├── drawable/
│           │   │   ├── music/poster resources
│           │   │   ├── play/pause icons
│           │   │   └── loop/replay icons
│           │   │
│           │   ├── layout/
│           │   │   ├── activity_main.xml
│           │   │   ├── activty_splash.xml
│           │   │   └── list_item.xml
│           │   │
│           │   └── raw/
│           │       └── local audio files
│           │
│           └── AndroidManifest.xml
│
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
└── README.md
```

------------------------------------------------------------------------

## 🎼 Included Music

The current project contains the following tracks:

1.  **War**
2.  **Hero's Journey**
3.  **Bang Bang**
4.  **Aasman Se Aaya Farishta**
5.  **Luffy's Fierce Attack**
6.  **Ghunghroo**

Audio and poster resources are bundled locally with the application.

------------------------------------------------------------------------

## 🔄 Application Flow

``` text
                    ┌──────────────────┐
                    │   Launch App     │
                    └────────┬─────────┘
                             ↓
                    ┌──────────────────┐
                    │  Splash Screen   │
                    │   ~2 seconds     │
                    └────────┬─────────┘
                             ↓
                    ┌──────────────────┐
                    │   MainActivity   │
                    └────────┬─────────┘
                             ↓
                    ┌──────────────────┐
                    │   Music List     │
                    │   RecyclerView   │
                    └────────┬─────────┘
                             ↓
              ┌──────────────┴──────────────┐
              ↓                             ↓
       ▶️ Play / Pause                 🔁 Loop / Replay
              ↓                             ↓
       MediaPlayer control          Loop state control
```

------------------------------------------------------------------------

## 🧩 Main Components

### `SplashActivity.kt`

Responsible for:

-   Loading the splash screen.
-   Animating the logo and app title.
-   Waiting for approximately 2 seconds.
-   Navigating to `MainActivity`.

### `MainActivity.kt`

Responsible for:

-   Loading the main layout.
-   Creating the list of `MusicItem` objects.
-   Connecting the music list to the `RecyclerView`.
-   Releasing the `MediaPlayer` through the adapter when the activity is
    destroyed.

### `MusicAdapter.kt`

Responsible for:

-   Binding music images and titles to each list item.
-   Handling play/pause operations.
-   Handling loop/replay operations.
-   Tracking the currently playing song.
-   Tracking the currently looping song.
-   Managing the `MediaPlayer`.

### `MusicItem`

A Kotlin data class containing:

``` kotlin
data class MusicItem(
    val title: String,
    var imageRes: Int,
    var audioRes: Int
)
```

It stores the title, image resource, and audio resource for each song.

------------------------------------------------------------------------

## 🚀 How to Run

### 1. Clone the repository

``` bash
git clone <YOUR_GITHUB_REPOSITORY_URL>
```

### 2. Open the project

Open the project in **Android Studio**.

### 3. Sync Gradle

Allow Android Studio to download/sync the required Gradle dependencies.

### 4. Connect a device or start an emulator

Use an Android phone with USB debugging enabled or an Android Emulator.

### 5. Run the application

Click **Run ▶** in Android Studio.

------------------------------------------------------------------------

## ⚙️ Project Configuration

Current application configuration:

``` text
Namespace:       com.example.assignment_24012021022
Application ID:  com.example.assignment_24012021022
Min SDK:         24
Target SDK:      36
Compile SDK:     37.1
Version:         1.0
```

The project uses Java 11 compatibility for compilation and Kotlin for
application development.

------------------------------------------------------------------------

## 🎯 Learning Objectives

This project demonstrates basic Android development concepts including:

-   Android Activity lifecycle
-   Splash screen implementation
-   XML layout design
-   `RecyclerView`
-   Custom `RecyclerView.Adapter`
-   Kotlin data classes
-   Event handling with button click listeners
-   Local audio playback using `MediaPlayer`
-   Managing application resources
-   Handling play/pause states
-   Implementing loop functionality
-   Releasing resources during the Activity lifecycle

------------------------------------------------------------------------

## 🔮 Future Improvements

Possible improvements for future versions:

-   ⏭️ Next/Previous song controls
-   🎚️ Volume and seek bar
-   ⏱️ Music progress indicator
-   📂 User-created playlists
-   ⭐ Favorite songs
-   🔍 Search and filter songs
-   🎨 More modern player screen
-   🔔 Notification-based music controls
-   📱 Background music playback using a foreground service
-   🌐 Online music streaming support

------------------------------------------------------------------------

## 👨‍💻 Developer

**Vansh Joshi**

B.Tech Computer Engineering Student\
Ganpat University

------------------------------------------------------------------------

## 📄 License

This project was created for educational/academic purposes.

