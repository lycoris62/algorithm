import java
.time
.LocalDate; 

class Solution {
    
    public 
        int 
        solution
        (
        int[] date1, 
        int[] date2
    ) 
        
    {
        int date1Year 
            = 
            date1[0];
        int date1Month 
            = 
            date1[1];
        int date1Day 
            = 
            date1[2];
        
        int date2Year 
            = 
            date2[0];
        int date2Month 
            = 
            date2[1];
        int date2Day 
            = 
            date2[2];
        
        LocalDate 
            localDate1 
            = 
            LocalDate
            .of(
            date1Year, 
            date1Month, 
            date1Day
        );
        
        LocalDate 
            localDate2 
            = 
            LocalDate
            .of(
            date2Year, 
            date2Month, 
            date2Day
        );
        
        
        return 
            localDate1
            .isBefore(
            localDate2
        ) 
            ? 1 
            : 0
                ;
    }
}