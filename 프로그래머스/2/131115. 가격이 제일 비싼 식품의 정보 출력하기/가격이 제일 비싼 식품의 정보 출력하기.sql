-- 코드를 입력하세요
SELECT
    *
FROM
    FOOD_PRODUCT F1
WHERE
    F1.PRICE = (
        SELECT
            MAX(F2.PRICE)
        FROM
            FOOD_PRODUCT F2
    )
;