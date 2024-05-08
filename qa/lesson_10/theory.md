## Jenkins

Ведущий инструмент непрерывной интеграции с открытым исходным кодом, разработанный Hudson lab.

Он кроссплатформенный и может использоваться в средах Windows, Linux, Mac OS и Solaris.

Дженкинс написан на Java.

Непрерывная интеграция (CI, англ. Continuous Integration) — практика разработки программного обеспечения, которая заключается в постоянном слиянии рабочих копий в общую основную ветвь разработки (до нескольких раз в день) и выполнении частых автоматизированных сборок проекта для скорейшего выявления потенциальных дефектов и решения интеграционных проблем

Поддерживает инструменты системы управления версиями, включая AccuRev, CVS, Subversion, Git, Mercurial, Perforce, Clearcase и RTC. Может собирать проекты с использованием Apache Ant и Apache Maven

Сборка может быть запущена разными способами, например, по событию фиксации изменений в системе управления версиями, по расписанию, по запросу на определённый URL, после завершения другой сборки в очереди

- [PageObjectModel [презентация]](https://docs.google.com/presentation/d/1H4w1nVSEH6pJAaPTpWR2T7HuI-uwVpyajw0stH_nPV8/edit?usp=drive_link)

- [Jenkins и его настройка [презентация]](https://docs.google.com/presentation/d/1VC2QYUCiHkzPsQtLmJ_k-zn8T13MrgXY/edit?usp=sharing&ouid=116447005932578256378&rtpof=true&sd=true)

- [Jenkins.exe, скачать LTS [ссылка на офф. сайт]](https://www.jenkins.io/download/)

- [Java Development Kit (JDK), скачать [ссылка на офф. сайт]]( https://www.oracle.com/java/technologies/downloads/)

- [Git, скачать [ссылка на офф. сайт]]( https://git-scm.com/download/)

- [Gradle Build Tool, скачать binary-only файл [ссылка на офф. сайт]](https://gradle.org/releases/)

- [Maven Build Tool, скачать Binary-zip-archive файл [ссылка на офф. сайт]](https://maven.apache.org/download.cgi)

*** 
### Проверить версию Java:
```
На Windows:
java --version
На MacOS:
java -version
```
### Найти папку, в которую установлен Java JDK на macOS:
```
/usr/libexec/java_home -v
```
### Проверить версию Git:
```
git –version
```
### Найти папку, в которую установлен Git на macOS:
```
which git
или
whereis git
```
*** 

### jdk-11
```
C:\Program Files\Java\jdk-11
```
### Git на Windows
```
C:\Program Files\Git\bin\git.exe 
```
### Git на MacOS
```
/usr/bin/git 
```
### gradle-8.7
```
C:\Tools\gradle-8.7 
```
### apache-maven-3.9.6
```
C:\Tools\apache-maven-3.9.6 
```
### Test report XMLs
```
***имя_папки_проекта_если _она_есть***/build/test-results/*/*.xml
```
***
### Запуск сервера Jenkins из командной строки из папки с файлом jenkins.war
```
java -jar jenkins.war
на MacOS иногда такая команда требуется:
java -jar jenkins.war --enable-future-java
```
### Ссылка для доступа к веб-интерфейсу Jenkins в браузере
```
http://localhost:8080/
```
*** 
### Запрашивает порт для запуска Jenkins у пользователя
``` 
@echo off
set /p PORT=Enter new port for launch Jenkins:
java -jar jenkins.war --httpPort=%PORT%
```
### Запрашивает у пользователя какой порт освободить
``` 
@echo off
set /p port="Enter the port number: "
for /f "tokens=5" %%a in ('netstat -aon ^| findstr :%port%') do (
taskkill /PID %%a /F
)
echo Processes on port %port% have been terminated.
Pause
```
