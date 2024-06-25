@echo off
"C:\\Users\\santiagoavs\\AppData\\Local\\Android\\Sdk\\cmake\\3.22.1\\bin\\cmake.exe" ^
  "-HC:\\Users\\santiagoavs\\Downloads\\git\\LaTrinchera_PTC\\Login_Register_ptc\\app\\src\\main\\cpp" ^
  "-DCMAKE_SYSTEM_NAME=Android" ^
  "-DCMAKE_EXPORT_COMPILE_COMMANDS=ON" ^
  "-DCMAKE_SYSTEM_VERSION=26" ^
  "-DANDROID_PLATFORM=android-26" ^
  "-DANDROID_ABI=x86" ^
  "-DCMAKE_ANDROID_ARCH_ABI=x86" ^
  "-DANDROID_NDK=C:\\Users\\santiagoavs\\AppData\\Local\\Android\\Sdk\\ndk\\26.1.10909125" ^
  "-DCMAKE_ANDROID_NDK=C:\\Users\\santiagoavs\\AppData\\Local\\Android\\Sdk\\ndk\\26.1.10909125" ^
  "-DCMAKE_TOOLCHAIN_FILE=C:\\Users\\santiagoavs\\AppData\\Local\\Android\\Sdk\\ndk\\26.1.10909125\\build\\cmake\\android.toolchain.cmake" ^
  "-DCMAKE_MAKE_PROGRAM=C:\\Users\\santiagoavs\\AppData\\Local\\Android\\Sdk\\cmake\\3.22.1\\bin\\ninja.exe" ^
  "-DCMAKE_LIBRARY_OUTPUT_DIRECTORY=C:\\Users\\santiagoavs\\Downloads\\git\\LaTrinchera_PTC\\Login_Register_ptc\\app\\build\\intermediates\\cxx\\Debug\\671e5a4j\\obj\\x86" ^
  "-DCMAKE_RUNTIME_OUTPUT_DIRECTORY=C:\\Users\\santiagoavs\\Downloads\\git\\LaTrinchera_PTC\\Login_Register_ptc\\app\\build\\intermediates\\cxx\\Debug\\671e5a4j\\obj\\x86" ^
  "-DCMAKE_BUILD_TYPE=Debug" ^
  "-BC:\\Users\\santiagoavs\\Downloads\\git\\LaTrinchera_PTC\\Login_Register_ptc\\app\\.cxx\\Debug\\671e5a4j\\x86" ^
  -GNinja
