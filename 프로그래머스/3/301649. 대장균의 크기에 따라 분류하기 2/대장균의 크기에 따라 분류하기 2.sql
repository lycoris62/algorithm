SELECT
    A.ID,
    CASE
        WHEN B.TILE = 1
            THEN "CRITICAL"
        WHEN B.TILE = 2
            THEN "HIGH"
        WHEN B.TILE = 3
            THEN "MEDIUM"
        ELSE
            "LOW"
    END COLONY_NAME
FROM
    ECOLI_DATA A
    JOIN
        (
            SELECT
                ID,
                NTILE(4) OVER (
                    ORDER BY 
                        SIZE_OF_COLONY DESC
                ) TILE
            FROM
                ECOLI_DATA
        ) B
    ON
        A.ID = B.ID
ORDER BY
    A.ID ASC