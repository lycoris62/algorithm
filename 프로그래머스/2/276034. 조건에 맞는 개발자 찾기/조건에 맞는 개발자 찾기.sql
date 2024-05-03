SELECT 
    D.ID,
    D.EMAIL,
    D.FIRST_NAME,
    D.LAST_NAME
FROM
    DEVELOPERS D
WHERE
    D.SKILL_CODE & (
        SELECT 
            CODE 
        FROM 
            SKILLCODES 
        WHERE 
            NAME = "Python"
    )
    OR
    D.SKILL_CODE & (
        SELECT 
            CODE 
        FROM 
            SKILLCODES 
        WHERE 
            NAME = "C#"
    )
ORDER BY
    D.ID ASC