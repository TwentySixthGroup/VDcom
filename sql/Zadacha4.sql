/*
Дано:

Таблица периодов
PeriodID	Value
1	10
3	10
5	20
6	20
7	30
9	40
10	40
	

Нужно:
1)	Требуется отобрать периоды в которых значение Value отличается от значения Value в предыдущем периоде. Выводимые поля: PeriodID, Value. В примере выше должны быть выведены значения 1, 5, 7, 9

2)	Требуется удалить из таблицы периоды в которых значение Value равно значению Value в предыдущем периоде. Выводимые поля: PeriodID, Value. В примере выше должны быть удалены значения 3, 6, 10
*/


-- 1-е задание
DECLARE
  Cur1 CURSOR FOR 
    SELECT p.PeriodID, p.[Values] 
    FROM tblPeriod p;
DECLARE 
  @V1 INT;
  SET @V1 = -1; 
DECLARE
  @V2 INT;
  SET @V2 = -1
DECLARE 
  Rec1 Cur1 % ROWTYPE;
  OPEN Cur1;
    WHILE (Cur1 IS NOT NULL)
    FETCH NEXT FROM Cur1 INTO Rec1;
      @V2 = Rec1.[Values]
      IF @V1 <> @V2 
        THEN PRINT (Rec1.PeriodID) || (Rec1.[Values])
        @V1 = @V2;
      END IF;
	  
-- 2-е задание
DECLARE
  Cur1 CURSOR FOR 
    SELECT p.PeriodID, p.[Values] 
    FROM tblPeriod p;
DECLARE 
  @V1 INT;
  SET @V1 = -1; 
DECLARE
  @V2 INT;
  SET @V2 = -1
DECLARE 
  Rec1 Cur1 % ROWTYPE;
  OPEN Cur1;
    WHILE (Cur1 IS NOT NULL)
    FETCH NEXT FROM Cur1 INTO Rec1;
      @V2 = Rec1.[Values]
      IF @V1 = @V2 
        THEN UPDATE p.[Values] SET = -10
        @V1 = @V2;
      END IF;
          CLOSE Cur1;

DELETE ALL 
FROM p
WHERE p.[Values] = -10

SELECT * FROM p