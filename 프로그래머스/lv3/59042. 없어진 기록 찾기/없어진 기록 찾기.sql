-- 코드를 입력하세요
SELECT O.ANIMAL_ID, O.NAME
from animal_ins I
    right outer join animal_outs O
    on I.ANIMAL_ID = O.ANIMAL_ID
where I.animal_id is NULL and O.animal_id is not null
ORDER BY ANIMAL_ID ASC
;