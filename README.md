[![](https://img.shields.io/badge/Jitpack-1.1.0-green?style=for-the-badge)](https://jitpack.io/#alessiocameroni/pixely-components)
![](https://img.shields.io/badge/Jetpack%20Compose-1.4.0--alpha04-blue?style=for-the-badge)
![](https://img.shields.io/badge/material3-1.1.0--alpha04-blueviolet?style=for-the-badge)


![Pixely Components](/github/TitleBanner.svg)

Pixely Components is a simple library containing a bunch of JetPack Compose components that aims to replicate different Android's system app components.

# About
The main purpose of this library is to simply compansate and add useful components to the Material3 library by Google, as some of the components already available in that library can look and/or feel outdated, or are straight up missing.
This library is a personal project meant to help my workflow, saving file and code clutter in projects, while keeping everything in a single place and making each components reusable in other projects.
All the components listed are currently used in other personal apps, such as [Revo Music Player](https://github.com/alessiocameroni/RevoMusicPlayer).

## Features
- Easy to use components
- Material3 support (wow!)
- API 24 minimum

<br>

# How to install and use
1. Add the JitPack repository to your `settings.gradle` file

```gradle
repositories {
    ...
    maven( url = "https://jitpack.io" )
}
```

2. Add the dependency in your `build.gradle` file

```gradle
dependencies {
    ...
    implementation 'com.github.alessiocameroni:pixely-components:1.1.0'
}
```

# Documentation
The documentation of each component can be found in [this repository wiki](https://github.com/alessiocameroni/pixely-components/wiki).

# Contribute
Any kind of contribution is more than welcome, it would be awesome to expand this library with more components down the line.
