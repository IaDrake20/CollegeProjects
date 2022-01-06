                 BR main 

number:          .BLOCK 2
forNum1:         .BLOCK 2
forNum2:         .BLOCK 2

main:            DECI number,d

                 LDWA forNum1,d
                 ADDA 1,i
                 STWA forNum1,d

                 LDWA forNum2,d
                 ADDA 1,i
                 STWA forNum2,d

;                 ;begin for 1
;for1:            LDWA forNum1,d
;                 ADDA forNum1,d
;                 STWA forNum1,d

                 ;begin for 2
                 DECO forNum1,d

for2:            LDWA forNum2,d
                 ADDA 1,i
                 STWA forNum2,d

                 LDWA forNum1,d
                 CPWA forNum2,d
                 BRGT for2
                 ;end for 2

                 LDBA '\n',i
                 STBA 0xFC16,d

for1:            LDWA forNum1,d
                 ADDA forNum1,d
                 STWA forNum1,d

                 LDWA number,d
                 CPWA forNum1,d
                 BRGT for1
                 ;end for 1

                 STOP
                 .END