                 BR main, i

;get character output 
main:            LDBA 0xFC15, d
                 STBA 0x0208, d


;LF
                 LDWA 0x000A, i
                 LDBA 0x0208, d


;print dashes
                 STRO dashes, d
                 .BLOCK 2
dashes:          .ASCII "----------------------------\x00 \n"

                 CPBA    'q',i
                 BREQ    QUIT,i
                 CPBA    'Q',i
                 BREQ    QUIT,i
                
;write character to mem
                 origChar:        STBA 0xFC16, d
                 
;is the character a number? if not, branch to next condition. if char < 30 and > 39, branch away to BR isLetter
                 CPBA 30, i
                 BRGT isLetter, i 
;print out that character
                 LDBA 0x0208,d
                 STBA 0xFC16, d

;if so, is it even or odd? Branch to even case print if even, etc

;even print

;odd print

isLetter:        BRGT isMisc, i 
;is the character a letter?
;print out that character
                 LDBA 0x0208, d
                 STBA 0xFC16, d

;if so, is the letter capital or lowercase?
                 
;is the letter a vowel?

;if the char is not any of the above,
;print out that character and ?
isMisc:          LDBA origChar, d ;load orig char to print
                 STBA 0xFC16, d
                 

       


;print what type of character the character is
     
;lastPrint:      .ASCII " " ; 

QUIT:            STOP
                 .END