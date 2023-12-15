SELECT 
    HOUR(DATETIME) HOUR, 
    COUNT(*) COUNT
FROM 
    ANIMAL_OUTS
GROUP BY 
    HOUR
HAVING 
    HOUR BETWEEN 9 AND 19
ORDER BY 
    HOUR