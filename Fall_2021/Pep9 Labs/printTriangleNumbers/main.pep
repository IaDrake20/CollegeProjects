                 BR main,i 
number:          .BLOCK 2
loopnum1:        .BLOCK 2
loopnum2:        .BLOCK 2
loopnum3:        .BLOCK 2
hvFV:            .BLOCK 2
main:            DECI number,d ;load input
 ;                STWA number,d

for1:            LDWA loopnum1,d
                 ADDA 1,i
                 STWA loopnum1,d

;for2:            STWA hvFV,d
for2:            LDWA number,d
                 SUBA loopnum1,d
                 STWA loopnum2,d

                 LDBA ' ',i
                 STBA 0xFC16,d ;print " "
                 LDWA number,d
                 SUBA number,d
                 BRGT for2,i ;end of for 2

for3:            LDWA loopnum3,d
                 ADDA 1,i
                 STWA loopnum3,d

                 LDWA number,d
                 DECO number,d
                 LDWA loopnum3,d
                 CPWA loopnum1,d
                 BRGE for3,i ;end of for 3

                 LDBA '\n',i
                 STBA 0xFC16,d

                 LDWA loopnum1,d
                 DECO loopnum1,d                 

                 LDWA loopnum1,d ;for loop 1's ending curly bracket
                 CPWA loopnum1,d
                 BRGE main,i 

                 STOP
                 .END

