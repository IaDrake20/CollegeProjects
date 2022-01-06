;FB8D and FB8E are the user input
;FB8B and FB8C will hold a count variable
;I hate stacks in assembly

;our loop will work something like this
; loop1 = n
; while( n
; > 0) { 

;        LDWA n from the stack
;        do {
;                print n
;                sub 1 from n
;        while ( n != 0)

main:            LDWA 0,i
                 ADDSP -2,i
n:               DECI 0,s ;get user input and store it in stack
                 
                 ;ADDSP -2,i
                 CALL tri

                 
                 
                 
                 STOP
;use n for loopvar1
tri:             ADDSP 2,i
                 LDWA 0,s
                 
                 ADDSP 2,i
                 STWA 0,s

                 ADDSP 2,i
                 STWA 0,s

                 ADDSP -4,i
                 
                 ;begin loop1
loop1:           ADDSP 2,i
                 STWA 0,s
                 
                 ;beg loop2 
loop2:           ADDSP -2,i

                 DECO 0,s
                 
ADDSP 2,i
                 ;LDWA 0,s
;remem to subsp 2,i

                 SUBA 1,i
                 BRGT loop2

                 LDBA '\n',i
                 STBA 0xFC16,d

;make sure this is reducing the orig number
                 ADDSP -10,s
                 ;LDWA 0,s
                 ADDA -1,i
                 BRGT loop1
                 RET             
                 .END                 