# 🎹 KeyboardLayout
**Cross-platform library for detecting keyboard layouts and languages on Windows, macOS, and Linux.**


## 🚀 Features
- **🖥️ Supported Operating Systems:** Available on Windows, Mac, and Linux.
- **🌐 Supported Languages And Input Methods:** Supports multiple languages and input methods, including Sogou Pinyin Method (Chinese) for macOS.
- **⚡ Lightweight and easy to use**


## 📦 Installation
Add the following dependency to your `build.gradle` file:

```groovy
dependencies {
    implementation 'io.github.siropkin.keyboard-layout:1.0.2'
}
```


## 🛠️ Usage
```kotlin
import io.github.siropkin.keyboardLayout.*
val keyboardLayout = KeyboardLayout()
val keyboardLayoutInfo = keyboardLayout.getInfo()
println("Layout: ${keyboardLayoutInfo.toString()}, Language: ${keyboardLayoutInfo.language}, Country: ${keyboardLayoutInfo.country}, Variant: ${keyboardLayoutInfo.variant}")
```


## 🤝 Contributing
Contributions are welcome!
Please open an issue or submit a pull request.


## 📄 License
This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.


## 📧 Contact
Made with ❤️ by [Ivan Seredkin](mailto:ivan.seredkin@gmail.com)
