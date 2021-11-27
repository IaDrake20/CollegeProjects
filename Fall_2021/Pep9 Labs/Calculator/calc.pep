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
                 ADDA 4,s; 
                 BRV addV,i
                 
                 STWA -10,s
                 DECO -10,s

addR:            RET
                 
addV:            CALL VError,i
                 BR addR,i
                 ;end

Sub:             LDWA 6,s
                 SUBA 4,s;
                 BRV subV,i

                 STWA -10,s
                 DECO -10,s

subR:            RET

subV:            call VError,i
                 BR addR,i
                 ;end
        

Mul:             LDWA 6,s
mLoop:           Call Add,i
                 ADDX 1,i;  
                 CPWX 2,s;
                 BRGE mLoop,i                                
                 RET

VError:          LDWA print,i
                 STRO print,d
                 RET

Div:             RET
Sqt:             RET
;Ovflow:          

                 .END