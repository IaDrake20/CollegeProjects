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

                 


                 BR main,i

callADD:         ADDSP -6,i
                 LDWA 0,i
                 CALL Add,i
                 ADDSP 6,i
                 CALL pDashes,i
                 BR main,i

callSUB:         ADDSP -6,i
                 CALL Sub,i
                 ADDSP 6,i
                 CALL pDashes,i
                 BR main,i

callMUL:         ADDSP -6,i
                 CALL Mul,i
                 ADDSP 6,i
                 CALL pDashes,i
                 BR main,i

callDIV:         ADDSP -6,i
                 CALL Div,i
                 ADDSP 6,i
                 CALL pDashes,i 
                 BR main,i

callS:           ADDSP -6,i
                 CALL Squ,i 
                 ADDSP 6,i
                 CALL pDashes,i
                 BR main,i
                 
                 

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
                 
                 RET
                 
                 
Add:             LDWA 6,s;      
                 ADDA 4,s; 
                 BRV addV,i
                 
addR:            STWA -10,s
                 DECO -10,s

                 RET
                 
addV:            CALL VError,i
                 BR addR,i
                 ;end

Sub:             LDWA 6,s
                 SUBA 4,s;
                 BRV subV,i

subR:            STWA -10,s
                 DECO -10,s

                 RET

subV:            call VError,i
                 BR addR,i
                 ;end
        
;parameter 1: 4,s
;parameter 2: 6,s
;will check for negatives, if a neg is present numbers will be made positive and the neg sign will be applied at the end
;add operand 1 to itself (operand2) times
Mul:             LDWX 4,s
                 LDBA 0,i
                 STBA -7,s
                 
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
                 ;ADDA 1,i
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
                

mulR:            STWA -10,s
                 LDBA -7,s
                 CPBA 1,i
                 BRNE noNeg,i

                 LDWA -10,s
                 ;SUBA 1,i
                 NEGA
                 STWA -10,s
                 

noNeg:           LDWA -10,s
                 DECO -10,s                               
                 RET

mulV:            call VError,i
                 BR mulR,i

;--------------------------------------------
;load operand 1
;subtract loop of operand 2
;        condition to leave is 
Div:             LDWX 4,s
                 LDBA 0,i
                 STBA -7,s
                 
;if one of the numbers is negative, (check for both) apply 2's complement to negative nums, then divide and reapply it
;the answer is held in the X reg
dOp1chk:         LDWA 6,s
                 BRGE dOp2chk,i 
                 NEGA
                 STWA 6,s
                 
                 LDBA -7,s
                 ADDA 1,i
                 STBA -7,s
                 
                 
dOp2chk:         LDWA 4,s
                 BRGE befdLoop,i
                 NEGA 
                 ;ADHY6CDA 1,i
                 STWA 4,s                 
                 
                 LDBA -7,s
                 ADDA 1,i
                 STBA -7,s
                 
befdLoop:        LDWX 0,i
                 LDWA 6,s
dLoop:           ADDX 1,i;
                 SUBA 4,s
                 BRLT divNegRs,i   
                 BRNE dLoop,i                                 
                

divR:            STWX -10,s
                 LDBA -7,s
                 CPBA 1,i
                 BRNE dNoNeg,i 

                 LDWX -10,s
                 ;SUBA 1,i
                 NEGX
                 STWX -10,s
                 

dNoNeg:          LDWX -10,s
                 DECO -10,s                               
                 RET

;revert to last subtraction
divNegRs:        ADDA 4,s
                 SUBX 1,i
                 STWX -10,s
                 BR divR,i
;----------------------------------------------------------------


VError:          LDWA print,i
                 STRO print,d
                 ;CALL pDashes,i
                 RET

pDashes:         LDWA dashes,i
                 STRO dashes,d
                 RET
pEqua:           RET

;Things I need to do
;        1)multiply the operand until it reaches: 
;        2)know if my current result is close to the actual answer: go until result is 1 "step" greater than correct answrr, back down to last answer and return that

;Operand 1: 4,s. This is what i want the result of the multiplication to be from User input
;Operand 2: 6,s. This is my current number that I am squaring, the program starts at 1
;To work for multiplication I need to make op2 the same as op1 and save my reult somewhere safe

Squ:             LDWA 4,s
                 STWA -12,s

                 ;overwrite op1 with op2
                 LDWA 6,s
                 STWA 4,s

;Op1: 4,s holds the number I want to be squared
;Op2: 6,s holds same number as op1 
;Result is held at -12,s which is safe

SquLoop:         CALL Mul,i
                 CPWA 4,s
                 BRNE SquLoop,i
                 RET
          
                 .END