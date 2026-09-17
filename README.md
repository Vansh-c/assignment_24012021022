# 🎵 MusikHören
 WhatsApp.Video.2026-09-15.at.17.58.27.mp4 
MusikHören is a simple Android music player application developed using **Kotlin** and **Android Studio**.

The application displays a collection of music tracks using a `RecyclerView`. Each track has its own image, title, play/pause button, and loop/replay button.

This project was created to practice Android development concepts such as **RecyclerView, Adapter, ViewHolder, MediaPlayer, Activity lifecycle, XML layouts, animations, and event handling**.

---

## ✨ Features

- 🎵 Display multiple music tracks using RecyclerView
- 🖼️ Individual image for each music track
- ▶️ Play music
- ⏸️ Pause and resume music
- 🔄 Enable/disable looping for a track
- 🎧 Only one track plays at a time
- 🔀 Switching to another track stops the previous track
- 🎬 Animated splash screen
- 📱 ConstraintLayout-based UI
- 🧹 MediaPlayer cleanup when the Activity is destroyed

---

## 🛠️ Technologies Used

- **Kotlin**
- **Android Studio**
- **RecyclerView**
- **ConstraintLayout**
- **Material FloatingActionButton**
- **MediaPlayer**
- **XML**
- **Android Resources**
- **Handler & Looper**

---

## 📱 App Flow

```text
SplashActivity
      │
      │ 2 seconds
      ▼
MainActivity
      │
      ▼
Create Music List
      │
      ▼
MusicAdapter
      │
      ▼
RecyclerView
      │
      ├── 🎵 War
      ├── 🎵 Hero's Journey
      ├── 🎵 Bang Bang
      ├── 🎵 Aasman Se Aaya Farishta
      ├── 🎵 Luffy's Fierce Attack
      └── 🎵 Ghunghroo
