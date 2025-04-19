# 📱 SplashScreen Android

A partir de Android 12, la API nativa de SplashScreen muestra una animación de inicio con el ícono de la app y una transición fluida. Puede personalizarse para mantener la identidad visual de la app. Para versiones anteriores, se recomienda usar la biblioteca androidx.core:splashscreen.

## ⚙️ Implementacion

Agrega esta línea en tu archivo `build.gradle`:

<details>
<summary><b>Groovy (build.gradle)</b></summary>

```groovy
implementation("androidx.core:core-splashscreen:x.x.x")
```
</details>

Una vez implementada la librería, es necesario crear o configurar el tema que se utilizará específicamente para el SplashScreen.

<details>
<summary><b>AndroidManifest</b></summary>

```xml
    <style name="Theme.App.Starting" parent="Theme.SplashScreen">
        <item name="windowSplashScreenBackground">TuColorApp</item>
        <item name="windowSplashScreenAnimatedIcon">TuIconoApp</item>
        <item name="postSplashScreenTheme">TuTemaCentral</item>
    </style>
```
</details>

Finalmente, en la SplashActivity, se utilizará el siguiente código para implementar el SplashScreen correctamente.

<details>
<summary><b>SplashActivity.kt</b></summary>

```kotlin
@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreen()
    }

    private fun splashScreen() {
        installSplashScreen().setKeepOnScreenCondition { true }
        Thread {
            TimeUnit.SECONDS.sleep(SPLASH_SCREEN_TIME_OUT)
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }.start()
    }

    companion object {
        private const val SPLASH_SCREEN_TIME_OUT = 3L
    }
}
```
</details>