## 7 принципов тестирования

1. Тестирование демонстрирует наличие дефектов, а не их отсутствие
2. Исчерпывающее тестирование невозможно(за исключением тривальных случаев)
3. Раннее тестирование сохраняет время и деньги
4. Принцип скопления или кластеризация дефектов
5. Парадокс пестицида
6. Тестирование зависит от контекста
7. Заблуждение об отсутствии ошибок

## 7 principles of testing

1. Tests show the presence of defects, not their absence
2. Exhaustive testing is impossible(except in trivial cases)
3. Early Testing saves time and money
4. Grouping defects
5. Beware of the pesticide paradox
6. Testing is context-dependent
7. Absence-of-errors is a fallacy

[Презентация](https://docs.google.com/presentation/d/1xqulUU3ufYaUkBKo4iA4Abj7Frj2dPgQ/edit?usp=sharing&ouid=116447005932578256378&rtpof=true&sd=true)


[Chropath](https://chromewebstore.google.com/detail/chropath/ljngjbnaijcbncmcnjfhigebomdlkcjo?pli=1)

[UI Elements](https://docs.google.com/presentation/d/1PDbsrSNHTY3KdLiY3SDojRGAbUdNMwGA/edit?usp=sharing&ouid=116447005932578256378&rtpof=true&sd=true)

**build.gradle**

plugins {

id 'java'

}

group = 'org.example'

version = '1.0-SNAPSHOT'

repositories {

mavenCentral()

}

dependencies {

testImplementation platform('org.junit:junit-bom:5.9.1')
testImplementation 'org.junit.jupiter:junit-jupiter'
implementation 'org.seleniumhq.selenium:selenium-java:4.19.0'

}

test {

useJUnitPlatform()

}
