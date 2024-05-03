## Jenkins

Ведущий инструмент непрерывной интеграции с открытым исходным кодом, разработанный Hudson lab.

Он кроссплатформенный и может использоваться в средах Windows, Linux, Mac OS и Solaris.

Дженкинс написан на Java.

Непрерывная интеграция (CI, англ. Continuous Integration) — практика разработки программного обеспечения, которая заключается в постоянном слиянии рабочих копий в общую основную ветвь разработки (до нескольких раз в день) и выполнении частых автоматизированных сборок проекта для скорейшего выявления потенциальных дефектов и решения интеграционных проблем

Поддерживает инструменты системы управления версиями, включая AccuRev, CVS, Subversion, Git, Mercurial, Perforce, Clearcase и RTC. Может собирать проекты с использованием Apache Ant и Apache Maven

Сборка может быть запущена разными способами, например, по событию фиксации изменений в системе управления версиями, по расписанию, по запросу на определённый URL, после завершения другой сборки в очереди

[POM](https://docs.google.com/presentation/d/1H4w1nVSEH6pJAaPTpWR2T7HuI-uwVpyajw0stH_nPV8/edit?usp=drive_link)

[Настройка Jenkins](https://docs.google.com/presentation/d/1VC2QYUCiHkzPsQtLmJ_k-zn8T13MrgXY/edit?usp=sharing&ouid=116447005932578256378&rtpof=true&sd=true)

[jenkins.exe download](https://www.jenkins.io/download/)

[gradle download](https://gradle.org/releases/)

[maven download](https://maven.apache.org/download.cgi)

**C:\Program Files\Java\jdk-11** jdk-11

**C:\Program Files\Git\bin\git.exe** Git

**C:\Tools\gradle-8.7** gradle-8.7

**C:\Tools\apache-maven-3.9.6** apache-maven-3.9.6

**folder_name/build/test-results/*/*.xml** Test report XMLs

**java -jar jenkins.war** запуск сервера Jenkins

**http://localhost:8080/** ссылка для доступа к интерфейсу Jenkins

**@echo off
set /p PORT=Enter new port for launch Jenkins:
java -jar jenkins.war --httpPort=%PORT%**  - запрашивает порт для запуска Jenkins у пользователя

**@echo off
set /p port="Enter the port number: "
for /f "tokens=5" %%a in ('netstat -aon ^| findstr :%port%') do (
taskkill /PID %%a /F
)
echo Processes on port %port% have been terminated.
Pause** - запрашивате у пользователя какой порт освободить

Строки для Gradle и JUnit

**gradle QA38_DemoQA_POM:smoke** запуск таски

**gradle QA38_Phonebook_v2:test -Ptags=@ALL** запуск по тэгу