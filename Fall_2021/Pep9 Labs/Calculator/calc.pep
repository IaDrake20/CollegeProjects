main:            CALL clearMem,i
                 
                 LDBA 0xFC15,d
                 STBA 0,s
                 ADDSP -2,i
                 
                 DECI 0,s
                 LDWA 0,s
                 ADDSP -2,i
                 
                 DECI 0,s
                 LDWA 0,s
                 ;ADDSP -2,i

                 ADDSP 4,i
                 LDBA 0,s
                 CPBA '+',i
                 BREQ callADD,i

                 CPBA 'q',i
                 BREQ STOP,i

                 CPBA 'Q',i
                 BREQ STOP,i

                 BR main,i

callADD:         ADDSP -6,i
                 CALL Add,i
                 
                 

STOP:            STOP

clearMem:        LDBA 0,i
                 STBA 0,s
                 ADDSP -2,i

                 LDWA 0,i
                 STWA 0,s
                 ADDSP -2,i

                 STWA 0,s
                 
                 ADDSP 4,i

                 RET
                 
                 
Add:             ADDSP 6,i
                 LDWA 0,s;
                 
                 ADDSP 2,i       
                 ADDA 0,s;

                 ADDSP -5,i 
                 RET

Sub:             RET
Mul:             RET
Div:             RET
Sqt:             RET

                 .END