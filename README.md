# flutterHostProject

flutter 的 Android 宿主项目

### project environment:
- init and update the dependent project(path : module_flutter).
```bash
git submodule init
git submodule update
```


### prepare environment:
- flutter binery file is excutable and in your system path
- pub package mirror.(in china this can upper your package download speed)
- dart package mirror.(in china this can upper your package download speed)
- finally, you can run `flutter doctor` to check your environment.

### Build Steps:
1. change directory to flutter module (such as : module_flutter)
2. run : `flutter build aar` #it will generate the configure file.
3. back to you project root directory.
4. enjoy your coding!

### commond record:
```bash
cd module_flutter
flutter build aar
cd ..
gradlew aDebug
```
