                 BR main,i
print:           .ASCII "Overflow"

main:            CALL clearMem,i
                 
                 LDBA 0xFC15,d
                 STBA 0,s
                 ;ADDSP -2,i
                 
                 DECI -2,s
                 LDWA -2,s
                 ;ADDSP -2,i
                 
                 DECI -4,s
                 LDWA -4,s
                 ;ADDSP -2,i

                 ;ADDSP 4,i
                 LDBA 0,s

                 CPBA '+',i
                 BREQ callADD,i

                 CPBA '-',i
                 BREQ callSUB,i

                 CPBA 'q',i
                 BREQ STOP,i

                 CPBA 'Q',i
                 BREQ STOP,i


                 BR main,i

callADD:         ADDSP -6,i
                 CALL Add,i
                 ADDSP 6,i

callSUB:         ADDSP -6,i
                 CALL Sub,i
                 ADDSP 6,i
                 
                 

STOP:            STOP

clearMem:        LDBA 0,i
                 STBA 0,s

                 LDWA 0,i
                 STWA -2,s
                 ;ADDSP -2,i

                 STWA -4,s
                 ;ADDSP -1,i
                 RET
                 
                 
Add:             LDWA 6,s;
                        
                 ADDA 2,s; 
                 BRV VError,i
                 
                 RET

Sub:             LDWA 6,s
                 SUBA 4,s;
                 RET

Mul:             LDWA 6,s                 
                 RET

VError:          LDWA print,i
                 STWA 0xFC16,d
                 RET

Div:             RET
Sqt:             RET
Ovflow:          

                 .END