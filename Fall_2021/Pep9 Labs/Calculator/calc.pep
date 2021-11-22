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

                 CALL Add,i


                 STOP

clearMem:        LDBA 0,i
                 STBA 0,s
                 ADDSP -2,i

                 LDWA 0,i
                 STWA 0,s
                 ADDSP -2,i

                 STWA 0,s
                 
                 ADDSP 5,i

                 RET
                 
                 
Add:             ADDA 2,s;ADDSP 6,i
                 ;ADDA 2,s
                 ;add operand 1 to operand 2
                 LDWA 0,s
                 RET

Sub:             RET
Mul:             RET
Div:             RET
Sqt:             RET

                 .END