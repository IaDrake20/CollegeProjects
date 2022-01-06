;Ian Drake
;First byte of stack holds operator, the 4 previous 4 bytes hold the two operands, next 2 bytes holds results   
; while in the add, subtract, multiply, and divide subroutines the stack pointer is shifted to the left by 6.
; This is to store the return address in a place that doesn't overwrite my data
;NOTE (11/29/2021) As I have been writing this over the past week, its only today that I am seeing alot of ways that I could do this better or in a more organized fashion             

                 BR main,i
print:           .ASCII "Error\n\x00"
dashes:          .ASCII "\n----------------------------------\n\x00" 

main:            CALL clearMem,i
                 
                 LDBA 0xFC15,d
                 STBA 0,s
                 ;ADDSP -2,i

                 CPBA 'q',i
                 BREQ STOP,i

                 CPBA 'Q',i
                 BREQ STOP,i
                 
                 DECI -2,s
                 LDWA -2,s
                 ;ADDSP -2,i

                 ;check to see if op is square root
                 LDBA 0,s;
                 CPBA 's',i
                 BREQ callS,i
                 
                 DECI -4,s
                 LDWA -4,s
                 ;ADDSP -2,i

                 ;ADDSP 4,i
                 LDBA 0,s

                 CPBA '+',i
                 BREQ callADD,i

                 CPBA '-',i
                 BREQ callSUB,i

                 CPBA '*',i
                 BREQ callMUL,i
                 
                 CPBA '/',i
                 BREQ callDIV,i

                 
finalOut:        LDWA -2,s
                 DECO -2,s

                 LDBA ' ',i  
                 STBA 0xFC16,d

                 LDBA 0,s
                 STBA 0xFC16,d

                 LDBA ' ',i  
                 STBA 0xFC16,d

                 LDWA -4,s
                 DECO -4,s

                 LDBA ' ',i  
                 STBA 0xFC16,d

                 LDBA '=',i
                 STBA 0xFC16,d

                 LDBA ' ',i  
                 STBA 0xFC16,d

                 LDWA -6,s
                 DECO -6,s
                                                 
                 CALL pDashes,i

                 BR main,i

SfinalO:         LDWA -2,s
                 DECO -2,s
         
                 LDBA ' ',i  
                 STBA 0xFC16,d

                 LDBA 0,s
                 STBA 0xFC16,d
                 
                 LDBA ' ',i  
                 STBA 0xFC16,d

                 LDBA '=',i
                 STBA 0xFC16,d

                 LDBA ' ',i  
                 STBA 0xFC16,d

                 LDWA -8,s
                 DECO -8,s

                 BR main,i

callADD:         ADDSP -6,i
                 LDWA 0,i
                 CALL Add,i
                 ADDSP 6,i
                 BR finalOut,i

callSUB:         ADDSP -6,i
                 CALL Sub,i
                 ADDSP 6,i
                 BR finalOut,i

callMUL:         ADDSP -6,i
                 CALL Mul,i
                 ADDSP 6,i
                 BR finalOut,i

callDIV:         ADDSP -6,i
                 CALL Div,i
                 ADDSP 6,i
                 BR finalOut,i

callS:           ADDSP -4,i
                 CALL Squ,i 
                 ADDSP 4,i
                 BR SfinalO,i
                 
                 

STOP:            STOP

clearMem:        LDBA 0,i
                 STBA 0,s

                 LDWA 0,i
                 STWA -2,s
                 ;ADDSP -2,i

                 STWA -4,s
                 ;ADDSP -1,i

                 STWA -6,s
                 STWA -8,s

                 LDWA 0,i
                 STWA 0,x
                 
                 RET
                 
                 
Add:             LDWA 6,s;      
                 ADDA 4,s; 
                 BRV addV,i
                 
addR:            STWA 2,s
                 RET
                 
addV:            CALL Error,i
                 BR addR,i
                 ;end

Sub:             LDWA 6,s
                 SUBA 4,s;
                 BRV subV,i

subR:            STWA 2,s 
                 RET

subV:            call Error,i
                 BR addR,i
                 ;end
        
Mul:             LDWX 0,i
                 
