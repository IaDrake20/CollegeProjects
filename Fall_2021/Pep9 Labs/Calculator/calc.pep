                 BR main,i
print:           .ASCII "Overflow\n\x00" 

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
                 CALL Add,i
                 ADDSP 6,i
                 BR main,i

callSUB:         ADDSP -6,i
                 CALL Sub,i
                 ADDSP 6,i
                 BR main,i

callMUL:         ADDSP -6,i
                 CALL Mul,i
                 ADDSP 6,i
                 BR main,i

callDIV:         ADDSP -6,i
                 CALL Div,i
                 ADDSP 6,i
                 BR main,i
                 
                 

STOP:            STOP

clearMem:        LDBA 0,i
                 STBA 0,s

                 LDWA 0,i
                 STWA -2,s
                 ;ADDSP -2,i

                 STWA -4,s
                 ;ADDSP -1,i
                 
                 RET
                 
                 
Add:             ADDA 4,s;LDWA 6,s;      
                 ;ADDA 4,s; 
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







;--------------------------------------------
Div:             LDWX 4,s
                 LDBA 0,i
                 STBA -7,s
                 
;if one of the numbers is negative, (check for both) apply 2's complement to negative nums, then multiply and reapply it
dOp1chk:          LDWA 6,s
                 BRGE op2chk,i
                 NEGA
                 STWA 6,s
                 
                 LDBA -7,s
                 ADDA 1,i
                 STBA -7,s
                 
                 
dOp2chk:          LDWA 4,s
                 BRGE befmLoop,i
                 NEGA 
                 ;ADDA 1,i
                 STWA 4,s                 
                 
                 LDBA -7,s
                 ADDA 1,i
                 STBA -7,s
                 
befdLoop:        LDWX 4,s
                 LDWA 0,i
dLoop:           ADDA 6,s
                 BRV mulV,i 
                 SUBX 1,i;  
                 BRNE mLoop,i                                 
                

divR:            STWA -10,s
                 LDBA -7,s
                 CPBA 1,i
                 BRNE noNeg,i

                 LDWA -10,s
                 ;SUBA 1,i
                 NEGA
                 STWA -10,s
                 

dNoNeg:           LDWA -10,s
                 DECO -10,s                               
                 RET
;----------------------------------------------------------------

mulV:            call VError,i
                 BR mulR,i

VError:          LDWA print,i
                 STRO print,d
                 RET

Div:             RET
Sqt:             RET
;Ovflow:          

                 .END