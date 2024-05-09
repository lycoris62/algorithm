SELECT 
    A.ID
FROM
    ECOLI_DATA A
    JOIN
        (
            SELECT
                C.ID
            FROM
                ECOLI_DATA C
                JOIN 
                    ECOLI_DATA D
                ON
                    C.PARENT_ID = D.ID
            WHERE 
                D.PARENT_ID IS NULL
        ) B
    ON A.PARENT_ID = B.ID
ORDER BY
    ID ASC