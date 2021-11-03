         BR main,i 
num:     .BLOCK 2
main:    DECI num,d
         LDWA num,d
         SUBA 50,i
         BRLE here0,i
         DECO 1,i
         BR done,i


here0:   DECO 0,i
         
done:    STOP
         .END