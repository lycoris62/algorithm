-- 코드를 입력하세요
SELECT I.ANIMAL_ID, I.ANIMAL_TYPE, I.NAME
FROM ANIMAL_INS I JOIN ANIMAL_OUTS O
ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE 
    I.SEX_UPON_INTAKE like "Intact%"
    AND
    (
        O.SEX_UPON_OUTCOME like "Spayed%" 
        OR 
        O.SEX_UPON_OUTCOME like "Neutered%"
    )
ORDER BY O.ANIMAL_ID
;