;if one of the numbers is negative, (check for both) apply 2's complement to negative nums, then multiply and reapply it
op1chk:          LDWA 6,s
                 BRGE op2chk,i
                 NEGA
                 STWA 6,s
                 
                 LDBA -7,s
                 ADDA 1,i
                 STBA -7,s
                                  
op2chk:          LDWA 4,s
                 BRGE befmLoop,i
                 NEGA 
                 STWA 4,s                 
                 
                 LDBA -7,s
                 ADDA 1,i
                 STBA -7,s
                 
befmLoop:        LDWX 4,s
                 LDWA 0,i
mLoop:           ADDA 6,s
                 BRV mulV,i 
                 SUBX 1,i;  
                 BRNE mLoop,i                                 
                

mulR:            STWA 2,s
                 LDBA -7,s
                 CPBA 1,i
                 BRNE noNeg,i

                 LDWA 2,s

                 NEGA
                 STWA 2,s


noNeg:           RET

mulV:            call Error,i
                 BR mulR,i

;--------------------------------------------
;load operand 1
;subtract loop of operand 2
;        condition to leave is 
Div:             LDWX 4,s
                 LDBA 0,i
                 STBA 4,s
                 
;if one of the numbers is negative, (check for both) apply 2's complement to negative nums, then divide and reapply it
;the answer is held in the X reg
dOp1chk:         LDWA 6,s
                 BRGE dOp2chk,i 
                 NEGA
                 STWA 6,s
                 
                 LDBA 5,s
                 ADDA 1,i
                 STBA 5,s
                 
                 
dOp2chk:         LDWA 4,s
                 BRGE befdLoop,i
                 NEGA 
                 ;ADHY6CDA 1,i
                 STWA 4,s                 
                 
                 LDBA 2,s
                 ADDA 1,i
                 STBA 2,s
                 
befdLoop:        LDWX 0,i
                 LDWA 6,s
dLoop:           ADDX 1,i;
                 SUBA 4,s
                 BRLT divNegRs,i   
                 BRNE dLoop,i                                 
                

divR:            STWX 2,s
                 LDBA -7,s
                 CPBA 1,i
                 BRNE dNoNeg,i 

                 LDWX 2,s
                 ;SUBA 1,i
                 NEGX
                 STWX 2,s
                 

dNoNeg:          RET

;revert to last subtraction
divNegRs:        ADDA 4,s
                 SUBX 1,i
                 STWX 2,s
                 BR divR,i
;----------------------------------------------------------------


Error:          LDWA print,i
                 STRO print,d
                 ;CALL pDashes,i
                 RET

pDashes:         LDWA dashes,i
                 STRO dashes,d
                 RET

;Things I need to do
;        1)multiply the operand until it reaches: 
;        2)know if my current result is close to the actual answer: go until result is 1 "step" greater than correct answer, back down to last answer and return that

;Operand 1: 4,s. This is what i want the result of the multiplication to be from User input; k
;Operand 2: 6,s. This is my current number that I am squaring, the program starts at 1
;To work for multiplication I need to make op2 the same as op1 and save my reult somewhere safe

Squ:             CPWA 0,i
                 ;BRGT SquNegCS,i

                 LDWA 0,s
                 STWA -10,s

                 LDWA 4,s
                 STWA -3,s

                 LDWA 0,i
                 STWA 2,s
                 STWA 4,s

;Op1: 4,s holds the number I want to be squared
;Op2: 6,s holds same number as op1 
;Result is held at -12,s which is safe

SquLoop:         LDWA 2,s
                 LDWX 4,s               
                 ADDA 1,i
                 STWA 2,s
                 STWA 4,s

                 ;CPWA -3,s
                  

                 CALL Mul,i
                 ;LDWA 0,s

                 LDWA -3,s
                 ;DECO -3,s

                 CPWA -3,s
                 BRNE SquLoop,i
                 ;BRLT SquNegCS,i  

                 LDWA -3,s
                 STWA -2,s
                 LDWA -10,s
                 STWA 0,s

                 RET               

SquNegCS:        CALL Error,i
                 RET
          
                 .END