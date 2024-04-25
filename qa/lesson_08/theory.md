[Logger](https://docs.google.com/presentation/d/1kptX1Ce1NBux34JP7e9kOr_38TzyKEAGN1rUPcqn77M/edit?usp=drive_link)

**cmd commands**

gradle clean test - запуск всех тестов из всех модулей

gradle QA38_Phonebook_v2:test -Ptags=@LoginTests - запуск тестов по тэгу из определенного модуля

gradle QA38_Phonebook_v2:test --tests *LoginTests - запуск тестов по определненному класу