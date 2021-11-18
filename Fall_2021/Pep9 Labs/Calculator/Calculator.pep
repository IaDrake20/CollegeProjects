                 BR main,i

main:            LDBA '\n',i
                 
                 ;clear out junk
                 ;CALL clearMem,i

                 ;going to just do .BLOCK and store that to the stack
                 ;can't get my DECI to work
                 LDBA '+',i
                 ADDSP -1,i
                 STBA 0,s

                 LDWA 0x2B,i
                 ADDSP -2,i
                 STWA 0,s

                 LDWA 0x0002,i
                 ADDSP -2,i
                 STWA 0,s
                 
                 




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
                 ;CALL Add,i 
                 ;Call Sub,i
                 ;CALL Mul,i
                 ;CALL Div,i
                 ;Call Squ,i


                 
print:           ADDSP 1,i ;print input 2
                 LDBA 0,s

                 STOP

;faster to just not use a branch
clearMem:        LDWA 0,i
                 ADDSP -2,i
                 STWA 0,s

                 ADDSP -2,i
                 STWA 0,s

                 ADDSP -2,i
                 STWA 0,s
                 RET 

;Add:            some kind out output to say now in add function
; save it?       ADDSP 1,i
;                LDBA  0,s
;                ADDSP             
;Sub:
;Mul:
;Div:
;Squ:


                 .END
         
                 