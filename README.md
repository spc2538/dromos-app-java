# Dromos app java

# Tabla de contenidos
- [Introducción](#introduccion)
- [Descripción](#descripcion)
- [Créditos](#creditos)
- [Acerca de la documentación](#acerca-de-la-documentacion)
- [Java 17 instalación](#java-17-instalacion)

## Introducción
- Ejecutar sistema con terminal o powershell
```powershell
cd src
java -cp ./streets.jar streets/simulacion/Simulacion
```
- Screenshots
    ![Screenshot](snapshots/default_size.png)

## Descripción

Este programa fue creado gracias a el libro "Fundamentals of 2D programming with java", libro muy recomendado para la programación en 2D y 3D con Java. Durante mi curso de Programación concurrente y paralela en la universidad de la BUAP, uno de los proyectos finales estaba basado en crear una simulación de automóviles transitando sobre las calles Avenida San Claudio y la 14 sur, las cuales irónicamente están ubicadas muy cerca de la facultad de ciencias de la computación.

Los hilos son generados en tiempo aleatorio, pero los semáforos siguen los tiempos que tenían en aquel entonces esas calles. La programación garantiza que ningún auto tenga un "accidente", o que cruce el semáforo en rojo. El libro que mencione previamente fue en el que me base para poder realizar la interfaz gráfica en 2D.

El código fuente esta ubicado dentro del directorio src/streets/streets.

## Créditos
    - https://www.amazon.com/Fundamental-2D-Game-Programming-Java/dp/1305076532
![Screenshot](snapshots/41x1Vpt8SSL._SX402_BO1%2C204%2C203%2C200_.jpg)

## Acerca de la documentación
Tiene mucho tiempo este proyecto de haber sido creado, por lo que pido una disculpa de antemano por la falta de profesionalismo expuesto en el código fuente y en los archivos pdf. En aquel entonces este no fue el único proyecto final que tuve que realizar en un mes, de aquella materia y de otras, sin mencionar los exámenes.

## Java 17 instalación

### Debian y Fedora

```powershell

sudo mkdir /usr/lib/jvm
cd /usr/lib/jvm
ls ~/Downloads
sudo tar -xvzf ~/Downloads/jdk-17.0.4.1_linux-x64_bin.tar.gz

nano ~/.bashrc
: '
export PATH="$PATH:/usr/lib/jvm/jdk-17.0.4.1/bin"
JAVA_HOME="/usr/lib/jvm/jdk-17.0.4.1"
'

sudo update-alternatives --install "/usr/bin/java" "java" "/usr/lib/jvm/jdk-17.0.4.1/bin/java" 0
sudo update-alternatives --install "/usr/bin/javac" "javac" "/usr/lib/jvm/jdk-17.0.4.1/bin/javac" 0
sudo update-alternatives --set java /usr/lib/jvm/jdk-17.0.4.1/bin/java
sudo update-alternatives --set javac /usr/lib/jvm/jdk-17.0.4.1/bin/javac

update-alternatives --list java
update-alternatives --list javac

java --version
javac --version
```

