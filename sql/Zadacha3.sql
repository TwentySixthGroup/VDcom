/*
Дано:

Таблица счетов
CounterpartyID int 
primary key identity	Name varchar(255)	IsActive bit
1	Иванов	1
2	Петров	0
3	Сидоров	1

CounterpartyID – идентификатор счета
Name – название счета
IsActive – признак активности

Таблица проводок
TransID int	TransDate date	RcvID int	SndID int	AssetID int	Quantity numeric(19, 8)
1	01.01.2012	1	2	1	100
2	02.01.2012	1	3	2	150
3	03.01.2012	3	1	1	300
4	04.01.2012	2	1	3	50

TransID – идентификатор проводки
TransDate – дата проведения проводки
RcvID – идентификатор получателя
SndID – идентификатор отправителя
AssetID – идентификатор актива(рубли, доллары, акции лукойла, акции газпрома и т.д.)
Quantity – количество передаваемого актива

Нужно:

1)	Отобрать активные счета по которым есть проводки как минимум по двум разным активам. Выводимые поля: CounterpartyID, Name, Cnt(количество уникальных активов по которым есть проводки)
2)	Посчитать суммарное число актива, образовавшееся на активных счетах, в результате проведенных проводок. Выводимые поля: CounterpartyID, Name, AssetID, Quantity 
3)	Посчитать средний дневной оборот по всем счетам по всем проводкам считая что AssetID во всех проводках одинаковый. Выводимые поля: CounterpartyID, Name, Oborot
4)	Посчитать средний месячный оборот по всем счетам по всем проводкам считая что AssetID во всех проводках одинаковый. Выводимые поля: CounterpartyID, Name, Oborot


*/


-- 1-e задание
SELECT a.CounterpartyID, a.Name, COUNT(b.AssetID) AS Cnt
  FROM tblCounterparty a, tblTransaction b 
  WHERE ((a.CounterpartyID = b.RcvID) OR (a.CounterpartyID = b.SndID)) AND a.IsActive = 1
  GROUP BY b.AssetID 
  HAVING Cnt > 1
-- 2-е задание
SELECT a.CounterpartyID, a.Name, b.AssetID, SUM(b.Quantity) AS Q
  FROM tblCounterparty a, tblTransaction b 
  WHERE ((a.CounterpartyID = b.RcvID) OR (a.CounterpartyID = b.SndID)) AND a.IsActive = 1
  GROUP BY b.AssetID
-- 3-е задание
SELECT a.CounterpartyID, a.Name, AVG(b.Quantity) AS Oborot
  FROM tblCounterparty a, tblTransaction b 
  WHERE (a.CounterpartyID = b.RcvID) OR (a.CounterpartyID = b.SndID)
  GROUP BY b.TransDate 
  HAVING b.TransDate = '20120102'
-- В последней строчке выбрана конкретная дата, но можно вместо неё использовать текущую дату с помощью функции GATEDATE.
--4
SELECT a.CounterpartyID, a.Name, AVG(b.Quantity) AS Oborot
  FROM tblCounterparty a, tblTransaction b 
  WHERE (a.CounterpartyID = b.RcvID) OR (a.CounterpartyID = b.SndID)
  GROUP BY (MONTH(SYSDATETIME) = MONTH(b.TransDate))