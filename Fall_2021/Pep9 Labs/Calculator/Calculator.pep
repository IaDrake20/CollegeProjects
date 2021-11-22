                 BR main,i

main:            LDBA '\n',i
                 
                 ;clear out junk
                 CALL clearMem,i

                 ;DECI not woeking, for now just manually setting it
                 LDBA '+',i
                 STBA 0,s

                 LDWA 0x31,i
                 ADDSP -2,i
                 STWA 0,s

                 LDWA 0x32,i
                 ADDSP -1,i
                 STWA 0,s

                 ADDSP 3,i
                 
                 
                 




                 ;LDBA 0xFC15,d
                 ;ADDSP -1, i
                 ;STBA 0,s; push operand
         
                 ;ADDSP -2,i
                 ;DECI 0,s
                 ;STWA 0,s;push input 1

                 ;ADDSP -2,i
                 ;DECI 0,s
                 ;STWA 0,s;push input 2

                 ;call, calculate, then print out
                 CALL Add,i 
                 ;Call Sub,i
                 ;CALL Mul,i
                 ;CALL Div,i
                 ;Call Squ,i


                 STOP
;print:           ;ADDSP 1,i ;print input 2 
                 ;LDBA 0,s

                
;faster to just not use a branch
clearMem:        LDWA 0,i
                 ADDSP -1,i
                 STWA 0,s

                 ADDSP -2,i
                 STWA 0,s

                 ADDSP -2,i
                 STWA 0,s

                 ADDSP 6,i
                 RET 

Add:            LDWA 0,s;ADDSP 2,i			;subroutine
	     ;LDWA 0,s 
	     ADDA 2,s
	     ;BRV  addRET,i
                 ADDSP -2,i
addRET:          RET	;branch if overflow bit	           
;Sub:
;Mul:
;Div:
;Squ:


                 .END
         
                 