# 📖 OpenBook - Cliente Bibliográfico Modular

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)

Aplicación móvil nativa para Android basada en la arquitectura **Dual-Pane Layout**. Desarrollada como proyecto académico para el módulo de *Herramientas de programación móvil I* del **Politécnico Grancolombiano**. 

OpenBook actúa como un cliente bibliográfico interactivo que consume la API de Open Library, integrando múltiples componentes esenciales del desarrollo móvil en una interfaz de doble panel.

---

## 🚀 Características Principales (Módulos)

La aplicación divide la pantalla en un menú lateral fijo y un panel dinámico que renderiza los siguientes 5 módulos funcionales:

1. **👤 Perfil:** Muestra información académica utilizando contenedores `ScrollView` para la lectura fluida de textos extensos.
2. **📚 Fotos (Catálogo):** Galería interactiva con `HorizontalScrollView`. Implementa **Corrutinas** (`lifecycleScope`) para descargar y renderizar asíncronamente las portadas desde la API de Open Library sin bloquear la interfaz.
3. **🎥 Video:** Reproductor multimedia nativo (`VideoView`) con controles de interfaz (`MediaController`) para visualización de tutoriales locales.
4. **🌐 Web:** Integración de un `WebView` y un `EditText` que permite la navegación directa en el portal oficial de Open Library desde la aplicación.
5. **🔘 Botones:** Panel de demostración técnica que captura e ilustra eventos de interacción del usuario (clics, switches y cambios de estado).

---

## 🛠️ Arquitectura y Tecnologías

* **Lenguaje:** Kotlin
* **UI Toolkit:** Android XML Layouts
* **Arquitectura Visual:** Dual-Pane Layout (FragmentContainerView)
* **Gestión de UI:** Fragments (`LeftMenuFragment` como orquestador estático y 5 fragmentos dinámicos de contenido).
* **Concurrencia:** Kotlin Coroutines (`Dispatchers.IO` y `Dispatchers.Main`) para peticiones de red.
* **SDK Mínimo:** API 24 (Android 7.0)

---

## 📸 Capturas de Pantalla

<img width="260" height="397" alt="image" src="https://github.com/user-attachments/assets/7f4bb11e-b7bb-4278-96c3-c236f393b9df" />
<img width="268" height="575" alt="image" src="https://github.com/user-attachments/assets/c4f75fee-3e8b-4f10-a134-a041515b9a2d" />


---

## ⚙️ Instalación y Ejecución

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone [https://github.com/tu-usuario/openbook-android.git](https://github.com/tu-usuario/openbook-android.git)
