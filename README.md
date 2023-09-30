# Compose Multiplatform Template
### A Compose Multiplatform Template for Android, Linux, and Windows build-targets.

### Features:
- 📦 Preconfigured dependencies with [Gradle Version Catalogs](https://docs.gradle.org/current/userguide/platforms.html)
- 🗃️ Structured with Clean Architecture
- 💾 Local database preconfigured with [SQLDelight](https://github.com/cashapp/sqldelight)
- 🗺️ Type-safe navigation with [Voyager](https://github.com/adrielcafe/voyager)
- 📱 💻 Platform-specific navigation components with expect/actual and [WindowSizeClass](https://github.com/chrisbanes/material3-windowsizeclass-multiplatform)

### Usage
Simply clone this repo with Git:
```
git clone https://github.com/har-nick/Compose_Multiplatform_Template
```

### Contributing
This project is open to pull-requests, issues, or questions.

If there's a feature you think would be broadly beneficial to add here feel free to let me know!

### Notes
- A run config (named Desktop) is included to run the JVM build target through Android Studio.
- No dependency injection method is included. See [Koin](https://github.com/InsertKoinIO/koin) as an example, or set up Manual DI if you like.
