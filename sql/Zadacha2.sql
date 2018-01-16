/*
Дано:  Есть две таблицы. tblBook – содержит информацию о книгах, которые есть в библиотеке, таблица tblBookInLibrary – содержит информацию о дате регистрации по некоторым книгам в библиотеке.

Таблица: tblBook
BookID	Name
1	 Война и мир
2	 Преступление и наказание
3	 Мастер и Маргарита
4	Тихий дон

Таблица: tblBookInLibrary

BookID	Date
1	01.05.2006
3	05.07.2004


Нужно:

1)	Выбрать все книги, а поле дата должно быть заполнено только у тех книг, у которых дата регистрации больше  01.02.2005
2)	Выбрать все книги у которых дата регистрации в библиотеке больше  01.02.2005 либо не задана вообще:
*/


-- 1-е задание
SELECT a.BookID, a.Name, b.Date
  FROM tblBook a LEFT JOIN tblBookInLibrary b
  ON a.BookID = b.BookID
  WHERE (b.Date > '20050201')
  
-- 2-е задание 
SELECT a.BookID, a.Name, b.Date
  FROM tblBook a LEFT JOIN tblBookInLibrary b
  ON a.BookID = b.BookID
  WHERE (b.Date > '20050201' OR b.Date IS NULL)