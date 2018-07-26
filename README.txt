Папка src/main/resources:
 - файл с параметрами подключения connect.properties;
 - файл с запросами к серверу requestFile.xlsx;
 - RequestDataReader - класс в который вычитываются запросы из файла requestFile.xlsx.
  Возвращает коллекцию заполненную запросами, хранящимися в виде LinkedHashMap;
 - RequestHolder - класс использует коллекцию от RequestDataReader для отсылки запросов, получения ответов от сервера;
 - sendRequest(String key, String condition) - метод класса RequestHolder , который отсылает запрос и получает ответ
 от сервера. На вход получает два параметра: поисковое имя поля и его значение.

 Папка src/test/java:
 - RequestHolderTest класс с тестами по выставленному заданию;

 Папка src/main/java:
 - запускной класс Main.

Модуль работает в консольной строке Intelij IDEA.

