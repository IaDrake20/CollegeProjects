main:            LDBA 0xFC15,d
                 ADDSP -1, i
                 STBA 0,s; push operand
         
                 LDBA 0xFC15,d
                 ADDSP -1,i
                 STBA 0,s;push input 1

                 LDBA 0xFC15,d
                 ADDSP -1,i 
                 STBA 0,s;[ush input 2

                 ;call, calculate, then print out
                 CALL Add,d
                 Call Sub,d
                 CALL Mul,d
                 CALL Div,d
                 Call Squ,d


                 
print:           ADDSP 1,i ;print input 2
                 LDBA 0,s
                 STOP

Add:             ADDSP 1,i
                 LDBA              
Sub:
Mul:
Div:
Squ:


                 .END
         
                 