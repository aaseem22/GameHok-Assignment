# How to Run the App in Android Studio

## Prerequisites
1. Install **Android Studio** (latest version).
2. Ensure **JDK** is installed (comes with Android Studio).
3. (Optional) Install **Git** for cloning repositories.

## Steps to Run the App

### 1. Clone the Repository
```bash
git clone <repository-url>
```
Replace `<repository-url>` with the project URL.

### 2. Open in Android Studio
1. Launch Android Studio.
2. Click **File > Open**, select the project folder, and click **OK**.
3. Sync with Gradle if prompted.

### 3. Set Up a Device
- **Emulator:**
  - Open **Device Manager**, create a virtual device, and start it.
- **Physical Device:**
  - Enable **Developer Options** and **USB Debugging**.
  - Connect via USB and verify with:
  ```bash
  adb devices
  ```

### 4. Build and Run
1. Select your device (emulator or physical) from the dropdown.
2. Click **Run** (green triangle) or press `Shift + F10`.
3. The app will launch on the device.

## Troubleshooting
- **Gradle issues:** Sync project or check dependencies.
- **Emulator issues:** Enable hardware acceleration.
- **Build errors:** Clean (`Build > Clean`) and rebuild (`Build > Rebuild`).

For more help, visit [Android Developer Documentation](https://developer.android.com/docs).

