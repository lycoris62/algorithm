SELECT
    I.ID,
    N.FISH_NAME,
    I.LENGTH
FROM
    FISH_INFO I
    JOIN
        FISH_NAME_INFO N
    ON
        I.FISH_TYPE = N.FISH_TYPE
WHERE 
    N.FISH_TYPE IN (
        SELECT
            FISH_TYPE
        FROM
            FISH_INFO
        GROUP BY
            FISH_TYPE
        HAVING
            LENGTH = MAX(LENGTH)
    )
ORDER BY
    I.ID ASC
