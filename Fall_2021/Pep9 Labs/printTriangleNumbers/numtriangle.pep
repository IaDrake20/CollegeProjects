                 BR main 

number:          .BLOCK 2
forNum1:         .BLOCK 2 ;.EQUATE 0
forNum2:         .BLOCK 2 ;.EQUATE 0

main:            DECI number,d

               
                 ;begin for 1
for1:            LDWA forNum1,d
                 ADDA 1,i
                 STWA forNum1,d
                 
                 LDWA number,d
                 STWA forNum2,d

                 ;begin for 2
for2:            LDWA forNum2,d
                 ADDA -1,i
                 STWA forNum2,d

                 ;print cur value of first for loop's var
                 DECO forNum1,d

                 ;forNum1 - forNum2 > 0
                 LDWA forNum1,d
                 CPWA forNum2,d
                 BRLE for2
                 ;end for 2

                 LDBA '\n',i
                 STBA 0xFC16,d

                 LDWA number,d
                 CPWA forNum1,d
                 BRGT for1
                 ;end for 1
                 STOP

             .END

