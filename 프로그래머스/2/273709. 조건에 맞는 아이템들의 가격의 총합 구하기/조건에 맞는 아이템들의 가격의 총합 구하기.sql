SELECT
    SUM(PRICE) TOTAL_PRICE
FROM
    ITEM_INFO I
WHERE
    I.RARITY = "LEGEND"