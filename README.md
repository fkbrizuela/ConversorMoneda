# ConversorMoneda
![Stars](https://img.shields.io/github/stars/fkbrizuela/ConversorMoneda)
![License](https://img.shields.io/github/license/fkbrizuela/ConversorMoneda)

Un conversor de monedas simple escrito en Java usando la API de ExchangeRate.

## 📁 Acceso al proyecto
* Clona el repositorio usando `git`: 
```bash
  $ git clone https://github.com/fkbrizuela/ConversorMoneda
```
* O descarga el zip desde [aquí](https://github.com/fkbrizuela/ConversorMoneda/archive/refs/heads/main.zip).
## 🛠️ Abre y ejecuta el proyecto
* Descarga el Java JDK desde [aquí](https://www.oracle.com/ar/java/technologies/downloads/) o [aquí](https://adoptium.net/es/temurin/releases/).
* Descarga la librería Gson 2.13.1 desde [Maven Central](https://search.maven.org/artifact/com.google.code.gson/gson/2.13.1/jar)
* Compila el proyecto:
```bash
  javac -cp gson-2.13.1.jar;src -d build src/net/fkbrizuela/ConversorMoneda/Main.java
  jar cvfe ConversorMoneda.jar net.fkbrizuela.ConversorMoneda.Main -C build .
```
