; Ian Drake
; 11/9/2021
; CS 0046 Section 4010

begin:           BR main, i
                 
dashes:          .ASCII "----------------------------\n\x00"
input:           .BLOCK 1

;get character output 
main:            LDBA 0xFC15, d
                 STBA input,  d

;print dashes
                 STRO dashes, d
                 
                 LDBA input, d
                

;quit if Q or q
                 CPBA    'q',i
                 BREQ    QUIT,i
                 CPBA    'Q',i
                 BREQ    QUIT,i
                
                 STBA 0xFC16, d

                 LDBA input, d
                 
;is the character a number? if not, branch to next condition. if char < 30 and > 39, branch away to isLetter
                 CPBA 0x30, i
                 BRLT isLetter, i ;if less than 30, go to letter check
                 CPBA 0x39, i
                 BRGT isLetter, i
;LF 
                 LDBA 0x000A, i
                 STBA 0xFC16, d

;print N since we have confirmed this to be a number
                 LDBA 'N', i
                 STBA 0xFC16, d
                 
                 LDBA input, d                 

                 ANDA 0x01, i 
                 BRNE odd, i             

even:            LDBA 0x000A, i
                 STBA 0xFC16, d

                 LDBA 'E', i ;print E for even
                 STBA 0xFC16, d

                 BR loop, i 

odd:             LDBA 0x000A, i
                 STBA 0xFC16, d

                 LDBA 'O', i ;print O for odd
                 STBA 0xFC16, d

                 BR loop, i                 
                 

isLetter:        LDBA 0x000A, i
                 STBA 0xFC16, d

                 LDBA input, d

;Is this a capital letter?
                 CPBA 0x41, i
                 BRLT notUp, i

                 CPBA 0x5A, i    
                 BRGT notUp, i

                 LDBA 'C', i
                 STBA 0xFC16, d

;Check to see if char is a vowel
                 LDBA input, d
                 
                 CPBA 'A', i
                 BREQ printVow, i

                 CPBA 'E', i
                 BREQ printVow, i

                 CPBA 'I', i
                 BREQ printVow, i

                 CPBA 'O', i
                 BREQ printVow, i

                 CPBA 'U', i
                 BREQ printVow, i

                 BR loop, i                 

;Check for lowercase letter
notUp:           CPBA 0x61, i
                 BRLT isMisc, i

                 CPBA 0x7A, i
                 BRGT isMisc, i

                 LDBA 'L', i
                 STBA 0xFC16, d
;vowel check 
                 LDBA input, d
                 
                 CPBA 'a', i
                 BREQ printVow, i

                 CPBA 'e', i
                 BREQ printVow, i

                 CPBA 'i', i
                 BREQ printVow, i

                 CPBA 'o', i
                 BREQ printVow, i

                 CPBA 'u', i
                 BREQ printVow, i

                 BR loop, i

printVow:        LDBA 0x000A,i
                 STBA 0xFC16,d
                 
                 LDBA 'V', i
                 STBA 0xFC16, d
                 
                 BR loop, i

isMisc:          LDBA '?', i
                 STBA 0xFC16, d                 
                          
loop:            LDBA 0x000A, i
                 STBA 0xFC16, d

                 BR main, i
QUIT:            STOP
                 .END